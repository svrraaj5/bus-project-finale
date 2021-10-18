package com.lti.dao;

import java.util.Date;
import java.util.List;

import com.lti.model.BusTbl;

public interface BusDao {
	public int createBus(BusTbl bus);

	public List<BusTbl> readAllBus();

	public BusTbl updateBus(BusTbl bus);

	public int deleteBus(int id);

	public BusTbl readBusById(int id);
	
	public List<BusTbl> readBusByFromTo(String from, String to);
	


}
