package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.FlightBookedDao;
import com.lti.model.FlightBooked;

@Service("flightBookedService")
public class FlightBookedServiceImpl implements FlightBookedService {

	@Autowired
	private FlightBookedDao flightBookedDao;
	@Override
	public List<FlightBooked> getAllFlightBooked() {
		return flightBookedDao.readAllFlightBooked();
	}

	@Override
	public List<FlightBooked> getFlightHistory(String emailId) {
		return flightBookedDao.readFlightHistory(emailId);
	}

	@Override
	public List<FlightBooked> getUpcomingFlight(String emailId) {
		return flightBookedDao.readUpcomingFlight(emailId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void cancelFlight(String bookingId) {
		flightBookedDao.deleteFlightBookedByCustomer(bookingId);
		
	}

	@Override
	public FlightBooked getFlightBookedById(String bookingId) {
		// TODO Auto-generated method stub
		return flightBookedDao.readFlightBookedById(bookingId);
	}

}
