package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.Kkg_QnA_Dao;
import com.javalec.bbs.dao.Kkg_Review_Dao;
import com.javalec.bbs.dto.Kkg_Question_Dto;
import com.javalec.bbs.dto.Kkg_Review_Dto;


public class QViewCommand implements SCommand {

	HttpSession session;
	
	public QViewCommand(HttpSession session) {
		this.session = session;
		
	}
	
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	int qcode =Integer.parseInt(request.getParameter("qcode"));
		
		Kkg_QnA_Dao dao = new Kkg_QnA_Dao();
		Kkg_Question_Dto dto  = dao.question_view(qcode);
		
		System.out.println("question_view_command 에서 dot의 Title 값 : "+dto.getQtitle());
		request.setAttribute("question", dto);
	
	
	
	
	
	
	}

}//end
