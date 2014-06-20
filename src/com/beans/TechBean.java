package com.beans;

import java.io.Serializable;

public class TechBean implements Serializable {
private int QNO;
private String QUESTION;
private String OPT1;
private String OPT2;
private String OPT3;
private String OPT4;
private String ANS;
public int getQNO() {
	return QNO;
}
public void setQNO(int qNO) {
	QNO = qNO;
}
public String getQUESTION() {
	return QUESTION;
}
public void setQUESTION(String qUESTION) {
	QUESTION = qUESTION;
}
public String getOPT1() {
	return OPT1;
}
public void setOPT1(String oPT1) {
	OPT1 = oPT1;
}
public String getOPT2() {
	return OPT2;
}
public void setOPT2(String oPT2) {
	OPT2 = oPT2;
}
public String getOPT3() {
	return OPT3;
}
public void setOPT3(String oPT3) {
	OPT3 = oPT3;
}
public String getOPT4() {
	return OPT4;
}
public void setOPT4(String oPT4) {
	OPT4 = oPT4;
}
public String getANS() {
	return ANS;
}
public void setANS(String aNS) {
	ANS = aNS;
}



}
