package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Payment;
import com.lti.service.MailServiceImpl;
import com.lti.service.PaymentService;

@RestController
@RequestMapping(path = "Pay")
@CrossOrigin
public class PaymentAppController {

	@Autowired
	private PaymentService service3;
	
	@Autowired
	private ReservationAppController rAC;
	
	@Autowired
	private MailServiceImpl mail;
	
	String payment;

	@PostMapping(path = "/")
	public void addPayment(@RequestBody Payment pay) {
//		Payment p=new Payment();
////		p.setPaymentId(pay.getPaymentId());
//		p.setPaymentMethod(pay.getPaymentMethod());
//		p.setChargedFare(pay.getChargedFare());
//		p.setBookingDate(pay.getBookingDate());
		service3.addPayment(pay);
		System.out.println("Payment successfull");
//	payment =  "\n, Payment Id: "+pay.getPaymentId()
//				+"\n, Payment Method: "+pay.getPaymentMethod()+"\n, Charged Fare: "+pay.getChargedFare();
//		String email = pay.getRes().getEmailId();
//		mail.send(email,"RESERVATION SUCCESSFUL", payment);
		
	}

	@GetMapping(path = "/")
	public List<Payment> getAllPayment() {
		List<Payment> pay = service3.findAllPayment();
		return pay;
	}

	@PutMapping(path = "/")
	public Payment updatePaymentByPaymentId(@RequestBody Payment pay) {
		boolean result = service3.modifyPayment(pay);
		if (result)
			pay = service3.findPaymentByPaymentId(pay.getPaymentId());
		return pay;
	}

//	@DeleteMapping(path = "{id}")
//	public void deletePaymentByPaymentId(@PathVariable("id") int paymentId) {
//		service3.removePayment(paymentId);
//	}
	
	@DeleteMapping(path = "{tno}")
	public void deletePaymentByPaymentTno(@PathVariable("tno") int tno) {
		service3.removePaymentByTno(tno);
	}

}
