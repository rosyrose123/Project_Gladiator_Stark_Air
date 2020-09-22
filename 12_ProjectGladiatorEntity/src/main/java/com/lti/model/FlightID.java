package com.lti.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class FlightID implements Serializable {

	@Column(name="Flight_Number")
	private String flightNumber;
	
	@Column(name="Travel_Date")
	private java.sql.Date travelDate;

	public FlightID(String flightNumber, java.sql.Date travelDate) {
		super();
		this.flightNumber = flightNumber;
		this.travelDate = travelDate;
	}

	public FlightID() {
		super();
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public java.sql.Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(java.sql.Date travelDate) {
		this.travelDate = travelDate;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((travelDate == null) ? 0 : travelDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightID other = (FlightID) obj;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (travelDate == null) {
			if (other.travelDate != null)
				return false;
		} else if (!travelDate.equals(other.travelDate))
			return false;
		return true;
	}

}
