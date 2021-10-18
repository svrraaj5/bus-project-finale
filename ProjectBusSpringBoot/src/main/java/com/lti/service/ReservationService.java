package com.lti.service;

import java.util.List;

import com.lti.model.BusTbl;
import com.lti.model.ReservationTbl;

public interface ReservationService {

	public ReservationTbl addReservation(ReservationTbl resv);

	public List<ReservationTbl> findAllReservation();

	public boolean modifyReservation(ReservationTbl resv);

	public boolean removeReservation(int ticketNo);

	public ReservationTbl findReservationByTicketNo(int ticketNo);
	
	public boolean setBus(ReservationTbl resv, BusTbl bus);
	
	public List<ReservationTbl> findAllReservationByEmailId(String emailId);
}
