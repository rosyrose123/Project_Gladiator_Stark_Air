package com.lti.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dao.PassengerDetailsDao;
import com.lti.dto.BookingDto;
import com.lti.model.Customer;
import com.lti.model.Flight;
import com.lti.model.FlightBooked;
import com.lti.model.FlightID;
import com.lti.model.OTPSystem;
import com.lti.model.PassengerDetails;
import com.lti.service.CustomerService;
import com.lti.service.FlightBookedService;
import com.lti.service.FlightService;
import com.lti.service.PassengerDetailsService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping(path = "customer")
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PassengerDetailsService passengerDetailsService;

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private FlightBookedService flightBookedService;

	private Map<String, OTPSystem> otp_data = new HashMap<String, OTPSystem>();

	private final static String ACCOUNT_SID = "AC104b82fdd1715caf7de75ce8c5f4b86a";
	private final static String AUTH_ID = "39adf329c1c40169717653eaf739e0d6";

	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}

	@GetMapping(path = "/sent/{email}")
	public String sendOTP(@PathVariable("email") String email) {
		if (customerService.findCustomerById(email) != null) {
			OTPSystem otpSystem = new OTPSystem();
			otpSystem.setMobileNumber(customerService.findCustomerById(email).getPhoneNumber());
			otpSystem.setOtp(String.valueOf(((int) (Math.random() * (10000 - 1000))) + 1000));
			otpSystem.setExpiryTime(System.currentTimeMillis() + 90000);
			otp_data.put(customerService.findCustomerById(email).getPhoneNumber(), otpSystem);
			Message.creator(new PhoneNumber(customerService.findCustomerById(email).getPhoneNumber()),
					new PhoneNumber("+13344714435"), "Your OTP is : " + otpSystem.getOtp()).create();
			System.out.println("OTP sent successfully");
			return "true";
		}
		System.out.println("Failed to sent OTP");
		return "false";
	}

	@PutMapping(path = "/verify/{email}")
	public String verifyOTP(@PathVariable("email") String email, @RequestBody OTPSystem requestOTPSystem) {
		if (requestOTPSystem.getOtp() == null || requestOTPSystem.getOtp().trim().length() <= 0) {
			System.out.println("Please enter OTP");
			return "false";
		}

		if (otp_data.containsKey(customerService.findCustomerById(email).getPhoneNumber())) {
			OTPSystem otpSystem = otp_data.get(customerService.findCustomerById(email).getPhoneNumber());
			if (otpSystem != null) {
				if (otpSystem.getExpiryTime() >= System.currentTimeMillis()) {
					if (requestOTPSystem.getOtp().equals(otpSystem.getOtp())) {
						System.out.println("OTP is Verified");
						return "true";
					}
				}
			}
		}
		System.out.println("OTP verification failed");
		return "false";
	}

	@PostMapping(path = "/register")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}

	@GetMapping(path = "/{emailId}/{password}")
	public String customerLoginAuthentication(@PathVariable("emailId") String emailId,
			@PathVariable("password") String password) {
		return customerService.customerLoginAuthentication(emailId, password);
	}

	@GetMapping(path = "/{travelDate}/{source}/{destination}")
	public List<Flight> searchFlight(@PathVariable("travelDate") Date travelDate, @PathVariable("source") String source,
			@PathVariable("destination") String destination) {
		
		return flightService.findFlightByCustomer(travelDate, source, destination);
	}

	
	
	@GetMapping(path = "/update/{emailId}/{password}")
	public void customerChangePassword(@PathVariable("emailId") String emailId,
			@PathVariable("password") String password) {
		System.out.println("there gfds");
		 customerService.customerUpdatePassword(emailId, password);
	}

//	/*
//	 * @PostMapping(path = "/confirmBooking.do") public void
//	 * confirmBooking(@RequestBody PassengerDetails customer,@RequestBody Customer
//	 * customer) {
	@PostMapping(path = "/confirmBooking.do")
	public void confirmBooking(@RequestBody BookingDto dto) {
		Flight flight = flightService.findFlightById(dto.getfId());
		Customer customer = customerService.findCustomerById(dto.getEmailId());
		
		FlightBooked fb = dto.getFb();
		
		
		PassengerDetails details = dto.getPassengerdetails();
		details.setFb(fb);
		fb.addDetails(details);
		
		fb.setCustomer(customer);
		fb.setFlight(flight);
		
		flight.addBooking(fb);
		customer.addBooking(fb);
		
		flight.setUpper(dto.getUpper());
		flight.setLower(dto.getLower());
		
		flightService.modifyFlight(flight);
	}
	
	@GetMapping(path="/upcomingFlight/{emailId}")
    public List<FlightBooked> upcomingFlights(@PathVariable("emailId") String emailId){
		System.out.println(new java.sql.Date(Calendar.getInstance().getTimeInMillis())+" Sample");
		return this.flightBookedService.getUpcomingFlight(emailId);
	}
	
	@GetMapping(path="/flightHistory/{emailId}")
    public List<FlightBooked> flightHistory(@PathVariable("emailId") String emailId){
		return this.flightBookedService.getFlightHistory(emailId);
	}

	@GetMapping(path="/flightDelete/{bookingId}")
	public void cancelFlight(@PathVariable("bookingId") String bookingId) {
		//flightBookedService.cancelFlight(bookingId);
		FlightBooked fb=flightBookedService.getFlightBookedById(bookingId);
		System.out.println(fb);
		Flight flight=fb.getFlight();
		//PassengerDetails passengerDetails=fb.details;
		PassengerDetails passengerDetails=passengerDetailsService.findPassengerDetailsById(bookingId);	
		System.out.println(passengerDetails);
		int seat1=passengerDetails.getPassenger1SeatNumber();
		int seat2=passengerDetails.getPassenger2SeatNumber();
		int seat3=passengerDetails.getPassenger3SeatNumber();
		int seat4=passengerDetails.getPassenger4SeatNumber();
		int lower=flight.getLower();
		int upper=flight.getUpper();
		int cnt=0;
		if(seat1>0) {
			cnt++;
			int tmp=seat1;
			if(seat1>24) {
				tmp=seat1-24;
				tmp--;
				upper=(upper^(1<<tmp));
			}
			else {
				tmp--;
				lower=(lower^(1<<tmp));
				
			}
			
		}
		if(seat2>0) {
			cnt++;
			int tmp=seat2;
			if(seat2>24) {
				tmp=seat2-24;
				tmp--;
				upper=(upper^(1<<tmp));
			}
			else {
				tmp--;
				lower=(lower^(1<<tmp));
				
			}
			
		}
		if(seat3>0) {
			cnt++;
			int tmp=seat3;
			if(seat3>24) {
				tmp=seat3-24;
				tmp--;
				upper=(upper^(1<<tmp));
			}
			else {
				tmp--;
				lower=(lower^(1<<tmp));
				
			}
		}
		if(seat4>0) {
			cnt++;
			int tmp=seat4;
			if(seat4>24) {
				tmp=seat4-24;
				tmp--;
				upper=(upper^(1<<tmp));
			}
			else {
				tmp--;
				lower=(lower^(1<<tmp));
				
			}
		}
		flight.setUpper(upper);
		flight.setLower(lower);
		flight.setSeats(flight.getSeats()+fb.getBookedSeats());
		flightService.modifyFlight(flight);
		flightBookedService.cancelFlight(bookingId);
	}
	
}