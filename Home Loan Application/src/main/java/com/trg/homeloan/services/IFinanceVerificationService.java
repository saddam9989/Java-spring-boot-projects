package com.trg.homeloan.services;

import java.util.List;

import com.trg.homeloan.entities.Admin;
import com.trg.homeloan.entities.FinanceVerificationOfficer;

public interface IFinanceVerificationService  {
	

	public FinanceVerificationOfficer addFinanceOfficer(FinanceVerificationOfficer officer); 
	public FinanceVerificationOfficer getFinanceOfficer(int userId);
	public List<FinanceVerificationOfficer> getAllFinanceOfficers();
	

}
