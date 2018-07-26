package com.wipro.srs.bean;

import java.util.Date;




import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "SRS_TBL_Schedule ")
public class ScheduleBean {

	@Id
	private String scheduleID;
	
	@NotEmpty(message="Enter ship id")
	String shipID;
	
	@NotEmpty(message="Enter route id")
	String routeID;
	
	@Temporal(TemporalType.TIMESTAMP) 
//	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull(message = "Enter date")
	Date startDate;
	
	
	
	
	
	public String getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}
	
	
	

	public String getShipID() {
		return shipID;
	}
	public void setShipID(String shipID) {
		this.shipID = shipID;
	}
	
	
	

	public String getRouteID() {
		return routeID;
	}
	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
