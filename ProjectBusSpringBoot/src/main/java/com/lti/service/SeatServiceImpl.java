package com.lti.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.SeatDao;
import com.lti.model.SeatTbl;

@Service("service5")

public class SeatServiceImpl implements SeatService {

	@Autowired
	private SeatDao dao = null;

	@Override
	public boolean addSeat(SeatTbl seat) {
		int result = dao.createSeat(seat);
		return (result > 0) ? true : false;
	}

	

	@Override
	public boolean modifySeat(SeatTbl seat) {

		SeatTbl result = dao.updateSeat(seat);
		return ((result != null) ? true : false);
	}

	@Override
	public boolean removeSeat(int seatId) {

		int result = dao.deleteSeat(seatId);
		return (result == 1) ? true : false;
	}

	@Override
	public SeatTbl findSeatBySeatId(int seatId) {

		return dao.readSeatBySeatId(seatId);
	}
//
//	@Override
//	public List<SeatTbl> findAllSeatByIdDate(int id, Date date) {
//	
//		return dao.readBookedSeats(id, date);
//	}
//	
	@Override
	public List<Integer> findAllSeatByIdDate(int id, Date date) {
	
		return dao.readBookedSeats(id, date);
	}



}
