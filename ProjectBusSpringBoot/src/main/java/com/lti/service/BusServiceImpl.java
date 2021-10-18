package com.lti.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.BusDao;
import com.lti.model.BusTbl;


@Service("service1")
//@Scope(scopeName = "singleton")
public class BusServiceImpl implements BusService {

	@Autowired
	private BusDao dao = null;

	@Override
	public boolean addBus(BusTbl bus) {
		int result = dao.createBus(bus);
		return (result > 0) ? true : false;
	}

	@Override
	public List<BusTbl> findAllBus() {

		return dao.readAllBus();
	}

	@Override
	public boolean modifyBus(BusTbl bus) {

		BusTbl result = dao.updateBus(bus);
		return ((result != null) ? true : false);
	}

	@Override
	public boolean removeBus(int id) {
		int result = dao.deleteBus(id);
		return (result == 1) ? true : false;
	}

	@Override
	public BusTbl findBusById(int id) {

		return dao.readBusById(id);
	}

	@Override
	public List<BusTbl> findBusByFromTo(String from, String to) {
		return dao.readBusByFromTo(from, to);
	}


}
