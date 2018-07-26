package com.wipro.srs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name = "SRS_TBL_Route ")
public class RouteBean {

	@Id
	private String routeID;
	
	
	@NotEmpty(message="Please enter value for source")
	private String source;
	
	
	@NotEmpty(message="Please enter value for destination")
	private String destination;
	
	
	@NotEmpty(message="Please enter value for duration")
	private String travelDuration;
	
	@NotNull
	private Double fare;

	public String getRouteID() {
		return routeID;
	}

	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTravelDuration() {
		return travelDuration;
	}

	public void setTravelDuration(String travelDuration) {
		this.travelDuration = travelDuration;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}
	
	
	
	
}
