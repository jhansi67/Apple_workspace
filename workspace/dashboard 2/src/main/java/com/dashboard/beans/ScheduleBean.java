package com.dashboard.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="db_schedule")
public class ScheduleBean {

	@Id
	private int scheduleId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId")
	private TrainerBean courseId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pId")
	private CredentialBean studentId;
	
	private int completionStatus;
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	
	public TrainerBean getCourseId() {
		return courseId;
	}
	public void setCourseId(TrainerBean courseId) {
		this.courseId = courseId;
	}
	public CredentialBean getStudentId() {
		return studentId;
	}
	public void setStudentId(CredentialBean studentId) {
		this.studentId = studentId;
	}
	public int getCompletionStatus() {
		return completionStatus;
	}
	public void setCompletionStatus(int completionStatus) {
		this.completionStatus = completionStatus;
	}
	
	
	
	
}
