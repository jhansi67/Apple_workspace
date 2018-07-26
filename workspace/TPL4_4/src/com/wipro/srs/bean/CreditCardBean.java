package com.wipro.srs.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "SRS_TBL_CreditCard")
public class CreditCardBean {

	@Id
	@NotNull(message ="Please enter date")
	@NotEmpty(message ="Please enter date")
	private String creditCardNumber;
	
//	@Temporal(TemporalType.TIMESTAMP) 
	@DateTimeFormat(pattern="MM/dd/yyyy")
//	@NotNull(message ="Please enter date")
//	@NotEmpty(message ="Please enter date")
	private Date validFrom;
	
//	@Temporal(TemporalType.TIMESTAMP) 
	@DateTimeFormat(pattern="MM/dd/yyyy")
//	@NotNull(message ="Please enter date")
//	@NotEmpty(message ="Please enter date")
	private Date validTo;
	
	private double balance;
	private String userId;
	
	
	
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
	
}
