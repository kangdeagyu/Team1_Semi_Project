package com.javalec.bbs.dto;

public class JDto {

	
	String cid;
	String pimagename;
	String pimage;
	String cname;
	String ctelno;
	String caddress;
	String cemail;
	String pname;
	String pprice;
	
	int pcode;
	
	
	public JDto() {
		// TODO Auto-generated constructor stub
	}

	

	



	public JDto(String pimagename, String pimage, String pname, String pprice, int pcode) {
		super();
		this.pimagename = pimagename;
		this.pimage = pimage;
		this.pname = pname;
		this.pprice = pprice;
		this.pcode = pcode;
	}







	public JDto(String cid, String cname, String ctelno, String caddress, String cemail) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.ctelno = ctelno;
		this.caddress = caddress;
		this.cemail = cemail;
	
	}



	public String getPimagename() {
		return pimagename;
	}



	public void setPimagename(String pimagename) {
		this.pimagename = pimagename;
	}



	public String getPimage() {
		return pimage;
	}



	public void setPimage(String pimage) {
		this.pimage = pimage;
	}



	public int getPcode() {
		return pcode;
	}



	public void setPcode(int pcode) {
		this.pcode = pcode;
	}



	public String getCid() {
		return cid;
	}


	public void setCid(String cid) {
		this.cid = cid;
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


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getPprice() {
		return pprice;
	}


	public void setPprice(String pprice) {
		this.pprice = pprice;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
