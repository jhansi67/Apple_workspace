package com.dashboard.service;

import java.util.ArrayList;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.SkillBean;
import com.dashboard.beans.StudentSkillBean;
import com.dashboard.dao.DaoClass;

@Service("serviceClass")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class ServiceClass {
	
	@Autowired
	DaoClass dao;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	public boolean addSkill(SkillBean skillBean) {
		
		if(skillBean.getSkillName().equals(""))
		
		return false;
		
		else 
		{
			dao.addSkill(skillBean);
			return true;
		}

	}
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	public ArrayList<SkillBean> displaySkillList(){
		
		ArrayList<SkillBean> ssb=dao.displaySkill();
		
		if(ssb.equals(null)||ssb.isEmpty())
			return null;
		else
		 return ssb;
		
		
	}
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public TreeMap<String, Integer> getStudentList(String skills) {
		TreeMap<String, Integer> studList=dao.getStudentList(skills);
		
		if(studList.size()!=0)
		return studList;
		else
		{
			studList.put("Empty", 0);
			return studList;
		}
	}

	public ArrayList<String> getPidList(String[] arr) {
		ArrayList<String> al=dao.getPidList(arr);
		return al;
	}
	
	
}