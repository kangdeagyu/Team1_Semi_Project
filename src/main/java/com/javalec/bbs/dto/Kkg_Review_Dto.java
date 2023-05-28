package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class Kkg_Review_Dto {

	
	//field
	int rcode ;
	String r_cid ;
	int r_pcode ;
	String rcontent;
	int rstar;
	String rtitle;
	Timestamp rdate;
	//constructor
	
	
	public Kkg_Review_Dto() {
		super();
	}
	
	
	
	
	public Kkg_Review_Dto(int rcode, String r_cid, int r_pcode, String rtitle, String rcontent, int rstar, Timestamp rdate) {
		super();
		this.rcode = rcode;
		this.r_cid = r_cid;
		this.r_pcode = r_pcode;
		this.rtitle = rtitle;
		this.rcontent = rcontent;
		this.rstar = rstar;
		this.rdate = rdate;
	}


















	//getter & setter
	public int getRcode() {
		return rcode;
	}

	public void setRcode(int rcode) {
		this.rcode = rcode;
	}
	public String getR_cid() {
		return r_cid;
	}
	public void setR_cid(String r_cid) {
		this.r_cid = r_cid;
	}
	public int getR_pcode() {
		return r_pcode;
	}
	public void setR_pcode(int r_pcode) {
		this.r_pcode = r_pcode;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public int getRstar() {
		return rstar;
	}
	public void setRstar(int rstar) {
		this.rstar = rstar;
	}




	public String getRtitle() {
		return rtitle;
	}




	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}




	public Timestamp getRdate() {
		return rdate;
	}




	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	
	
	
	
	
	
	
	
	
	
	
}
