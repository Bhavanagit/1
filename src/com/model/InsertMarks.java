package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.beans.MarksBean;
import com.dao.UtilConnection;

public class InsertMarks {
	public static boolean insertMarks(MarksBean bean){
		Connection con=null;
		PreparedStatement pstmt=null;
		String aptmarks="insert into aptmarks values((select entity_id from userdetails where userid='"+bean.getUserid()+"'),?,?)";
		String techmarks="insert into techmarks values((select entity_id from userdetails where userid='"+bean.getUserid()+"'),?,?)";
		String sqlmarks="insert into sqlmarks values((select entity_id from userdetails where userid='"+bean.getUserid()+"'),?,?)";
		String Dotnetmarks="insert into DotNetmarks values((select entity_id from userdetails where userid='"+bean.getUserid()+"'),?,?)";
		String javamarks="insert into javamarks values((select entity_id from userdetails where userid='"+bean.getUserid()+"'),?,?)";
		String osmarks="insert into osmarks values((select entity_id from userdetails where userid='"+bean.getUserid()+"'),?,?)";
		String dsmarks="insert into dsmarks values((select entity_id from userdetails where userid='"+bean.getUserid()+"'),?,?)";
		String cppmarks="insert into cppmarks values((select entity_id from userdetails where userid='"+bean.getUserid()+"'),?,?)";
		String dimarks="insert into dimarks values((select entity_id from userdetails where userid='"+bean.getUserid()+"'),?,?)";
		String rcmarks="insert into rcmarks values((select entity_id from userdetails where userid='"+bean.getUserid()+"'),?,?)";
		String armarks="insert into armarks values((select entity_id from userdetails where userid='"+bean.getUserid()+"'),?,?)";
		String lrmarks="insert into lrmarks values((select entity_id from userdetails where userid='"+bean.getUserid()+"'),?,?)";
		String fgmarks="insert into fgmarks values((select entity_id from userdetails where userid='"+bean.getUserid()+"'),?,?)";

		System.out.println("Test Name from InsertMarks------>>>>"+bean.getTestName());
		boolean flag=false;
		try{
		con=UtilConnection.getCon();
		if(bean.getTestName().equals("aptitude")){
		 pstmt= con.prepareStatement(aptmarks);
		 System.out.println("inserting into aptitude marksssss");
		}
		if(bean.getTestName().equals("technical")){
			pstmt=con.prepareStatement(techmarks);
			 System.out.println("inserting into tech marksssss");

		}
		else if(bean.getTestName().equals("sql")){
			pstmt=con.prepareStatement(sqlmarks);
			 System.out.println("inserting into SQL marksssss");

		}
		else if(bean.getTestName().equals(".net")){
			pstmt=con.prepareStatement(Dotnetmarks);
			 System.out.println("inserting into .net marksssss");

		}
		else if(bean.getTestName().equals("java")){
			pstmt=con.prepareStatement(javamarks);
			 System.out.println("inserting into java marksssss");

		}
		else if(bean.getTestName().equals("os")){
			pstmt=con.prepareStatement(osmarks);
			 System.out.println("inserting into OS marksssss");

		}
		else if(bean.getTestName().equals("ds")){
			pstmt=con.prepareStatement(dsmarks);
			 System.out.println("inserting into DS marksssss");

		}
		else if(bean.getTestName().equals("cpp")){
			pstmt=con.prepareStatement(cppmarks);
			 System.out.println("inserting into CPP marksssss");

		}
		
		else if(bean.getTestName().equals("fg")){
			pstmt=con.prepareStatement(fgmarks);
			 System.out.println("inserting into FG marksssss");

		}
		else if(bean.getTestName().equals("rc")){
			pstmt=con.prepareStatement(rcmarks);
			 System.out.println("inserting into RC marksssss");

		}
		else if(bean.getTestName().equals("di")){
			pstmt=con.prepareStatement(dimarks);
			 System.out.println("inserting into Di marksssss");

		}
		else if(bean.getTestName().equals("ar")){
			pstmt=con.prepareStatement(armarks);
			 System.out.println("inserting into AR marksssss");

		}
		else if(bean.getTestName().equals("lr")){
			pstmt=con.prepareStatement(lrmarks);
			 System.out.println("inserting into LR marksssss");

		}
		
		else{
			System.out.println("please check the test name");
		}




		pstmt.setInt(1, bean.getMarks());
		pstmt.setInt(2, bean.getTestTaken());
		int updatedrows=pstmt.executeUpdate();
		System.out.println("marks rows updated"+updatedrows);
		flag=true;
		}
		catch(SQLException sqle){
			System.out.println("Exception occured at inserting the marks");
			System.out.println(sqle);
		}
		finally{
		try {
			con.close();
			System.out.println("connection from closed finally"+con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return flag;
	}

}
