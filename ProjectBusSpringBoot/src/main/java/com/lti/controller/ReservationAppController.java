package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.BusTbl;
import com.lti.model.ReservationTbl;
import com.lti.service.MailServiceImpl;
import com.lti.service.ReservationService;

@RestController
@RequestMapping(path = "Reserve")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationAppController {

	@Autowired
	private ReservationService service2;
	
	@Autowired
	private MailServiceImpl mail;
	
	@Autowired
	private PaymentAppController payApp;

	String resDetails;
	
//	@PostMapping(path = "/")
//	public void addReservation(@RequestBody ReservationTbl resv) {
//		System.out.println(resv.getUser());
//		ReservationTbl res=service2.addReservation(resv);
//		resDetails = "Reservation Details: "+"\nTicket no: "+resv.getTicketNo()+"\nTotal Fare: "+resv.getTotalFare()+"\nBooking Date: "+resv.getDepartureDate()+"\nBus Details: "+resv.getBus()+"\nNo Of Seats: "+resv.getNoOfSeats()+payApp.payment;
//		//mail.send(resv.getEmailId(),"RESERVATION SUCCESSFULL", resDetails);
//	}

	@GetMapping(path = "/")
	public List<ReservationTbl> getAllReservation() {
		List<ReservationTbl> resv = service2.findAllReservation();
		return resv;
	}
	
	@GetMapping(path = "{id}")
	public ReservationTbl getReservationBytno(@PathVariable("id") int tno) {
		ReservationTbl resv = service2.findReservationByTicketNo(tno);
		return resv;
	}
	
	@GetMapping(path = "res/{emailId}")
	public List<ReservationTbl> getReservationByEmailId(@PathVariable("emailId") String emailId) {
		List<ReservationTbl> resv = service2.findAllReservationByEmailId(emailId);
		return resv;
	}
	
	@PutMapping(path = "/")
	public ReservationTbl updateReservationByTicketNo(@RequestBody ReservationTbl resv) {
		boolean result = service2.modifyReservation(resv);
		
		if (result)
			resv = service2.findReservationByTicketNo(resv.getTicketNo());
		mail.send(resv.getEmailId(), "Cancellation Succesful",  "Your Ticket with Ticket Number: "+resv.getTicketNo()+" has been cancelled successfully. We will refund your amount within 2 working days.");
		return resv;
	}

	@DeleteMapping(path = "{id}")
	public void deleteReservationByTicketNo(@PathVariable("id") int ticketNo) {
		service2.removeReservation(ticketNo);
	}
	
	@PutMapping(path = "/set")
	public ReservationTbl setBus(@RequestBody ReservationTbl resv, @RequestBody BusTbl bus) {
		boolean result = service2.setBus(resv, bus);
		if (result)
			resv = service2.findReservationByTicketNo(resv.getTicketNo());
		return resv;
	}
}
