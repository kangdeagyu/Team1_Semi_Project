package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.Kms_UserMain_Dao;
import com.javalec.bbs.dto.Kms_UserMain_Dto;

public class Kms_ListCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession(true);
//		String cid=(String)session.getAttribute("sid");
//		request.setAttribute("cid", cid);
		Kms_UserMain_Dao dao = new Kms_UserMain_Dao();
		ArrayList<Kms_UserMain_Dto> dtos = dao.list();
		request.setAttribute("list", dtos);
	}

}
