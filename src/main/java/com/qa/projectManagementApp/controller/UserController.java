package com.qa.projectManagementApp.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.projectManagementApp.entities.User;
import com.qa.projectManagementApp.service.UserService;


@RestController
public class UserController {
	
	private UserService service;
	public UserController(UserService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAll() {
		 return this.service.getAllUsers();
	}
	
	@PostMapping("/createUser")
	public User addUser(@RequestBody User user) {
		
		return this.service.addUser(user);
	}
	
	@GetMapping("/getUser")
	public List<User> getUser(@PathParam("email") String email){
		return this.service.getUserByEmail(email);
	}
}
