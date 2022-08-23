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
	private  long id;
	
	@Column
	private String name;
	
	@Column(unique=true)
	private String email;
	
	@Column
	public String accountstatus="Active" ;
	
	@Column
	public LocalDateTime registrydate = LocalDateTime.now() ;
	
	@Column
	private String password ;

}

// add a way to throw custom error if duplicate error given on sign in
//add a regex check for email