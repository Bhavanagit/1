package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EndServlet() {
        super();
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	HttpSession session=request.getSession(false);
	String sunTechId=(String)session.getAttribute("sunTechId");
	session.invalidate();
	session=request.getSession(true);
	boolean isNewLogin=false;
	session.setAttribute("isNewLogin",isNewLogin);
	session.setAttribute("sunTechId",sunTechId );
	RequestDispatcher rd=request.getRequestDispatcher("jsp/test.jsp");
	rd.forward(request, response);
	
	
	}

}
