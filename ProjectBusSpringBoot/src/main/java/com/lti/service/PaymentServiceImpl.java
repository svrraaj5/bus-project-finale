package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.PaymentDao;
import com.lti.model.Payment;

@Service("service3")
//@Scope(scopeName = "singleton")
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao dao = null;

	@Override
	public boolean addPayment(Payment pay) {
		int result = dao.createPayment(pay);
		return (result > 0) ? true : false;
	}

	@Override
	public List<Payment> findAllPayment() {
		return dao.readAllPayments();
	}

	@Override
	public boolean modifyPayment(Payment pay) {
		Payment result = dao.updatePayment(pay);
		return ((result != null) ? true : false);
	}

	@Override
	public boolean removePayment(int paymentId) {
		int result = dao.deletePayment(paymentId);
		return (result == 1) ? true : false;
	}

	@Override
	public Payment findPaymentByPaymentId(int paymentId) {
		return dao.readPaymentByPaymentId(paymentId);
	}

	@Override
	public boolean removePaymentByTno(int tno) {
		int result = dao.deletePaymentBytno(tno);
		return (result == 1) ? true : false;
	}

}
