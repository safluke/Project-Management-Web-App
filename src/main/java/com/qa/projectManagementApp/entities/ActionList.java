package com.qa.projectManagementApp.entities;

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
public class Actionlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long actionid;

	@Column
	private String content;
	
	@Column
	public String status="Not Started";
	
	@Column
	private String deadline;  // look into formatting issues here
	
	@Column
	public int deadline1=50;
	
	@Column
	public int deadline2=25;

	}
	

//figure out how to connect userID