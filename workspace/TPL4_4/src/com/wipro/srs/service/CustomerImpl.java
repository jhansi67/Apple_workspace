package com.wipro.srs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.log.SysoLogger;
import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.dao.CustomerDAO;



@Service("customer")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class CustomerImpl implements Customer{

	@Autowired
	CustomerDAO customerDAO;
	
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	@Override
	public ArrayList<ScheduleBean> viewScheduleByRoute(String source,String destination, Date date) {
		if(source == null || source.isEmpty() || source.equals(""))
			return null;
		else if(destination == null || destination.isEmpty() || destination.equals(""))
			return null;
		else if(date == null)
			return null;
		else{	
			System.out.println("go to dao.......");
			ArrayList<ScheduleBean> scheduleships = customerDAO.viewScheduleByRoute(source,destination,date);
			return scheduleships;
		}
	}

	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	@Override
	public String reserveTicket(ReservationBean reservationBean,ArrayList<PassengerBean> passengerBean) {
		if(reservationBean==null)
			return "FAIL";
		else if(passengerBean==null || passengerBean.size()==0)
			return "FAIL";
		else{
			String reserve = customerDAO.reserveSeat(reservationBean,passengerBean);
			return reserve;
		}
	}

	

	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	@Override
	public Map<ReservationBean, ArrayList<PassengerBean>> viewTicket(String reservationId) {
		if(reservationId == null || reservationId.isEmpty() || reservationId.equals("")){
			System.out.print("null!!!!!!");
			return null;
		}
		else{
			System.out.print("Service entered reservationid is not null...");
			Map<ReservationBean, ArrayList<PassengerBean>> ticket = customerDAO.viewTicket(reservationId);
			return ticket;
		}
	}

	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	@Override
	public Map<ReservationBean, ArrayList<PassengerBean>> printTicket(String reservationId) {
		if(reservationId == null || reservationId.isEmpty() || reservationId.equals("")){
			System.out.print("null!!!!!!");
			return null;
		}
		else{
			System.out.print("Service entered reservationid is not null...pppppppppppp");
			Map<ReservationBean, ArrayList<PassengerBean>> ticket = customerDAO.viewTicket(reservationId);
			System.out.println("\nticket   "+ticket);
			return ticket;
		}
	}

	
	
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	//////////////////////		adis	////////////////////////////////////////////////
	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public boolean cancelTicket(String reservationId) {
		boolean res;
		System.out.println("Inside service of cancel ticket");
		if(reservationId==null||reservationId.equals(""))
			return false;
		else
		{
			res=customerDAO.cancelTicket(reservationId);
			if(!res){
				System.out.println("False from dao layer");
				return false;
			}
		}
		
		return res;
	}
	///////////////////////////////////////////////////////////////////////////////////


	@Override
	public double getRouteFare(String scheduleID) {
		if(scheduleID == null)
			return -1;
		else if(scheduleID.isEmpty() || scheduleID.equals(""))
			return -1; 
		
		System.out.println("Getting fare for scheduleid : "+scheduleID);
		double routefare = customerDAO.getRouteFare(scheduleID);
		return routefare;
	}


	
	

}
