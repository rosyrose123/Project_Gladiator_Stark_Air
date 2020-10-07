package com.lti.dao;

import java.sql.Date;
import java.util.List;


import com.lti.model.FlightBooked;
import com.lti.model.PassengerDetails;

public interface FlightBookedDao {

	

	public List<FlightBooked> readAllFlightBooked();

	public int deleteFlightBookedByCustomer(String bookingId);

	public FlightBooked addPassengerDetails(PassengerDetails details, String bookingId);

	public FlightBooked readFlightBookedById(String bookingId);
	
	public List<FlightBooked> readFlightHistory(String emailId);
	
	public List<FlightBooked> readUpcomingFlight(String emailId);
	
	

}
