package com.lti.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.PassengerDetailsDao;
import com.lti.model.PassengerDetails;


@Service("passengerDetailsService")
public class PassengerDetailsServiceImpl implements PassengerDetailsService{

	@Autowired
	private PassengerDetailsDao passengerDetailsDao;
	
	@Override
	public PassengerDetails findPassengerDetailsById(String bookingId) {
		return passengerDetailsDao.getPassengerDetailsById(bookingId);
	}
	
}
