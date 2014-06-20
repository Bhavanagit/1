package com.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.beans.ForgotPassword;
import com.beans.GetPass;
import com.dao.UtilConnection;

public class ForgotPassModel {
	GetPass getPassword=null;
	Connection con=null;
	String userid=null;
	String password=null;
	String sql="select userid,password from userdetails where mobile=?";
	public GetPass retrivepass(ForgotPassword fpassword){
	
		try{
			con=UtilConnection.getCon();
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setString(0, (String)fpassword.getRno());
			ResultSet rs=pstmt.executeQuery();
			while (rs.next()) {
				userid=rs.getString("userid");
				 password=rs.getString("password");
			}			
		con.close();
		}
		catch(Exception e){
			
		}
			
return getPassword;	
}
}