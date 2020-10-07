package com.lti.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.model.FlightBooked;
import com.lti.model.FlightID;
import com.lti.model.PassengerDetails;

@Component
public class BookingDto {
	@Autowired
	private PassengerDetails passengerdetails;
	
	
	@Autowired
	private FlightBooked fb;
	
	@Autowired
	private FlightID fId;
	
	
	private String emailId;
	
	private int lower;
	
	private int upper;

	public PassengerDetails getPassengerdetails() {
		return passengerdetails;
	}

	public void setPassengerdetails(PassengerDetails passengerdetails) {
		this.passengerdetails = passengerdetails;
	}

	public FlightBooked getFb() {
		return fb;
	}

	public void setFb(FlightBooked fb) {
		this.fb = fb;
	}

	public FlightID getfId() {
		return fId;
	}

	public void setfId(FlightID fId) {
		this.fId = fId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	public BookingDto(PassengerDetails passengerdetails, FlightBooked fb, FlightID fId, String emailId, int lower,
			int upper) {
		super();
		this.passengerdetails = passengerdetails;
		this.fb = fb;
		this.fId = fId;
		this.emailId = emailId;
		this.lower = lower;
		this.upper = upper;
	}
	
	

	@Override
	public String toString() {
		return "BookingDto [passengerdetails=" + passengerdetails + ", fb=" + fb + ", fId=" + fId + ", emailId="
				+ emailId + ", lower=" + lower + ", upper=" + upper + "]";
	}

	public BookingDto() {
		
	}

	public int getUpper() {
		return upper;
	}

	public void setUpper(int upper) {
		this.upper = upper;
	}

	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		this.lower = lower;
	}
	
	

}
