package com.wipro.srs.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.srs.bean.PaymentBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.dao.CustomerDAO;

public class PaymentImpl implements Payment{

	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	public boolean findByCardNumber(String userid, String cardnumber,Date from,Date to) {
		if(userid == null || userid.isEmpty() || userid.equals(""))
			return false;
		if(cardnumber==null || cardnumber.isEmpty() || cardnumber.equals(""))
			return false;
		
		boolean paid = customerDAO.isValidCard(userid,cardnumber,from,to);
		System.out.println("payment impl has payed = "+paid);
		if(paid)
			return true;
		else{
			System.out.println("Either not went to database or not enough balance....");
			return false;
		}
	}

	
	
	
	@Override
	public String process(PaymentBean paymentBean,ReservationBean rb) {
		if(paymentBean == null)
			return "FAIL";
		else if(paymentBean.getUserID() == null || paymentBean.getUserID().isEmpty() || paymentBean.getUserID().equals(""))
			return "FAIL";
		else if(paymentBean.getCreditCardNumber() == null || paymentBean.getCreditCardNumber().isEmpty() || paymentBean.getCreditCardNumber().equals(""))
			return "FAIL";
		else{
			
			boolean paid = customerDAO.makePayment(paymentBean,rb);
			System.out.println("Paymentimpl msg = "+paid);
			if(paid){
				return "SUCCESS";
			}else{
				return "FAIL";
			}
		}
	}

}
