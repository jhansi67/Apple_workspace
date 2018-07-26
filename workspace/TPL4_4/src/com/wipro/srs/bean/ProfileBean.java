package com.wipro.srs.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "SRS_TBL_User_Profile ")
public class ProfileBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int surrogateKey;

	private String userID;

	@NotEmpty(message = "Enter the First name")
	@Size(min = 2, message="Enter name properly")
	private String firstName;

	@NotEmpty(message = "Enter the Last name")
	private String lastName;

//	@NotNull(message = "Enter DOB")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Enter DOB")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private java.util.Date dateOfBirth;

	@NotEmpty(message = "select the gender")
	private String gender;

	@NotEmpty(message = "Enter the street")
	private String street;

	@NotEmpty(message = "Enter the Location")
	private String location;

	@NotEmpty(message = "Enter the city")
	private String city;

	@NotEmpty(message = "Enter the state")
	private String state;

	@Size(min = 6, max = 6, message = "Pincode should be of length 6")
	private String pincode;

	@NotNull(message = "Enter the mobile number")
	@Size(min = 10, max = 10, message = "Enter the Phone Number correctly")
	private String mobileNo;

	@Id
	@NotEmpty(message = "Enter the email")
	@Email(message = "Enter the email correctly")
	private String emailID;

	@NotEmpty(message = "Please enter the password")
	private transient String password;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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

	public java.util.Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
