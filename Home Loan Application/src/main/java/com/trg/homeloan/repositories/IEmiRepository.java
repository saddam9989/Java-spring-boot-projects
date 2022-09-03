package com.trg.homeloan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trg.homeloan.entities.EMI;

public interface IEmiRepository extends JpaRepository<EMI, Integer>{

}