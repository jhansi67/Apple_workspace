package com.wipro.srs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.ScheduleBean;

public interface Customer {

	public ArrayList<ScheduleBean> viewScheduleByRoute (String source, String destination, Date date);
	
	public String reserveTicket(ReservationBean reservationBean, ArrayList<PassengerBean> passengerBean);
	//Return value must be either: "SUCCESS", "FAIL" 
	
	public boolean cancelTicket(String reservationId); 
	
	public Map<ReservationBean, ArrayList<PassengerBean>> viewTicket(String reservationId);
	
	public Map<ReservationBean, ArrayList<PassengerBean>> printTicket(String reservationId);

	public double getRouteFare(String scheduleID);

	
}
