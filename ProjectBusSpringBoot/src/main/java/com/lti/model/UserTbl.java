package com.lti.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
//@Scope(scopeName="prototype")
@Entity
@Table(name = "USER_TBL")
public class UserTbl {
	@Id
	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "PHONE_NO")
	private String phoneNo;

	@Column(name = "PASSWORD")
	private String pass;

	@Column(name = "Date_Of_Birth")
	@Temporal(TemporalType.DATE)
	private Date DOB;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "NO_OF_BOOKINGS")
	private int noOfBookings;

	@Column(name = "WALLET")    //wallet is not used
	private float wallet;

	// inverse side
	//@JsonManagedReference
	//@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//private Set<ReservationTbl> res;

	/*public void addTicket(ReservationTbl resv) {
		res.add(resv);
	}*/

	public UserTbl() {
		super();
	}

	public UserTbl(String emailId, String firstName, String lastName, String phoneNo, String pass, Date DOB,
			String gender, int noOfBookings, float wallet) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.pass = pass;
		this.DOB = DOB;
		this.gender = gender;
		this.noOfBookings = noOfBookings;
		this.wallet = wallet;
	}

	public UserTbl(String emailId, String firstName, String lastName, String phoneNo, String pass, Date DOB,
			String gender) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.pass = pass;
		this.DOB = DOB;
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date DOB) {
		this.DOB = DOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNoOfBookings() {
		return noOfBookings;
	}

	/*public Set<ReservationTbl> getRes() {
		return res;
	}

	public void setRes(Set<ReservationTbl> res) {
		this.res = res;
	}*/

	public void setNoOfBookings(int noOfBookings) {
		this.noOfBookings = noOfBookings;
	}

	public float getWallet() {
		return wallet;
	}

	public void setWallet(float wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "UserTbl [emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo="
				+ phoneNo + ", pass=" + pass + ", DOB=" + DOB + ", gender=" + gender + ", noOfBookings="
				+ noOfBookings + ", wallet=" + wallet + "]";
	}
}
