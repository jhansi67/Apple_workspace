package com.wipro.srs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.dao.AdminDAO;

@Service("adminService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDAO adminDAO;
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public String addShip(ShipBean shipbean) {
		// TODO Auto-generated method stub
		if(shipbean == null)
			return "ERROR";
		if(shipbean.getShipName() == null)
			return "ERROR";
		if(shipbean.getShipName().equals(" "))
			return "ERROR";
		String shipId = adminDAO.generateShipId(shipbean.getShipName());
		if(shipId.length() !=6)
			return "ERROR";
		else{
			shipbean.setShipId(shipId);
			return(adminDAO.addShip(shipbean));
		}
		
		
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public boolean modifyShip(ShipBean shipbean) {
		// TODO Auto-generated method stub
		boolean flag=true;
		if(shipbean == null){
			flag = false;
			
		}
		if(shipbean.getShipId() == null){
			flag = false;
			
		}
			
		if(flag)	
		return (adminDAO.modifyShip(shipbean));
		else
			return flag;
		
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public int removeShip(ArrayList<String> ShipId) {
		// TODO Auto-generated method stub
		if(ShipId == null)
			return 0;
		else
			return(adminDAO.removeShip(ShipId));
		
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public String addSchedule(ScheduleBean scheduleBean) {
		// TODO Auto-generated method stub
		System.out.println("in service");
		
		if(scheduleBean==null){
			System.out.println("11");
			return "ERROR";
		}
		if(scheduleBean.getRouteID()==null){
			System.out.println("12");
			return "ERROR";
		}
		if(scheduleBean.getRouteID().equals("")){
			System.out.println("13");
			return "ERROR";
		}
		if(scheduleBean.getShipID()==null){
			System.out.println("14");
			return "ERROR";
		}
		if(scheduleBean.getShipID().equals("")){
			System.out.println("15");
			return "ERROR";
		}
		if(scheduleBean.getStartDate()==null){
			System.out.println("16");
			return "ERROR";
		}
		String s="";
		String id=adminDAO.generateScheduleId(scheduleBean.getRouteID());
		System.out.println(id);
		if(id.length()!=8){
			return "FAILURE";
		}
		scheduleBean.setScheduleID(id);
		s=adminDAO.addSchedule(scheduleBean);
		return s;
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public boolean modifySchedule(ScheduleBean scheduleBean) {
		// TODO Auto-generated method stub
		if(scheduleBean==null){
			return false;
		}
		if(scheduleBean.getRouteID()==null){
			return false;
		}
		if(scheduleBean.getRouteID().equals("")){
			return false;
		}
		if(scheduleBean.getScheduleID()==null){
			System.out.println("null1");
			return false;
		}
		if(scheduleBean.getScheduleID().equals("")){
			System.out.println("null2");
			return false;
		}
		if(scheduleBean.getStartDate()==null){
			return false;
		}
		boolean b=adminDAO.modifySchedule(scheduleBean);
		if(b){
			return true;
		}
		else{
			return false;
		}
		
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public int removeSchedule(ArrayList<String> scheduleId) {
		
		try {
			if(scheduleId==null){
				System.out.println("44");
				return 0;
			}
			int  n=adminDAO.removeSchedule(scheduleId);
			if(n==0){
				System.out.println("service n=0....");
				return 0;
			}
			else{
				return 1;
			}
		} catch (Exception e) {
			System.out.println("Controller catch.....");
			e.printStackTrace();
			return 0;
		}
		
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public String addRoute(RouteBean routebean) {
		// TODO Auto-generated method stub
		if(routebean == null)
			return "ERROR";
		String routeId = adminDAO.generateRouteId(routebean.getSource(),routebean.getDestination());
		if(routeId.length() !=8)
			return "ERROR";
		routebean.setRouteID(routeId);
		
		return(adminDAO.addRoute(routebean));
		
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public boolean modifyRoute(RouteBean routebean) {
		// TODO Auto-generated method stub
		if(routebean == null)
			  return false;
			else
				return(adminDAO.modifyRoute(routebean));
		
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public int removeRoute(String routeid) {
		// TODO Auto-generated method stub
		if(routeid == null)
			return 0;
		if(routeid.equals(" "))
			return 0;
		else return(adminDAO.removeRoute(routeid));
		
	}

	@Override
	public ShipBean viewByShipId(String shipId) {
		// TODO Auto-generated method stub
		if(shipId == null)
			return null;
			
		ShipBean sb=adminDAO.viewByShipId(shipId);
		if(sb==null){
			return null;
		}
		return sb;
		
	}

	@Override
	public RouteBean viewByRouteId(String routeid) {
		// TODO Auto-generated method stub
		if(routeid==null){
			return null;
		}
		if(routeid.equals("")){
			return null;
		}
		RouteBean rb=adminDAO.viewByRouteId(routeid);
		if(rb==null){
			return null;
		}
		
		return rb;
	}

	@Override
	public ArrayList<ShipBean> viewByAllShips() {
		// TODO Auto-generated method stub
		ArrayList<ShipBean> list=adminDAO.viewByAllShips();
		if(list==null){
			return null;
		}
		if(list.isEmpty()){
			return null;
		}
		return list;
	}

	@Override
	public ArrayList<RouteBean> viewByAllRoute() {
		// TODO Auto-generated method stub
		ArrayList<RouteBean> list=adminDAO.viewByAllRoute();
		if(list==null){
			return null;
		}
		if(list.isEmpty()){
			return null;
		}
		return list;
	}

	@Override
	public ArrayList<ScheduleBean> viewByAllSchedule() {
		// TODO Auto-generated method stub
		ArrayList<ScheduleBean> list=adminDAO.viewByAllSchedule();
		if(list==null){
			return null;
		}
		if(list.isEmpty()){
			return null;
		}
		return list;
		
	}

	@Override
	public ScheduleBean viewByScheduleId(String scheduleid) {
		// TODO Auto-generated method stub
		if(scheduleid==null){
			return null;
		}
		if(scheduleid.equals("")){
			return null;
		}
		ScheduleBean sb=adminDAO.viewByScheduleId(scheduleid);
		if(sb==null){
			return null;
		}
		return sb;
	}

	@Override
	public ArrayList<PassengerBean> viewPasengersByShip(String scheduleid) {
		// TODO Auto-generated method stub
		if(scheduleid==null){
			return null;
		}
		if(scheduleid.equals("")){
			return null;
		}
		ArrayList<PassengerBean> list=adminDAO.viewPasengersByShip(scheduleid);
		if(list==null){
			return null;
		}
		if(list.isEmpty()){
			return null;
		}
		return list;
	}

	
	////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////
	@Override
	public ArrayList<ReservationBean> viewAllReservations() {
		ArrayList<ReservationBean> rbeans = adminDAO.viewAllReservations();
		return rbeans;
	}

	
	
}
