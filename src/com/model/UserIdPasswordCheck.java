package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.CredentialsBean;
import com.beans.RegesterBean;
import com.dao.UtilConnection;

public class UserIdPasswordCheck {
	String sql="select userid,password from userdetails where userid=?";
	public CredentialsBean checkDB(CredentialsBean cBean){
		//CredentialsBean cBean=null;
		boolean flag=false;
		Connection con=null;
		try{
			con=UtilConnection.getCon();
			System.out.println("From Credentials Bean username"+cBean.getUserName());
			
			System.out.println("password"+cBean.getPassword());
		
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1, cBean.getUserName());
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()){
			cBean=new CredentialsBean();
			System.out.println("from ucheck bean"+rs.getString("userid"));
			System.out.println(rs.getString("userid"));
			cBean.setUserName(rs.getString("userid"));
			cBean.setPassword(rs.getString("password"));
		
		}
		else {
			cBean.setPassword("nodata");
			cBean.setUserName("nodata");
		}
		}
		catch(SQLException sql){
			System.out.println("SqlException from UserIdPasswordCheck class");
			
		}
		finally{
			try {
				con.close();
				System.out.println("connection closed from UserIdPasswordChecck");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cBean;
		
	}
	
	
	
}
