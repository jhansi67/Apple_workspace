package com.wipro.srs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name = "SRS_TBL_Ship")
public class ShipBean {

	@Id
	private String shipId;
	
	@NotEmpty(message="Enter ship name")
	private String shipName;
	
	@NotNull(message="Enter seating capacity")
	private Integer seatingCapacity;

	@NotNull(message="Enter reservation capacity")
	private Integer reservationCapacity;

	public String getShipId() {
		return shipId;
	}

	public void setShipId(String shipId) {
		this.shipId = shipId;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public Integer getReservationCapacity() {
		return reservationCapacity;
	}

	public void setReservationCapacity(Integer reservationCapacity) {
		this.reservationCapacity = reservationCapacity;
	}
	
	
	
	
}
