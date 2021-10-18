package com.lti.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(scopeName="prototype")
@Entity
@Table(name = "PAYMENT")
public class Payment {
	@Id
	@Column(name = "PAYMENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	
//	@Column(name = "ADDED_FARE")
//	private double addedFare;
	
	//owner side
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "TICKET_NO")
//	private ReservationTbl res;
	
	@Column(name = "BOOKING_DATE")
	@Temporal(TemporalType.DATE)
	private Date bookingDate;
	
//	@Column(name  = "DAY_DIFFERENCE")
//	private int dayDifference;
	
	@Column(name = "CHARGED_FARE")
	private double chargedFare;
	
	@Column(name = "PAYMENT_METHOD")
	private String paymentMethod;
	
	public Payment() {
		super();
	}

	public Payment(int paymentId, double addedFare, Date bookingDate, double chargedFare, String paymentMethod) {
		super();
		this.paymentId = paymentId;
//		this.addedFare = addedFare;
		this.bookingDate = bookingDate;
//		this.dayDifference = dayDifference;
		this.chargedFare = chargedFare;
		this.paymentMethod = paymentMethod;
	}

//	public Payment(double addedFare, String paymentMethod) {
//		super();
//		this.addedFare = addedFare;
//		this.paymentMethod = paymentMethod;
//	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

//	public double getAddedFare() {
//		return addedFare;
//	}
//
//	public void setAddedFare(double addedFare) {
//		this.addedFare = addedFare;
//	}

//	public ReservationTbl getRes() {
//		return res;
//	}
//
//	public void setRes(ReservationTbl res) {
//		this.res = res;
//	}

//	public int getDayDifference() {
//		return dayDifference;
//	}
//
//	public void setDayDifference(int dayDifference) {
//		this.dayDifference = dayDifference;
//	}

	public double getChargedFare() {
		return chargedFare;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setChargedFare(double chargedFare) {
		this.chargedFare = chargedFare;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId +  ", chargedFare=" + chargedFare + ", paymentMethod=" + paymentMethod + "]";
	}
}
