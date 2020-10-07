package com.lti.service;

import java.util.List;

import com.lti.model.Admin;
import com.lti.model.Flight;
import com.lti.model.FlightID;

public interface AdminService {
	public boolean addAdmin(Admin admin);
	public List<Admin> findAllAdmins();
	public boolean modifyAdmin(Admin admin);
	public boolean removeAdmin(String userName);
	public Admin findAdminById(String userName);
	public String adminLoginAuthentication(Admin admin);
	public String addFlightByAdmin(Flight flight);
	public String removeFlightByAdmin(FlightID fid);

}
