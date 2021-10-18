package com.lti.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
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
@Table(name = "BUS_TBL")
public class BusTbl implements Serializable{
	@Id
	@Column(name = "BUS_ID")
	private int id;
//	
//	@Id
//	@Column(name = "DEPARTURE")
//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date departureDate;
	
	
//	@Column(name = "ARRIVAL")
//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date arrivalDate;
	
	@Column(name = "SOURCE")
	private String source;
	
	@Column(name = "DESTINATION")
	private String destination;
	
	@Column(name = "BASE_FARE")
	private double baseFare;
//	
//	@Column(name = "AVAILABLE_SEAT")
//	private int availableSeat;
	
	@Column(name = "TOTAL_SEAT")
	private int totalSeat;
	
	@Column(name = "BUS_STATUS")
	private int busStatus;
	
//	@Column(name = "COACH_BUS_STATUS")
//	private int coachBusStatus;

	@Column(name = "DEPARTURE_TIME")
	private String departureTime;
	
	@Column(name = "Arrival_TIME")
	private String arrivalTime;
	
	//inverse side
	//@JsonManagedReference
	//@OneToMany(mappedBy = "bus", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//private Set<ReservationTbl> reservations;
	
	//inverse side
//	@JsonManagedReference
//	@OneToMany(mappedBy = "busDetails", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	private Set<SeatTbl> seat;
	
	/*public void addSeat(SeatTbl st) {
		seat.add(st);
	}*/
	
	public BusTbl() {
		super();
	}
	public BusTbl(int id, Date departureDate, Date arrivalDate, String source, String destination, double baseFare,
			int availableSeat, int totalSeat, int busStatus, String departureTime, String arrivalTime) {
		super();
		this.id = id;
//		this.departureDate = departureDate;
//		this.arrivalDate = arrivalDate;
		this.source = source;
		this.destination = destination;
		this.baseFare = baseFare;
//		this.availableSeat = availableSeat;
		this.totalSeat = totalSeat;
		this.busStatus = busStatus;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
//	public BusTbl(int id, Date departureDate, Date arrivalDate, String source, String destination, double baseFare,
//			int availableSeat, int totalSeat, int busStatus, int coachBusStatus,String departureTime,
//			String arrivalTime) {
//		super();
//		this.id = id;
//		this.departureDate = departureDate;
//		this.arrivalDate = arrivalDate;
//		this.source = source;
//		this.destination = destination;
//		this.baseFare = baseFare;
//		this.availableSeat = availableSeat;
//		this.totalSeat = totalSeat;
//		this.busStatus = busStatus;
//		this.coachBusStatus = coachBusStatus;
//		this.departureTime = departureTime;
//		this.arrivalTime = arrivalTime;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public Date getDepartureDate() {
//		return departureDate;
//	}
//
//	public void setDepartureDate(Date departureDate) {
//		this.departureDate = departureDate;
//	}
//	
//	public Date getArrivalDate() {
//		return arrivalDate;
//	}
//
//	public void setArrivalDate(Date arrivalDate) {
//		this.arrivalDate = arrivalDate;
//	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}

//	public int getAvailableSeat() {
//		return availableSeat;
//	}
//
//	public void setAvailableSeat(int availableSeat) {
//		this.availableSeat = availableSeat;
//	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public int getBusStatus() {
		return busStatus;
	}

	public void setBusStatus(int busStatus) {
		this.busStatus = busStatus;
	}

//	public int getCoachBusStatus() {
//		return coachBusStatus;
//	}
//
//	public void setCoachBusStatus(int coachBusStatus) {
//		this.coachBusStatus = coachBusStatus;
//	}


	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	/*public Set<ReservationTbl> getReservations() {
		return reservations;
	}
	public void setReservations(Set<ReservationTbl> reservations) {
		this.reservations = reservations;
	}*/
	/*public Set<SeatTbl> getSeat() {
		return seat;
	}
	public void setSeat(Set<SeatTbl> seat) {
		this.seat = seat;
	}*/

	@Override
	public String toString() {
		/*
		 * return "BusTbl [busId=" + busId + ", departure=" + departure + ", arrival=" +
		 * arrival + ", source=" + source + ", destination=" + destination +
		 * ", baseFare=" + baseFare + ", availableSeat=" + availableSeat +
		 * ", totalSeat=" + totalSeat + ", busStatus=" + busStatus + ", coachBusStatus="
		 * + coachBusStatus + ", driverStatus=" + driverStatus + ", startTime=" +
		 * startTime + ", reachTime=" + reachTime + "]";
		 */
		 return "\n, Bus Id: " + id + "\n, source: " + source
			+ "\n, Destination: " + destination + "\n, Departure Time: " + departureTime + "\n, Arrival Time: " + arrivalTime ;
		
	}

	

}
