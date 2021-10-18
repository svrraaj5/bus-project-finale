package com.lti.dao;

import java.util.List;

import com.lti.model.UserTbl;


public interface UserDao {
	public String createUser(UserTbl user);

	public List<UserTbl> readAllUsers();

	public UserTbl updateUser(UserTbl user);

	public UserTbl readUserByEmailId(String emailId);

}
