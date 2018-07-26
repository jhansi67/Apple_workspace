package com.wipro.srs.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name = "SRS_TBL_Reservation ")
public class ReservationBean {

	@Id
	private String reservationID;
	private String userId;
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	private String scheduleID;		
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date bookingDate;
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date journeyDate;
	private int noOfSeats;
	private double totalFare;
	private String 	bookingStatus;
	
	

	

	public String getReservationID() {
		return reservationID;
	}


	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}


	public String getScheduleID() {
		return scheduleID;
	}


	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}


	public Date getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}


	public Date getJourneyDate() {
		return journeyDate;
	}


	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}


	public int getNoOfSeats() {
		return noOfSeats;
	}


	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}


	public double getTotalFare() {
		return totalFare;
	}


	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}


	public String getBookingStatus() {
		return bookingStatus;
	}


	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}


	
	
	
	
	
	
}
