package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.Kkg_Review_Dao;
import com.javalec.bbs.dto.Kkg_Review_Dto;
import com.javalec.bbs.homecontroller.Controller;


public class RViewCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
	int rcode =Integer.parseInt(request.getParameter("rcode"));
		
		Kkg_Review_Dao dao = new Kkg_Review_Dao();
		Kkg_Review_Dto dto  = dao.review_view(rcode);
		
		System.out.println("reivew_view_command 에서 dot의 Title 값 : "+dto.getRtitle());
		request.setAttribute("review", dto);
		
		
	}

}
