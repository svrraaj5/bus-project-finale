package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Payment;
import com.lti.model.ReservationTbl;

@Repository
//@Scope(scopeName = "singleton")
public class PaymentDaoImpl implements PaymentDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public int createPayment(Payment pay) {
		entityManager.persist(pay);
		return pay.getPaymentId();
	}

	@Override
	@Transactional
	public List<Payment> readAllPayments() {
		String jpql = "Select p From Payment p";
		TypedQuery<Payment> tquery = entityManager.createQuery(jpql, Payment.class);
		return tquery.getResultList();
	}

	@Override
	@Transactional
	public int deletePayment(int paymentId) {

		Payment pay = entityManager.find(Payment.class, paymentId);
		entityManager.remove(pay);
		return 1;
	}

	@Override
	@Transactional
	public Payment readPaymentByPaymentId(int paymentId) {

		return entityManager.find(Payment.class, paymentId);
	}

	@Override
	@Transactional
	public Payment updatePayment(Payment pay) {

		pay = entityManager.merge(pay);
		return pay;
	}

	@Override
	@Transactional
	public int deletePaymentBytno(int tno) {
		String jpql = "delete from Payment p where p.res.ticketNo = :tno";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("tno", tno);
		int result = query.executeUpdate();
		return result;
	}

}
