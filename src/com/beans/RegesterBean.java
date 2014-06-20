package com.beans;

import java.io.Serializable;

public class RegesterBean implements Serializable {
	
	
	 private String userId;
	 private String password;
	 private String name;
	 private String eMail;
	 private String mobile;
	 private String branch;
	 private String year;
	 private String college;
	 private String sscMarks;
	 private String interMarks;
	 private String highestdegreeMarks;
	 
	public String getSscMarks() {
		return sscMarks;
	}
	public void setSscMarks(String sscMarks) {
		this.sscMarks = sscMarks;
	}
	public String getInterMarks() {
		return interMarks;
	}
	public void setInterMarks(String interMarks) {
		this.interMarks = interMarks;
	}
	public String getHighestdegreeMarks() {
		return highestdegreeMarks;
	}
	public void setHighestdegreeMarks(String highestdegreeMarks) {
		this.highestdegreeMarks = highestdegreeMarks;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
		 
}
