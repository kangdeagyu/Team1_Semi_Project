package com.javalec.bbs.dto;

import java.sql.Time;
import java.sql.Timestamp;

public class Kkg_Answer_Dto {

	
	int acode;
	int a_qcode;
	String a_aid;
	String atitle;
	String acontent;
	Timestamp adate;
	Timestamp adeldate;
	
	public Kkg_Answer_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public Kkg_Answer_Dto(int acode, int a_qcode, String a_aid, String atitle, String acontent, Timestamp adate, Timestamp adeldate) {
		super();
		this.acode = acode;
		this.a_qcode = a_qcode;
		this.a_aid = a_aid;
		this.atitle = atitle;
		this.acontent = acontent;
		this.adate = adate;
		this.adeldate = adeldate;
	}




	public int getAcode() {
		return acode;
	}
	public void setAcode(int acode) {
		this.acode = acode;
	}
	public int getA_qcode() {
		return a_qcode;
	}
	public void setA_qcode(int a_qcode) {
		this.a_qcode = a_qcode;
	}
	public String getA_aid() {
		return a_aid;
	}
	public void setA_aid(String a_aid) {
		this.a_aid = a_aid;
	}
	public String getAtitle() {
		return atitle;
	}
	public void setAtitle(String atitle) {
		this.atitle = atitle;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public Timestamp getAdate() {
		return adate;
	}
	public void setAdate(Timestamp adate) {
		this.adate = adate;
	}
	public Timestamp getAdeldate() {
		return adeldate;
	}
	public void setAdeldate(Timestamp adeldate) {
		this.adeldate = adeldate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}//end
