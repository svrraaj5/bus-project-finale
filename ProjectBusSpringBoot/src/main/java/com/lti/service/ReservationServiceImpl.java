package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.ReservationDao;
import com.lti.model.BusTbl;
import com.lti.model.ReservationTbl;

@Service("service2")
//@Scope(scopeName = "singleton")
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao dao = null;

	@Override
	public ReservationTbl addReservation(ReservationTbl resv) {
		ReservationTbl res = dao.createReservation(resv);
		return res;
	}

	@Override
	public List<ReservationTbl> findAllReservation() {

		return dao.readAllReservations();
	}

	@Override
	public boolean modifyReservation(ReservationTbl resv) {

		ReservationTbl result = dao.updateReservation(resv);
		return ((result != null) ? true : false);
	}

	@Override
	public boolean removeReservation(int ticketNo) {

		int result = dao.deleteReservation(ticketNo);
		return (result == 1) ? true : false;
	}

	@Override
	public ReservationTbl findReservationByTicketNo(int ticketNo) {

		return dao.readReservationByTicketNo(ticketNo);
	}

	@Override
	public boolean setBus(ReservationTbl resv, BusTbl bus) {
		int result = dao.setBus(resv, bus);
		return (result == 1) ? true : false;
	}

	@Override
	public List<ReservationTbl> findAllReservationByEmailId(String emailId) {
		return dao.readAllReservationsByEmailId(emailId);
	}

}
