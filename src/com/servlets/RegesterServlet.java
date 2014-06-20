package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.RegesterBean;
import com.model.UserRegester;

public class RegesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegesterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	/*System.out.println(request.getParameter("userId"));
	System.out.println(request.getParameter("password"));
	System.out.println(request.getParameter("name"));
	System.out.println(request.getParameter("mail"));
	System.out.println(request.getParameter("mobile"));
	System.out.println(request.getParameter("branch"));
	System.out.println(request.getParameter("year"));
	System.out.println(request.getParameter("college"));
	*/
	RegesterBean rBean=new RegesterBean();
	rBean.setBranch(request.getParameter("branch"));
	rBean.setCollege(request.getParameter("college"));
	rBean.seteMail(request.getParameter("mail"));
	rBean.setMobile(request.getParameter("mobile"));
	rBean.setName(request.getParameter("name"));
	rBean.setPassword(request.getParameter("password"));
	rBean.setUserId(request.getParameter("userId"));
	rBean.setYear(request.getParameter("year"));
	rBean.setSscMarks(request.getParameter("ssc"));
	rBean.setInterMarks(request.getParameter("inter"));
	rBean.setHighestdegreeMarks(request.getParameter("highestdegreemarks"));
	UserRegester userRegester=new UserRegester();
	boolean b=userRegester.regester(rBean);
	System.out.println("regestration"+b);
	String msg=null;
	if(b==true){
		msg="Regestered Successfully please login with the UserId and Password";
		request.setAttribute("msg",msg);
		RequestDispatcher rd=request.getRequestDispatcher("jsp/login.jsp");
		rd.forward(request, response);
	}
	else{
		msg="Sorry The UserId you are trying to use is already existed";
		request.setAttribute("msg",msg);
		RequestDispatcher rd=request.getRequestDispatcher("jsp/login.jsp");
		rd.forward(request, response);
		
	}
	
	}

}
