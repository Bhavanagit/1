package com.test;

import java.sql.SQLException;

import com.beans.CredentialsBean;
import com.beans.RegesterBean;
import com.model.UserIdPasswordCheck;
import com.model.UserRegester;

public class UserRegesterTest {

	public static void main(String[] args) {
	RegesterBean rBean=new RegesterBean();
	rBean.setBranch("cse");
	rBean.setCollege("mdha");
	rBean.seteMail("mail");
	rBean.setMobile("8977539775");
	rBean.setName("umesh");
	rBean.setPassword("kothval");
	rBean.setUserId("123");
	rBean.setYear("IVyear");
	CredentialsBean cbBean;
	UserIdPasswordCheck uc=new UserIdPasswordCheck();
	/*cbBean=uc.checkDB(rBean);
	if(cbBean!=null){
	System.out.println("from UserRegesterTest"+cbBean.getUserName());
	System.out.println("from UserRegesterTest"+cbBean.getPassword());*/
	
	}

}
