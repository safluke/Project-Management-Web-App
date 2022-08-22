package com.qa.projectManagementApp.entities;

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
public class ActionList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long actionID;
	
	@Column
	private User userID;
	
	@Column
	private String content;
	
	@Column
	private String status;
	
	@Column
	private String deadline;
	
	@Column
	private int deadline1;
	
	@Column
	private int deadline2;

	public ActionList(long id, String status, String deadline, String content) {
		super();
		this.actionID = id;
		this.userID = getUserID();
		this.content=content;
		this.status = status;
		this.deadline=deadline;
		this.deadline1 = 50;
		this.deadline2 = 25;
	}
	
	
}
