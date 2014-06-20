package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class UtilConnection {  
	private static Connection con;
	static{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	public static synchronized Connection getCon() throws SQLException {
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "onlinetest", "onlinetest");
		System.out.println("connected"+con);
		return con;
	}
	
	public static void close(Connection con) throws SQLException{
			con.close();
			System.out.println("closed connection"+con);
	}
		
	

}
