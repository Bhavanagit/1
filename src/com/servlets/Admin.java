package com.servlets;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRExporterParameter;
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
 * Servlet implementation class Admin
 */
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */protected void service(HttpServletRequest request,
 			HttpServletResponse response) throws ServletException, IOException {
 		// TODO Auto-generated method stub

 		String test = request.getParameter("test");
 		System.out.println(test);

 		HttpSession httpSession = request.getSession(false);

 		if (httpSession != null) {

 			if (test.equalsIgnoreCase("apt")) {

 				response.setContentType("application/pdf");
 				response.setHeader("Content-disposition",
 						"inline;filename=\"Marks.pdf\"");
 				try{
 					FileInputStream inputStream=new FileInputStream(new File("F:\\online test\\complete3.jrxml"));
 				
 				JasperDesign jrXmlLoader=JRXmlLoader.load(inputStream);
 				HashMap map=new HashMap();
 				//map.put("user_id", (String)httpSession.getAttribute("sunTechId"));
 				JasperReport report=JasperCompileManager.compileReport(jrXmlLoader);
 				Connection con=UtilConnection.getCon();
 				JasperPrint jp= JasperFillManager.fillReport(report, map, con);
 				ByteArrayOutputStream outputByteArray = new ByteArrayOutputStream();
 				
 				JRXlsExporter exporterXLS = new JRXlsExporter();
 		         exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jp);
 		         exporterXLS.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "F:\\online test\\complete.xls" );
 		         exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputByteArray);
 		         exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
 		         exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
 		         exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
 		         exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
 		         exporterXLS.exportReport();
 		         System.out.println("exported");

 				
 				
 				
 				/*JasperViewer jViewer = new JasperViewer(jp, false, null);
				jViewer.setVisible(true);
				JasperExportManager
						.exportReportToPdfFile(jp, "F:\\AptitudeMarks.pdf");*/
				con.close();
 				}
 				catch(Exception e){
 					System.out.println(e);
 				}
 			}
 			else{
 				
 				response.setContentType("application/pdf");
 				response.setHeader("Content-disposition",
 						"inline;filename=\"Marks.pdf\"");
 				try{
 					FileInputStream inputStream=new FileInputStream(new File("F:\\online test\\TechnicalA.jrxml"));
 				
 				JasperDesign jrXmlLoader=JRXmlLoader.load(inputStream);
 				HashMap map=new HashMap();
 				//map.put("user_id", (String)httpSession.getAttribute("sunTechId"));
 				JasperReport report=JasperCompileManager.compileReport(jrXmlLoader);
 				Connection con=UtilConnection.getCon();
 				JasperPrint jp= JasperFillManager.fillReport(report, map, con);
 				 ByteArrayOutputStream outputByteArray = new ByteArrayOutputStream();
 				
 				JRXlsExporter exporterXLS = new JRXlsExporter();
 		         exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jp);
 		         exporterXLS.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "F:\\online test\\GeneratedReport\\cpmplete.xls" );
 		         exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputByteArray);
 		         exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
 		         exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
 		         exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
 		         exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
 		         exporterXLS.exportReport();

 				
 				
 				
 				
 			/*	JasperViewer jViewer = new JasperViewer(jp, false, null);
				jViewer.setVisible(true);
				JasperExportManager
						.exportReportToPdfFile(jp, "F:\\AptitudeMarks.pdf");*/
				con.close();
 				}
 				catch(Exception e){
 					System.out.println(e);
 				}

 				
 			}

 		}
 		/*RequestDispatcher rd=request.getRequestDispatcher("jsp/download.jsp");
 		rd.forward(request, response);*/

    }
}
