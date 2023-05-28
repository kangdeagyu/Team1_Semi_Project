package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.Kkg_Review_Dao;
import com.javalec.bbs.dto.Kkg_Review_Dto;

public class RWriteCommand implements SCommand {

	String id ;
	

	
	public RWriteCommand(String id) {
		super();
		this.id = id;
	}



	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		
//		
//	int rcode =Integer.parseInt(request.getParameter("rcode"));
//		
//		Kkg_Review_Dao dao = new Kkg_Review_Dao();
//		Kkg_Review_Dto dto  = dao.review_view(rcode);
//		
//		System.out.println("reivew_view_command 에서 dot의 Title 값 : "+dto.getRtitle());
//		request.setAttribute("review", dto);
//		

		
		
		
		
		
		
	}

}
