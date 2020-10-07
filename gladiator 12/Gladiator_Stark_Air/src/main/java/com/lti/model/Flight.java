package com.lti.model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "FLIGHT")
@Component("flight")
@Scope(scopeName = "prototype")
public class Flight implements Serializable{

	@EmbeddedId
	private FlightID fid;

	@Column(name = "SOURCE")
	private String source;

	@Column(name = "DESTINATION")
	private String destination;

	@Column(name = "SEATS")
	private int seats;

	@Column(name = "RETURN_DATE")
	private java.sql.Date returnDate;
	
	@Column(name="DESTINATION_ARRIVAL_DATE")
	private java.sql.Date destinationArrivalDate;

	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "flight")
	private Set<FlightBooked> bookings = new HashSet<FlightBooked>();

	@Column(name = "ARRIVAL_TIME")
	private String arrivalTime;

	@Column(name = "DEPARTURE_TIME")
	private String departureTime;
	
	@Column(name="BASE_FARE")
	private double baseFare;
	
	@Column(name="ADMIN_CANCELLATION_STATUS")
	private int adminCancellationStatus;
	
	@Column(name="UPPER")
	private int upper;
	
	@Column(name="LOWER")
	private int lower;

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

	public FlightID getfId() {
		return fid;
	}

	public void addBooking(FlightBooked fb) {
		bookings.add(fb);
		this.seats = this.seats - fb.getBookedSeats();
	}

	public void setfId(FlightID fid) {
		this.fid = fid;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public java.sql.Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(java.sql.Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Flight [fid=" + fid + ", source=" + source + ", destination=" + destination + ", seats=" + seats
				+ ", returnDate=" + returnDate + "]";
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public double getBaseFare() {
		return baseFare;
	}

	public void setDistance(double baseFare) {
		this.baseFare = baseFare;
	}

	public java.sql.Date getDestinationArrivalDate() {
		return destinationArrivalDate;
	}

	public void setDestinationArrivalDate(java.sql.Date destinationArrivalDate) {
		this.destinationArrivalDate = destinationArrivalDate;
	}

	public int getAdminCancellationStatus() {
		return adminCancellationStatus;
	}

	public void setAdminCancellationStatus(int adminCancellationStatus) {
		this.adminCancellationStatus = adminCancellationStatus;
	}

}
