package com.qa.projectManagementApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.projectManagementApp.entities.Login;
import com.qa.projectManagementApp.repo.LoginRepo;

@Service
public class LoginService {
	
	@Autowired
	private ServiceAuthHelper auth;
	
	
	private LoginRepo repo;

	public LoginService(LoginRepo repo) {
		super();
		this.repo = repo;
	}

	public List<Login> getAllLogins() {
		return this.repo.findAll();
	}

	public Login addLogin(Login login, String authorizationHeader) {
		auth.checkCredentialsLogin(authorizationHeader,  login);
		return repo.save(login);
	}
	

}
