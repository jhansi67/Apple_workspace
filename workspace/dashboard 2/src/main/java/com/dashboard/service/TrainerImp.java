package com.dashboard.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.AskBean;
import com.dashboard.beans.PhotoBean;
import com.dashboard.beans.TrainerBean;
import com.dashboard.dao.TrainerDAO;

@Service("trainerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainerImp implements Trainer {
	
	@Autowired
	TrainerDAO  trainerDAO;

	public String addEvent(TrainerBean tb) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<AskBean, ArrayList<AskBean>> askForum() {
		// TODO Auto-generated method stub
		return trainerDAO.askForum();
	}

	public AskBean addComment(AskBean askbean) {
		// TODO Auto-generated method stub
		return trainerDAO.addComment(askbean);
	}

	public AskBean addPost(AskBean askbean) {
		// TODO Auto-generated method stub
		return trainerDAO.addPost(askbean);
	}

	@Override
	public void addPhoto(PhotoBean pb) {
		trainerDAO.addPhoto(pb);
		
	}
	
	
	
}

	

	

	
	