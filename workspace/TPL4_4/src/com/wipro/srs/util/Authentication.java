package com.wipro.srs.util;

import com.wipro.srs.bean.CredentialsBean;

public interface Authentication {

	public boolean authenticate(CredentialsBean credentialsBean);
	
	public String authorize(String userId);
	
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);
}
