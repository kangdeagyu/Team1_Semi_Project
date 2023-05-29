package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class SJihwan_Cart_Purchase_Dto {

	// Field
	//basket
	int bcode;
	String b_cid;
	int b_pcode;
	int bqty;
	String bdate;
	
	//order
	int onum;
	String o_cid;
	int o_pcode;
	String oqty;
	Timestamp DateTime;
	
	//product
	int pcode;
	String pname;
	int pprice;
	String pimage;
	
	//customer
	String cid;
	String cname;
	String caddress;
	String cemail;
	Timestamp cinsertdate;
	Timestamp cupdatedate;
	Timestamp cdeletedate;
	boolean isSelected;
	
	// Constructor


	public SJihwan_Cart_Purchase_Dto(String pimage, int pcode, String pname, int pprice, int bqty, int bcode) {
		super();
		this.pimage = pimage;
		this.pcode = pcode;
		this.pname = pname;
		this.pprice = pprice;
		this.bqty = bqty;
		this.bcode = bcode;
	}


	
	public SJihwan_Cart_Purchase_Dto(int pprice) {
		super();
		this.pprice = pprice;
	}

	
	
	
	
	
	
	
	
	
	
	// Method
	
	










	public int getBcode() {
		return bcode;
	}


	public void setBcode(int bcode) {
		this.bcode = bcode;
	}


	public int getBqty() {
		return bqty;
	}


	public void setBqty(int bqty) {
		this.bqty = bqty;
	}


	public int getPcode() {
		return pcode;
	}


	public void setPcode(int pcode) {
		this.pcode = pcode;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public int getPprice() {
		return pprice;
	}


	public void setPprice(int pprice) {
		this.pprice = pprice;
	}


	public String getPimage() {
		return pimage;
	}


	public void setPimagename(String pimage) {
		this.pimage = pimage;
	}
	
	
	public boolean isSelected() {
		return isSelected;
	}
	
	public void setSelected(boolean selected) {
		isSelected = selected;
	}
	
	
	
	
	
	
	
	
	
	
	
}
