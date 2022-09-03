package com.trg.homeloan.services;

import java.util.List;

import com.trg.homeloan.entities.Admin;

public interface IAdminService {

	public Admin addAdmin(Admin admin); 
	public Admin getAdmin(int userId);
	public List<Admin> getAllAdmin();
	
	}

