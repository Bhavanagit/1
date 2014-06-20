package com.beans;

import java.io.Serializable;

public class DisplayMarksBean implements Serializable {
	
	private String userId;
	 private int aptMarks;
	 private int techMarks;
	 private int testTaken;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getAptMarks() {
		return aptMarks;
	}
	public void setAptMarks(int aptMarks) {
		this.aptMarks = aptMarks;
	}
	public int getTechMarks() {
		return techMarks;
	}
	public void setTechMarks(int techMarks) {
		this.techMarks = techMarks;
	}
	public int getTestTaken() {
		return testTaken;
	}
	public void setTestTaken(int testTaken) {
		this.testTaken = testTaken;
	}

}



