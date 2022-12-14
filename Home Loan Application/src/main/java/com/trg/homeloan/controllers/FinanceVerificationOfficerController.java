package com.trg.homeloan.controllers;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trg.homeloan.entities.LoanApplication;
import com.trg.homeloan.entities.ResponseToken;
import com.trg.homeloan.entities.User;
import com.trg.homeloan.exceptions.FinanceVerificationException;
import com.trg.homeloan.exceptions.LoanApplicationNotFoundException;
import com.trg.homeloan.jwt.JwtTokenUtil;
import com.trg.homeloan.repositories.IFinanceVerificationRepository;
import com.trg.homeloan.services.FinanceVerificationService;
import com.trg.homeloan.services.ILoanApplicationService;

@RestController
@RequestMapping("/homeloan/financeOfficer")
@CrossOrigin(origins = "http://localhost:4200")
public class FinanceVerificationOfficerController {
	
	Logger logger = Logger.getLogger(FinanceVerificationOfficerController.class.getName());
	
	@Autowired
	FinanceVerificationService financeVerificationService;
	
	@Autowired
	ILoanApplicationService loanApplicationService;
	
	@Autowired
	IFinanceVerificationRepository iFinanceVerificationRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	User user =null;
	
	
	public FinanceVerificationOfficerController() {
		logger.log(Level.INFO,"-----> Inside Finance Verification Service Controller Working!");
	}


	@GetMapping("/LoanApplications")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications(HttpServletRequest request) {
		user=jwtTokenUtil.validateTokenAndGetUserDetails(request);
		
		return new ResponseEntity<>(loanApplicationService.retrieveAllLoanApplication(), HttpStatus.OK);
	}
	

	@PutMapping("/updateFinanceVerificationStatus/{loanApplicationId}")
	public ResponseEntity<LoanApplication> updateFinanceStatus(@PathVariable int loanApplicationId ,HttpServletRequest request) throws FinanceVerificationException, LoanApplicationNotFoundException {
		user=jwtTokenUtil.validateTokenAndGetUserDetails(request);
		
		
		return new ResponseEntity<>(loanApplicationService.updateFinanceStatus(loanApplicationId), HttpStatus.OK);

	}
}
