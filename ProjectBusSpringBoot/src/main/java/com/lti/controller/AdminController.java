package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Admin;
import com.lti.service.AdminService;

@RestController
@RequestMapping(path = "Admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	private AdminService service4;

	@PostMapping(path = "/")
	public void addAdmin(@RequestBody Admin admin) {
		service4.addAdmin(admin);
	}

	@GetMapping(path = "/")
	public List<Admin> getAllAdmin() {
		List<Admin> admin = service4.findAllAdmin();
		return admin;
	}
}
