package com.qa.projectManagementApp.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String accountStatus ;
	
	@Column
	private String registryDate ;
	
	@Column
	private String password ;


	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();	


public User(String name, String email, String password) {
    super();
	this.name = name;
	this.email = email;
	this.accountStatus = "Active";
	this.registryDate = dtf.format(now);
	this.password = password;

	}
}

