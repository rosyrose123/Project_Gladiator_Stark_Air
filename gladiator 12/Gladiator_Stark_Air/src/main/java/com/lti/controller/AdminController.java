package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Admin;
import com.lti.model.Flight;
import com.lti.model.FlightBooked;
import com.lti.model.FlightID;
import com.lti.service.AdminService;
import com.lti.service.FlightBookedService;
import com.lti.service.FlightService;



@RestController
@RequestMapping(path="admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private FlightBookedService flightBookedService;
	
	@PostMapping(path="/")
	public String adminLoginAuthentication(@RequestBody Admin admin) {
		return service.adminLoginAuthentication(admin);
	}
	
	@PostMapping(path="/addFlight.do")
	public String addFlightByAdmin(@RequestBody Flight flight) {
		return service.addFlightByAdmin(flight);
	}
	
	@GetMapping(path="/viewFlights.do")
	public List<Flight> getAllFlights(){
		return flightService.findAllFlights();
	}
	
	@PostMapping(path = "/deleteFlight.do")
    public String deleteFlight(@RequestBody FlightID fid) {
    	return service.removeFlightByAdmin(fid);
    }
	
	@GetMapping(path="/viewFlightBooked.do")
	public List<FlightBooked> viewFlightBooked(){
		return this.flightBookedService.getAllFlightBooked(); 
	}
	
}
