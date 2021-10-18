package com.lti.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.BusTbl;
import com.lti.service.BusService;


@RestController
@RequestMapping(path = "Bus")
@CrossOrigin
public class BusAppController {
	@Autowired
	private BusService service1;
	
	@PostMapping(path = "/")
	public void addBus(@RequestBody BusTbl bus) {
		service1.addBus(bus);
	}

	@GetMapping(path = "/")
	public List<BusTbl> getAllBus() {
		List<BusTbl> bus = service1.findAllBus();
		return bus;
	}
	
	@GetMapping(path = "{id}")
	public BusTbl getBusById(@PathVariable("id") int id) {
		BusTbl bus = service1.findBusById(id);
		return bus;
	}
	
	@GetMapping(path = "{from}/{to}")
	public List<BusTbl> getBusByFromTo(@PathVariable("from") String from, @PathVariable("to") String to) {
		List<BusTbl> bus = service1.findBusByFromTo(from, to);
		return bus;
	}
	
	@PutMapping(path = "/")
	public BusTbl updateBusById(@RequestBody BusTbl bus) {
		boolean result = service1.modifyBus(bus);
		if (result)
			bus = service1.findBusById(bus.getId());
		return bus;
	}

	@DeleteMapping(path = "{id}")
	public void deleteBusById(@PathVariable("id") int id) {
		service1.removeBus(id);
	}
	
}
