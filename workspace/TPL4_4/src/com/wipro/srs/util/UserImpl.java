package com.wipro.srs.util;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.dao.CustomerDAO;

public class UserImpl implements User {
	@Autowired
	Authentication authentication;

	@Autowired
	CustomerDAO customerDAO;

	@Override
	public String login(CredentialsBean credentialsBean) {

		if (credentialsBean == null)
			return "INVALID";
		else if (credentialsBean.getUserID() == null
				|| credentialsBean.getUserID().isEmpty()
				|| credentialsBean.getUserID().equals(""))
			return "INVALID";
		else if (credentialsBean.getPassword() == null
				|| credentialsBean.getPassword().isEmpty()
				|| credentialsBean.getPassword().equals(""))
			return "INVALID";
		else {
			System.out.println("Userid = " + credentialsBean.getUserID()
					+ " password = " + credentialsBean.getPassword());

			// AuthenticationImpl authenticated = new AuthenticationImpl();
			boolean valid = authentication.authenticate(credentialsBean);
			System.out.println("authentication= " + authentication);

			if (valid) {
				String type = authentication.authorize(credentialsBean
						.getUserID());

				if (type == null || type.isEmpty() || type.equals("")) {
					System.out.println("Unable to get type.....");
					return "FAIL";
				} else {
					boolean logstatus = authentication.changeLoginStatus(
							credentialsBean, 1);
					System.out.println("loginstatus ................."
							+ logstatus);

					if (logstatus) {
						return type;
					} else
						return "FAIL2";
				}

			} else
				return "FAIL";
		}
	}

	@Override
	public boolean logout(String userId) {
		// return false;
		CredentialsBean credentialsBean = new CredentialsBean();
		credentialsBean.setUserID(userId);
		boolean log = authentication.changeLoginStatus(credentialsBean, 0);

		return log;
	}

	// ///////////////////////////////////////////////////////////////////////////
	// /////////////////// adis ////////////////////////////////////

	@Override
	public String register(ProfileBean profileBean) {

		boolean res = false;
		String id = "";
		String result;

		if (profileBean != null) {
			if (profileBean.getCity() != "" && profileBean.getCity() != null) {
				if (profileBean.getDateOfBirth() != null) {
					if (profileBean.getEmailID() != ""
							&& profileBean.getEmailID() != null) {
						if (profileBean.getFirstName() != ""
								&& profileBean.getFirstName() != null) {
							if (profileBean.getGender() != "") {
								if (profileBean.getLastName() != ""
										&& profileBean.getLastName() != null) {
									if (profileBean.getLocation() != ""
											&& profileBean.getLocation() != null) {
										if (profileBean.getMobileNo() != ""
												&& profileBean.getMobileNo()
														.length() == 10) {
											if (profileBean.getPassword() != ""
													&& profileBean
															.getPassword() != null
													&& profileBean
															.getPassword()
															.length() > 6) {
												if (profileBean.getPincode() != null
														&& profileBean
																.getPincode() != ""
														&& profileBean
																.getPincode()
																.length() == 6) {
													if (profileBean.getState() != "") {
														if (profileBean
																.getStreet() != ""
																&& profileBean
																		.getStreet() != null) {
															res = true;
														}
													}
												}
											}

										}
									}
								}
							}

						}
					}
				}

			}
		}

		if (res == true) {
			result = customerDAO.daoAdd(profileBean);
			// id = customerDAO.generateUserId(profileBean.getFirstName());
		} else
			return "FAIL";

		if (result == null || result.isEmpty() || result.equals("negative"))
			return "FAIL";
		else
			return result;
	}

	// ///////////////////////////////////////////////////////////////////////////
	// //////////////////////// adis ////////////////////////////////
	@Override
	public String changePassword(CredentialsBean credentialsBean,
			String newPassword) {
		boolean res = true;
		boolean res1;
		if (credentialsBean.getPassword() == null
				|| credentialsBean.getPassword() == "") {
			if (newPassword == null || newPassword == "") {

				res = false;
			}
		}

		System.out.println("userimpl uid=" + credentialsBean.getUserID()
				+ " newpass=" + newPassword);
		if (res) {
			res1 = customerDAO.changePassword(credentialsBean, newPassword);

		} else {
			res1 = false;
		}

		if (res1)
			return "changed";
		else
			return "failed";

	}

	// /////////////////////////////////////////////////////////////////////////

	///////////////////////////		AJAX  UTIL		//////////////////////////
	@Override
	public String validify(String emailID) {

		String res = "";

		res = customerDAO.daoValidify(emailID);

		if (res.equals("positive")) {

			res = "idExist";

		} else
			res = "idNoExist";

		return res;
	}
}
