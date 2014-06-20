package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.net.ns.SessionAtts;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	HttpSession session=request.getSession(false);
	System.out.println("New Session"+session.isNew());
	//session.setMaxInactiveInterval(0);
	System.out.println("vlue of id from logout"+(String)session.getAttribute("sunTechId"));
	session.removeAttribute("sunTechId");
	System.out.println("vlue of id from  logout after remove"+(String)session.getAttribute("sunTechId"));

	session.invalidate();
	System.out.println(session.equals(null));
	RequestDispatcher rd=request.getRequestDispatcher("jsp/home.jsp");
	rd.forward(request, response);
	}

	
}
