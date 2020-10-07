package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.FlightBooked;
import com.lti.model.PassengerDetails;


@Repository("PassengerDetailsDao")
public class PassengerDetailsDaoImpl implements PassengerDetailsDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public PassengerDetails getPassengerDetailsById(String bookingId) {
		return entityManager.find(PassengerDetails.class, bookingId);
	}

}
