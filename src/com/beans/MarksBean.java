package com.beans;

import java.io.Serializable;

public class MarksBean implements Serializable{

	private String userid;
	private int marks;
	private int testTaken;
	private String testName;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getMarks() {
		return marks;
	}
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getTestTaken() {
		return testTaken;
	}
	public void setTestTaken(int testTaken) {
		this.testTaken = testTaken;
	}
	}
