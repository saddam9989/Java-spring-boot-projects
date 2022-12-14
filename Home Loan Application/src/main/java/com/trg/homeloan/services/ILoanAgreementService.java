package com.trg.homeloan.services;

import java.util.List;

import com.trg.homeloan.entities.EMI;
import com.trg.homeloan.entities.LoanAgreement;
import com.trg.homeloan.exceptions.LoanAgreementNotFoundException;

public interface ILoanAgreementService{
	
	
		public LoanAgreement addLoanAgreement(int loanApplicationId, EMI emi) ;
		public LoanAgreement updateLoanAgreement(int loanAgreementId, LoanAgreement loanAgreement) throws LoanAgreementNotFoundException;
		public LoanAgreement deleteLoanAgreement(int loanAgreementId) throws LoanAgreementNotFoundException;
		public List<LoanAgreement> getAllLoanAgreements();
		public LoanAgreement getLoanAgreement(int loanAgreementId) throws LoanAgreementNotFoundException;
		
		public int getLoanAgreementId(int loanApplicationId)throws LoanAgreementNotFoundException;
		




}
