package com.qa.projectManagementApp.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long userid;
	
	
	@Column(nullable=false,length=20)
	private String firstname;
	
	@Column(nullable=false,length=20)
	private String lastname;
	
	@Column(nullable = false, unique=true, length=50)
	private String email;
	
	@Column
	public String accountstatus="Active" ;
	
	@Column
	public LocalDateTime registrydate = LocalDateTime.now() ;
	
	@Column(nullable=false,length=64)
	private String password ;
	
	@Column
	//private Collection<role> roles = new ArrayList<>();
	private String role="USER";

}

// add a way to throw custom error if duplicate error given on sign in
//add a regex check for email