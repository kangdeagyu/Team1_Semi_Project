package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.Kkg_Review_Dao;
import com.javalec.bbs.dto.Kkg_Review_Dto;
import com.javalec.bbs.homecontroller.Controller;

public class RInsertCommand implements SCommand {
	private HttpSession session;
	
	public RInsertCommand (HttpSession session) {
		this.session = session;
		
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		//int rcode ;
		String cid = session.getAttribute("ID").toString();
		int pcode = Integer.parseInt(request.getParameter("pcode"));
		String rtitle = request.getParameter("rtitle");
		String rcontent = request.getParameter("rcontent");
		int rstar = Integer.parseInt(request.getParameter("rstar"));
				
				
		
		
			Kkg_Review_Dao dao = new Kkg_Review_Dao();
			boolean rs  = dao.review_insert(cid, pcode, rtitle, rcontent, rstar);
			
			
		System.out.println("reivew_insert 결과 : " + rs);
	
			
	
	
		
	}

}
