package com.lti.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.FlightDao;
import com.lti.model.Flight;
import com.lti.model.FlightID;

@Service("flightService")
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private FlightDao flightDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addFlight(Flight flight) {

		String result = flightDao.createFlight(flight);
		return (result!=null) ? true : false;
	}

	@Override
	public List<Flight> findAllFlights() {
		return flightDao.readAllFlights();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean modifyFlight(Flight flight) {
		Flight result = flightDao.updateFlight(flight);
		return (result!=null) ? true : false;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean removeFlight(FlightID fid) {
		int result = flightDao.deleteFlight(fid);
		return (result == 1) ? true : false;
	}

	@Override
	public Flight findFlightById(FlightID fid) {
		return flightDao.readFlightById(fid);
	}

	@Override
	public List<Flight> findFlightByCustomer(Date travelDate, String source, String destination) {
		return flightDao.readFlightByCustomer(travelDate, source, destination);
	}


}
