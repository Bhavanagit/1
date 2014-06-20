package com.test;

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

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dao.UtilConnection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class SampleReport {

	public void report() {

		// here we will load jrxml file

		FileInputStream input = null;
		try {
			input = new FileInputStream(new File(
					"F:\\online test\\Technical.jrxml"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JasperDesign design = null;
		try {
			design = JRXmlLoader.load(input);
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// if we have parameters pass below manner

		JasperReport report = null;
		try {
			report = JasperCompileManager.compileReport(design);
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map parameters = new HashMap();
		parameters.put("ReportTitle", "Excel JasperReport");

		// Get the connectionObect based on out ( jdbc / ConnectionPool )

		Connection con = null;
		try {
			con = UtilConnection.getCon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// here we will pass the all parameters

		JasperPrint print = null;
		try {
			print = JasperFillManager.fillReport(report, parameters, con);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileOutputStream ouputStream = null;
		try {
			ouputStream = new FileOutputStream(new File(
					"F:/online test/catalog.xls"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		JRXlsExporter exporterXLS = new JRXlsExporter();
		exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
		exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
				byteArrayOutputStream);

		try {
			exporterXLS.exportReport();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ouputStream.write(byteArrayOutputStream.toByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ouputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ouputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
