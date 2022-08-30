package com.qa.projectManagementApp.DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long userid;
	
	@Column(nullable=false,length=20)
	private String firstname;
	
	@Column(nullable=false,length=20)
	private String lastname;
	
	@Column(nullable = false, unique=true, length=50)
	private String email;
	
	}


