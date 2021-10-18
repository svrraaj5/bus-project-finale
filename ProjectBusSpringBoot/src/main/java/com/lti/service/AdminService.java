package com.lti.service;

import java.util.List;

import com.lti.model.Admin;

public interface AdminService {

	public boolean addAdmin(Admin admin);

	public List<Admin> findAllAdmin();
}
