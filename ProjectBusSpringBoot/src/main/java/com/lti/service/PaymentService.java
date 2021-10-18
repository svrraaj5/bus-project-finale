package com.lti.service;

import java.util.List;

import com.lti.model.Payment;

public interface PaymentService {

	public boolean addPayment(Payment pay);

	public List<Payment> findAllPayment();

	public boolean modifyPayment(Payment pay);

	public boolean removePayment(int paymentId);

	public Payment findPaymentByPaymentId(int paymentId);

	public boolean removePaymentByTno(int tno);
}
