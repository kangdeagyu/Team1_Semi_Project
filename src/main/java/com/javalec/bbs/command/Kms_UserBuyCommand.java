package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.Kms_UserMain_Dao;
import com.javalec.bbs.dto.Kms_UserMain_Dto;

public class Kms_UserBuyCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String pname = request.getParameter("pname");
		Kms_UserMain_Dao dao = new Kms_UserMain_Dao();
		Kms_UserMain_Dto dto = dao.contentView(pname);
		
		request.setAttribute("contentView", dto);
	}

}
