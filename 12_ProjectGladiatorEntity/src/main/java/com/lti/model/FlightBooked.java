package com.lti.model;

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

@Entity
@Table(name = "Flight_Booked")
public class FlightBooked {

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
	private int customerCancelledStatus;

	@Column(name = "Number_Of_Seats")
	private int bookedSeats;
	
	@Column(name="Method_Of_Payment")
	private String paymentMethod;
	
	@Column(name="Total_Fare")
	private double totalFare;

	@ManyToOne
	@JoinColumn(name = "Email_Id")
	private Customer customer;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "Flight_Number", referencedColumnName = "Flight_Number"),
			@JoinColumn(name = "Travel_Date", referencedColumnName = "Travel_Date") })
	private Flight flight;
	
	@OneToOne(mappedBy="fb", cascade=CascadeType.ALL)
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

	public int getCustomerCancelledStatus() {
		return customerCancelledStatus;
	}

	public void setCustomerCancelledStatus(int customerCancelledStatus) {
		this.customerCancelledStatus = customerCancelledStatus;
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
				+ customerCancelledStatus + ", customer=" + customer + ", flight=" + flight + "]";
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
