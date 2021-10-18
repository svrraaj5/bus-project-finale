package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.UserTbl;
import com.lti.service.MailServiceImpl;
import com.lti.service.UserService;

@RestController
@RequestMapping(path = "Users")
@CrossOrigin
public class UserAppController {
	@Autowired
	private UserService service;
	
	@Autowired
	private MailServiceImpl mail;
	
	// http://localhost:9091/UserApp/users
	@PostMapping(path = "/")
	public void addUser(@RequestBody UserTbl user) {
		System.out.println(user);
		service.addUser(user);
	}

	@GetMapping(path = "/")
	public List<UserTbl> getAllUsers() {
		List<UserTbl> users = service.findAllUsers();
		return users;
	}

	@GetMapping(path = "{id}")
	public UserTbl getUserByEmailId(@PathVariable("id") String id) {
		return service.findUserById(id);
	}
	
	@PutMapping(path = "/")
	public UserTbl updateUserEmailId(@RequestBody UserTbl user) {
		boolean result = service.modifyUser(user);
		if(result)
			user = service.findUserById(user.getEmailId());
		return user;
		
	}
	
	@GetMapping(path = "/getOtp/{email}")
	public String getOtp(@PathVariable("email") String email) {
		String cotp = mail.createOtp();
		mail.send(email, "OTP for Password Generation", "<p> Your <b>One Time Password</b> is: "+cotp+"</p>");
		return cotp;
	}
	
	@PutMapping(path = "{email}")
	public void resetPassword(@PathVariable("email") String email, @RequestBody UserTbl user) {
		UserTbl u = service.findUserById(email);
		u.setPass(user.getPass());
		service.modifyUser(u);
	}
	
}
