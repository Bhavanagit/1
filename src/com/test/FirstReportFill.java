package com.test;

import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperRunManager;

public class FirstReportFill {

	public static void main(String[] args) {
		try{
			System.out.println("filling report");
			JasperFillManager.fillReportToFile("FirstReport.jasper",new HashMap(),new JREmptyDataSource());
			JasperRunManager.runReportToPdfFile("FirstReport.jasper",new HashMap(),new JREmptyDataSource());
			System.out.println("done!");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
			
	}

}
