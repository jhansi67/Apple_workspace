package com.wipro.srs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.icu.impl.ICUBinary.Authenticate;
import com.ibm.icu.util.Calendar;
import com.itextpdf.text.log.SysoLogger;
import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.CreditCardBean;
import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.PassengerListBean;
import com.wipro.srs.bean.PaymentBean;
import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.dao.AdminDAO;
import com.wipro.srs.dao.CustomerDAO;
import com.wipro.srs.service.AdminService;
import com.wipro.srs.service.Customer;
import com.wipro.srs.service.CustomerImpl;
import com.wipro.srs.util.AuthenticationImpl;
import com.wipro.srs.util.Payment;
import com.wipro.srs.util.User;
import com.wipro.srs.util.UserImpl;

@Controller
public class Controller1 {

	@Autowired
	Customer customer;

	@Autowired
	User user;

	@Autowired
	Payment payment;

	@Autowired
	AdminService adminService;

	// //////////////////////////////////////////////////////////////////////////////
	// ////////////////// login logout ///////////////////////////////

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String processLogOut(HttpSession httpsession, Model model) {
		String userID = (String) httpsession.getAttribute("userID");
		System.out.println("****************************" + userID);
		boolean log = user.logout(userID);
		if (log) {
			httpsession.invalidate();
			return "logout";
		} else {
			model.addAttribute("failmsg",
					"Logout failed. Your session was alredy expired " + "!!!");
			return "fail";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(@RequestParam("userID") String userID,
			@RequestParam("password") String password, HttpSession httpsession,
			Model model) {

		// String userID = cbean.getUserID();
		// String password = cbean.getPassword();
		System.out.print(userID + " " + password);

		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setUserID(userID);
		credentialsBean.setPassword(password);

		String s = user.login(credentialsBean);
		System.out.print(s + " " + "0000000000000000000000000000");

		if (s.equals("C")) {
			httpsession.setAttribute("userID", userID);
			return "CustomerHomePage";
		} else if (s.equals("A")) {
			httpsession.setAttribute("userID", userID);
			System.out.println("going to adminpage");
			return "AdminHomePage1";
		} else if (s.equals("FAIL2")) {
			model.addAttribute("failmsg",
					"Login failed... You have already crossed the maximum login limit... "
							+ "!!!");
			return "fail";
		} else {
			model.addAttribute("failmsg",
					"Login failed... Invalid credentials... " + "!!!");
			return "fail";
		}
	}

	// ///////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////

	// ////////////////////////////////////////////////////////////////////////////
	// //////////////// view ship details /////////////////////////////
	// //////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/ViewShipDetails", method = RequestMethod.GET)
	public String processEntertoview(Model model) {

		ArrayList<RouteBean> routebeans = adminService.viewByAllRoute();
		// if(routebeans == null)
		// return "fail";
		ArrayList<String> source = new ArrayList<String>();
		// source.add(" --- Select One --- ");

		if (routebeans == null || routebeans.isEmpty()) {
			model.addAttribute("failmsg",
					"There are no routes assigned by the survice providers.... "
							+ "!!!");
			return "fail";
		}

		for (int i = 0; i < routebeans.size(); ++i) {
			String currSource = routebeans.get(i).getSource();
			if (source.contains(currSource))
				continue;
			source.add(currSource);
		}

		RouteBean routeBean = new RouteBean();
		model.addAttribute("routeBean", routeBean);
		model.addAttribute("source", source);
		return "ViewShipDetails";
	}

	@RequestMapping(value = "/ViewShipScheduleDetails", method = RequestMethod.POST)
	public String processView(@ModelAttribute("routeBean") RouteBean routeBean,
			Model model) {

		try {

			String source = routeBean.getSource();
			String destination = routeBean.getDestination();
			System.out.print("source = " + source);
			System.out.print("destination = " + destination);

			ArrayList<RouteBean> routeList = adminService.viewByAllRoute();
			ArrayList<ScheduleBean> schduleList = new ArrayList<ScheduleBean>();

			for (int i = 0; i < routeList.size(); ++i) {
				RouteBean route = routeList.get(i);

				if (route.getSource().equals(source) == true
						&& route.getDestination().equals(destination) == true) {
					String routeId = route.getRouteID();
					ArrayList<ScheduleBean> allSchedules = adminService
							.viewByAllSchedule();

					if (allSchedules == null || allSchedules.isEmpty()) {
						model.addAttribute("failmsg",
								"No reservations can be done as there are no schedules for future dates...");
						return "fail";
					}

					for (int j = 0; j < allSchedules.size(); ++j) {
						ScheduleBean anyScheduleBean = allSchedules.get(j);
						System.out.print(anyScheduleBean.getScheduleID()
								+ "................");

						if (anyScheduleBean.getRouteID().equals(routeId)) {
							schduleList.add(anyScheduleBean);
							System.out.println("schids = "
									+ anyScheduleBean.getScheduleID());
						}
					}
				}
			}

			System.out.println(".......schedulelist size = "
					+ schduleList.size());
			model.addAttribute("schduleList", schduleList);
			return "ViewShipScheduleDetails";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("failmsg",
					"Schedules, routes or ships were not assigned yet... "
							+ "!!!");
			return "fail";
		}
	}

	// /////////////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////////////

	// ////////////////////////////////////////////////////////////////////////////////
	// ////////////////// CUSTOMER SHIP RESERVATION /////////////////////////
	// //////////////////////////////////////////////////////////////////////////////
	ReservationBean rb;
	ArrayList<PassengerBean> plb;
	double toatlfare = 0;

	// ///////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////// DIRECT RESERVATION
	// ////////////////////////////////////////

	@RequestMapping(value = "/DirectReserveShip", method = RequestMethod.GET)
	public String modifyrouteget(@RequestParam("scheduleID") String scheduleID,
			Model model) {

		System.out.println("scheduleid to be reserved..." + scheduleID);
		ArrayList<String> scheduleIdList = new ArrayList<String>();

		// //
		scheduleIdList.add(scheduleID);

		ScheduleBean schedule = adminService.viewByScheduleId(scheduleID);
		if (schedule.getStartDate().compareTo(new Date()) < 0) {
			model.addAttribute("failmsg",
					"You can not reserve past schedules..." + "!!!");
			return "fail";
		}
		// //

		model.addAttribute("scheduleIdList", scheduleIdList);
		model.addAttribute("reservationBean", new ReservationBean());
		return "CustomerReserveShip";
	}

	// ////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/CustomerReserveShip", method = RequestMethod.GET)
	public String setCustomerReservation(Model model) {
		System.out.print("get....................................");
		ReservationBean reservationBean = new ReservationBean();
		ArrayList<PassengerBean> passengerList = new ArrayList<PassengerBean>();

		ArrayList<ScheduleBean> scheduleList = adminService.viewByAllSchedule();
		if (scheduleList == null || scheduleList.isEmpty()) {
			model.addAttribute("failmsg", "No schedules assigned yet...");
			return "fail";
		}
		/*
		 * if(scheduleList == null || scheduleList.isEmpty()){ return "fail"; }
		 * 
		 * if(passengerList == null || passengerList.isEmpty()){ return "fail";
		 * }
		 */

		ArrayList<String> scheduleIdList = new ArrayList<String>();
		for (int i = 0; i < scheduleList.size(); ++i) {
			Date current = new Date();
			Date schdate = scheduleList.get(i).getStartDate();

			if (schdate.compareTo(current) >= 0)
				scheduleIdList.add(scheduleList.get(i).getScheduleID());
		}

		model.addAttribute("scheduleIdList", scheduleIdList);
		model.addAttribute("reservationBean", reservationBean);
		model.addAttribute("passengerList", passengerList);
		return "CustomerReserveShip";
	}

	@RequestMapping(value = "/CustomerReserveShip", method = RequestMethod.POST)
	public String processCustomerReservation(
			@ModelAttribute("reservationBean") ReservationBean reservationBean,
			Model model, HttpSession httpSession) {

		System.out.print("post" + reservationBean.getNoOfSeats());
		PassengerListBean pb = new PassengerListBean();
		model.addAttribute("pb", pb);
		model.addAttribute("seat", reservationBean.getNoOfSeats());
		rb = reservationBean;
		String uid = (String) httpSession.getAttribute("userID");
		System.out.println("----------------------------uid = " + uid);
		rb.setUserId(uid);
		// //////////////////////////////////////////////////////////
		double routefare = 0;
		routefare = customer.getRouteFare(rb.getScheduleID());
		System.out.println("controller routefare = " + routefare);
		if (routefare <= 0) {
			model.addAttribute("failmsg", "route fare was not assigned "
					+ "!!!");
			return "fail";
		}
		// //////////////////////////////////////////////////////////

		double totalfare = routefare * rb.getNoOfSeats();
		System.out.println(totalfare);
		rb.setTotalFare(totalfare);
		model.addAttribute("routefare", routefare);
		model.addAttribute("totalfare", totalfare);

		// ///////////
		String schid = reservationBean.getScheduleID();
		ScheduleBean schbean = adminService.viewByScheduleId(schid);
		String shipid = schbean.getShipID();
		ShipBean ship = adminService.viewByShipId(shipid);
		int rcap = ship.getReservationCapacity();

		if (rcap == 0 || rcap < reservationBean.getNoOfSeats())
			model.addAttribute("type", "Waiting");
		else
			model.addAttribute("type", "Confirmed");
		model.addAttribute("capacity", ship.getReservationCapacity());

		// //////////
		ArrayList<ReservationBean> reservations = adminService
				.viewAllReservations();
		int totalWaitingPassengers = 0;
		int totalWaitingReservations = 0;
		for (int i = 0; i < reservations.size(); ++i) {
			ReservationBean rb = reservations.get(i);

			if (rb.getBookingStatus().equals("Waiting")) {
				totalWaitingPassengers += rb.getNoOfSeats();
				totalWaitingReservations++;
			}
		}
		model.addAttribute("totalWaitingReservations", totalWaitingReservations);
		model.addAttribute("totalWaitingPassengers", totalWaitingPassengers);
		// //////////
		return "PassengerList";
	}

	@RequestMapping(value = "/passenger", method = RequestMethod.POST)
	public String processPassengerList(
			@ModelAttribute("pb") PassengerListBean pb, Model model) {

		System.out.println("passenger*********************");
		ArrayList<PassengerBean> plist = pb.getList();
		System.out.println("No. of passengers: " + plist.size());

		for (int i = 0; i < plist.size(); ++i) {
			System.out.print("here");
			PassengerBean p = plist.get(i);
			System.out.println(p.getName() + " " + p.getAge() + " "
					+ p.getGender());
		}

		plb = plist;

		CreditCardBean credeitCardBean = new CreditCardBean();
		model.addAttribute("creditcard", credeitCardBean);
		return "payment";
		/*
		 * String s = customer.reserveTicket(rb, plb);
		 * 
		 * if (s == null) { return "fail"; } else if (s.equals("SUCCESS")) {
		 * return "Success"; } else { return "fail"; }
		 */
	}

	@RequestMapping(value = "/paymentinput", method = RequestMethod.GET)
	public String setPaymentInput(Model model, HttpSession httpSession) {
		System.out.print("get payments");

		System.out.print(httpSession.getAttribute("userID"));
		CreditCardBean creditCardBean = new CreditCardBean();

		model.addAttribute("creditCardBean", creditCardBean);
		return "payment";
	}

	@RequestMapping(value = "/paymentprocess", method = RequestMethod.POST)
	public String processpaymentinput(
			@ModelAttribute("creditcard") CreditCardBean creditCardBean,
			Model model, HttpSession httpSession) {

		try {

			if (creditCardBean.getCreditCardNumber() == null
					|| creditCardBean.getCreditCardNumber().isEmpty()
					|| creditCardBean.getCreditCardNumber().equals("")) {
				model.addAttribute("failmsg", "Data not entered properly... "
						+ "!!!");
				return "fail";
			}

			String userId = (String) httpSession.getAttribute("userID");
			System.out.println(creditCardBean.getUserId() + " "
					+ creditCardBean.getCreditCardNumber()
					+ " payment for uid = " + userId);

			boolean validcard = payment.findByCardNumber(userId,
					creditCardBean.getCreditCardNumber(),creditCardBean.getValidFrom(),creditCardBean.getValidTo());
			System.out.println("card found = " + validcard);

			if (validcard) {

				PaymentBean paymentBean = new PaymentBean();
				paymentBean.setCreditCardNumber(creditCardBean
						.getCreditCardNumber());
				paymentBean.setUserID(userId);

				// ///////////////////////////////////
				rb.setBookingStatus("Not Payed...");
				String s = customer.reserveTicket(rb, plb);

				if (s == null) {
					System.out.println("Controller:failed reserve....1");
					model.addAttribute("failmsg",
							"There was a error in booking... Please try again.... "
									+ "!!!");
					return "fail";
				} else if (s.equals("SUCCESS")) {
					String msg = payment.process(paymentBean, rb);
					if (msg.equals("SUCCESS")) {
						System.out
								.println("Paid the total amount successfully........");

						ArrayList<ReservationBean> reseves = adminService
								.viewAllReservations();
						int max = 0;
						int pos = 0;
						for (int i = 0; i < reseves.size(); ++i) {
							String seq = reseves.get(i).getReservationID()
									.substring(4, 8);
							System.out.println(seq);
							int n = Integer.parseInt(seq);
							if (max < n) {
								max = n;
								pos = i;
							}
						}
						ReservationBean lastReservation = reseves.get(pos);
						System.out
								.println("found last reservation = .........="
										+ max);
						model.addAttribute("lastReservation", lastReservation);
						model.addAttribute("plist", plb);
						return "SuccessReservationandPayment";
					} else {
						System.out
								.println("Not payed... Contact with admin....");
						ArrayList<ReservationBean> reseves = adminService
								.viewAllReservations();
						ReservationBean lastReservation = reseves.get(reseves
								.size() - 1);
						model.addAttribute("lastReservation", lastReservation);
						model.addAttribute("plist", plb);
						return "notpayed";
					}
				} else {
					System.out.println("Controller:failed reserve....2" + s);
					model.addAttribute("failmsg",
							"There was an error in booking... Please try again...."
									+ "!!!");
					return "fail";
				}
				// /////////////////////////////////
				// } else {
				// System.out.println("Not payed...................");
				// return "fail";
				// }
			} else {
				model.addAttribute("failmsg", "Invalid credit card details..."
						+ "!!!");
				return "fail";
			}
		} catch (Exception e) {
			model.addAttribute("failmsg",
					"Error occured while reservation... Please try it again...");
			return "fail";
		}
	}

	// ///////////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////

	// ///////////////////////////////////////////////////////////////////////////////
	// ////////////////// VIEW TICKET ////////////////////////////////////////
	@RequestMapping(value = "/ViewTicketInput", method = RequestMethod.GET)
	public String processTicket(Model model, HttpSession httpSession) {
		System.out.print("View the ticket.................");
		ArrayList<ReservationBean> reservationList = adminService
				.viewAllReservations();
		ArrayList<String> rids = new ArrayList<String>();

		for (int i = 0; i < reservationList.size(); ++i) {
			ReservationBean rb = reservationList.get(i);
			String rid = rb.getReservationID();
			String uid = (String) httpSession.getAttribute("userID");
			Date cuurentDate = new Date();
			Date journeyDate = rb.getJourneyDate();

			if (uid.equals(rb.getUserId())) {
				if (journeyDate.compareTo(cuurentDate) == 1
						|| journeyDate.compareTo(cuurentDate) == 0) {
					System.out.println("future journey...." + rid + " "
							+ journeyDate.compareTo(cuurentDate));
					rids.add(rid);
				} else {
					System.out.println("Expired ticket date....." + rid + " "
							+ journeyDate.compareTo(cuurentDate));
				}
			}
		}
		model.addAttribute("rb", new ReservationBean());
		model.addAttribute("rids", rids);
		return "ViewTicketInput";
	}

	@RequestMapping(value = "/ViewTicketInput2", method = RequestMethod.POST)
	public String processViewTicket(
			@ModelAttribute("rb") ReservationBean reservationBean, Model model) {

		try {
			String reservationId = reservationBean.getReservationID();
			System.out.println("View for rid=" + reservationId);
			if (reservationId == null || reservationId.isEmpty()
					|| reservationId.equals("")) {
				model.addAttribute("failmsg", "Invalid credit card details..."
						+ "!!!");
				return "fail";
			}

			System.out.print("reservationId = " + reservationId);
			Map<ReservationBean, ArrayList<PassengerBean>> ticket = customer
					.viewTicket(reservationId);

			if (ticket == null)
				return "Empty";
			else if (ticket.isEmpty() || ticket.size() == 0)
				return "Empty";
			else {
				model.addAttribute("ticket", ticket);
				return "Ticket";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("failmsg",
					"There was an error in booking...Please try again..."
							+ "!!!");
			return "fail";
		}
	}

	// /////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	// ////////////////////////////////////////////////////////////////////////
	// ///////////// PRINT TICKET /////////////////////////////////
	@RequestMapping(value = "/PrintTicketInput", method = RequestMethod.GET)
	public String processPrintTicket(HttpSession httpSession, Model model) {
		System.out.print("print the ticket.................");
		// ////////////////////////////////////////////////////////////////////////
		ArrayList<ReservationBean> reservationList = adminService
				.viewAllReservations();
		ArrayList<String> rids = new ArrayList<String>();

		for (int i = 0; i < reservationList.size(); ++i) {
			ReservationBean rb = reservationList.get(i);
			String rid = rb.getReservationID();
			String uid = (String) httpSession.getAttribute("userID");
			Date cuurentDate = new Date();
			Date journeyDate = rb.getJourneyDate();

			if (uid.equals(rb.getUserId())) {
				if (journeyDate.compareTo(cuurentDate) == 1
						|| journeyDate.compareTo(cuurentDate) == 0) {
					System.out.println("future journey...." + rid + " "
							+ journeyDate.compareTo(cuurentDate));
					rids.add(rid);
				} else {
					System.out.println("Expired ticket date....." + rid + " "
							+ journeyDate.compareTo(cuurentDate));
				}
			}
		}
		model.addAttribute("rb", new ReservationBean());
		model.addAttribute("rids", rids);
		// ///////////////////////////////////////////////////////////////////////
		return "PrintTicketInput";
	}

	@RequestMapping(value = "/PrintTicketInput2", method = RequestMethod.POST)
	public String processViewPrintTicket(
			@ModelAttribute("rb") ReservationBean reservationBean, Model model) {

		try {
			String reservationId = reservationBean.getReservationID();
			if (reservationId == null || reservationId.isEmpty()
					|| reservationId.equals("")) {
				model.addAttribute("failmsg", "Invalid credit card details..."
						+ "!!!");
				return "fail";
			}

			System.out.print("reservationId = " + reservationId);
			Map<ReservationBean, ArrayList<PassengerBean>> pticket = customer
					.printTicket(reservationId);

			System.out.println("in controller ticket "
					+ pticket.keySet().size());
			if (pticket == null)
				return "Empty";
			else if (pticket.isEmpty() || pticket.size() == 0)
				return "Empty";
			else {
				model.addAttribute("pticket", pticket);
				return "PrintTicket";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("failmsg",
					"There was an error in booking...Please try again ..."
							+ "!!!");
			return "fail";
		}
	}

	// ////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// ADD CUSTOMER /////////////////////////////
	// ///////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/customerAdd", method = RequestMethod.GET)
	public String showForm(Model model) {
		System.out.println("here in Get Method");
		ProfileBean profileBean = new ProfileBean();
		model.addAttribute("profileBean", profileBean);
		System.out.println(profileBean.getCity());
		return "CustomerRegister";
	}

	// ///////////////////////////////////////////////////////////////////////////////////
	// /////////////// /////////////// ////////// ////////////////
	@RequestMapping(value = "/validEmailInfo", method = RequestMethod.GET)
	public @ResponseBody
	String validify(Model model, @RequestParam("emailID") String emailID) {

		System.out.println("Inside Validify Email id Get Method");
		String result1 = user.validify(emailID);
		System.out.println("Result inside Controller is" + result1);
		int res1 = 0;
		if (emailID.isEmpty() || emailID == null)
			return "Insert Email Id";
		if (result1.equals("idExist")) {
			return "EXIST";
		} else if (emailID.length() != 0) {
			String test = emailID;
			int dot = -2;
			int at_rate = -2;
			// ///////////////checking characters using char at
			int ch1 = 0;
			int ch2 = 0;
			for (int i = 0; i < test.length(); i++) {
				if (test.charAt(i) == '@') {
					at_rate = i;
					ch1++;
				}
				if (test.charAt(i) == '.') {
					dot = i;
					ch2++;
				}
			}
			System.out.println(dot);
			System.out.println(at_rate);
			// ///////////////////////checking for . and @ parameters
			int temp = dot - 1;
			if (at_rate == -2 || dot == -2 || at_rate == 0 || dot == 0
					|| temp == at_rate || ch1 != 1 || ch2 != 1) {
				res1 = -5;
			} else if (dot < at_rate) {
				res1 = -5;
			}
			System.out.println(res1);
		}
		if (res1 == -5)
			return "INVALID";
		else
			return "VALID";
	}

	// /////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/addInfo", method = RequestMethod.POST)
	public String processForm(
			@Valid @ModelAttribute("profileBean") ProfileBean profileBean,
			BindingResult result, Model model) {
		String res1 = "";
		System.out.println("In the Post Method");

		if (result.hasErrors()) {
			System.out.println("Spring Validation Working");
			return "CustomerRegister";

		}

		String res;

		res = user.register(profileBean);

		if (res != "FAIL") {
			System.out.println(profileBean.getFirstName());
			model.addAttribute("msg", profileBean.getUserID());

			res1 = "DoneRegistration";
		} else {
			System.out.println("Invalid details");
			res1 = "CustomerRegister";
		}
		// return null;
		return res1;

	}

	// //////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////////////////
	// //////////////// CANCEL TICKET ///////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	String cancelReservationID;

	@RequestMapping(value = "/ticketCancel", method = RequestMethod.GET)
	public String cancelTicket(Model model, HttpSession httpSession) {
		System.out.println("here in Cancel ticket Get Method");
		String uid = (String) httpSession.getAttribute("userID");
		System.out.println("cancel for userId = " + uid);
		ArrayList<ReservationBean> reservationList = adminService
				.viewAllReservations();
		ArrayList<String> rids = new ArrayList<String>();

		for (int i = 0; i < reservationList.size(); ++i) {
			ReservationBean rb = reservationList.get(i);

			System.out.println(rb.getUserId() + " " + uid);
			Date today = new Date();
			Date scheduleDate = rb.getJourneyDate();
			System.out.println("Working?????????????????????????????????"
					+ today.after(scheduleDate));

			if (!today.after(scheduleDate)) {
				if (uid.equals(rb.getUserId())) {
					rids.add(rb.getReservationID());
					System.out.print("hello.............................");
				}
			}
		}
		System.out.println("found reservationids for uid = " + rids.size()
				+ " total was = " + reservationList.size());
		model.addAttribute("rids", rids);
		model.addAttribute("rb", new ReservationBean());
		return "CustomerCancelReservation";
		// return "CancelConfirm";
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////
	// Confirm cancellation
	// /////////////////////////////////////////////////////////
	@RequestMapping(value = "/confirmCancelTicket", method = RequestMethod.POST)
	public String processConifrmCancelticket(
			@ModelAttribute("rb") ReservationBean reservationBean, Model model) {

		System.out.println("Lets confirm it...........");
		cancelReservationID = reservationBean.getReservationID();
		Map<ReservationBean, ArrayList<PassengerBean>> ticketDetail = customer
				.viewTicket(reservationBean.getReservationID());
		ReservationBean rbdetails = null;
		ArrayList<PassengerBean> pblistdetails = null;

		for (ReservationBean r : ticketDetail.keySet()) {
			System.out.println("................ loop............");
			rbdetails = r;
			pblistdetails = ticketDetail.get(r);
			System.out.println(rbdetails.getTotalFare() + " plist obj="
					+ pblistdetails);
		}
		// /////////////////////////////////////////////////
		// route
		// ////////////////////////////////////////////////

		model.addAttribute("rbdetails", rbdetails);
		model.addAttribute("pblistdetails", pblistdetails);
		return "CancelConfirm";
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/cancelTicket")
	public String processCancelticket(
			@RequestParam("confirmoption") String confirmoption, Model model) {
		boolean res;
		System.out.println(".................. rid = " + cancelReservationID
				+ "confirmoption" + confirmoption);

		if (confirmoption.equalsIgnoreCase("Yes")) {
			res = customer.cancelTicket(cancelReservationID);

			if (res) {
				model.addAttribute("succmsg",
						"Your reservation was cancelled successfully");
				return "Success";
			} else {
				model.addAttribute("failmsg",
						"Your reservation was cancelled successfully");
				return "fail";
			}
		} else {
			return "CustomerDefaultView";
		}
		// model.addAttribute("msg", "Error in cancel");
		// model.addAttribute("msg", "Ticket cancel succesfull");
		// return "CustomerDelete";

	}

	// /////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	// ////////////////////////////////////////////////////////////////////////
	// ///////////////// ADI CHANGE PASSWORD /////////////////////
	@RequestMapping(value = "/ChangePassword", method = RequestMethod.GET)
	public String changePassword(Model model) {
		System.out.println("here in Change password  Get Method");
		return "CustomerChangePassword";
	}

	@RequestMapping(value = "/passwordChange", method = RequestMethod.POST)
	public String processChangePassword(
			@RequestParam("password") String password,
			@RequestParam("newPassword") String newPassword,
			@RequestParam("confirmPassword") String confirmPassword,
			Model model, HttpServletRequest request) {
		String res;

		CredentialsBean credentialsBean = new CredentialsBean();
		HttpSession session = request.getSession();

		String userId = (String) session.getAttribute("userID");
		credentialsBean.setUserID(userId);
		credentialsBean.setPassword(password);

		System.out.println("controller uid=" + credentialsBean.getUserID()
				+ " pass=" + credentialsBean.getPassword());

		res = user.changePassword(credentialsBean, newPassword);

		if (res.equals("changed")) {
			user.logout(userId);
			// session.invalidate();
			return "PasswordChangeSuccess";
		} else {
			model.addAttribute("failmsg",
					"There was an error in changing the password... Please try again....");
			return "fail";
		}
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////
	// /////////////////////// AJAX
	@RequestMapping(value = "/findDestnations", method = RequestMethod.POST)
	public @ResponseBody
	String findDestnations(@RequestParam("selectedSource") String selectedSource) {
		System.out.println("ajax success!!!!............." + selectedSource);
		ArrayList<RouteBean> allRoutes = adminService.viewByAllRoute();
		String destinations = "";
		for (int i = 0; i < allRoutes.size(); ++i) {
			RouteBean route = allRoutes.get(i);
			if (route.getSource().equals(selectedSource)) {
				destinations = destinations + " " + route.getDestination();
				System.out.println(destinations);
			}
		}
		return destinations;
	}
}
