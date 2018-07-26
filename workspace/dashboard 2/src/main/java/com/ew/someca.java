package com.ew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.DisussBean;





@Controller

public class someca {
	@Autowired 
	SessionFactory sessionFactory;
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	  @RequestMapping(value="/hello", method = RequestMethod.GET)
	  public String printHello(Model model) throws ClassNotFoundException, SQLException
	{
		 // List<DisussBean> l = new ArrayList<DisussBean>();
		List<Integer> l1 = new ArrayList<Integer>();
		  Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery(" from DisussBean");
	List	allUsers = q.list();
		for (int i = 0; i < allUsers.size(); i++) {
			DisussBean user = (DisussBean) allUsers.get(i);
			l1.add(user.getCommentId());
			System.out.println(user.getCommentId());
			  }
		for (int i = 0; i < allUsers.size(); i++) {
			DisussBean user = (DisussBean) allUsers.get(i);
			if(l1.contains(user.getPostid()))
			{
				
			}
			else
			{
				System.out.println("i m post");
				System.out.println(user.getPostid());
				System.out.println(user.getName());
				
				
			}
		}
	
	  return null;
	}
	  
}
