package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetOptions extends HttpServlet {
    public GetOptions() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String ans=request.getParameter("q");
	System.out.println("-------->>>>"+ans);
	HttpSession session=request.getSession(false);
	List answers=(List)session.getAttribute("answers");
	if(ans!=null){
	answers.add(ans);
	int check=(Integer)session.getAttribute("index");
	check++;
	session.setAttribute("index", check);

	}
	else{
		ans="notanswered";
		answers.add(ans);
		List questionsList= (List)session.getAttribute("list");
		
		int check=(Integer)session.getAttribute("index");
		if(check<questionsList.size()){
		check++;
		session.setAttribute("index", check);
		}
	}
	System.out.println("answers size"+answers.size());
	session.setAttribute("answers", answers);
	System.out.println(ans);
	String testName=request.getParameter("testName");
	System.out.println(testName);
	
	//System.out.println(request.getAttribute("list2"));	
	if(testName.trim().equals("aptitude")){
		if((Boolean)session.getAttribute("nextQuestion")){
			System.out.println("next Question"+(Boolean)session.getAttribute("nextQuestion"));
			RequestDispatcher rd=request.getRequestDispatcher("jsp/apt.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("jsp/submit.jsp");
				rd.forward(request, response);
		}
	}
	if(testName.trim().equals("tech")){
		
		
		if((Boolean)session.getAttribute("nextQuestion")){
			RequestDispatcher rd=request.getRequestDispatcher("jsp/tech.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("jsp/submittech.jsp");
				rd.forward(request, response);
		}
		
		
			}
	
	}	
	
	}


