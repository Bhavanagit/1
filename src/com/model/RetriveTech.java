package com.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.ChooseTest;
import com.beans.TechBean;
import com.dao.UtilConnection;

public class RetriveTech {
	List list;
	ChooseTest ch;
	
	String sql = null;

		
	public void getTestName(ChooseTest ch1){
		this.ch=ch1;
	}


	public List getRecords() {
		String tname=ch.getTestName();
		if(tname.equals("technical")){
			sql="SELECT * FROM( SELECT * FROM techquestions where qno<=30 ORDER BY dbms_random.value  ) WHERE rownum <=10";
			System.out.println("TEchnical Selectedddddddd");
		}
		if(tname.equals("sql")){
			sql="SELECT * FROM( SELECT * FROM sqlquestions where qno<=5 ORDER BY dbms_random.value  ) WHERE rownum <=5";

		}
		if(tname.equals(".net")){
			sql="SELECT * FROM( SELECT * FROM Dnetquestions where qno<=10 ORDER BY dbms_random.value  ) WHERE rownum <=10";

		}
		if(tname.equals("java")){
			sql="SELECT * FROM( SELECT * FROM javaquestions where qno<=10 ORDER BY dbms_random.value  ) WHERE rownum <=10";

		}
		if(tname.equals("os")){
			sql="SELECT * FROM( SELECT * FROM osquestions where qno<=5 ORDER BY dbms_random.value  ) WHERE rownum <=5";

		}
		if(tname.equals("ds")){
			sql="SELECT * FROM( SELECT * FROM dsquestions where qno<=10 ORDER BY dbms_random.value  ) WHERE rownum <=10";

		}

		if(tname.equals("cpp")){
			sql="SELECT * FROM( SELECT * FROM cppquestions where qno<=10 ORDER BY dbms_random.value  ) WHERE rownum <=10";

		}


		
		
		
		
		Connection con=null;
		try {
			 con= UtilConnection.getCon();
			System.out.println("from RetriveApt" + con);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			list = new ArrayList();
			while (rs.next()) {

				int qno = rs.getInt("qno");
				String question = rs.getString("question");
				String opt1 = rs.getString("opt1");
				String opt2 = rs.getString("opt2");
				String opt3 = rs.getString("opt3");
				String opt4 = rs.getString("opt4");
				String ans = rs.getString("ans");
				/*
				 * System.out.println(qno); System.out.println(question);
				 * System.out.println(opt1); System.out.println(opt2);
				 * System.out.println(opt3); System.out.println(opt4);
				 * System.out.println(ans);
				 */

				TechBean techBeans = new TechBean();
				techBeans.setQNO(qno);
				techBeans.setQUESTION(question);
				techBeans.setOPT1(opt1);
				techBeans.setOPT2(opt2);
				techBeans.setOPT3(opt3);
				techBeans.setOPT4(opt4);
				techBeans.setANS(ans);
				list.add(techBeans);

			}

		}

		catch (SQLException s) {
			s.printStackTrace();

		}

		finally {
			try {
				con.close();
				System.out.println("connection closed from RetriveTEch");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("from retriveApt" + list.size());
		return list;

	}

}
