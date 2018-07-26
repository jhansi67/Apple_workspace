package com.dashboard.service;

import java.util.ArrayList;
import java.util.Map;

import com.dashboard.beans.AskBean;
import com.dashboard.beans.PhotoBean;
import com.dashboard.beans.TrainerBean;

public interface Trainer {
//	ArrayList<DoctorBean> viewAllAvailableDoctors(Date date);
//	ArrayList<DoctorBean> intimateAdmin(Date date, String status);
	public String addEvent(TrainerBean tb);
	public Map<AskBean, ArrayList<AskBean>> askForum();
	public AskBean addComment(AskBean askbean);
	public AskBean addPost(AskBean askbean);
	public void addPhoto(PhotoBean pb);
}
