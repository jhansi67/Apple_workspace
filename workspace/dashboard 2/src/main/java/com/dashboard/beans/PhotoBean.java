package com.dashboard.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
public class PhotoBean {
	
	@Id
	private String photoId;
	
	private byte[] photoImg;
	public String getPhotoId() {
		return photoId;
	}
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	public byte[] getPhotoImg() {
		return photoImg;
	}
	public void setPhotoImg(byte[] photoImg) {
		this.photoImg = photoImg;
	}

	
	

	
    
    

}
