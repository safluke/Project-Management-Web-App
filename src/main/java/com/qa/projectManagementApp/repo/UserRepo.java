package com.qa.projectManagementApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.projectManagementApp.entities.User;



@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	@Query("SELECT p from User p WHERE p.email = ?1")
	User findUserByEmailJPQL(String email);
	
	User findByEmail(String email);
	
	@Query("SELECT p from User p WHERE p.email = ?1 and p.userid = ?2")
	User findUserByIdAndEmailJPQL(String email, long userid);
	

	}

