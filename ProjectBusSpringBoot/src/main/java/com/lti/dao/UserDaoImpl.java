package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.UserTbl;

@Repository
//@Scope(scopeName = "singleton")
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public String createUser(UserTbl user) {
		entityManager.persist(user);
		return user.getEmailId();
	}

	@Override
	public List<UserTbl> readAllUsers() {
		String jpql = "Select u From UserTbl u";
		TypedQuery<UserTbl> tquery = entityManager.createQuery(jpql, UserTbl.class);
		return tquery.getResultList();
	}

	/*
	 * @Override public UserTbl updateUser(UserTbl user) { user =
	 * entityManager.merge(user); return user; }
	 */

	@Override
	public UserTbl readUserByEmailId(String emailId) {

		return entityManager.find(UserTbl.class, emailId);
	}

	@Override
	@Transactional
	public UserTbl updateUser(UserTbl user) {
		user = entityManager.merge(user);
		return user;
	}

}
