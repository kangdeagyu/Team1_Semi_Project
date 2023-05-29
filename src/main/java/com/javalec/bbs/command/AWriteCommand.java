package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.Kkg_QnA_Dao;

public class AWriteCommand implements SCommand {

	
	HttpSession session;
	public AWriteCommand(HttpSession session) {
				this.session= session; 
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		//atitle / acode / acontent 가져옴.
		int acode = Integer.parseInt(request.getParameter("acode"));
		String atitle = request.getParameter("atitle");
		String acontent = request.getParameter("acontent");
		String aid = session.getAttribute("ID").toString();
		
		Kkg_QnA_Dao dao = new Kkg_QnA_Dao();
		boolean rs  = dao.a_insert(acode, atitle, acontent, aid);
		
		
		System.out.println("reivew_insert 결과 : " + rs);
	
	
	
	
	
	}

}//end
