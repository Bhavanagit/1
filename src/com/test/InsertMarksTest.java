package com.test;

import com.beans.UserIdBean;
import com.model.GetRowNum;


public class InsertMarksTest {

	public static void main(String[] args) {
		UserIdBean cBean=new UserIdBean();		
		cBean.setUserId("123");
		int num=GetRowNum.getRowNum(cBean);
		System.out.println(num);
		
	}

}
