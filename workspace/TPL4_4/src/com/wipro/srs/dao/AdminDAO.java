package com.wipro.srs.dao;

import java.util.ArrayList;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;



public interface AdminDAO {

	String addShip(ShipBean shipbean);
	boolean modifyShip(ShipBean shipbean);
	int removeShip(ArrayList<String> ShipId);
	String addSchedule(ScheduleBean scheduleBean);
	boolean modifySchedule(ScheduleBean scheduleBean);
	int removeSchedule(ArrayList<String> scheduleId);
	String addRoute(RouteBean routebean);
	boolean modifyRoute(RouteBean routebean);
	int removeRoute(String routeid);
	ShipBean viewByShipId(String ShipId);
	RouteBean viewByRouteId(String routeid);
	ArrayList<ShipBean> viewByAllShips();
	ArrayList<RouteBean> viewByAllRoute();
	ArrayList<ScheduleBean> viewByAllSchedule();
	ScheduleBean viewByScheduleId(String scheduleid);
	ArrayList<PassengerBean> viewPasengersByShip(String scheduleid);
	String generateShipId(String shipName);
	String generateRouteId(String source,String destination);
	String generateScheduleId(String routeID);
	String generateReservationId(String source,String destination);
	ArrayList<ReservationBean> viewAllReservations();
	
}
