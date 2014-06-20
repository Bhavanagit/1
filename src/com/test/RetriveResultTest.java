package com.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.beans.DisplayMarksBean;
import com.model.RetriveResult;

public class RetriveResultTest {

	public static void main(String[] args) {
		RetriveResult result = new RetriveResult();
		Map rMap = result.displayResult();
		Set keyset=rMap.keySet();
		Iterator itr=keyset.iterator();
		while (itr.hasNext()) {
			String userId = (String) itr.next();
			List list=(List)rMap.get(userId);
			Iterator iterator=list.iterator();
			System.out.println("userId");
			System.out.println(userId);
			while (iterator.hasNext()) {
				DisplayMarksBean dBean = (DisplayMarksBean) iterator.next();
				int aptMarks=dBean.getAptMarks();
				int techMarks=dBean.getTechMarks();
				int testTaken=dBean.getTestTaken();
				System.out.println("\t"+"aptmarks"+"\t"+"techMarks"+"\t"+"TestTaken");
				System.out.println("\t"+aptMarks+"\t"+techMarks+"\t"+testTaken);
			}
		}
		
	
	}

}
