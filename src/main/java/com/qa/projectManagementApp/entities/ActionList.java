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
	private String status="Not Started";
	
	@Column
	private LocalDate deadline;  
	
	@Column
	private LocalDate deadline1=LocalDate.now().plusDays(3L);
	
	@Column
	private LocalDate deadline2=LocalDate.now().plusDays(7L);

	public Actionlist() {
		super();
	}

	public Actionlist(long actionid, int userid, LocalDate datecreated, String content, String status,
			LocalDate deadline, LocalDate deadline1, LocalDate deadline2) {
		super();
		this.actionid = actionid;
		this.userid = userid;
		this.datecreated = datecreated;
		this.content = content;
		this.status = status;
		this.deadline = deadline;
		this.deadline1 = deadline1;
		this.deadline2 = deadline2;
	}

	public long getActionid() {
		return actionid;
	}

	public void setActionid(long actionid) {
		this.actionid = actionid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public LocalDate getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(LocalDate datecreated) {
		this.datecreated = datecreated;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public LocalDate getDeadline1() {
		return deadline1;
	}

	public void setDeadline1(LocalDate deadline1) {
		this.deadline1 = deadline1;
	}

	public LocalDate getDeadline2() {
		return deadline2;
	}

	public void setDeadline2(LocalDate deadline2) {
		this.deadline2 = deadline2;
	}

	
	}

	

//figure out how to connect userID