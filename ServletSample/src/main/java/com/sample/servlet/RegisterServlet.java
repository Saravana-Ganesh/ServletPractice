package com.sample.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.bo.RegisterBO;
import com.sample.service.RegisterService;
import com.sample.utils.StringUtils;

public class RegisterServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		//Get rparams 
		RegisterBO registerBO = null;
		RegisterService registerService = null;
		
		String userEmail = request.getParameter("userEmail");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		System.out.println("userEmail="+userEmail);
		System.out.println("password="+password);
		System.out.println("userName="+userName);
		System.out.println("userPhone="+userPhone);
		try {
			if(StringUtils.isNotNullOrNotEmpty(userEmail) && StringUtils.isNotNullOrNotEmpty(password)
					&& StringUtils.isNotNullOrNotEmpty(userName) && StringUtils.isNotNullOrNotEmpty(userPhone)) {
				registerBO = new RegisterBO();
				registerBO.setUserEmail(userEmail);
				registerBO.setUserPassword(password);
				registerBO.setUserName(userName);
				registerBO.setUserPhone(userPhone);
				registerService = new RegisterService();
				boolean createUser = registerService.createUser(registerBO);			
						 if(createUser) {
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
