package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.CredentialsBean;
import com.model.UserIdPasswordCheck;

public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	CredentialsBean cBean=null;
	String id=request.getParameter("sunTechId").trim();
	String password=request.getParameter("password").trim();
	cBean=new CredentialsBean();
	cBean.setUserName(id);
	cBean.setPassword(password);
	
	System.out.println(id);
	UserIdPasswordCheck ucheck=new UserIdPasswordCheck();
	cBean=ucheck.checkDB(cBean);

	 if((id.isEmpty()&&password.isEmpty())||(id.isEmpty()&&!password.isEmpty())||(!id.isEmpty()&&password.isEmpty())){
		System.out.println("isEmpty<<<<<-----");
		String errMsg="please check the id and password";
		System.out.println("in the else block of login check servlet ");		
		request.setAttribute("errMsg", errMsg);
		RequestDispatcher rd=request.getRequestDispatcher("jsp/login.jsp");
		rd.forward(request, response);
		
	}
	 else if(id.equals("admin")&&id.equals("admin")){
		 RequestDispatcher rd=request.getRequestDispatcher("jsp/admin.jsp");
		 rd.forward(request, response);
	 }
	  
	 
	else{
	
	if(id.equals(cBean.getUserName())&&password.equals(cBean.getPassword())){
		HttpSession session=request.getSession(true);
		
		if(session!=null){
		System.out.println("in the session block");
		session=request.getSession(true);
		session.setAttribute("sunTechId", id);
		boolean isNewLogin=true;
		session.setAttribute("isNewLogin",isNewLogin);
		RequestDispatcher rd=request.getRequestDispatcher("jsp/test.jsp");
		rd.forward(request, response);
	
		}
		else
			System.out.println(session);
		
		}
	
	else{
		String errMsg="please check the id and password";
		System.out.println("in the else block of login check servlet ");
		request.setAttribute("errMsg", errMsg);
		RequestDispatcher rd=request.getRequestDispatcher("jsp/login.jsp");
		rd.forward(request, response);
	
	}
	
		
	}
	}

}
