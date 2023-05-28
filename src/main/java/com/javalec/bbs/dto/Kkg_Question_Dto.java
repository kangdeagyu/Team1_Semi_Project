package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class Kkg_Question_Dto {

	
	
	
	
	
	//field
	
	int qcode;
	String q_cid;
	String qtitle;
	String qcontent;
	Timestamp qdate;
	Timestamp qdeldate;

	
	
	
	//constructor
	
	public Kkg_Question_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	public Kkg_Question_Dto(int qcode, String q_cid, String qtitle, String qcontent, Timestamp qdate, Timestamp qdeldate) {
		super();
		this.qcode = qcode;
		this.q_cid = q_cid;
		this.qtitle = qtitle;
		this.qcontent = qcontent;
		this.qdate = qdate;
		this.qdeldate = qdeldate;
	}


	
	
	
	//getter & setter
	
	
	
	public int getQcode() {
		return qcode;
	}






	public void setQcode(int qcode) {
		this.qcode = qcode;
	}






	public String getQ_cid() {
		return q_cid;
	}






	public void setQ_cid(String q_cid) {
		this.q_cid = q_cid;
	}






	public String getQtitle() {
		return qtitle;
	}






	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}






	public String getQcontent() {
		return qcontent;
	}






	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}






	public Timestamp getQdate() {
		return qdate;
	}






	public void setQdate(Timestamp qdate) {
		this.qdate = qdate;
	}






	public Timestamp getQdeldate() {
		return qdeldate;
	}






	public void setQdeldate(Timestamp qdeldate) {
		this.qdeldate = qdeldate;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//end
