package com.wipro.srs.util;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.dao.CustomerDAO;


//@Service("customer")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class AuthenticationImpl implements Authentication{
@Autowired
	CustomerDAO customerDAO;
	
	@Override
	public boolean authenticate(CredentialsBean credentialsBean) {
		
		if(credentialsBean == null)
			return false;
		else if(credentialsBean.getUserID() == null || credentialsBean.getUserID().isEmpty())
			return false;
		else if(credentialsBean.getPassword() == null || credentialsBean.getPassword().isEmpty())
			return false;
		
		System.out.println("userid = " + credentialsBean.getUserID()+" pass = "+credentialsBean.getPassword());
		boolean valid = customerDAO.validateUser(credentialsBean);
		return valid;	
	}

	
	
	
	@Override
	public String authorize(String userId) {
		
		if(userId == null || userId.isEmpty() || userId.equals(""))
			return "FAIL";
		else{
			String type = customerDAO.getUserType(userId);
			return type;
		}
	}

	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean,int loginStatus) {
		if(credentialsBean==null)
			return false;
		else if(credentialsBean.getUserID() == null || credentialsBean.getUserID().isEmpty() || credentialsBean.getUserID().equals(""))
			return false;
		else if(loginStatus < 0 && loginStatus > 1)
			return false;
		else{
			boolean changed = customerDAO.changeLoginStatus(credentialsBean,loginStatus);
			if(changed)
				return true;
			else 
				return false;
		}
	}
}
