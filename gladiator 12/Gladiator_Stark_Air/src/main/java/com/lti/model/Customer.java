package com.lti.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "Customer")
@Component("customer")
@Scope(scopeName = "prototype")
public class Customer implements Serializable {

	@Id
	@Column(name = "Email_Id")
	private String emailId;

	@Column(name = "First_Name")
	private String firstName;

	@Column(name = "Last_Name")
	private String lastName;

	@Column(name = "Date_Of_Birth")
	private java.sql.Date dateOfBirth;

	@Column(name = "Title")
	private String title;

	@Column(name = "Phonenumber")
	private String phoneNumber;

	@Column(name = "Password")
	private String password;

	@OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL})
	private Set<FlightBooked> bookings = new HashSet<FlightBooked>();

	public Customer(String emailId, String firstName, String lastName, java.sql.Date dateOfBirth, String title, String phoneNumber,
			String password) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.title = title;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public Customer() {
		super();
	}

	public void addBooking(FlightBooked fb) {
		bookings.add(fb);
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public java.sql.Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(java.sql.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", title=" + title + ", phoneNumber=" + phoneNumber + ", password=" + password + "]";
	}

	public Set<FlightBooked> getBookings() {
		return bookings;
	}

	public void setBookings(Set<FlightBooked> bookings) {
		this.bookings = bookings;
	}

}
