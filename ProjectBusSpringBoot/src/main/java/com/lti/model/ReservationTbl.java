package com.lti.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Component
@Entity
@Table(name = "RESERVATION")
public class ReservationTbl {
	@Id
	@Column(name = "TICKET_NO")
	@SequenceGenerator(name="reservation_seq",initialValue=1001,allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="reservation_seq")
	
	private int ticketNo;
	
	@Column(name = "DEPARTURE_DATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date departureDate = new Date();
	
	@Column(name = "NO_OF_SEATS")
	private int noOfSeats;
	
	@Column(name = "TICKET_STATUS")
	private int ticketStatus;

	@Column(name = "CANCELLATION_DATE")
	@Temporal(TemporalType.DATE)
	private Date cancellationDate;
	
	@Column(name = "REFUND_AMOUNT")
	private double refundAmount;
	
	@Column(name = "TOTAL_FARE")
	private double totalFare;
	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name = "PHONE_NO")
	private String phoneNo;

	//owner side
	//@JsonBackReference
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REGISTERED_DETAILS")
	private UserTbl user;
	
	//owner side
//	@JsonManagedReference
	@OneToOne(fetch = FetchType.EAGER)
	
        @JoinColumn( name = "BUS_ID",  referencedColumnName = "BUS_ID")
       
	private BusTbl bus;
	
	//inverse side
	@JsonBackReference
	@OneToMany(mappedBy = "reserve",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<SeatTbl> seats;
	
	
	public ReservationTbl() {
		super();
	}

	public ReservationTbl(int noOfSeats, int ticketStatus,
			BusTbl bus, double totalFare, String emailId, String phoneNo) {
		super();
		this.noOfSeats = noOfSeats;
		this.ticketStatus = ticketStatus;
		this.bus = bus;
		this.totalFare = totalFare;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}

	public ReservationTbl(int noOfSeats, int ticketStatus, String emailId) {
		super();
		this.noOfSeats = noOfSeats;
		this.ticketStatus = ticketStatus;
		this.emailId = emailId;
	}
	
	public ReservationTbl(int noOfSeats, int ticketStatus,
			Date cancellationDate, double refundAmount, BusTbl bus, double totalFare, String emailId, String phoneNo) {
		super();
		this.noOfSeats = noOfSeats;
		this.ticketStatus = ticketStatus;
		this.cancellationDate = cancellationDate;
		this.refundAmount = refundAmount;
		this.bus = bus;
		this.totalFare = totalFare;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}

	public ReservationTbl(int noOfSeats, int ticketStatus) {
		super();
		this.noOfSeats = noOfSeats;
		this.ticketStatus = ticketStatus;
	}
	
	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Set<SeatTbl> getSeats() {
		return seats;
	}

	public void setSeats(Set<SeatTbl> seats) {
		this.seats = seats;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(int ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public Date getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	public double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	public BusTbl getBus() {
		return bus;
	}

	public void setBus(BusTbl bus) {
		this.bus = bus;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public UserTbl getUser() {
		return user;
	}

	public void setUser(UserTbl user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "\n Reservation Details: \n Ticket No:" + ticketNo + ", Departure Date: " + departureDate + "\n, No Of Seats: " + noOfSeats
				+ "\n, Total Fare=" + totalFare + "\n, EmailId: " + emailId + ", Phone No:"
				+ phoneNo + "\n, Bus Details: " + bus;
	}


	
}
