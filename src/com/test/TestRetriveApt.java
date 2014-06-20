package com.test;

import java.util.List;

import com.model.RetriveApt;

public class TestRetriveApt {
	
	public static void main(String ar[]){
		RetriveApt apt=new RetriveApt();
		List list=apt.getRecords();
	}

}
