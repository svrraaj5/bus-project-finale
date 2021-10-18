package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Admin;

@Repository
//@Scope(scopeName = "singleton")
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public String createAdmin(Admin admin) {
		entityManager.persist(admin);
		return admin.getEmailId();
	}

	@Override
	@Transactional
	public List<Admin> readAdmin() {
		String jpql = "Select a From Admin a";
		TypedQuery<Admin> tquery = entityManager.createQuery(jpql, Admin.class);
		return tquery.getResultList();
	}

}
