package com.qa.projectManagementApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.qa.projectManagementApp.entities.Login;
import com.qa.projectManagementApp.service.LoginService;


@RestController
public class LoginController {
	
	private LoginService service;
	public LoginController(LoginService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getAllLogin")
	public List<Login> getAll() {
		 return this.service.getAllLogins();
	}
	
	@CrossOrigin
	@PostMapping("/createLogin")
	public Login addLogin(@RequestHeader(value="Authorization")String authorizationHeader ,
						  @RequestBody Login login ) {
		
		return this.service.addLogin(login,authorizationHeader);
	}

}
