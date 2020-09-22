package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Passenger_Details")
public class PassengerDetails {

	@Id
	@Column(name = "Booking_Id")
	private String bookingId;

	@OneToOne
	@PrimaryKeyJoinColumn(name = "Booking_Id", referencedColumnName = "Booking_Id")
	private FlightBooked fb;

	@Column(name = "Passenger1_Name")
	private String passenger1Name;

	@Column(name = "Passenger1_Gender")
	private String passenger1Gender;

	@Column(name = "Passenger1_Age")
	private int passenger1Age;

	@Column(name = "Passenger1_Seat_Number")
	private int passenger1SeatNumber;

	@Column(name = "Passenger2_Name")
	private String passenger2Name;

	@Column(name = "Passenger2_Gender")
	private String passenger2Gender;

	@Column(name = "Passenger2_Age")
	private int passenger2Age;

	@Column(name = "Passenger2_Seat_Number")
	private int passenger2SeatNumber;

	@Column(name = "Passenger3_Name")
	private String passenger3Name;

	@Column(name = "Passenger3_Gender")
	private String passenger3Gender;

	@Column(name = "Passenger3_Age")
	private int passenger3Age;

	@Column(name = "Passenger3_Seat_Number")
	private int passenger3SeatNumber;

	@Column(name = "Passenger4_Name")
	private String passenger4Name;

	@Column(name = "Passenger4_Gender")
	private String passenger4Gender;

	@Column(name = "Passenger4_Age")
	private int passenger4Age;

	@Column(name = "Passenger4_Seat_Number")
	private int passenger4SeatNumber;
	
	public PassengerDetails() {
		
	}
	public PassengerDetails(FlightBooked fb) {
        this.bookingId = fb.getBookingId();
        this.fb = fb;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getPassenger1Name() {
		return passenger1Name;
	}

	public void setPassenger1Name(String passenger1Name) {
		this.passenger1Name = passenger1Name;
	}

	public String getPassenger1Gender() {
		return passenger1Gender;
	}

	public void setPassenger1Gender(String passenger1Gender) {
		this.passenger1Gender = passenger1Gender;
	}

	public int getPassenger1Age() {
		return passenger1Age;
	}

	public void setPassenger1Age(int passenger1Age) {
		this.passenger1Age = passenger1Age;
	}

	public int getPassenger1SeatNumber() {
		return passenger1SeatNumber;
	}

	public void setPassenger1SeatNumber(int passenger1SeatNumber) {
		this.passenger1SeatNumber = passenger1SeatNumber;
	}

	public String getPassenger2Name() {
		return passenger2Name;
	}

	public void setPassenger2Name(String passenger2Name) {
		this.passenger2Name = passenger2Name;
	}

	public String getPassenger2Gender() {
		return passenger2Gender;
	}

	public void setPassenger2Gender(String passenger2Gender) {
		this.passenger2Gender = passenger2Gender;
	}

	public int getPassenger2Age() {
		return passenger2Age;
	}

	public void setPassenger2Age(int passenger2Age) {
		this.passenger2Age = passenger2Age;
	}

	public int getPassenger2SeatNumber() {
		return passenger2SeatNumber;
	}

	public void setPassenger2SeatNumber(int passenger2SeatNumber) {
		this.passenger2SeatNumber = passenger2SeatNumber;
	}

	public String getPassenger3Name() {
		return passenger3Name;
	}

	public void setPassenger3Name(String passenger3Name) {
		this.passenger3Name = passenger3Name;
	}

	public String getPassenger3Gender() {
		return passenger3Gender;
	}

	public void setPassenger3Gender(String passenger3Gender) {
		this.passenger3Gender = passenger3Gender;
	}

	public int getPassenger3Age() {
		return passenger3Age;
	}

	public void setPassenger3Age(int passenger3Age) {
		this.passenger3Age = passenger3Age;
	}

	public int getPassenger3SeatNumber() {
		return passenger3SeatNumber;
	}

	public void setPassenger3SeatNumber(int passenger3SeatNumber) {
		this.passenger3SeatNumber = passenger3SeatNumber;
	}

	public String getPassenger4Name() {
		return passenger4Name;
	}

	public void setPassenger4Name(String passenger4Name) {
		this.passenger4Name = passenger4Name;
	}

	public String getPassenger4Gender() {
		return passenger4Gender;
	}

	public void setPassenger4Gender(String passenger4Gender) {
		this.passenger4Gender = passenger4Gender;
	}

	public int getPassenger4Age() {
		return passenger4Age;
	}

	public void setPassenger4Age(int passenger4Age) {
		this.passenger4Age = passenger4Age;
	}

	public int getPassenger4SeatNumber() {
		return passenger4SeatNumber;
	}

	public void setPassenger4SeatNumber(int passenger4SeatNumber) {
		this.passenger4SeatNumber = passenger4SeatNumber;
	}

	@Override
	public String toString() {
		return "PassengerDetails [bookingId=" + bookingId + ", passenger1Name=" + passenger1Name + ", passenger1Gender="
				+ passenger1Gender + ", passenger1Age=" + passenger1Age + ", passenger1SeatNumber="
				+ passenger1SeatNumber + ", passenger2Name=" + passenger2Name + ", passenger2Gender=" + passenger2Gender
				+ ", passenger2Age=" + passenger2Age + ", passenger2SeatNumber=" + passenger2SeatNumber
				+ ", passenger3Name=" + passenger3Name + ", passenger3Gender=" + passenger3Gender + ", passenger3Age="
				+ passenger3Age + ", passenger3SeatNumber=" + passenger3SeatNumber + ", passenger4Name="
				+ passenger4Name + ", passenger4Gender=" + passenger4Gender + ", passenger4Age=" + passenger4Age
				+ ", passenger4SeatNumber=" + passenger4SeatNumber + "]";
	}

}
