package com.sample.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.bo.LoginBO;
import com.sample.service.LoginService;
import com.sample.utils.StringUtils;

public class LoginServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		//Get rparams 
		LoginBO loginBO = null;
		LoginService loginService = null;
		
		String userEmail = request.getParameter("userEmail");
		String password = request.getParameter("password");
		try {
			if(StringUtils.isNotNullOrNotEmpty(userEmail)&&StringUtils.isNotNullOrNotEmpty(password)) {
				loginBO = new LoginBO();
				loginBO.setUserEmail(userEmail);
				loginBO.setUserPassword(password);
				loginService = new LoginService();
				boolean isValidUser = loginService.validateUser(loginBO);			
						 if(isValidUser) {
					     //Setting response
					     response.setContentType("text/plain");
					     response.setCharacterEncoding("UTF-8"); 			  
						 response.getWriter().write("1"); 
						 }else {			
							 response.getWriter().write("0");
						 }	
				 }else {
					 response.getWriter().write("0");
				 }

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
