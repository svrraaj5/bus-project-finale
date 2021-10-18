package com.lti.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.BusTbl;

@Repository
public class BusDaoImpl implements BusDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public int createBus(BusTbl bus) {
		entityManager.persist(bus);
		return bus.getId();
	}

	@Override
	public List<BusTbl> readAllBus() {
		String jpql = "Select b From BusTbl b";
		TypedQuery<BusTbl> tquery = entityManager.createQuery(jpql, BusTbl.class);
		return tquery.getResultList();

	}

	@Override
	@Transactional
	public BusTbl updateBus(BusTbl bus) {
		bus = entityManager.merge(bus);
		return bus;
	}
	

	@Override
	public BusTbl readBusById(int id) {
		String jpql = "Select b From BusTbl b where b.id = :id and b.busStatus = 1";
		TypedQuery<BusTbl> tquery = entityManager.createQuery(jpql, BusTbl.class);
		tquery.setParameter("id", id);
		return tquery.getSingleResult();
	}

	@Override
	public List<BusTbl> readBusByFromTo(String from, String to) {
		String jpql = "Select b From BusTbl b where b.source = :s and b.destination = :d and b.busStatus = 1 and b.totalSeat>0";
		TypedQuery<BusTbl> tquery = entityManager.createQuery(jpql, BusTbl.class);
		tquery.setParameter("s", from);
		tquery.setParameter("d", to);
		return tquery.getResultList();
	}

	@Override
	@Transactional
	public int deleteBus(int id) {
		String jpql1 = "Delete From BusTbl b where b.id = :id";
		Query query1 = entityManager.createQuery(jpql1);
		query1.setParameter("id", id);
		query1.executeUpdate();
		return 1;
	}



}
