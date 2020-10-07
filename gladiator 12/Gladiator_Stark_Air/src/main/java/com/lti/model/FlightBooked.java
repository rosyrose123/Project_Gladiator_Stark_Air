package com.lti.model;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Component
@Entity
@Table(name = "Flight_Booked")
public class FlightBooked implements Serializable{

	
	
	public FlightBooked(String bookingId, long transactionId, java.sql.Date bookingDate, int adminCancellationStatus,
			int customerCancellationStatus, int bookedSeats, String paymentMethod, double totalFare, Customer customer,
			Flight flight) {
		super();
		this.bookingId = bookingId;
		this.transactionId = transactionId;
		this.bookingDate = bookingDate;
		this.adminCancellationStatus = adminCancellationStatus;
		this.customerCancellationStatus = customerCancellationStatus;
		this.bookedSeats = bookedSeats;
		this.paymentMethod = paymentMethod;
		this.totalFare = totalFare;
		this.customer = customer;
		this.flight = flight;
		
	}

	@Id
	@Column(name = "Booking_Id")
	private String bookingId;

	@Column(name = "Transaction_Id")
	private long transactionId;

	@Column(name = "Booking_Date")
	private java.sql.Date bookingDate;

	@Column(name = "Admin_Cancellation_Status")
	private int adminCancellationStatus;


	@Column(name = "Customer_Cancellation_Status")
	private int customerCancellationStatus;

	@Column(name = "Number_Of_Seats")
	private int bookedSeats;
	
	@Column(name="Method_Of_Payment")
	private String paymentMethod;
	
	@Column(name="Total_Fare")
	private double totalFare;

	@JsonIgnoreProperties("bookings")
	@ManyToOne
	@JoinColumn(name = "Email_Id")
	private Customer customer;

	@JsonIgnoreProperties("bookings")
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "Flight_Number", referencedColumnName = "Flight_Number"),
			@JoinColumn(name = "Travel_Date", referencedColumnName = "Travel_Date") })
	private Flight flight;
	
	@OneToOne(mappedBy="fb", cascade= {CascadeType.ALL})
    private PassengerDetails details;
	
	

	public void addDetails(PassengerDetails details) {
		this.details = details;
	}

	public FlightBooked() {
		super();
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public java.sql.Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(java.sql.Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getAdminCancellationStatus() {
		return adminCancellationStatus;
	}

	public void setAdminCancellationStatus(int adminCancellationStatus) {
		this.adminCancellationStatus = adminCancellationStatus;
	}

	public int getCustomerCancellationStatus() {
		return customerCancellationStatus;
	}

	public void setCustomerCancellationStatus(int customerCancellationStatus) {
		this.customerCancellationStatus =customerCancellationStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "FlightBooked [bookingId=" + bookingId + ", transactionId=" + transactionId + ", bookingDate="
				+ bookingDate + ", adminCancellationStatus=" + adminCancellationStatus + ", customerCancelledStatus="
				+ customerCancellationStatus + ", customer=" + customer + ", flight=" + flight + "]";
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

}
