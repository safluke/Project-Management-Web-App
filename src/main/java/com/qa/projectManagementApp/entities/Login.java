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
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long loginid;
	
	@Column
	private int userid;
	
	@Column
	private String status = "Online";
	
	@Column
	public LocalDateTime logintime= LocalDateTime.now();

	public Login() {
		super();
	}

	public Login(long loginid, int userid, String status, LocalDateTime logintime) {
		super();
		this.loginid = loginid;
		this.userid = userid;
		this.status = status;
		this.logintime = logintime;
	}

	public long getLoginid() {
		return loginid;
	}

	public void setLoginid(long loginid) {
		this.loginid = loginid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getLogintime() {
		return logintime;
	}

	public void setLogintime(LocalDateTime logintime) {
		this.logintime = logintime;
	}
	
		
}

// send this to db with user ID, based on email get