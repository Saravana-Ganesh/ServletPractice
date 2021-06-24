package com.sample.service;

import com.sample.bo.LoginBO;
import com.sample.dao.LoginDAO;

public class LoginService {

	public boolean validateUser(LoginBO loginBO) {
		LoginDAO loginDAO = new LoginDAO();
		return loginDAO.validateUser(loginBO);
	}
	
}
