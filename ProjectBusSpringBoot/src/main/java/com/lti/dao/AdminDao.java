package com.lti.dao;

import java.util.List;

import com.lti.model.Admin;

public interface AdminDao {

	public String createAdmin(Admin admin);

	public List<Admin> readAdmin();

}
