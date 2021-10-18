package com.lti.service;

import java.util.Date;
import java.util.List;

import com.lti.model.BusTbl;

public interface BusService {
	public boolean addBus(BusTbl bus);

	public List<BusTbl> findAllBus();

	public boolean modifyBus(BusTbl bus);

	public boolean removeBus(int id);

	public BusTbl findBusById(int id);
	
	public List<BusTbl> findBusByFromTo(String from, String to);
	


}
