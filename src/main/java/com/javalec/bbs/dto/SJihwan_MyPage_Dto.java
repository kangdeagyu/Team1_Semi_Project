package com.javalec.bbs.dto;

public class SJihwan_MyPage_Dto {

	// Field
	String cid;
	String cpw;
	String cname;
	String ctelno;
	String caddress;
	String cemail;
	
	
	
	//Constructor
	public SJihwan_MyPage_Dto(String cid, String cpw, String cname, String ctelno, String caddress, String cemail) {
		super();
		this.cid = cid;
		this.cpw = cpw;
		this.cname = cname;
		this.ctelno = ctelno;
		this.caddress = caddress;
		this.cemail = cemail;
	}



	
	
	
	
	
	
	
	
	//Method
	
	public String getCid() {
		return cid;
	}



	public void setCid(String cid) {
		this.cid = cid;
	}



	public String getCpw() {
		return cpw;
	}



	public void setCpw(String cpw) {
		this.cpw = cpw;
	}



	public String getCname() {
		return cname;
	}



	public void setCname(String cname) {
		this.cname = cname;
	}



	public String getCtelno() {
		return ctelno;
	}



	public void setCtelno(String ctelno) {
		this.ctelno = ctelno;
	}



	public String getCaddress() {
		return caddress;
	}



	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}



	public String getCemail() {
		return cemail;
	}



	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
