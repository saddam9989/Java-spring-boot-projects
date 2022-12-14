package com.trg.homeloan;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.trg.homeloan.entities.Admin;
import com.trg.homeloan.entities.Customer;
import com.trg.homeloan.entities.EMI;
import com.trg.homeloan.entities.FinanceVerificationOfficer;
import com.trg.homeloan.entities.LandVerificationOfficer;
import com.trg.homeloan.entities.LoanAgreement;
import com.trg.homeloan.entities.LoanApplication;
import com.trg.homeloan.entities.Status;
import com.trg.homeloan.entities.User;
import com.trg.homeloan.repositories.IAdminRepository;
import com.trg.homeloan.repositories.ICustomerRepository;
import com.trg.homeloan.repositories.IEmiRepository;
import com.trg.homeloan.repositories.IFinanceVerificationRepository;
import com.trg.homeloan.repositories.ILandVerificationRepository;
import com.trg.homeloan.repositories.ILoanAgreementRepository;
import com.trg.homeloan.repositories.ILoanApplicationRepository;
import com.trg.homeloan.repositories.IUserRepository;


@Component
public class DBinti implements CommandLineRunner {
	
		@Autowired
		private IAdminRepository adminRepo;
		
		@Autowired
		private ICustomerRepository custRepo;
		
		@Autowired
		private IFinanceVerificationRepository financeRepo;
		
		@Autowired
		private ILandVerificationRepository landverRepo;
		
		@Autowired
		private ILoanApplicationRepository loanAppRepo;
		
		Logger logger = LoggerFactory.getLogger(DBinti.class);
		
	@Override
	public void run(String... args) throws Exception {
		
		adminRepo.deleteAll();
		financeRepo.deleteAll();
		landverRepo.deleteAll();
		loanAppRepo.deleteAll();
		logger.info("Add data to the table");
		adminRepo.save(new Admin("raj123", "raj123", "admin", "Likesh", "7788996655"));
		landverRepo.save(new LandVerificationOfficer("nabeel123", "nabeel123", "landVerification", "Nabeel", "9988776655"));
		financeRepo.save(new FinanceVerificationOfficer("siva123", "siva123", "financeVerification", "siva Hariharan", "8899776644"));
		loanAppRepo.save(new LoanApplication(new Customer("customer1", "customer123", "customer", "customer1", "9988776655", "customer@gmail.com", LocalDate.of(1999, 8, 10), "male", "Indian", "336706642486", "AKPDQ6347D"), 1000000, 5));
       
		logger.info("Data added to the table");
	}

}
