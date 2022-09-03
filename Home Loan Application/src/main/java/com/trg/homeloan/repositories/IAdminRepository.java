package com.trg.homeloan.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trg.homeloan.entities.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer>{
		

	
}