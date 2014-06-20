package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import com.dao.UtilConnection;
import com.lowagie.text.pdf.codec.Base64.InputStream;
import com.lowagie.text.pdf.codec.Base64.OutputStream;

public class Report2 {
 
  public  void report() {
	  //Connection conn=null;
	  	try{
	  		FileInputStream input = (FileInputStream) new FileInputStream(new File(
	  				"F:\\online test\\MR.jrxml"));
	  				JasperDesign design = JRXmlLoader.load(input);
			  JasperReport report = JasperCompileManager.compileReport(design);
			  Map parameters = new HashMap();
			  parameters.put("ReportTitle", "PDF JasperReport");
			  InitialContext initialContext = new InitialContext();
			  Connection conn = UtilConnection.getCon();
			  JasperPrint print = JasperFillManager.fillReport(report,
			  parameters, conn);
			  FileOutputStream output = new FileOutputStream(new File(
			  "F:\\umesh.pdf"));
			  JasperExportManager.exportReportToPdfFile(print, "F:\\gen.pdf"); 
}
  catch(Exception e) {
e.printStackTrace();
}
	  	}
}