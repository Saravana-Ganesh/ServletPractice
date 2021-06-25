package com.sample.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sample.bo.ResponseBO;
import com.sample.service.HomeService;

public class HomeServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HomeService homeService = new HomeService();				
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8"); 
		try {
			response.getWriter().write(new Gson().toJson(homeService.getCaseCount()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
