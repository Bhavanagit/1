package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.ChooseTest;
import com.model.RetriveApt;
import com.model.RetriveTech;

/**
 * Servlet implementation class StartServlet
 */
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   
	 String selecttest= request.getParameter("test");
	 List answers=new ArrayList();
	 
	 System.out.println("Selected test from StartServlett---->>>>"+selecttest);
	 String s1="aptitude";
	 int index=0;
	 ChooseTest ch =new ChooseTest();

	  /*if(selecttest.equals("aptitude")){
		 ch.setTestName("aptitude");
	 }*/
	
	 
	 System.out.println("Test name From StartServlettttt===>>>>"+ch.getTestName());
	

	 	if(selecttest.equals(s1)||selecttest.equals("ar")||selecttest.equals("lr")||selecttest.equals("fg")||selecttest.equals("rc")||selecttest.equals("di")){
	 		
	 		if(selecttest.equals(s1)){
	 			 ch.setTestName("aptitude");
	 		 }
	 		 if(selecttest.equals("ar")){
	 			 ch.setTestName("ar");
	 		 }
	 		 
	 		 if(selecttest.equals("lr")){
	 			 ch.setTestName("lr");
	 		 }
	 		 if(selecttest.equals("fg")){
	 			 ch.setTestName("fg");
	 		 }
	 		 if(selecttest.equals("rc")){
	 			 ch.setTestName("rc");
	 		 }
	 		 if(selecttest.equals("di")){
	 			 ch.setTestName("di");
	 		 }
	 		 
	 		
	 		
	 	RetriveApt rApt=new RetriveApt();
	 	rApt.getTestName(ch);
	 	 List list= rApt.getRecords();
	 	 System.out.println("from start servlet"+list.size());
	 	 HttpSession session=request.getSession(false);
	 	 //session.setMaxInactiveInterval(30);
		 session.setAttribute("answers", answers);
	 	 session.setAttribute("list", list);
		 session.setAttribute("index", index);
		 session.setAttribute("stest", selecttest);
		 ch.setTestName("aptitude");

		 //session.setMaxInactiveInterval(4000);
		 System.out.println("in the if");
		 System.out.println((List)session.getAttribute("list"));
    	 RequestDispatcher rd=request.getRequestDispatcher("./jsp/apt.jsp");
    		rd.forward(request, response);
    		System.out.println("after the RD");
	 	}
     else{
    	 
    	 
    	 if(selecttest.equals("technical")){
    		 ch.setTestName("technical");
    	 }
    	 if(selecttest.equals("sql")){
    		 ch.setTestName("sql");
    	 }
    	 
    	 if(selecttest.equals(".net")){
    		 ch.setTestName(".net");
    	 }
    	 if(selecttest.equals("java")){
    		 ch.setTestName("java");
    	 }
    	 if(selecttest.equals("os")){
    		 ch.setTestName("os");
    	 }
    	 if(selecttest.equals("cpp")){
    		 ch.setTestName("cpp");
    	 }
    	 if(selecttest.equals("ds")){
    		 ch.setTestName("ds");
    	 }
    	
    	  	     	 
    	 RetriveTech tech=new RetriveTech();
    	 tech.getTestName(ch);
    	 List list= tech.getRecords();
    	 System.out.println("from start servlet"+list.size());
    	 HttpSession session=request.getSession(false);
    	 session.setAttribute("list", list);
		 session.setAttribute("answers", answers);
    	 session.setAttribute("index", index);
		 session.setAttribute("stest", selecttest);

    	// session.setMaxInactiveInterval(4000);
		 System.out.println((List)session.getAttribute("list"));

    	 RequestDispatcher rd=request.getRequestDispatcher("jsp/tech.jsp");
    		rd.forward(request, response);
    	}    
     }
	

}
