package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.AptBean;
import com.beans.MarksBean;
import com.beans.TechBean;
import com.beans.UserIdBean;
import com.model.GetRowNum;
import com.model.InsertMarks;

/**
 * Servlet implementation class Result
 */
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Result() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		int marks = 0;
		int i = 0;
		if (!session.getAttribute("index").equals(null)) {
			i = (Integer) session.getAttribute("index");
		}
		List list = (List) session.getAttribute("list");
		List answers = (List) session.getAttribute("answers");
		String testName = request.getParameter("testName");
		System.out.println("test taken isssss" + testName);

		System.out.println("i value from ResltServlet" + i);
		System.out.println("list from Result Servlet" + list.size());
		System.out.println("answers from Result Servlet" + answers.size());
		if (testName.equals("aptitude")) {
			for (int j = 0; j < i; j++) {
				
 				AptBean aptBean = (AptBean) list.get(j);
				if (!answers.isEmpty()) {
					if (answers.get(j) != null) {

						if (((String) answers.get(j)).trim().equals(aptBean.getANS().trim())) {
							System.out.println("right---->j=" + j
									+ "\tSelected-->" + (String) answers.get(j)
									+ "\tAnswer" + aptBean.getANS());

							marks++;
						} else {
							System.out.println("wrong---->j=" + j + "\tselected-->"
									+ (String) answers.get(j) + "\tanswer-->"

									+ aptBean.getANS());
						}
					} else {
						System.out.println("not answerd"
								+ aptBean.getQUESTION());
					}
				}
			}
			

			System.out.println("number of questions" + i);
			System.out.println("marks gained" + marks);
			request.setAttribute("marks", marks);
			 }

		else if (testName.equals("tech")) {
			for (int j = 0; j < i; j++) {
				if (!answers.isEmpty()) {
					TechBean techBean = (TechBean) list.get(j);
					if (answers.get(j) != null) {
						if (((String) answers.get(j)).equals(techBean.getANS())) {
							System.out.println("right---->j=" + j + "\t"
									+ (String) answers.get(j) + "\t"
									+ techBean.getANS());

							marks++;

						} else
							System.out.println("wrong---->j=" + j + "\t"
									+ (String) answers.get(j) + "\t"
									+ techBean.getANS());

					} else
						System.out.println("not answerd"
								+ techBean.getQUESTION());
				}
			}

		} else {
			System.out.println("from else of result");
		}

		System.out.println("number of questions" + i);
		System.out.println("marks gained" + marks);
		System.out.println("Selected TEst Name from Resulttttt Servlete+++++>>>>>>"+session.getAttribute("stest"));

		MarksBean mBean = new MarksBean();
		UserIdBean userIdBean = new UserIdBean();
		mBean.setTestName((String)session.getAttribute("stest"));
		userIdBean.setTestName((String)session.getAttribute("stest"));
		
		mBean.setMarks(marks);
		mBean.setUserid((String) session.getAttribute("sunTechId"));

		userIdBean.setUserId((String) session.getAttribute("sunTechId"));
		
		int testTaken = GetRowNum.getRowNum(userIdBean);
		boolean marksupdate = false;
		if ((Boolean) session.getAttribute("isNewLogin")) {
			mBean.setTestTaken(testTaken + 1);
		} else {
			mBean.setTestTaken(testTaken+1);

		}
		marksupdate = InsertMarks.insertMarks(mBean);

		System.out.println("Inserted Marks" + marksupdate);

		System.out.println("number of questions" + i);
		System.out.println("marks gained" + marks);
		request.setAttribute("marks", marks);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/result.jsp");
		rd.forward(request, response);

	}

}
