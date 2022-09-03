package com.trg.homeloan.services;

import java.util.List;

import com.trg.homeloan.entities.LoanAgreement;
import com.trg.homeloan.entities.LoanApplication;
import com.trg.homeloan.exceptions.AdminApprovalException;
import com.trg.homeloan.exceptions.CustomerNotFoundException;
import com.trg.homeloan.exceptions.FinanceVerificationException;
import com.trg.homeloan.exceptions.LandVerificationException;
import com.trg.homeloan.exceptions.LoanAgreementNotFoundException;
import com.trg.homeloan.exceptions.LoanApplicationNotFoundException;

public interface ILoanApplicationService  {
	
	public LoanApplication addLoanApplication(int userId, double loanAppliedAmount,int loanTenureYears) throws CustomerNotFoundException;
	
	public LoanApplication updateLoanApplication(int loanApplicationId,LoanApplication loanApplication) throws LoanApplicationNotFoundException;
	public LoanApplication deleteLoanApplication(int loanApplicationId) throws LoanApplicationNotFoundException;
	public List<LoanApplication> retrieveAllLoanApplication();
	public LoanApplication retrieveLoanApplication(int loanApplicationId) throws LoanApplicationNotFoundException;
	public LoanApplication updateLandStatus(int loanApplicationId) throws LandVerificationException,LoanApplicationNotFoundException;
	public LoanApplication updateFinanceStatus(int loanApplicationId) throws FinanceVerificationException, LoanApplicationNotFoundException;
	public LoanApplication updateAdminStatus(int loanApplicationId) throws AdminApprovalException, LoanApplicationNotFoundException;
	public LoanAgreement getLoanAgreement(int loanApplicationId)throws LoanAgreementNotFoundException;
	

}
