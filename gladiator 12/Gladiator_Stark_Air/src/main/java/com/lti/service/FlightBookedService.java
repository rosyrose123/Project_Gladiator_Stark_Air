package com.lti.service;

import java.util.List;

import com.lti.model.FlightBooked;

public interface FlightBookedService {
	
	public List<FlightBooked> getAllFlightBooked();
	
	public List<FlightBooked> getFlightHistory(String emailId);
	
	public List<FlightBooked> getUpcomingFlight(String emailId);

	public void cancelFlight(String bookingId);

	public FlightBooked getFlightBookedById(String bookingId);
}
