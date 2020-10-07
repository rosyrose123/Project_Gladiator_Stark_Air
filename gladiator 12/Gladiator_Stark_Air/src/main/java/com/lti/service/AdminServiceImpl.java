package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.AdminDao;
import com.lti.dao.FlightDao;
import com.lti.model.Admin;
import com.lti.model.Flight;
import com.lti.model.FlightID;

@Service("adminService")
@Scope(scopeName = "singleton")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private FlightDao flightDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addAdmin(Admin admin) {

		String result = adminDao.createAdmin(admin);
		return (result!=null) ? true : false;
	}

	@Override
	public List<Admin> findAllAdmins() {
		return adminDao.readAllAdmins();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean modifyAdmin(Admin admin) {
		Admin result = adminDao.updateAdmin(admin);
		return (result!=null) ? true : false;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean removeAdmin(String userName) {
		int result = adminDao.deleteAdmin(userName);
		return (result == 1) ? true : false;
	}

	@Override
	public Admin findAdminById(String userName) {
		return adminDao.readAdminById(userName);
	}

	@Override
	public String adminLoginAuthentication(Admin admin) {
		Admin result = adminDao.readAdminById(admin.getUserName());
		
		if(result!=null) {
		if(admin.getPassword().equals(result.getPassword()))
			return "Success";
		else
			return "Faliure. Invalid password";
		}
		else
			return "Invalid username";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String addFlightByAdmin(Flight flight) {
		String result = flightDao.createFlight(flight);
		return result;
		}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String removeFlightByAdmin(FlightID fid) {
		int result= flightDao.deleteFlight(fid);
		return (result==1)?"Deleted Successfully":"Flight does not exist";
	}

}
