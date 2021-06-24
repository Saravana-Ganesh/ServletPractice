package com.sample.service;

import com.sample.bo.RegisterBO;
import com.sample.dao.RegisterDAO;

public class RegisterService {

	public boolean createUser(RegisterBO registerBO) {
		RegisterDAO registerDAO = new RegisterDAO();
		return registerDAO.createUser(registerBO);
	}

}
