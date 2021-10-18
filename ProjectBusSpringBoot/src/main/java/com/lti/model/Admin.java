package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "ADMIN_DETAILS")
public class Admin {
	@Id
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name = "PASSWORD")
	private String password;
	
	public Admin() {
		super();
	}
	
	public Admin(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Admin [emailId=" + emailId + ", password=" + password + "]";
	}
}
