package com.lti.dao;

import java.util.List;

import com.lti.model.BusTbl;
import com.lti.model.ReservationTbl;

public interface ReservationDao {

	public ReservationTbl createReservation(ReservationTbl resv);

	public List<ReservationTbl> readAllReservations();

	public int deleteReservation(int ticketNo);

	public ReservationTbl readReservationByTicketNo(int ticketNo);

	public ReservationTbl updateReservation(ReservationTbl resv);
	
	public int setBus(ReservationTbl resv, BusTbl bus);
	
	public List<ReservationTbl> readAllReservationsByEmailId(String emailId);
}
