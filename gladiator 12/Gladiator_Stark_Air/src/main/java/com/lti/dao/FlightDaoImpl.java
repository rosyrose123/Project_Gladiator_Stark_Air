package com.lti.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Flight;
import com.lti.model.FlightBooked;
import com.lti.model.FlightID;

@Repository("flightDao")
public class FlightDaoImpl  implements FlightDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public String createFlight(Flight flight) {
		System.out.println(flight.getArrivalTime()+"    arrival time");
		if(readFlightById(flight.getfId())==null)
		{entityManager.persist(flight);
		return flight.getfId().getFlightNumber()+flight.getfId().getTravelDate();
		}
		else
			return "Cannot add. Flight exists";
	}

	@Override
	public List<Flight> readAllFlights() {
		String jpql ="Select f from Flight f where f.adminCancellationStatus=0";
		TypedQuery<Flight> tquery = entityManager.createQuery(jpql, Flight.class);
		return tquery.getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int deleteFlight(FlightID fid) {
		Flight flight = entityManager.find(Flight.class, fid);
		//System.out.println(flight);
		
		if(flight!=null && flight.getAdminCancellationStatus()==0)
		{
			flight.setAdminCancellationStatus(1);
			entityManager.merge(flight);
			return 1;
		}
		else
			return 0;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Flight updateFlight(Flight flight) {
		entityManager.clear();
		flight = entityManager.merge(flight);
		return flight;
	}

	@Override
	public Flight readFlightById(FlightID fid) {
		
		return entityManager.find(Flight.class, fid);
	}

	@Override
	public int addBooking(FlightID fid, FlightBooked fb) {
		Flight flight = readFlightById(fid);
		flight.addBooking(fb);
		updateFlight(flight);
		return 1;
	}

	@Override
	public List<Flight> readFlightByCustomer(Date travelDate, String source, String destination) {
		String jpql ="Select f from Flight f where f.adminCancellationStatus=0 AND f.fid.travelDate=:travelDate AND f.source=:source AND f.destination=:destination";
		TypedQuery<Flight> tquery = entityManager.createQuery(jpql, Flight.class);
		tquery.setParameter("travelDate", travelDate);
		tquery.setParameter("source", source);
		tquery.setParameter("destination", destination);
		return tquery.getResultList();
		
	}

}
