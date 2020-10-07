package com.lti.dao;

import java.util.List;

import com.lti.model.Customer;
import com.lti.model.FlightBooked;

public interface CustomerDao {
	public String createCustomer(Customer customer);
	public List<Customer> readAllCustomers();
	public int deleteCustomer(String emailId);
	public Customer updateCustomer(Customer customer);
	public Customer readCustomerById(String emailId);
	public int addBooking(String emailId, FlightBooked fb);

}
