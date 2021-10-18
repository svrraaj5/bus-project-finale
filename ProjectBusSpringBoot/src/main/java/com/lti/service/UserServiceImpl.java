package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.UserDao;
import com.lti.model.UserTbl;

@Service("service")
//@Scope(scopeName = "singleton")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao = null;

	@Override
	public boolean addUser(UserTbl user) {
		String result = getDao().createUser(user);
		return (result != "") ? true : false;
	}

	@Override
	public List<UserTbl> findAllUsers() {
		return getDao().readAllUsers();
			}

	@Override
	public UserTbl findUserById(String emailId) {
		
		return getDao().readUserByEmailId(emailId);
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean modifyUser(UserTbl user) {
		UserTbl result = getDao().updateUser(user);
		return (result != null)? true : false;
	}
	
}