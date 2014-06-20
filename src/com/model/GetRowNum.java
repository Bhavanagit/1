package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beans.CredentialsBean;
import com.beans.UserIdBean;
import com.dao.UtilConnection;

public class GetRowNum {

	public static int getRowNum(UserIdBean bean) {
		int rowNum = 0;
		ResultSet rs = null;
		Connection con =null;
		
		try {
			String sql = "select max(testtaken) from aptmarks where e_Id=(select entity_id from userdetails where userid=?)";
			String sql2 = "select max(testtaken) from techmarks where eid=(select entity_id from userdetails where userid=?)";
			String sql3="select max(testtaken) from sqlmarks where E_Id=(select entity_id from userdetails where userid=?)";
			String sql4="select max(testtaken) from DotNetmarks where DE_Id=(select entity_id from userdetails where userid=?)";
			String sql5="select max(testtaken) from osmarks where E_Id=(select entity_id from userdetails where userid=?)";
			String sql6="select max(testtaken) from dsmarks where E_Id=(select entity_id from userdetails where userid=?)";
			String sql7="select max(testtaken) from cppmarks where E_Id=(select entity_id from userdetails where userid=?)";
			String sql8="select max(testtaken) from javamarks where E_Id=(select entity_id from userdetails where userid=?)";
			String lr="select max(testtaken) from lrmarks where E_Id=(select entity_id from userdetails where userid=?)";
			String ar="select max(testtaken) from armarks where E_Id=(select entity_id from userdetails where userid=?)";
			String di="select max(testtaken) from dimarks where E_Id=(select entity_id from userdetails where userid=?)";
			String fg="select max(testtaken) from fgmarks where E_Id=(select entity_id from userdetails where userid=?)";
			String rc="select max(testtaken) from rcmarks where E_Id=(select entity_id from userdetails where userid=?)";
			

			PreparedStatement pstmt = null;
			con= UtilConnection.getCon();
			System.out.println("connected");
			System.out.println("TestNameFrom GetRowNum-------"+bean.getTestName());
			if (bean.getTestName().equals("aptitude")) {
				pstmt = con.prepareStatement(sql);
				System.out.println("apt querry created executed from+++++========.....>>>GetRowNum");
				pstmt.setString(1, bean.getUserId());
				rs = pstmt.executeQuery();
				System.out.println("query executed");

			}
			
			if (bean.getTestName().equals("lr")) {
				pstmt = con.prepareStatement(lr);
				System.out.println("lr querry created executed from======>>>GetRowNum");
				pstmt.setString(1, bean.getUserId());
				rs = pstmt.executeQuery();
				System.out.println("query executed");

			}

			if (bean.getTestName().equals("ar")) {
				pstmt = con.prepareStatement(ar);
				System.out.println("ar querry created executed from======>>>GetRowNum");
				pstmt.setString(1, bean.getUserId());
				rs = pstmt.executeQuery();
				System.out.println("query executed");

			}
			
			
			if (bean.getTestName().equals("fg")) {
				pstmt = con.prepareStatement(fg);
				System.out.println("fg querry created executed from======>>>GetRowNum");
				pstmt.setString(1, bean.getUserId());
				rs = pstmt.executeQuery();
				System.out.println("query executed");

			}
			if (bean.getTestName().equals("di")) {
				pstmt = con.prepareStatement(di);
				System.out.println("di querry created executed from======>>>GetRowNum");
				pstmt.setString(1, bean.getUserId());
				rs = pstmt.executeQuery();
				System.out.println("query executed");

			}
			if (bean.getTestName().equals("rc")) {
				pstmt = con.prepareStatement(rc);
				System.out.println("rc querry created executed from======>>>GetRowNum");
				pstmt.setString(1, bean.getUserId());
				rs = pstmt.executeQuery();
				System.out.println("query executed");

			}


			
			
			

			
			
			if (bean.getTestName().equals("technical")) {
				pstmt = con.prepareStatement(sql2);
				System.out.println("querry created");
				pstmt.setString(1, bean.getUserId());
				rs = pstmt.executeQuery();
				System.out.println("query executed");

			}
			if (bean.getTestName().equals("sql")) {
				pstmt = con.prepareStatement(sql3);
				System.out.println("querry created");
				pstmt.setString(1, bean.getUserId());
				rs = pstmt.executeQuery();
				System.out.println("query executed");

			}
			
			if (bean.getTestName().equals(".net")) {
				pstmt = con.prepareStatement(sql4);
				System.out.println("querry created");
				pstmt.setString(1, bean.getUserId());
				rs = pstmt.executeQuery();
				System.out.println("query executed");

			}
			
			if (bean.getTestName().equals("java")) {
				pstmt = con.prepareStatement(sql8);
				System.out.println("querry created");
				pstmt.setString(1, bean.getUserId());
				rs = pstmt.executeQuery();
				System.out.println("query executed");

			}
			if (bean.getTestName().equals("os")) {
				pstmt = con.prepareStatement(sql5);
				System.out.println("querry created");
				pstmt.setString(1, bean.getUserId());
				rs = pstmt.executeQuery();
				System.out.println("query executed");

			}
			if (bean.getTestName().equals("ds")) {
				pstmt = con.prepareStatement(sql6);
				System.out.println("querry created");
				pstmt.setString(1, bean.getUserId());
				rs = pstmt.executeQuery();
				System.out.println("query executed");

			}
			if (bean.getTestName().equals("cpp")) {
				pstmt = con.prepareStatement(sql7);
				System.out.println("querry created");
				pstmt.setString(1, bean.getUserId());
				rs = pstmt.executeQuery();
				System.out.println("query executed");

			}

			
				
			
			
			if (rs.next()) {
				rowNum = rs.getInt("max(TESTTAKEN)");
				System.out.println("test taken from GetRowNum" + rowNum);
			} else {
				rowNum = 0;
			}
		} catch (SQLException sql) {
			System.out.println("Exception occured in GetRowNum");
			System.out.println(sql);
		}
		finally{
			try {
				con.close();
				System.out.println("connection Closed from GetRowNumber");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return rowNum;
	}

}
