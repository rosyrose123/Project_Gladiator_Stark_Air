package com.lti.dao;

import java.util.List;

import com.lti.model.Admin;



public interface AdminDao {
	
	public String createAdmin(Admin admin);
	public List<Admin> readAllAdmins();
	public int deleteAdmin(String userName);
	public Admin updateAdmin(Admin admin);
	public Admin readAdminById(String userName);
}
