package com.lti.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.SeatDto;
import com.lti.model.ReservationTbl;
import com.lti.model.SeatTbl;
import com.lti.service.MailServiceImpl;
import com.lti.service.ReservationService;
import com.lti.service.SeatService;

@RestController
@RequestMapping(path = "Seat")
@CrossOrigin(origins = "http://localhost:4200")
public class SeatAppController {

	@Autowired
	private SeatService service5;
	
	@Autowired
	private MailServiceImpl mail;
	
	@Autowired
	private ReservationService service2;
	
	String resDetails;
	@PostMapping(path = "/")
	public void addSeat(@RequestBody SeatDto seatDto) {
		
		ReservationTbl rs;
		ReservationTbl res=seatDto.getReserve();
		List<Integer> seatnos=seatDto.getSeatId();
		Set<SeatTbl> allSeats=new HashSet<SeatTbl>();
		for(Integer i:seatnos) {
			SeatTbl st=new SeatTbl();
			st.setSeatId(i);
			st.setReserve(res);
			//service5.addSeat(st);	
			allSeats.add(st);
		}
		res.setSeats(allSeats);
		rs=service2.addReservation(res);
		
		resDetails = "Reservation Details: "+"\nTicket no: "+rs.getTicketNo()+"\nTotal Fare: "+rs.getTotalFare()+"\nBooking Date: "+
		rs.getDepartureDate()+"\nBus Details: "+rs.getBus()+"\nNo Of Seats: "+rs.getNoOfSeats();
		mail.send(res.getEmailId(),"Your Payment is Successful", resDetails);
		
		System.out.println("Seat added successfully");
		//System.out.println(seat.getBusDetails());
	}

//	@GetMapping(path = "/")
//	public List<SeatTbl> getAllSeat() {
//		List<SeatTbl> seat = service5.findAllSeat();
//		System.out.println(seat);
//		return seat;
//	}
	
//	@GetMapping(path = "{id}/{date}")
//	public List<SeatTbl> getAllSeatByIdDate(@PathVariable("id") int id,  @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
//		List<SeatTbl> seat = service5.findAllSeatByIdDate(id, date);
//		return seat;
//	}
	
	@GetMapping(path = "{id}/{date}")
	public List<Integer> getAllSeatByIdDate(@PathVariable("id") int id,  @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		List<Integer> seat = service5.findAllSeatByIdDate(id, date);
		return seat;
	}

	@PutMapping(path = "/")
	public SeatTbl updateSeatById(@RequestBody SeatTbl seat) {
		boolean result = service5.modifySeat(seat);
		if (result)
			seat = service5.findSeatBySeatId(seat.getSeatId());
		return seat;
	}

	@DeleteMapping(path = "{id}")
	public void deleteSeatById(@PathVariable("id") int id) {
		service5.removeSeat(id);
	}
}
