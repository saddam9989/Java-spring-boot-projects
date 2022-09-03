package com.trg.homeloan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trg.homeloan.entities.LandVerificationOfficer;

public interface ILandVerificationRepository extends JpaRepository<LandVerificationOfficer, Integer> {

	
}


