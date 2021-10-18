package com.lti.service;

import java.util.Date;
import java.util.List;

import com.lti.model.SeatTbl;

public interface SeatService {

	public boolean addSeat(SeatTbl seat);

//	public List<SeatTbl> findAllSeatByIdDate(int id, Date date);
	
	public List<Integer> findAllSeatByIdDate(int id, Date date);

	public boolean modifySeat(SeatTbl seat);

	public boolean removeSeat(int seatId);

	public SeatTbl findSeatBySeatId(int seatId);
	
//	public List<SeatTbl> findAllSeatByIdDate(int id, Date date);
}
