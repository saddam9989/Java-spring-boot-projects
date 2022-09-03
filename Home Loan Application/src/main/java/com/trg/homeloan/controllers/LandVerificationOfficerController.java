package com.trg.homeloan.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.validation.annotation.Validated;
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
import com.trg.homeloan.exceptions.LandVerificationException;
import com.trg.homeloan.exceptions.LoanApplicationNotFoundException;
import com.trg.homeloan.jwt.JwtTokenUtil;
import com.trg.homeloan.repositories.ILandVerificationRepository;
import com.trg.homeloan.services.ILoanApplicationService;
import com.trg.homeloan.services.LandVerificationService;

@RestController
@RequestMapping("/homeloan/landOfficer")
@CrossOrigin(origins = "http://localhost:4200")
public class LandVerificationOfficerController {
	
	Logger logger = Logger.getLogger(AdminController.class.getName());

	@Autowired
	LandVerificationService landVerificationService;
	
	@Autowired
	ILoanApplicationService loanApplicationService;
	
	@Autowired
	ILandVerificationRepository iLandVerificationRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	User user =null;
	
	public LandVerificationOfficerController() {
		logger.log(Level.INFO,"-----> Inside Land Service Controller Working!");
	}


	@GetMapping("/LoanApplications")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications(HttpServletRequest request) {
		user=jwtTokenUtil.validateTokenAndGetUserDetails(request);
		return new ResponseEntity<>(loanApplicationService.retrieveAllLoanApplication(), HttpStatus.OK);
	}
	
	@PutMapping("/updateLandVerificationStatus/{loanApplicationId}")
	public ResponseEntity<LoanApplication> updateLandStatus(@PathVariable int loanApplicationId,HttpServletRequest request) throws LandVerificationException, LoanApplicationNotFoundException {
		
		user=jwtTokenUtil.validateTokenAndGetUserDetails(request);
		return new ResponseEntity<>(loanApplicationService.updateLandStatus(loanApplicationId), HttpStatus.OK);

	}
}
