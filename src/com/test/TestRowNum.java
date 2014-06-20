package com.test;

import com.beans.UserIdBean;
import com.model.GetRowNum;

public class TestRowNum {

	public static void main(String[] args) {
		UserIdBean bean=new UserIdBean();
		bean.setUserId("101");
		bean.setTestName("aptitude");
		GetRowNum.getRowNum(bean);
	}

}
