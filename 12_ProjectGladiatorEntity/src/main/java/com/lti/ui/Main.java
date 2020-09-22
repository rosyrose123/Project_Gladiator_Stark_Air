package com.lti.ui;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Customer;
import com.lti.model.Flight;
import com.lti.model.FlightBooked;
import com.lti.model.FlightID;
import com.lti.model.PassengerDetails;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = factory.createEntityManager();

		// Adding flight 1
		Flight flight = new Flight();
		FlightID fid = new FlightID();
		fid.setFlightNumber("FX505D");
		LocalDate date = LocalDate.of(2020, 10, 25);
		fid.setTravelDate(Date.valueOf(date));
		flight.setId(fid);
		flight.setSource("Mumbai");
		flight.setDestination("New Delhi");
		flight.setReturnDate(Date.valueOf(LocalDate.of(2020, 10, 26)));
		LocalTime atime1 = LocalTime.of(9, 30);
		flight.setArrivaltime(Timestamp.valueOf(LocalDateTime.of(date, atime1)));
		flight.setSeats(60);
		LocalTime dtime1 = LocalTime.of(10, 30);
		flight.setDepartureTime(Timestamp.valueOf(LocalDateTime.of(date, dtime1)));
		flight.setDistance(774);

		// Adding flight 2
		Flight flight2 = new Flight();
		FlightID fid2 = new FlightID();
		fid2.setFlightNumber("DB808C");
		LocalDate date2 = LocalDate.of(2020, 10, 23);
		fid2.setTravelDate(Date.valueOf(date2));
		flight2.setId(fid2);
		flight2.setSource("Hyderabad");
		flight2.setDestination("Kolkata");
		flight2.setReturnDate(Date.valueOf(LocalDate.of(2020, 10, 26)));
		LocalTime atime2 = LocalTime.of(11, 30);
		flight2.setArrivaltime(Timestamp.valueOf(LocalDateTime.of(date2, atime2)));
		flight2.setSeats(60);
		LocalTime dtime2 = LocalTime.of(12, 30);
		flight2.setDepartureTime(Timestamp.valueOf(LocalDateTime.of(date2, dtime2)));
		flight2.setDistance(890);

		// Adding flight 3
		Flight flight3 = new Flight();
		FlightID fid3 = new FlightID();
		fid3.setFlightNumber("DC198H");
		LocalDate date3 = LocalDate.of(2020, 10, 27);
		fid3.setTravelDate(Date.valueOf(date3));
		flight3.setId(fid3);
		flight3.setSource("Bangalore");
		flight3.setDestination("Chennai");
		flight3.setReturnDate(Date.valueOf(LocalDate.of(2020, 10, 28)));
		LocalTime atime3 = LocalTime.of(11, 45);
		flight3.setArrivaltime(Timestamp.valueOf(LocalDateTime.of(date3, atime3)));
		flight3.setSeats(60);
		LocalTime dtime3 = LocalTime.of(12, 30);
		flight3.setDepartureTime(Timestamp.valueOf(LocalDateTime.of(date3, dtime3)));
		flight3.setDistance(885);

		// Adding customers
		Customer customer1 = new Customer("abc", "Mukul", "Katiyar", java.sql.Date.valueOf(LocalDate.of(1998, 11, 18)),
				"Mr", "8960883635", "SolidusSnake");
		Customer customer2 = new Customer("xyz", "Avinash", "Katiyar", java.sql.Date.valueOf(LocalDate.of(1960, 8, 15)),
				"Mr", "8960806877", "VenomSnake");

		// Adding flight booking 1
		FlightBooked fb = new FlightBooked();
		fb.setBookingId("GX7894");
		fb.setAdminCancellationStatus(0);
		fb.setBookingDate(Date.valueOf(LocalDate.of(2020, 8, 21)));
		fb.setCustomer(customer1);
		fb.setCustomerCancelledStatus(0);
		fb.setFlight(flight);
		fb.setTransactionId(001);
		fb.setBookedSeats(2);
		fb.setPaymentMethod("PayTM");

		// Passenger Details for flight booking 1
		PassengerDetails details = new PassengerDetails(fb);
		details.setPassenger1Name("Geralt");
		details.setPassenger1Age(85);
		details.setPassenger1Gender("Male");
		details.setPassenger1SeatNumber(24);
		details.setPassenger2Name("Yennefer");
		details.setPassenger2Age(84);
		details.setPassenger2Gender("Female");
		details.setPassenger2SeatNumber(25);

		// Add passenger details to flight booking 1
		fb.addDetails(details);

		// Adding flight booking 2
		FlightBooked fb2 = new FlightBooked();
		fb2.setBookingId("CD6785");
		fb2.setAdminCancellationStatus(0);
		fb2.setBookingDate(Date.valueOf(LocalDate.of(2020, 8, 20)));
		fb2.setCustomer(customer2);
		fb2.setCustomerCancelledStatus(0);
		fb2.setFlight(flight2);
		fb2.setTransactionId(002);
		fb2.setBookedSeats(1);
		fb2.setPaymentMethod("Credit Card");

		// Passenger Details for flight booking 2
		PassengerDetails details2 = new PassengerDetails(fb2);
		details2.setPassenger1Name("Mario");
		details2.setPassenger1Age(34);
		details2.setPassenger1Gender("Male");
		details2.setPassenger1SeatNumber(11);

		// Add passenger details to flight booking 2
		fb2.addDetails(details2);

		// Associating the booking with flights and customers.
		flight.addBooking(fb);
		customer1.addBooking(fb);

		flight2.addBooking(fb2);
		customer2.addBooking(fb2);

		// Persisting the customer and flight objects while simultaneously persisting
		// flight booking object by cascading property
		entityManager.getTransaction().begin();
		entityManager.persist(flight);
		entityManager.persist(flight2);
		entityManager.persist(flight3);
		entityManager.persist(customer1);
		entityManager.persist(customer2);
		entityManager.getTransaction().commit();

		FlightBooked fb3 = new FlightBooked();
		fb3.setBookingId("GF3460");
		fb3.setAdminCancellationStatus(0);
		fb3.setBookingDate(Date.valueOf(LocalDate.of(2020, 8, 22)));
		fb3.setCustomer(customer2);
		fb3.setCustomerCancelledStatus(0);
		fb3.setFlight(flight3);
		fb3.setTransactionId(002);
		fb3.setBookedSeats(2);
		fb3.setPaymentMethod("Debit Card");

		// Passenger Details for fb3
		PassengerDetails details3 = new PassengerDetails(fb3);
		details3.setPassenger1Name("Link");
		details3.setPassenger1Age(17);
		details3.setPassenger1Gender("Male");
		details3.setPassenger1SeatNumber(21);
		details3.setPassenger2Name("Zelda");
		details3.setPassenger2Age(17);
		details3.setPassenger2Gender("Female");
		details3.setPassenger2SeatNumber(22);

		// Add passenger details to fb3
		fb3.addDetails(details3);

		// Add fb3 to flight3
		flight3.addBooking(fb3);

		entityManager.getTransaction().begin();
		entityManager.merge(flight3);
		entityManager.getTransaction().commit();

	}

}
