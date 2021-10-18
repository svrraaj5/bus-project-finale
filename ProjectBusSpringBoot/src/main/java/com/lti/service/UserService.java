package com.lti.service;

import java.util.List;

import com.lti.model.UserTbl;

public interface UserService {
	public boolean addUser(UserTbl user);

	public List<UserTbl> findAllUsers();

	public UserTbl findUserById(String emailId);
	
	public boolean modifyUser(UserTbl user);
}
