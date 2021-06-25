package com.sample.service;

import com.sample.bo.ResponseBO;
import com.sample.dao.HomeDAO;

public class HomeService {
	public ResponseBO getCaseCount() {
		HomeDAO homeDAO = new HomeDAO();
		return homeDAO.getCaseCount();
	}
}
