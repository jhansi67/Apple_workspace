package com.wipro.srs.util;

import java.util.Date;

import com.wipro.srs.bean.PaymentBean;
import com.wipro.srs.bean.ReservationBean;

public interface Payment {

	public boolean findByCardNumber(String userid, String cardnumber, Date date, Date date2);
	
	public String process(PaymentBean paymentBean,ReservationBean rb);
}
