package com.lti.dto;

import java.util.List;

import com.lti.model.ReservationTbl;

public class SeatDto {
	List<Integer> seatId;
	ReservationTbl reserve;
	public List<Integer> getSeatId() {
		return seatId;
	}
	public void setSeatId(List<Integer> seatId) {
		this.seatId = seatId;
	}
	public ReservationTbl getReserve() {
		return reserve;
	}
	public void setReserve(ReservationTbl reserve) {
		this.reserve = reserve;
	}
	
	
}
