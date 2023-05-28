package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.Kkg_Review_Dao;
import com.javalec.bbs.dto.Kkg_Review_Dto;

public class RUpdateCommand implements SCommand {

	public RUpdateCommand () {
		
	}
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	

		
		String cid = request.getParameter("cid");
		String rtitle = request.getParameter("rtitle");
		String rcontent = request.getParameter("rcontent");
		int rstar = Integer.parseInt(request.getParameter("rstar"));
		int rcode = Integer.parseInt(request.getParameter("rcode"));
				
		
		
			Kkg_Review_Dao dao = new Kkg_Review_Dao();
			boolean rs  = dao.review_update(cid, rtitle, rcontent, rstar, rcode);
			
			
		System.out.println("reivew_update 결과 : " + rs);
		
		
		
		
	}

}
