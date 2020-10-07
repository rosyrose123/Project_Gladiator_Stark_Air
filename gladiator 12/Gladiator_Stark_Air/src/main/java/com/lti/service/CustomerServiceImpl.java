package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.CustomerDao;
import com.lti.model.Customer;


@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addCustomer(Customer customer) {

		String result = customerDao.createCustomer(customer);
		return (result!=null) ? true : false;
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerDao.readAllCustomers();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean modifyCustomer(Customer customer) {
		Customer result = customerDao.updateCustomer(customer);
		return (result!=null) ? true : false;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean removeCustomer(String emailId) {
		int result = customerDao.deleteCustomer(emailId);
		return (result == 1) ? true : false;
	}

	@Override
	public Customer findCustomerById(String emailId) {
		return customerDao.readCustomerById(emailId);
	}

	@Override
	public String customerLoginAuthentication(String emailId, String password) {
		Customer result = customerDao.readCustomerById(emailId);
		
		if(result!=null) {
		if(password.equals(result.getPassword()))
			return "Success";
		else
			return "Faliure. Invalid password";
		}
		else
			return "Invalid username";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String customerUpdatePassword(String emailId, String password) {
		Customer customer = customerDao.readCustomerById(emailId);

		System.out.println(customer);
		customer.setPassword(password);
		customerDao.updateCustomer(customer);
		Customer customer2 = customerDao.readCustomerById(emailId);
		System.out.println("chenged");
		System.out.println(customer2);
		return "ok";
	}

}
