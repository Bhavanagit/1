package com.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.beans.DisplayMarksBean;
import com.dao.UtilConnection;

public class RetriveResult {
	public Map displayResult() {
		String sql = "select * from marks";
		Map rmap = new HashMap();
		List list = new ArrayList();
		Connection con = null;
		try {
			con = UtilConnection.getCon();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String userId = rs.getString("userid");
				int aptMarks = rs.getInt("aptmarks");
				int techMarks = rs.getInt("techmarks");
				int testTaken = rs.getInt("testtaken");
				DisplayMarksBean dBean = new DisplayMarksBean();
				dBean.setAptMarks(aptMarks);
				dBean.setTechMarks(techMarks);
				dBean.setTestTaken(testTaken);
				list.add(dBean);
				rmap.put(userId, list);
			}

		} catch (SQLException sqle) {
			System.out.println("Exception from RetriveResult");
			System.out.println(sqle);
		} finally {
			try {
				con.close();
				System.out.println("finallllyyy" + con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return rmap;
	}

}
