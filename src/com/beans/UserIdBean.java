package com.beans;

import java.io.Serializable;

public class UserIdBean implements Serializable{
	private String userId;
	private String testName;

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	

}
