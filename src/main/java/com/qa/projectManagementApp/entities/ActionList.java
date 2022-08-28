package com.qa.projectManagementApp.entities;

import java.time.LocalDate;
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
public class Actionlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long actionid;
	
	@Column
	private int userid;
	
	@Column
	private LocalDate datecreated = LocalDate.now();
	
	@Column
	private String content;

	@Column
	public String status="Not Started";
	
	@Column
	private LocalDate deadline;  
	
	@Column
	public LocalDate deadline1=LocalDate.now().plusDays(3L);
	
	@Column
	public LocalDate deadline2=LocalDate.now().plusDays(7L);

	}
	

//figure out how to connect userID