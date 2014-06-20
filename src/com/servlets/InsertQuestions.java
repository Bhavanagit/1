package com.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.dao.UtilConnection;

/**
 * Servlet implementation class InsertQuestions
 */
public class InsertQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertQuestions() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		try{
	        Connection conn=UtilConnection.getCon();
	        PreparedStatement sql_statement = null;
	        
	        String jdbc_insert_sql = "INSERT INTO questions"
	                        + "(qno,question,opt1,opt2,opt3,opt4,ans) VALUES"
	                        + "(?,?,?,?,?,?,?)";
	        sql_statement = conn.prepareStatement(jdbc_insert_sql);
	        /* We should now load excel objects and loop through the worksheet data */
	        FileInputStream input_document = new FileInputStream(new File("F:\\poi-test.xls"));
	        /* Load workbook */
	        HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document);
	        /* Load worksheet */
	        HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);
	        // we loop through and insert data
	        Iterator<Row> rowIterator = my_worksheet.iterator(); 
	        while(rowIterator.hasNext()) {
	                Row row = rowIterator.next(); 
	                Iterator<Cell> cellIterator = row.cellIterator();
	                int index=2;
	                while(cellIterator.hasNext()) {
	                                Cell cell = cellIterator.next();
	                                

	                                switch(cell.getCellType()) { 
	                                case Cell.CELL_TYPE_NUMERIC: //handle string columns
	                                        sql_statement.setDouble(1, cell.getNumericCellValue());                                                                                     
	                                        break;
	                                        
	                                case Cell.CELL_TYPE_STRING: //handle string columns
	                                	if(index<=7){
	                                    sql_statement.setString(index, cell.getStringCellValue());
	                                    index++;
	                                    break;
	                                	}
	                                	
	                                 
	                                
	                              }
	                               
	                        }
	        //we can execute the statement before reading the next row
	        sql_statement.executeUpdate();
	        }
	        /* Close input stream */
	        input_document.close();
	        /* Close prepared statement */
	        sql_statement.close();
	        /* COMMIT transaction */
	        conn.commit();
	        /* Close connection */
	        conn.close();
	        System.out.println("inserted");
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        }

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
	        Connection conn=UtilConnection.getCon();
	        PreparedStatement sql_statement = null;
	        
	        String jdbc_insert_sql = "INSERT INTO questions"
	                        + "(qno,question,opt1,opt2,opt3,opt4,ans) VALUES"
	                        + "(?,?,?,?,?,?,?)";
	        sql_statement = conn.prepareStatement(jdbc_insert_sql);
	        /* We should now load excel objects and loop through the worksheet data */
	        FileInputStream input_document = new FileInputStream(new File("F:\\poi-test.xls"));
	        /* Load workbook */
	        HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document);
	        /* Load worksheet */
	        HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);
	        // we loop through and insert data
	        Iterator<Row> rowIterator = my_worksheet.iterator(); 
	        while(rowIterator.hasNext()) {
	                Row row = rowIterator.next(); 
	                Iterator<Cell> cellIterator = row.cellIterator();
	                int index=2;
	                while(cellIterator.hasNext()) {
	                                Cell cell = cellIterator.next();
	                                

	                                switch(cell.getCellType()) { 
	                                case Cell.CELL_TYPE_NUMERIC: //handle string columns
	                                        sql_statement.setDouble(1, cell.getNumericCellValue());                                                                                     
	                                        break;
	                                        
	                                case Cell.CELL_TYPE_STRING: //handle string columns
	                                	if(index<=7){
	                                    sql_statement.setString(index, cell.getStringCellValue());
	                                    index++;
	                                    break;
	                                	}
	                                	
	                                 
	                                
	                              }
	                               
	                        }
	        //we can execute the statement before reading the next row
	        sql_statement.executeUpdate();
	        }
	        /* Close input stream */
	        input_document.close();
	        /* Close prepared statement */
	        sql_statement.close();
	        /* COMMIT transaction */
	        conn.commit();
	        /* Close connection */
	        conn.close();
	        System.out.println("inserted");
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        }

		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
