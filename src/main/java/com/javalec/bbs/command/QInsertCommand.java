package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.Kkg_QnA_Dao;
import com.javalec.bbs.dao.Kkg_Review_Dao;

public class QInsertCommand implements SCommand {
	
	HttpSession session ;
	
	
	public QInsertCommand(HttpSession session ) {
		this.session = session;
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		String q_cid = session.getAttribute("ID").toString();
		String qtitle = request.getParameter("qtitle");
		String qcontent = request.getParameter("qcontent");
		
			Kkg_QnA_Dao dao = new Kkg_QnA_Dao();
			boolean rs  = dao.q_insert(q_cid, qtitle, qcontent);
			
			
		System.out.println("reivew_insert 결과 : " + rs);
	
		
		
		
		
		
		
		
		
		
		
	}

}
