package com.lti.dao;

import java.sql.Date;
import java.util.List;

import com.lti.model.Flight;
import com.lti.model.FlightBooked;
import com.lti.model.FlightID;

public interface FlightDao {
	
	public String createFlight(Flight flight);
	public List<Flight> readAllFlights();
	public int deleteFlight(FlightID fid);
	public Flight updateFlight(Flight flight);
	public Flight readFlightById(FlightID fid);
	public int addBooking(FlightID fid, FlightBooked fb);
	public List<Flight> readFlightByCustomer(Date travelDate, String source, String destination);

}
