package com.javalec.bbs.dto;

import java.io.FileInputStream;

public class Kms_UserMain_Dto {
	
	int pcode;
	String pname;
	int pprice;
	String pimage;
	String pimagename;

	public Kms_UserMain_Dto() {
		// TODO Auto-generated constructor stub
	}
	




	public Kms_UserMain_Dto(int pcode, String pimage, String pname, int pprice) {
		super();
		this.pcode = pcode;
		this.pimage = pimage;
		this.pname = pname;
		this.pprice = pprice;
	}





	public Kms_UserMain_Dto(String pimage, String pimagename, int pcode, int pprice, String pname) {
		super();
		this.pimage = pimage;
		this.pimagename = pimagename;
		this.pcode = pcode;
		this.pprice = pprice;
		this.pname = pname;
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

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public String getPimagename() {
		return pimagename;
	}

	public void setPimagename(String pimagename) {
		this.pimagename = pimagename;
	}
	
	
}
