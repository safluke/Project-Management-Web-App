package com.qa.projectManagementApp.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.qa.projectManagementApp.DTO.UserDTO;
import com.qa.projectManagementApp.DTO.checkUserDTO;
import com.qa.projectManagementApp.entities.User;
import com.qa.projectManagementApp.service.UserService;


@RestController
public class UserController {
	
	private UserService service;
	public UserController(UserService service) {
		super();
		this.service = service;
	}
	
	@CrossOrigin
	@GetMapping("/getAllUsers")
	public List<User> getAll() {
		 return this.service.getAllUsers();
	}
	@CrossOrigin
	@PostMapping("/createUser")
	public User addUser(@RequestBody User user) {
		
		return this.service.addUser(user);
	}
	
	@CrossOrigin
	@GetMapping("/checkUser")
	public checkUserDTO checkUser(@PathParam("email") String email){
			return this.service.checkUserByEmail(email);
	}
	
	@CrossOrigin
	@GetMapping("/getUser")
	public UserDTO getUser(@PathParam("email") String email){
		return this.service.getUserByEmail(email);
	}
}
