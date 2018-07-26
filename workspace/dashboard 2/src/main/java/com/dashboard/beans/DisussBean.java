package com.dashboard.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DisussBean {

	@Id
	private int postid;
	
	private String name;
	
	private int commentId;
	
	private String title;
	
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
