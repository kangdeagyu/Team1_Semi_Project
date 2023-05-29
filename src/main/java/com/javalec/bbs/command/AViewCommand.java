package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.Kkg_QnA_Dao;
import com.javalec.bbs.dto.Kkg_Answer_Dto;
import com.javalec.bbs.dto.Kkg_Question_Dto;

public class AViewCommand implements SCommand {

	HttpSession session;
	public AViewCommand(HttpSession session) {
		this.session = session;
		
	}
	
	
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub


		int qcode =Integer.parseInt(request.getParameter("qcode"));
			
			Kkg_QnA_Dao dao = new Kkg_QnA_Dao();
			Kkg_Answer_Dto dto_ans  = dao.answer_view(qcode);
			Kkg_Question_Dto dto_que = dao.question_view(qcode);
			
			System.out.println("question_view_command 에서 dto_ans의 Title 값 : "+dto_ans.getAtitle());
			System.out.println("question_view_command 에서 dto_que의 Title 값 : "+dto_que.getQtitle());
			request.setAttribute("answer", dto_ans);
			request.setAttribute("question", dto_que);
		

		
		
	}

}//end
