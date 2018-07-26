package com.dashboard.dao;

import java.util.ArrayList;
import java.util.Map;

import com.dashboard.beans.AskBean;
import com.dashboard.beans.PhotoBean;
import com.dashboard.beans.TrainerBean;

public interface TrainerDAO {
//		public ArrayList<DoctorBean> availableDoctorsDetails(Date date);
//		public ArrayList<DoctorBean> listOfDoctors(Date date,String status);
		public String addEvent(TrainerBean tb);
		public Map<AskBean, ArrayList<AskBean>> askForum();
		public	AskBean addComment(AskBean askbean);
	public	AskBean addPost(AskBean askbean);
	public void addPhoto(PhotoBean pb);
}
