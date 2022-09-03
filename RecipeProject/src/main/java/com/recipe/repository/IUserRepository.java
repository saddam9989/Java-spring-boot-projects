package com.recipe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.recipe.entity.Customer;
import com.recipe.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

	//Query for selecting userName by using findByName 
	@Query("SELECT u from User u WHERE u.username=:username ")
	public Optional<User> findByName(@Param("username") String userName);
	@Query("SELECT u from User u WHERE u.username=:username ")
	public Optional<Customer> findByUsename(@Param("username") String userName);

}
