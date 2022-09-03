package com.trg.homeloan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trg.homeloan.entities.LoanApplication;

public interface ILoanApplicationRepository extends JpaRepository<LoanApplication, Integer> {
	
}
