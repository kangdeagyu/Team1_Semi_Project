package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class SJihwan_UserOrderList_Dto {

	//Field
	
	//order
	int onum;
	String o_cid;
	int o_pcode;
	int oqty;
	String odate;

	// product
	int pcode;
	String pname;
	int pprice;
	String pimagename;

	// customer
	String cid;
	String cname;
	String caddress;
	String cemail;
	
	
	
	//Constructor
	public SJihwan_UserOrderList_Dto(String pimagename, int onum, String pname, int pprice, int oqty, String odate, int pcode) {
		super();
		this.pimagename = pimagename;
		this.onum = onum;
		this.pname = pname;
		this.pprice = pprice;
		this.oqty = oqty;
		this.odate = odate;
		this.pcode=pcode;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Method
	public int getOnum() {
		return onum;
	}



	public void setOnum(int onum) {
		this.onum = onum;
	}



	public String getO_cid() {
		return o_cid;
	}



	public void setO_cid(String o_cid) {
		this.o_cid = o_cid;
	}



	public int getO_pcode() {
		return o_pcode;
	}



	public void setO_pcode(int o_pcode) {
		this.o_pcode = o_pcode;
	}



	public int getOqty() {
		return oqty;
	}



	public void setOqty(int oqty) {
		this.oqty = oqty;
	}



	public String getOdate() {
		return odate;
	}



	public void setOdate(String odate) {
		this.odate = odate;
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



	public String getPimagename() {
		return pimagename;
	}



	public void setPimagename(String pimagename) {
		this.pimagename = pimagename;
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
