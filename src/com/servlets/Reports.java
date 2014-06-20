package com.servlets;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import com.dao.UtilConnection;

/**
 * Servlet implementation class Reports
 */
public class Reports extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String test = request.getParameter("test");
		HttpSession httpSession = request.getSession(false);
		JasperPrint jp = null;
		if (httpSession != null) {

			if (test.equals("apt")) {

				response.setContentType("application/pdf");
				response.setHeader("Content-disposition",
						"inline;filename=\"Marks.pdf\"");
				Connection con = null;
				FileInputStream inputStream = null;

				try {
					inputStream = new FileInputStream(new File(
							"D:\\jasper\\aptmarksstudent.jrxml"));

					JasperDesign jrXmlLoader = JRXmlLoader.load(inputStream);
					HashMap map = new HashMap();
					map.put("user_id",
							(String) httpSession.getAttribute("sunTechId"));
					JasperReport report = JasperCompileManager
							.compileReport(jrXmlLoader);
					System.out.println("creating conn");
					con = UtilConnection.getCon();
					System.out.println(con + "form Reports");
					jp = JasperFillManager.fillReport(report, map, con);
					JasperViewer jViewer = new JasperViewer(jp, false, null);
					jViewer.setVisible(true);
					/*JasperExportManager
							.exportReportToPdfFile(jp, "F:\\AptitudeMarks.pdf");*/
					con.close();

				} catch (Exception e) {
					System.out.println(e);
				}

			} else {
				FileInputStream inputStream = null;

				Connection con = null;

				response.setContentType("application/pdf");
				response.setHeader("Content-disposition",
						"inline;filename=\"Marks.pdf\"");
				try {
					inputStream = new FileInputStream(new File(
							"F:\\online test\\Technical.jrxml"));

					JasperDesign jrXmlLoader = JRXmlLoader.load(inputStream);
					HashMap map = new HashMap();
					map.put("user_id",
							(String) httpSession.getAttribute("sunTechId"));
					JasperReport report = JasperCompileManager
							.compileReport(jrXmlLoader);
					con = UtilConnection.getCon();
					jp = JasperFillManager.fillReport(report, map, con);
					JasperViewer jViewer = new JasperViewer(jp, false, null);
					jViewer.setVisible(true);
					JasperExportManager
							.exportReportToPdfFile(jp, "F:\\TechnicalMarks.pdf");
					con.close();
					} catch (Exception e) {
					System.out.println(e);
				} finally {
					jp = null;
					try {
						UtilConnection.close(con);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		}

	}

}
