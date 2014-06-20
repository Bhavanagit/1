package com.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.ForgotPassword;
import com.beans.GetPass;
import com.model.ForgotPassModel;

public class ForgotPass extends HttpServlet {
       
    	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rno=request.getParameter("rno");
			ForgotPassword password=new ForgotPassword();
			password.setRno(rno);
			ForgotPassModel fm=new ForgotPassModel();
			fm.retrivepass(password);
			
			
			
		
		
	}

}
