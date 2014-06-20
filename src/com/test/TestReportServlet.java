package com.test;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * Servlet implementation class TestReportServlet
 */
public class TestReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestReportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletOutputStream sos = response.getOutputStream();
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition",
				"inline:filename=\"Report.pdf\"");
		try {
			JasperPrint jp = JasperFillManager.fillReport(getServletContext()
					.getRealPath("/") + "FirstReport.jasper", new HashMap(),
					new JREmptyDataSource());
			byte[] pdfasbytes = JasperExportManager.exportReportToPdf(jp);
			sos.write(pdfasbytes);
			sos.flush();
			sos.close();

		} catch (JRException jr) {
			jr.printStackTrace();

		}

	}

}
