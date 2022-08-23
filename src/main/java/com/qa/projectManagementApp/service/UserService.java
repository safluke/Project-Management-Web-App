package com.qa.projectManagementApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.projectManagementApp.entities.User;
import com.qa.projectManagementApp.repo.UserRepo;


@Service
public class UserService {
	
	private UserRepo repo;
	
	
	public UserService(UserRepo repo) {
		super();
		this.repo = repo;
	}


	public List<User> getAllUsers() {
		return this.repo.findAll();
	}
	
	public User addUser(User user) {
		return repo.save(user);
	
	}
	
	public List<User> getUserByEmail(String email) {
		return this.repo.findUserByEmailJPQL(email);
	}
}