package com.lti.dao;

import java.util.Date;
import java.util.List;

import com.lti.model.SeatTbl;

public interface SeatDao {

	public int createSeat(SeatTbl seat);

//	public List<SeatTbl> readBookedSeats(int bid, Date dt);
	public List<Integer> readBookedSeats(int bid, Date dt);

	public int deleteSeat(int seatId);

	public SeatTbl updateSeat(SeatTbl seat);

	public SeatTbl readSeatBySeatId(int seatId);
	
//	public List<SeatTbl> readAllSeatsByIdDate(int id, Date date);
}
