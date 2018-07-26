package com.dashboard.controller;

import java.util.ArrayList;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.SkillBean;
import com.dashboard.beans.StudentSkillBean;
import com.dashboard.service.ServiceClass;

@Controller
public class Controller1 {
	
	@Autowired
	ServiceClass service;
	
	@RequestMapping(value = "/addSkill", method = RequestMethod.GET)
	public String showForm(Model model) {
		System.out.println("here in Get Method");
		SkillBean skillBean = new SkillBean();
		model.addAttribute("skillBean", skillBean);
		//System.out.println(profileBean.getCity());
		return "SkillList";
	}
	
	@RequestMapping(value = "/skill", method = RequestMethod.POST)
	public String processForm(
			 @ModelAttribute("skillBean") SkillBean skillBean,
			 Model model){
			System.out.println("Here in post method");	
			System.out.println("Oh yess");
			boolean result=service.addSkill(skillBean);
			
			if(result==true)
				return "Success";
				
			else
					return "Fail";
		
		
		
		
		
	}
	
	
	
	@RequestMapping(value = "/searchSkill", method = RequestMethod.GET)
	public String selectSkill(Model model) {
		ArrayList<SkillBean> ssb;
		System.out.println("here in Get Method");
		SkillBean skillBean1 = new SkillBean();
		System.out.println("came here 1");
		ssb=service.displaySkillList();
		System.out.println("came here 2");
		//System.out.println("Name is"+ssb.get(0).getSkillName());
		model.addAttribute("ssb", ssb);
		model.addAttribute("skillBean1", skillBean1);
		//System.out.println(profileBean.getCity());
		
		return "ListDisplay";
	}

	@RequestMapping(value = "/showSkill", method = RequestMethod.GET)
	public String showSkill(Model model, @ModelAttribute("skillBean1") SkillBean skillBean1) {
		String skills=skillBean1.getSkillName();
		System.out.println(skillBean1);
		System.out.println("The skil name are:"+skillBean1.getSkillName());
		TreeMap<String, Integer> studList=service.getStudentList(skills);
		System.out.println(studList);
		model.addAttribute("studList", studList);
		
		return "Fail";
		
	}
	
	@RequestMapping(value = "/ScheduleInterview", method = RequestMethod.POST)
	public String scheduleInterview(Model model,HttpServletRequest request) {
		try {
		String[] arr=	request.getParameterValues("stinlist");
		ArrayList<String> al=service.getPidList(arr);
			
			model.addAttribute("al", al);
			
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return "Success";
	}
}
