package com.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.AptBean;
import com.beans.ChooseTest;
import com.dao.UtilConnection;

public class RetriveApt {
	List list;
	ChooseTest ch;

	String sql = null;

	
	public void getTestName(ChooseTest ch1){
		this.ch=ch1;
	}

	
	
	public List getRecords() {
		
		String tname=ch.getTestName();
		if(tname.equals("aptitude")){
			sql="SELECT * FROM( SELECT * FROM aptquestions where qno<=10 ORDER BY dbms_random.value ) WHERE rownum <=10";
		}
		if(tname.equals("ar")){
			sql="SELECT * FROM( SELECT * FROM arquestions where qno<=10 ORDER BY dbms_random.value  ) WHERE rownum <=10";

		}
		if(tname.equals("fg")){
			sql="SELECT * FROM( SELECT * FROM fgquestions where qno<=10 ORDER BY dbms_random.value  ) WHERE rownum <=10";

		}
		if(tname.equals("rc")){
			sql="SELECT * FROM( SELECT * FROM rcquestions where qno<=5 ORDER BY dbms_random.value  ) WHERE rownum <=5";

		}
		if(tname.equals("lr")){
			sql="SELECT * FROM( SELECT * FROM lrquestions where qno<=8 ORDER BY dbms_random.value  ) WHERE rownum <=10";

		}
		if(tname.equals("di")){
			sql="SELECT * FROM( SELECT * FROM diquestions where qno<=5 ORDER BY dbms_random.value  ) WHERE rownum <=5";

		}

		
		
		
		
		
		
		Connection	con=null;
		try {
		con = UtilConnection.getCon();
		System.out.println("from RetriveApt"+con);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			list=new ArrayList();
			while (rs.next()) {

				int qno = rs.getInt("qno");
				String question = rs.getString("question");
				String opt1 = rs.getString("opt1");
				String opt2 = rs.getString("opt2");
				String opt3 = rs.getString("opt3");
				String opt4 = rs.getString("opt4");
				String ans = rs.getString("ans");
				/*System.out.println(qno);
				System.out.println(question);
				System.out.println(opt1);
				System.out.println(opt2);
				System.out.println(opt3);
				System.out.println(opt4);
				System.out.println(ans);*/

				AptBean aptBeans = new AptBean();
				aptBeans.setQNO(qno);
				aptBeans.setQUESTION(question);
				aptBeans.setOPT1(opt1);
				aptBeans.setOPT2(opt2);
				aptBeans.setOPT3(opt3);
				aptBeans.setOPT4(opt4);
				aptBeans.setANS(ans);
				list.add(aptBeans);
				
			}

		}

		catch (SQLException s) {
			s.printStackTrace();

		}

		finally {
			try {
				con.close();
				System.out.println("connection closed from RetriveApt");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("from retriveApt"+list.size());
		return list;

	}

}
