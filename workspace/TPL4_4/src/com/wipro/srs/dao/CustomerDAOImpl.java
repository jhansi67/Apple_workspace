package com.wipro.srs.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.config.Configuration;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.CreditCardBean;
import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.PaymentBean;
import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean validateUser(CredentialsBean credentialsBean) {

		try {
			System.out.print("abcdef.......................");
			Session session = sessionFactory.getCurrentSession();
			System.out.print("abcdef.......................aaaaaaaaaaa");
			CredentialsBean result = (CredentialsBean) session.load(
					CredentialsBean.class, credentialsBean.getUserID());

			if (result == null)
				return false;
			else if (result.getUserID().equals(credentialsBean.getUserID())
					&& result.getPassword().equals(
							credentialsBean.getPassword()))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String getUserType(String userId) {
		Session session = sessionFactory.getCurrentSession();

		CredentialsBean result = (CredentialsBean) session.get(
				CredentialsBean.class, userId);
		String type = result.getUserType();
		System.out.println("type  = ..............." + type);
		return type;
	}

	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean,
			int loginStatus) {
		try {
			Session session = sessionFactory.getCurrentSession();
			System.out.print("abcdef.......................aaaaaaaaaaa");
			CredentialsBean result = (CredentialsBean) session.load(
					CredentialsBean.class, credentialsBean.getUserID());

			if (result == null)
				return false;
			else if (result.getLoginStatus() == loginStatus)
				return false;
			else {
				Query q = session
						.createQuery("UPDATE CredentialsBean set loginStatus = :loginStatus "
								+ "WHERE userID = :userID");
				q.setInteger("loginStatus", loginStatus);
				q.setString("userID", credentialsBean.getUserID());
				int i = q.executeUpdate();
				System.out.print("changed......." + i);
				if (i > 0)
					return true;
				else
					return false;
			}
		} catch (Exception e) {

		}
		return false;
	}
	
	
	
	
//	boolean firstflag = false;
//	int n1;

	@Override
	public String reserveSeat(ReservationBean reservationBean,
			ArrayList<PassengerBean> passengerBean) {
		Session session = sessionFactory.getCurrentSession();

		int sequence;
		try {

			ScheduleBean schedule = (ScheduleBean) session.load(
					ScheduleBean.class, reservationBean.getScheduleID());
			RouteBean route = (RouteBean) session.load(RouteBean.class,
					schedule.getRouteID());

			int seatsbooked = reservationBean.getNoOfSeats();
			String schid = schedule.getScheduleID();
			String shipid = schedule.getShipID();

			Date bookDate = new Date(); // /// booking date = todays
										// sysdate...........
			Date journeyDate = schedule.getStartDate(); // ///
														// schedule->start_date
	//		n1 = 	seatsbooked;										// = journey date.....
			System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,start date = "+journeyDate);
			if (journeyDate.compareTo(bookDate) != 1) {
				System.out.println("Past bookings are not allowed..........");
				return "FAIL";
			}

			reservationBean.setBookingDate(bookDate);
			reservationBean.setJourneyDate(journeyDate);
			// Transaction tx=s.beginTransaction();
			Query query = session
					.createSQLQuery("select SRS_SEQ_RESERVATION_ID.nextval from dual");
			sequence = ((BigDecimal) query.uniqueResult()).intValue();
			System.out.print("Sequence..................." + sequence);

			String id = route.getSource().substring(0, 2)
					+ route.getDestination().substring(0, 2) + sequence;

			System.out.println("sequence = " + id);
			reservationBean.setReservationID(id);

			// ///////////////////// check reservation capacity
			// //////////////////////////////
	//		int rcap = 0;
	//		Query q2 = session.createQuery("from ShipBean where shipId = ?");
	//		q2.setString(0, shipid);
	//		ShipBean ship = (ShipBean) q2.list().get(0);
	//		rcap = ship.getReservationCapacity();
	//		System.out.println("\n****************************rcap = " + rcap);
			// ///////////////////////////////////////////////////////////////////////////////////

	//		if (rcap > 0)
				reservationBean.setBookingStatus("Not Payed");
	//		else
	//			reservationBean.setBookingStatus("Waiting");

			String msg = (String) session.save(reservationBean);

			if (msg == null)
				return "FAIL";

			for (int i = 0; i < passengerBean.size(); ++i) {
				PassengerBean p = passengerBean.get(i);
				p.setReservationID(id);
				p.setScheduleID(reservationBean.getScheduleID());
				int m = (Integer) session.save(passengerBean.get(i));
				if (m <= 0)
					return "FAIL";
			}

			// ////////////// decrease ship seats
			// ///////////////////////////////

		//	if (rcap > 0 && rcap-seatsbooked>=0) {
		//		String s = "update srs_tbl_ship set reservationcapacity = (reservationcapacity -?) where shipid = (select shipid from srs_tbl_schedule where scheduleid = ?)";
		//		Query q = session.createSQLQuery(s);
		//		q.setInteger(0, seatsbooked);
		//		q.setString(1, schid);
		//		int seatupdate = q.executeUpdate();
		//		System.out.println("updated seat no " + seatupdate);

	//			if (seatupdate <= 0)
	//				return "FAIL";
				
	//			if(rcap == seatsbooked)
	//				firstflag = true;
	//		}

			return "SUCCESS";
		} catch (Exception E) {
			E.printStackTrace();
			return "FAIL";
		}
	}

	@Override
	public ArrayList<ScheduleBean> viewScheduleByRoute(String source,
			String destination, Date date) {
		try {

			Session session = sessionFactory.getCurrentSession();
			System.out.println("in to dao.......");
			Query q = session
					.createQuery("from RouteBean as rb where rb.source= ? and rb.destination= ?");
			System.out.println("in to dao.......afff");
			q.setString(0, source);
			q.setString(1, destination);

			ArrayList<RouteBean> list = (ArrayList<RouteBean>) q.list();
			System.out.println("go to dao......." + list.size());

			ArrayList<ScheduleBean> scheduleships = new ArrayList<ScheduleBean>();
			for (int i = 0; i < list.size(); ++i) {
				String routeid = list.get(i).getRouteID();
				q = session
						.createQuery("from ScheduleBean as sb where sb.routeID= :routeID and sb.startDate= :startDate");
				q.setString("routeID", routeid);
				q.setDate("startDate", date);
				ArrayList<ScheduleBean> schlist = (ArrayList<ScheduleBean>) q
						.list();
				scheduleships.addAll(schlist);
			}
			System.out.println("go to dao......." + scheduleships.size());
			return scheduleships;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Map<ReservationBean, ArrayList<PassengerBean>> viewTicket(
			String reservationId) {

		try {
			HashMap<ReservationBean, ArrayList<PassengerBean>> ticket = new HashMap();
			Session session = sessionFactory.getCurrentSession();
			System.out.println("in to dao ticket.......");

			// ReservationBean reservationBean = (ReservationBean)
			// session.get(ReservationBean.class, reservationId);
			Query q = session
					.createQuery("from ReservationBean as rb where rb.reservationID = :reservationID");
			q.setString("reservationID", reservationId);
			ReservationBean reservationBean = (ReservationBean) q.list().get(0);

			if (reservationBean == null)
				return null;

			q = session
					.createQuery("from PassengerBean as pb where pb.reservationID = :reservationID");
			q.setString("reservationID", reservationId);
			ArrayList<PassengerBean> passengerlist = (ArrayList<PassengerBean>) q
					.list();
			System.out.print("passengers = " + passengerlist);

			ticket.put(reservationBean, passengerlist);
			return ticket;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}

	}

	// /////////////////////////////////////////////////////////////////////////////
	// /////////////////// adis //////////////////////////////////////////////
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String daoAdd(ProfileBean profileBean) {

		String res = "";
		try {
			Session session = sessionFactory.getCurrentSession();
			String id = generateUserId(profileBean.getFirstName());

			if (id != null) {
				CredentialsBean credentialsBean = new CredentialsBean();

				credentialsBean.setPassword(profileBean.getPassword());
				credentialsBean.setUserID(id);
				credentialsBean.setUserType("C");
				credentialsBean.setLoginStatus(0);

				session.save(credentialsBean);
				profileBean.setUserID(id);
				session.save(profileBean);

				res = "positive";
				System.out.println("result is" + res);
			} else
				res = "negative";
		} catch (Exception e) {
			e.printStackTrace();
			res = "negative";
		}

		return res;

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String generateUserId(String name) {
		int seq = 0;
		try {
			String hql = "select SRS_SEQ_USER_ID.nextval from dual";

			Session session = sessionFactory.getCurrentSession();

			// Query myquery = session.createQuery(sql);
			SQLQuery myquery = session.createSQLQuery(hql);

			seq = ((java.math.BigDecimal) myquery.uniqueResult()).intValue();

			System.out.println("sequence value is :  " + seq);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("inside generate id" + e);
		}
		return name.substring(0, 2).toUpperCase() + seq;

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean cancelTicket(String reservationId) {

		Date dt = new Date();
		PassengerBean passengerBean = new PassengerBean();
		String hql = "delete from PassengerBean where reservationID = :reservation_ID";
		int result = 0;
		System.out.println("Inside cancel ticket dao" + "\n And date is" + dt);
		int check;
		try {
			Session session = sessionFactory.getCurrentSession();

			ReservationBean reservationBean = (ReservationBean) session.get(
					ReservationBean.class, reservationId);
			check = reservationBean.getJourneyDate().compareTo(dt);

			double payed = reservationBean.getTotalFare();
			String uid = reservationBean.getUserId();
			int seats = reservationBean.getNoOfSeats();
			String scheduleid = reservationBean.getScheduleID();
			String bookingStatus = reservationBean.getBookingStatus();

			if (bookingStatus.equalsIgnoreCase("Waiting"))
				seats = 0;

			if (check == 1) {

				Query query = session.createQuery(hql);
				query.setParameter("reservation_ID", reservationId);
				result = query.executeUpdate();
				session.delete(reservationBean);

				Query q = session
						.createSQLQuery("update srs_tbl_creditcard set balance = (balance + ?) where userid = ?");
				q.setDouble(0, payed);
				q.setString(1, uid);
				int rset = q.executeUpdate();
				System.out.println("updated account balance " + rset);

				if (rset <= 0)
					return false;

				// ///////////////////////////////////////////////////////////////////////////
				// /////////////// waiting list ////////////////////////////////

				String sql = "from ReservationBean where bookingstatus = ?";
				Query q2 = session.createQuery(sql);
				q2.setString(0, "Waiting");
				ArrayList<ReservationBean> waitlist = (ArrayList<ReservationBean>) q2
						.list();

				if (waitlist == null || waitlist.size() == 0) { // //// none
																// waiting....
					System.out
							.println("incrementing rcapacty................................\n\n"
									+ scheduleid);
					ScheduleBean sbean = (ScheduleBean) session.load(
							ScheduleBean.class, scheduleid);
					String shipid = sbean.getShipID();
					ShipBean ship = (ShipBean) session.load(ShipBean.class,
							shipid);
					int rcap = ship.getReservationCapacity();
					System.out.println("I have shipid = " + shipid + "rcap = "
							+ rcap);

					if (rcap + seats <= ship.getSeatingCapacity()) {
						ship.setReservationCapacity(rcap + seats);
						session.saveOrUpdate(ship);
					}

				} else { // // someone is waiting
					System.out
							.println("changing book status................................\n\n");
					for (int i = 0; i < waitlist.size(); ++i) {
						ReservationBean rb = waitlist.get(i);
						int n = rb.getNoOfSeats();

						if (n <= seats) {
							// // change status
							String s = "update srs_tbl_reservation set bookingstatus = 'Confirmed' where reservationid = ? ";
							Query q4 = session.createSQLQuery(s);
							q4.setString(0, rb.getReservationID());

							int seatupdate = q4.executeUpdate();
							System.out.println("updated seat no " + seatupdate);
							seats = seats - n;
						}
					}

					if (seats != 0) {
						System.out
								.println("incrementing rcapacty.........additionally.......................\n\n"
										+ seats);
						ScheduleBean sbean = (ScheduleBean) session.load(
								ScheduleBean.class, scheduleid);
						String shipid = sbean.getShipID();
						ShipBean ship = (ShipBean) session.load(ShipBean.class,
								shipid);
						int rcap = ship.getReservationCapacity();
						System.out.println("I have shipid = " + shipid
								+ "rcap = " + rcap);

						if (rcap + seats <= ship.getSeatingCapacity()) {
							ship.setReservationCapacity(rcap + seats);
							session.saveOrUpdate(ship);
						}
					}
				}

				return true;

			} else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

			System.out.println("Result in DaO Layer Is:" + result);
		}
	}

	// ///////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean isValidCard(String userid, String cardnumber,Date from,Date to) {
		System.out.print("in THE DAO...." + userid + " " + cardnumber);
		if (userid == null || userid.isEmpty() || userid.equals(""))
			return false;
		if (cardnumber == null || cardnumber.isEmpty() || cardnumber.equals(""))
			return false;

		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session
					.createQuery("from CreditCardBean as cb where cb.creditCardNumber = :creditCardNumber");
			q.setString("creditCardNumber", cardnumber);
			ArrayList<CreditCardBean> list = (ArrayList<CreditCardBean>) q
					.list();

			if (list == null || list.size() == 0) {
				System.out.print("was null .....or size was 0");
				return false;
			} else {
				boolean valid = false;
				for (int i = 0; i < list.size(); ++i) {
					CreditCardBean c = list.get(i);
					if (c.getCreditCardNumber().equals(cardnumber)
							&& c.getUserId().equals(userid)) {
						valid = true;
						
						Date expired = c.getValidTo();
						Date validfrom = c.getValidFrom();
						
				//		System.out.println("validto match =...................... "+validfrom.compareTo(validfrom));
				//		System.out.println("validto match =....................... "+current.compareTo(expired));
						
						
						if(validfrom.compareTo(from) != 0 || expired.compareTo(to) != 0){
							System.out.println("credit card not ativated....*****************");
							valid = false;
						}
						
					}
				}
				
				return valid;
			}

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean makePayment(PaymentBean paymentBean, ReservationBean rb) {
		if (paymentBean == null)
			return false;
		else if (paymentBean.getUserID() == null
				|| paymentBean.getUserID().isEmpty()
				|| paymentBean.getUserID().equals(""))
			return false;
		else if (paymentBean.getCreditCardNumber() == null
				|| paymentBean.getCreditCardNumber().isEmpty()
				|| paymentBean.getCreditCardNumber().equals(""))
			return false;

		System.out.println("IN dao payment process"
				+ paymentBean.getCreditCardNumber() + paymentBean.getUserID());

		String cardno = paymentBean.getCreditCardNumber();
		double totalfare = rb.getTotalFare();
		System.out.println("Dao recieved total fare = " + totalfare);
		double balance = 0;

		// ////////////////////////////////////////////////////////////
		// /////////// query balance............................
		Session session = sessionFactory.getCurrentSession();
		Query q = session
				.createQuery("from CreditCardBean where creditCardNumber = ?");
		q.setString(0, cardno);
		CreditCardBean c = (CreditCardBean) q.list().get(0);
		balance = c.getBalance();
		System.out
				.println("\nbalance = " + balance + "totalfare  " + totalfare);

		if (totalfare > balance)
			return false;
		else {
			System.out
					.println("Deducting balanec.................................");
			// /////////////////////////////////////////
			// ////// deduct balance.........
			double newbalance = balance - totalfare;
			q = session
					.createQuery("UPDATE CreditCardBean set balance = :newbalance "
							+ "WHERE creditCardNumber = :cardno");
			q.setDouble("newbalance", newbalance);
			q.setString("cardno", cardno);
			int i = q.executeUpdate();

			if (i > 0) {
				paymentBean.setPaidAmount(totalfare);
				// System.out.println("setting....rb id: "+lastReserveSequence);
				// paymentBean.setReservationID(lastReserveSequence);
				String pay = (String) session.save(paymentBean);
				System.out.println("payments saved with id = " + pay);
				// lastpayid = pay;
				// System.out.println("\n\n *******************pay"+pay+"     lastpauid"+lastpayid);

				if (pay != null) {
					ReservationBean r = (ReservationBean) session.get(
							ReservationBean.class, rb.getReservationID());

					String scheduleId = r.getScheduleID();
					ScheduleBean scheduleBean = (ScheduleBean) session.get(
							ScheduleBean.class, scheduleId);
					ShipBean shipBean = (ShipBean) session.get(ShipBean.class,
							scheduleBean.getShipID());
					int rcap = shipBean.getReservationCapacity();
					System.out
							.println(".................................rcap................="
									+ rcap);
					
					
					
					
					
					boolean firstflag = false;
					// ////////////// decrease ship seats		// ///////////////////////////////

					if (rcap > 0 && rcap-rb.getNoOfSeats()>=0) {
						String s = "update srs_tbl_ship set reservationcapacity = (reservationcapacity -?) where shipid = (select shipid from srs_tbl_schedule where scheduleid = ?)";
						Query qq = session.createSQLQuery(s);
						qq.setInteger(0, rb.getNoOfSeats());
						qq.setString(1, rb.getScheduleID());
						int seatupdate = qq.executeUpdate();
						System.out.println("updated seat no " + seatupdate);

						if (seatupdate <= 0)
							return false;
						
						if(rcap == rb.getNoOfSeats())
							firstflag = true;
					}
					
					
					
					
					
					
					
					
					
					
					
					

					if (rcap == 0 || rcap < rb.getNoOfSeats()){
					
						if(firstflag == true){
							r.setBookingStatus("Confirmed");
							firstflag = false;
						}
						r.setBookingStatus("Waiting");
					}
					else
						r.setBookingStatus("Confirmed");
					session.saveOrUpdate(r);
					return true;
				} else
					return false;
			} else
				return false;

		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public double getRouteFare(String scheduleID) {
		if (scheduleID == null || scheduleID.isEmpty() || scheduleID.equals(""))
			return -100;

		System.out.println("********dao calculating routefare");

		try {
			Session session = sessionFactory.getCurrentSession();
			String sql = "select fare from srs_tbl_route where routeId = (select routeId from srs_tbl_schedule where scheduleId = ?)";
			Query q = session.createSQLQuery(sql);
			q.setString(0, scheduleID);
			double fare = ((java.math.BigDecimal) q.uniqueResult())
					.doubleValue();

			System.out.println("fare for this route is ... = " + fare);
			return fare;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return -100;
		}
	}

	// ////////////////////////////////////////////////////////////////////////////
	// /////////// adi /////////////////////////////////////////////////
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean changePassword(CredentialsBean credentialsBean,
			String newPassword) {

		try {
			Session session = sessionFactory.getCurrentSession();
			boolean res;
			System.out.println("uid == " + credentialsBean.getUserID());
			CredentialsBean cbean = (CredentialsBean) session.load(
					CredentialsBean.class, credentialsBean.getUserID());

			String pass = cbean.getPassword();
			System.out.println("befor setting the type check it.... "
					+ cbean.getUserType());
			if (pass.equals(credentialsBean.getPassword())) {
				cbean.setUserID(credentialsBean.getUserID());
				cbean.setPassword(newPassword);
				// cbean.setUserType(cbean.getUserType());
				// cbean.setLoginStatus(0);
				session.save(cbean);
				res = true;
			} else
				res = false;

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	// ///////////////////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////////////////
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String daoValidify(String emailID) {

		String res = "positive";
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from ProfileBean";
			Query myquery = session.createQuery(hql);
			// myquery.setString("emailID", emailID);
			ArrayList<ProfileBean> profile = (ArrayList<ProfileBean>) myquery.list();
			int flag = 0;

			for (int i = 0; i < profile.size(); i++) {
				ProfileBean p = profile.get(i);
				String email = p.getEmailID();
				
				if (email.equalsIgnoreCase(emailID)) {
					flag = 1;
					break;
				}
			}
			// System.out.println(profiles);
			if (flag == 1) {
				System.out.println("Found with email" + emailID);
				return "positive";
			} else
				return "negative";

		} catch (Exception e) {
			e.printStackTrace();
			res = "negative";
			return res;
		}
	}

}
