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
	
	@Column(nullable=false,length=150)
	private String password ;
	
	@Column
	//private Collection<role> roles = new ArrayList<>();
	private String role="USER";

	public User() {
		super();
	}

	public User(long userid, String firstname, String lastname, String email, String accountstatus,
			LocalDateTime registrydate, String password, String role) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.accountstatus = accountstatus;
		this.registrydate = registrydate;
		this.password = password;
		this.role = role;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountstatus() {
		return accountstatus;
	}

	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}

	public LocalDateTime getRegistrydate() {
		return registrydate;
	}

	public void setRegistrydate(LocalDateTime registrydate) {
		this.registrydate = registrydate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}

// add a way to throw custom error if duplicate error given on sign in
//add a regex check for email