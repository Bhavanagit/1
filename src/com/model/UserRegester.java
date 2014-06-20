package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.RegesterBean;
import com.dao.UtilConnection;

public class UserRegester {
	Connection con=null;
	String insertsql="insert into userdetails values(seq_entity_id.nextval,?,?,?,?,?,?,?,?,?,?,?)";
	String selectsql="select userid from userdetails where userid=?";
	PreparedStatement pstmt=null;
	public boolean regester(RegesterBean rBean){
		boolean flag=false;
		try{
			con=UtilConnection.getCon();
		
		pstmt=con.prepareStatement(selectsql);
		pstmt.setString(1, rBean.getUserId());
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()){
			flag=false;
		}
		
		else{
		
		pstmt=con.prepareStatement(insertsql);
		pstmt.setString(1, rBean.getUserId());
		pstmt.setString(2, rBean.getPassword());
		pstmt.setString(3, rBean.getName());
		pstmt.setString(4, rBean.geteMail());
		pstmt.setString(5, rBean.getMobile());
		pstmt.setString(6, rBean.getBranch());
		pstmt.setString(7, rBean.getYear());
		pstmt.setString(8, rBean.getCollege());
		pstmt.setString(9,rBean.getSscMarks());
		pstmt.setString(10, rBean.getInterMarks());
		pstmt.setString(11, rBean.getHighestdegreeMarks());
		
		int i=pstmt.executeUpdate();
		
		if(i!=0){
			flag=true;
		}
		}
		}

		catch (Exception e) {
			System.out.println("Sql Excepton from UserRegester");
		}
		finally{
		try {
			
			con.close();
			System.out.println("connection closed from UserRegister");
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Sql Excepton from UserRegester");		}
		}
		
		return flag;
	}

}
