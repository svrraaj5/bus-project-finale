package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.model.Admin;

@Service("service4")
//@Scope(scopeName = "singleton")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao dao = null;

	@Override
	public boolean addAdmin(Admin admin) {
		String result = dao.createAdmin(admin);
		return (result != null) ? true : false;
	}

	@Override
	public List<Admin> findAllAdmin() {
		return dao.readAdmin();
	}

}
