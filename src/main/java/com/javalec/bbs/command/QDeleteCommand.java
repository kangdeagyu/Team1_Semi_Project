package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.Kkg_QnA_Dao;
import com.javalec.bbs.dao.Kkg_Review_Dao;

public class QDeleteCommand implements SCommand {

	HttpSession session;
	
	public QDeleteCommand(HttpSession session) {
		
		this.session = session;
	}
	
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		int qcode = Integer.parseInt(request.getParameter("qcode"));
				
		
		
			Kkg_QnA_Dao dao = new Kkg_QnA_Dao();
			boolean rs  = dao.question_delete(qcode);
			
			
		System.out.println("reivew_update 결과 : " + rs);
		
		
		
		
		
	}

}
