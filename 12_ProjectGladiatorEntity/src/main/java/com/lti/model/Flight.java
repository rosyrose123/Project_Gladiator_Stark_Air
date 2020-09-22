package com.lti.model;

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

@Entity
@Table(name = "Flight")
public class Flight {

	@EmbeddedId
	private FlightID fid;

	@Column(name = "Source")
	private String source;

	@Column(name = "Destination")
	private String destination;

	@Column(name = "Seats")
	private int seats;

	@Column(name = "Return_Date")
	private java.sql.Date returnDate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "flight")
	private Set<FlightBooked> bookings = new HashSet<FlightBooked>();

	@Column(name = "Arrival_Time")
	private Timestamp arrivaltime;

	@Column(name = "Departure_Time")
	private Timestamp departureTime;
	
	@Column(name="Distance")
	private long distance;

	public FlightID getfId() {
		return fid;
	}

	public void addBooking(FlightBooked fb) {
		bookings.add(fb);
		this.seats = this.seats - fb.getBookedSeats();
	}

	public void setId(FlightID fid) {
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

	public Timestamp getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(Timestamp arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public Timestamp getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

}
