package com.wipro.srs.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.PaymentBean;
import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.ScheduleBean;

public interface CustomerDAO {

	public boolean validateUser(CredentialsBean credentialsBean);
	
	public String getUserType(String userId);

	public String reserveSeat(ReservationBean reservationBean,ArrayList<PassengerBean> passengerBean);

	public ArrayList<ScheduleBean> viewScheduleByRoute(String source,String destination, Date date);

	public Map<ReservationBean, ArrayList<PassengerBean>> viewTicket(String reservationId);

	public String daoAdd(ProfileBean profileBean);

	public String generateUserId(String firstName);

	public boolean cancelTicket(String reservationId);

	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);

	public boolean isValidCard(String userid, String cardnumber, Date from, Date to);

	public boolean makePayment(PaymentBean paymentBean, ReservationBean reservationBean);

	public double getRouteFare(String scheduleID);
	
	public boolean changePassword(CredentialsBean credentialsBean, String newPassword);

	public String daoValidify(String emailID);



}
