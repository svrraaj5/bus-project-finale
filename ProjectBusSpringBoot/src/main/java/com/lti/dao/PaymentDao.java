package com.lti.dao;

import java.util.List;

import com.lti.model.Payment;

public interface PaymentDao {

	public int createPayment(Payment pay);

	public List<Payment> readAllPayments();

	public int deletePayment(int paymentId);

	public Payment readPaymentByPaymentId(int paymentId);

	public Payment updatePayment(Payment pay);
	
	public int deletePaymentBytno(int tno);

}
