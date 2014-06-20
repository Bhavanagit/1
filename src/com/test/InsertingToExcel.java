package com.test;
import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;
import java.util.*;
import java.sql.*; 
public class InsertingToExcel {  
        public static void main(String[] args) throws Exception{                
                /* Create Connection objects */
                Class.forName ("oracle.jdbc.OracleDriver"); 
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "onlinetest", "onlinetest");
                PreparedStatement sql_statement = null;
                String jdbc_insert_sql = "INSERT INTO questions"
                                + "(qno,question,opt1,opt2,opt3,opt4,ans) VALUES"
                                + "(?,?,?,?,?,?,?)";
                sql_statement = conn.prepareStatement(jdbc_insert_sql);
                /* We should now load excel objects and loop through the worksheet data */
                FileInputStream input_document = new FileInputStream(new File("F:\\upload\\poi-test.xls"));
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
        }
}