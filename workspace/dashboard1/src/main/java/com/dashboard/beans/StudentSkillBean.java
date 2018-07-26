package com.dashboard.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="db_studskill")
public class StudentSkillBean {

	@Id
	private int skillAutoId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
	private CredentialBean studentId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skillId")
	private SkillBean skillId;

	public int getSkillAutoId() {
		return skillAutoId;
	}

	public void setSkillAutoId(int skillAutoId) {
		this.skillAutoId = skillAutoId;
	}

	public CredentialBean getStudentId() {
		return studentId;
	}

	public void setStudentId(CredentialBean studentId) {
		this.studentId = studentId;
	}

	public SkillBean getSkillId() {
		return skillId;
	}

	public void setSkillId(SkillBean skillId) {
		this.skillId = skillId;
	}

	


	
	
	
	
	
	
	
}
