package com.javalec.bbs.dto;

import java.io.FileInputStream;

public class Kms_UserMain_Dto {
	
	int pcode;
	String pname;
	int pprice;
	FileInputStream pimage;
	String pimagename;

	public Kms_UserMain_Dto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Kms_UserMain_Dto(String pname, int pprice, String pimagename) {
		super();
		this.pname = pname;
		this.pprice = pprice;
		this.pimagename = pimagename;
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

	public FileInputStream getPimage() {
		return pimage;
	}

	public void setPimage(FileInputStream pimage) {
		this.pimage = pimage;
	}

	public String getPimagename() {
		return pimagename;
	}

	public void setPimagename(String pimagename) {
		this.pimagename = pimagename;
	}
	
	
}
