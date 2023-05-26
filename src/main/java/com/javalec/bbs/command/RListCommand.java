package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.Kkg_Review_Dao;
import com.javalec.bbs.dto.Kkg_Review_Dto;

public class RListCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		int pcode =Integer.parseInt(request.getParameter("pcode"));
		
		Kkg_Review_Dao dao = new Kkg_Review_Dao();
		ArrayList<Kkg_Review_Dto> dtos  = dao.reviewList(pcode);
		
		System.out.println("커맨드 클래스에서 dots의 두번째의 rcode 값 : "+dtos.get(1).getRcode());
		request.setAttribute("rList", dtos);
		
		
		
		
	}

}
