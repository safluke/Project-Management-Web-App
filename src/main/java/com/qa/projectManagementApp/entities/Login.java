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
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long loginid;
	
	@Column
	private String status = "Online";
	
	@Column
	public LocalDateTime logintime= LocalDateTime.now();
	
		
}

// send this to db with user ID, based on email get