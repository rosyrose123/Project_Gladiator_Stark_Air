package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Customer;
import com.lti.model.FlightBooked;


@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public String createCustomer(Customer customer) {
		entityManager.persist(customer);
		return customer.getEmailId();
	}

	@Override
	public List<Customer> readAllCustomers() {
		String jpql = "Select c from Customer c";
		TypedQuery<Customer> tquery = entityManager.createQuery(jpql, Customer.class);
		return tquery.getResultList();

	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int deleteCustomer(String emailId){
		Customer customer = entityManager.find(Customer.class, emailId);
		entityManager.remove(customer);
		return 1;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Customer updateCustomer(Customer customer) {
		customer = entityManager.merge(customer);
		return customer;
	}

	@Override
	public Customer readCustomerById(String emailId) {
		
		return entityManager.find(Customer.class, emailId);
	}

	@Override
	public int addBooking(String emailId, FlightBooked fb) {
		Customer customer = readCustomerById(emailId);
		customer.addBooking(fb);
		updateCustomer(customer);
		return 1;
	}
	

}
