package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.Kkg_Review_Dao;

public class RDeleteCommand implements SCommand {

	public RDeleteCommand() {
		
	}
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
		String cid = request.getParameter("cid");
		int rcode = Integer.parseInt(request.getParameter("rcode"));
				
		
		
			Kkg_Review_Dao dao = new Kkg_Review_Dao();
			boolean rs  = dao.review_delete(rcode);
			
			
		System.out.println("reivew_update 결과 : " + rs);
		
			
		
		
		
		
		

	}

}
