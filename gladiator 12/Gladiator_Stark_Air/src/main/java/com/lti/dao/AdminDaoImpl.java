package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Admin;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public String createAdmin(Admin admin) {
		entityManager.persist(admin);
		return admin.getUserName();
	}

	@Override
	public List<Admin> readAllAdmins() {
		String jpql = "Select u from Admin u";
		TypedQuery<Admin> tquery = entityManager.createQuery(jpql, Admin.class);
		return tquery.getResultList();

	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int deleteAdmin(String userName){
		Admin admin = entityManager.find(Admin.class, userName);
		entityManager.remove(admin);
		return 1;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Admin updateAdmin(Admin admin) {
		admin = entityManager.merge(admin);
		return admin;
	}

	@Override
	public Admin readAdminById(String userName) {
		
		return entityManager.find(Admin.class, userName);
	}

}
