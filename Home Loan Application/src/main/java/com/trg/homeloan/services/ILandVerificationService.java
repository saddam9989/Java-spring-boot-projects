package com.trg.homeloan.services;

import java.util.List;

import com.trg.homeloan.entities.Admin;
import com.trg.homeloan.entities.FinanceVerificationOfficer;
import com.trg.homeloan.entities.LandVerificationOfficer;

public interface ILandVerificationService {
	

	public LandVerificationOfficer addLandOfficer(LandVerificationOfficer officer); 
	
	public LandVerificationOfficer getLandOfficer(int userId);
	public List<LandVerificationOfficer> getAllLandOfficers();
}


