package com.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.dao.UtilConnection;

/**
 * Servlet to handle File upload request from Client
 * 
 * @author Javin Paul
 */
public class UploadQuestions extends HttpServlet {
	private final String UPLOAD_DIRECTORY = "F:\\upload";

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		String name=null;
		String paper[]=request.getParameterValues("test");
		//System.out.println("paper name:::"+paper[0]);
	// process only if its multipart content
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(request);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						name = new File(item.getName()).getName();
						item.write(new File(getServletConfig()
								.getServletContext().getRealPath("\\")
								+ File.separator + name));
					}
				}

				// File uploaded successfully
				request.setAttribute("message", "File Uploaded Successfully");
			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to "
						+ ex);
			}

		} else {
			request.setAttribute("message",
					"Sorry this Servlet only handles file upload request");
		}
		System.out.println("--->executed ");
		System.out.println("executed ");

		Connection conn = null;
		
			try {
				conn = UtilConnection.getCon();
				PreparedStatement sql_statement = null;
				String jdbc_insert_sql = "INSERT INTO techquestions"
						+ "(qno,question,opt1,opt2,opt3,opt4,ans) VALUES"
						+ "(?,?,?,?,?,?,?)";
				sql_statement = conn.prepareStatement(jdbc_insert_sql);
				/*
				 * We should now load excel objects and loop through the
				 * worksheet data
				 */
				FileInputStream input_document = new FileInputStream(new File(
						getServletConfig().getServletContext()
								.getRealPath("\\") + File.separator + name));
				/* Load workbook */
				HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document);
				/* Load worksheet */
				HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);
				// we loop through and insert data
				Iterator<Row> rowIterator = my_worksheet.iterator();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					int index = 2;
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC: // handle string columns
							sql_statement.setDouble(1,
									cell.getNumericCellValue());
							break;

						case Cell.CELL_TYPE_STRING: // handle string columns
							if (index <= 7) {
								sql_statement.setString(index,
										cell.getStringCellValue());
								index++;
								break;
							}

						}

					}
					// we can execute the statement before reading the next row
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
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher rd = request.getRequestDispatcher("jsp/admin.jsp");
				try {
					rd.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
	}
}
