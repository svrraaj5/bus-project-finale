package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.BusTbl;
import com.lti.model.ReservationTbl;

@Repository
//@Scope(scopeName = "singleton")
public class ReservationDaoImpl implements ReservationDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public ReservationTbl createReservation(ReservationTbl resv) {
		ReservationTbl reserve=entityManager.merge(resv);
		return reserve;
	}

	@Override
	@Transactional
	public List<ReservationTbl> readAllReservations() {
		String jpql = "Select r From ReservationTbl r";
		TypedQuery<ReservationTbl> tquery = entityManager.createQuery(jpql, ReservationTbl.class);
		return tquery.getResultList();
	}

	@Override
	@Transactional
	public int deleteReservation(int ticketNo) {

		ReservationTbl resv = entityManager.find(ReservationTbl.class, ticketNo);
		entityManager.remove(resv);
		return 1;
	}

	@Override
	@Transactional
	public ReservationTbl readReservationByTicketNo(int ticketNo) {

		return entityManager.find(ReservationTbl.class, ticketNo);
	}

	@Override
	@Transactional
	public ReservationTbl updateReservation(ReservationTbl resv) {

		resv = entityManager.merge(resv);
		return resv;
	}

	@Override
	@Transactional
	public int setBus(ReservationTbl resv, BusTbl bus) {
		resv.setBus(bus);
		return 1;
	}

	@Override
	@Transactional
	public List<ReservationTbl> readAllReservationsByEmailId(String emailId) {
		String jpql = "Select r From ReservationTbl r where r.emailId = :em";
		TypedQuery<ReservationTbl> tquery = entityManager.createQuery(jpql, ReservationTbl.class);
		tquery.setParameter("em", emailId);
		return tquery.getResultList();
	}

}
