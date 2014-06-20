package com.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.dao.UtilConnection;

public class UploadQuestions {

	public static boolean upload(String path) {
		boolean flag = false;
		FileInputStream input_document = null;
		PreparedStatement sql_statement = null;
		Connection conn = null;

		try {/* Create Connection objects */
			conn = UtilConnection.getCon();
			String jdbc_insert_sql = "INSERT INTO questions"
					+ "(qno,question,opt1,opt2,opt3,opt4,ans) VALUES"
					+ "(?,?,?,?,?,?,?)";
			sql_statement = conn.prepareStatement(jdbc_insert_sql);
			/*
			 * We should now load excel objects and loop through the worksheet
			 * data
			 */
			input_document = new FileInputStream(new File(path));
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
						sql_statement.setDouble(1, cell.getNumericCellValue());
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
				input_document.close();
				flag = true;
				return flag;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("from upload questions model");
		}
		/* Close input stream */
		finally {

			/* Close prepared statement */
			try {
				sql_statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/* COMMIT transaction */
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/* Close connection */

		}

		return flag;

	}

}
