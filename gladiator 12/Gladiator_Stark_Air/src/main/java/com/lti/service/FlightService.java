package com.lti.service;

import java.sql.Date;
import java.util.List;

import com.lti.model.Flight;
import com.lti.model.FlightID;

public interface FlightService {
	public boolean addFlight(Flight flight);
	public List<Flight> findAllFlights();
	public boolean modifyFlight(Flight flight);
	public boolean removeFlight(FlightID fid);
	public Flight findFlightById(FlightID fid);
	public List<Flight> findFlightByCustomer(Date travelDate, String source, String destination);

}
