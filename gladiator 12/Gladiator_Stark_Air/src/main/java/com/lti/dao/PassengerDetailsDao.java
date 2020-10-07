package com.lti.dao;

import com.lti.model.PassengerDetails;

public interface PassengerDetailsDao {
	public PassengerDetails getPassengerDetailsById(String bookingId);
}
