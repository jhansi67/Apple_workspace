package com.dashboard.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="db_Trainer")
public class TrainerBean {
	
	@Id
	private String courseId;
	private String title;
	private String trainerId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skillId")
	private SkillBean skillId;
	
	
	private Date startDate;
	
	private Date endDate;
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	
	public SkillBean getSkillId() {
		return skillId;
	}
	public void setSkillId(SkillBean skillId) {
		this.skillId = skillId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	

}
