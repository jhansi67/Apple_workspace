package com.wipro.srs.dao;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String addSchedule(ScheduleBean scheduleBean) {

		System.out.println("in dao");
		if (scheduleBean == null) {
			System.out.println("null");
			return "ERROR";
		}
		Session session = sessionFactory.getCurrentSession();

		String routeID = scheduleBean.getRouteID();
		RouteBean rb = (RouteBean) session.get(RouteBean.class, routeID);
		if (rb == null) {
			return "FAILURE";
		}
		String shipID = scheduleBean.getShipID();
		ShipBean sb = (ShipBean) session.get(ShipBean.class, shipID);
		if (sb == null) {
			return "FAILURE";
		}

		// //////////////////////////////////////////////////////////////
		Query query = session.createQuery("from ScheduleBean where shipID=?");
		query.setString(0, shipID);
		List<ScheduleBean> l = query.list();
		Date sdate;
		for (int i = 0; i < l.size(); i++) {
			sdate = l.get(i).getStartDate();
			if (sdate.compareTo(scheduleBean.getStartDate()) == 0) {
				return "FAILURE";
			}
		}

		// /////////////////////////////////////////////////////////////

		String res = "";
		try {

			if (session.save(scheduleBean) != null) {
				System.out.println("success");
				res = "SUCCESS";
			}

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = "FAILURE";
		}
		return res;

	}

	@Override
	public boolean modifySchedule(ScheduleBean scheduleBean) {

		if (scheduleBean == null) {
			System.out.println("111");
			return false;
		}
		Session session = sessionFactory.getCurrentSession();
		ScheduleBean sb;
		if (scheduleBean.getScheduleID() == null) {
			System.out.println("null");
			return false;
		}
		try {
			sb = (ScheduleBean) session.get(ScheduleBean.class,
					scheduleBean.getScheduleID());
			String routeID = scheduleBean.getRouteID();
			RouteBean rb = (RouteBean) session.get(RouteBean.class, routeID);
			if (rb == null) {
				System.out.println("112");
				return false;
			}
			sb.setRouteID(routeID);
			String shipID = scheduleBean.getShipID();
			ShipBean shb = (ShipBean) session.get(ShipBean.class, shipID);
			if (shb == null) {
				System.out.println("113");
				return false;
			}
			sb.setShipID(shipID);
			sb.setStartDate(scheduleBean.getStartDate());
			session.update(sb);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public int removeSchedule(ArrayList<String> scheduleid) {
		System.out.println("in dao");

		// ////////////////////////////////////////////////////////

		// ///////////////////////////////////////////////////////
		if (scheduleid == null) {
			System.out.println("41");
			return 0;
		}
		if (scheduleid.isEmpty()) {
			System.out.println("42");
			return 0;
		}
		Session session = sessionFactory.getCurrentSession();
		int i;
		try {
			for (i = 0; i < scheduleid.size(); i++) {
				ScheduleBean sb = (ScheduleBean) session.get(
						ScheduleBean.class, scheduleid.get(i));
				if (sb == null) {
					System.out.println("43");
					return 0;
				}
				Query query1 = session
						.createQuery("from PassengerBean where scheduleID=?");
				query1.setString(0, scheduleid.get(i));
				List<PassengerBean> list1 = (List<PassengerBean>) query1.list();
				Query query2 = session
						.createQuery("from ReservationBean where scheduleID=?");
				query2.setString(0, scheduleid.get(i));
				List<ReservationBean> list2 = (List<ReservationBean>) query2
						.list();
				if (list2 != null) {
					for (int j = 0; j < list2.size(); j++) {
						ReservationBean rb = list2.get(j);
						DateFormat dateformat = new SimpleDateFormat(
								"yyyy/MM/dd ");
						Date date = new Date();
						if (rb.getJourneyDate().before(date)) {
							if (list1 != null) {
								Query q = session
										.createQuery("from PassengerBean where reservationID=?");
								q.setString(0, rb.getReservationID());
								List<PassengerBean> l = q.list();
								if (l == null) {
									System.out.println("I dont have any passenger...");
									session.delete(rb);
									session.delete(sb);
								} else {
									System.out.println("I have passengers...");
									for(int d=0;d<l.size();++d){
										PassengerBean passengerBean = l.get(d); 
										session.delete(passengerBean);
									}
									list2 = new ArrayList<>();
									System.out.println("deleted passengers..."+1);
									
									
									session.delete(rb);
									System.out.println("deleted reservationbean..."+2);
									list1 = new ArrayList<>();
									
									session.delete(sb);
									System.out.println("deleted passengers..."+3);
								}
							}
						}
					}
				}

				if (list1 == null && list2 == null) {
					session.delete(sb);
				}
				if (list1.isEmpty() && list2.isEmpty()) {
					session.delete(sb);
				} else {
					System.out.println("44");
					return 0;
				}

			}
			return 1;
		} catch (HibernateException e) {

			System.out.println("Dao catch....");
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public String addShip(ShipBean shipbean) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(shipbean);
			return "SUCCESS";
		} catch (HibernateException e) {
			return "FAIL";
		}

	}

	@Override
	public boolean modifyShip(ShipBean shipbean) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(shipbean);
			return true;
		} catch (HibernateException e) {
			return false;
		}

	}

	@Override
	public int removeShip(ArrayList<String> ShipId) {
		// TODO Auto-generated method stub
		// ////////////////////////////////////////////////////////////////////////
		boolean flag = false;
		int k = 0;
		System.out.println("in remove");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		Session session = sessionFactory.getCurrentSession();
		for (int i = 0; i < ShipId.size(); i++) {
			ShipBean shipbean = (ShipBean) session.get(ShipBean.class,
					ShipId.get(i));

			Query query = session
					.createQuery("from ScheduleBean where shipId=?");
			query.setString(0, shipbean.getShipId());
			List<ScheduleBean> list = query.list();
			if (list.size() == 0) {
				System.out.println("list size 0" + shipbean.getShipId());
				session.delete(shipbean);
				flag = true;
				continue;
			}
			for (int j = 0; j < list.size(); j++) {
				ScheduleBean scb = list.get(j);
				if (scb == null)
					continue;
				if (scb.getStartDate().before(date)) {
					System.out.println("in if j=" + j);
					System.out.println(date);
					System.out.println(scb.getScheduleID());

					session.delete(scb);
					session.delete(shipbean);
					flag = true;
				} else {
					System.out.println("in elsej=" + j);
					System.out.println(scb.getStartDate());

				}
			}
		}
		if (flag) {
			System.out.println(flag);
			return 1;
		} else {
			System.out.println(flag);
			return 0;
		}
		// /////////////////////////////////////////////////////////////////////

		/*
		 * Session session = sessionFactory.getCurrentSession(); try{ for(int
		 * i=0; i<ShipId.size(); i++){ ShipBean shipbean =
		 * (ShipBean)session.get(ShipBean.class, ShipId.get(i)); if(shipbean ==
		 * null) System.out.println("Id"+ShipId.get(i)+" doesnt exist"); else
		 * session.delete(shipbean); } return 1; } catch(HibernateException e){
		 * return 0; }
		 */

	}

	@Override
	public String addRoute(RouteBean routebean) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(routebean);
			return "SUCCESS";
		} catch (HibernateException e) {
			return "FAIL";
		}

	}

	@Override
	public boolean modifyRoute(RouteBean routebean) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(routebean);
			return true;
		} catch (HibernateException e) {
			return false;
		}

	}

	@Override
	public int removeRoute(String routeid) {
		// TODO Auto-generated method stub

		// ////////////////////////////////////////////////////////////////
		System.out.println(routeid);
		try {
			Session session = sessionFactory.getCurrentSession();
			RouteBean routebean = (RouteBean) session.get(RouteBean.class,
					routeid);
			if (routebean == null) {
				System.out.println("excep");
				return 0;
			}

			Query query = session
					.createQuery("from ScheduleBean where routeID=?");
			query.setString(0, routeid);
			List<ScheduleBean> list = query.list();
			System.out.println(list.size());
			if (list.size() == 0) {
				System.out.println("list null");
				session.delete(routebean);
				return 1;
			} else {
				ScheduleBean scb = list.get(0);
				DateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				if (scb.getStartDate().before(date)) {
					session.delete(scb);
					session.delete(routebean);
					return 1;
				} else {
					return 0;
				}
			}

			// return 1;

		} catch (HibernateException e) {
			return 0;
		}

		// //////////////////////////////////////////////////////////////
		/*
		 * try{ Session session = sessionFactory.getCurrentSession(); RouteBean
		 * routebean = (RouteBean)session.get(RouteBean.class, routeid);
		 * session.delete(routebean); return 1;
		 * 
		 * } catch(HibernateException e){ return 0; }
		 */

	}

	@Override
	public ShipBean viewByShipId(String ShipId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		ShipBean shipbean = (ShipBean) session.get(ShipBean.class, ShipId);
		if (shipbean == null) {
			System.out.println("Id doesnt exist");
			return null;
		}
		return shipbean;

	}

	@Override
	public RouteBean viewByRouteId(String routeid) {
		// TODO Auto-generated method stub
		if (routeid == null) {
			return null;
		}
		if (routeid.equals("")) {
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		RouteBean rb = null;
		try {
			rb = (RouteBean) session.get(RouteBean.class, routeid);
			if (rb == null) {
				return null;
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return rb;

	}

	@Override
	public ArrayList<ShipBean> viewByAllShips() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ShipBean");

		List<ShipBean> list = query.list();

		return (ArrayList<ShipBean>) list;

	}

	@Override
	public ArrayList<RouteBean> viewByAllRoute() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		ArrayList<RouteBean> list = null;
		try {
			Query query = session.createQuery("from RouteBean");
			list = (ArrayList<RouteBean>) query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;

	}

	@Override
	public ArrayList<ScheduleBean> viewByAllSchedule() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		ArrayList<ScheduleBean> list = null;
		ArrayList<ScheduleBean> futureList;

		try {
			Query query = session.createQuery("from ScheduleBean");
			list = (ArrayList<ScheduleBean>) query.list();

			futureList = new ArrayList<>();
			Date dt = new Date();

			for (int i = 0; i < list.size(); ++i) {
				ScheduleBean sbean = list.get(i);
				Date sdate = sbean.getStartDate();

				if (sdate.compareTo(dt) != -1)
					futureList.add(sbean);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public ScheduleBean viewByScheduleId(String scheduleid) {
		// TODO Auto-generated method stub
		if (scheduleid == null) {
			return null;
		}
		if (scheduleid.equals("")) {
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		ScheduleBean sb = null;
		try {
			sb = (ScheduleBean) session.get(ScheduleBean.class, scheduleid);
			if (sb == null) {
				return null;
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return sb;
	}

	@Override
	public ArrayList<PassengerBean> viewPasengersByShip(String scheduleid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		ArrayList<PassengerBean> list = null;
		try {
			ScheduleBean sb = (ScheduleBean) session.get(ScheduleBean.class,
					scheduleid);
			if (sb == null) {
				return null;
			}
			Query query = session
					.createQuery("from PassengerBean where scheduleID=?");
			query.setString(0, scheduleid);
			list = (ArrayList<PassengerBean>) query.list();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}

	public String generateShipId(String shipName) {
		if (shipName == null) {
			return "ERROR";
		}
		if (shipName.equals("")) {
			return "ERROR";
		}
		Session session = sessionFactory.getCurrentSession();
		String sid = "";
		try {

			SQLQuery query = session
					.createSQLQuery("select SRS_SEQ_SHIP_ID.NEXTVAL from dual");
			Long key = ((BigDecimal) query.uniqueResult()).longValue();
			String s = shipName.substring(0, 2);
			sid = s.toUpperCase() + key;
			System.out.println(sid);

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}

		return sid;
	}

	public String generateRouteId(String source, String destination) {
		if (source == null) {
			return "ERROR";
		}
		if (source.equals("")) {
			return "ERROR";
		}
		if (destination == null) {
			return "ERROR";
		}
		if (destination.equals("")) {
			return "ERROR";
		}
		Session session = sessionFactory.getCurrentSession();
		String sid = "";
		try {

			SQLQuery query = session
					.createSQLQuery("select SRS_SEQ_ROUTE_ID.NEXTVAL from dual");
			Long key = ((BigDecimal) query.uniqueResult()).longValue();
			String s = source.substring(0, 2);
			String d = destination.substring(0, 2);
			sid = s.toUpperCase() + d.toUpperCase() + key;
			System.out.println(sid);

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}

		return sid;
	}

	public String generateScheduleId(String routeID) {
		if (routeID == null) {
			return "ERROR";
		}
		if (routeID.equals("")) {
			return "ERROR";
		}

		Session session = sessionFactory.getCurrentSession();
		String sid = "";
		try {
			RouteBean rb = (RouteBean) session.get(RouteBean.class, routeID);
			if (rb == null) {
				System.out.println("21");
				return "ERROR";
			}
			String source = rb.getSource();
			String destination = rb.getDestination();
			SQLQuery query = session
					.createSQLQuery("select SRS_SEQ_SCHEDULE_ID.NEXTVAL from dual");
			Long key = ((BigDecimal) query.uniqueResult()).longValue();
			String s = source.substring(0, 2);
			String d = destination.substring(0, 2);
			sid = s.toUpperCase() + d.toUpperCase() + key;
			System.out.println(sid);

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}

		return sid;
	}

	public String generateReservationId(String source, String destination) {
		if (source == null) {
			return "ERROR";
		}
		if (source.equals("")) {
			return "ERROR";
		}
		if (destination == null) {
			return "ERROR";
		}
		if (destination.equals("")) {
			return "ERROR";
		}
		Session session = sessionFactory.getCurrentSession();
		String sid = "";
		try {

			SQLQuery query = session
					.createSQLQuery("select SRS_SEQ_RESERVATION_ID.NEXTVAL from dual");
			Long key = ((BigDecimal) query.uniqueResult()).longValue();
			String s = source.substring(0, 2);
			String d = destination.substring(0, 2);
			sid = s.toUpperCase() + d.toUpperCase() + key;
			System.out.println(sid);

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}

		return sid;
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public ArrayList<ReservationBean> viewAllReservations() {
		try {
			Session session = sessionFactory.getCurrentSession();
			ArrayList<ReservationBean> reservationList;
			Query q = session.createQuery("from ReservationBean");
			reservationList = (ArrayList<ReservationBean>) q.list();
			return reservationList;
		} catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
			return null;
		}
	}

}
