package com.javalec.bbs.command;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.Kkg_QnA_Dao;
import com.javalec.bbs.dao.Kkg_Review_Dao;
import com.javalec.bbs.dto.Kkg_Answer_Dto;
import com.javalec.bbs.dto.Kkg_Question_Dto;
import com.javalec.bbs.dto.Kkg_Review_Dto;

public class QListCommand implements SCommand {

	HttpSession session;
	public QListCommand (HttpSession session) {
		this.session=session;
	}
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		String q_cid =session.getAttribute("ID").toString();
		System.out.println(q_cid);
		System.out.println(q_cid.substring(0,5));
		Kkg_QnA_Dao dao = new Kkg_QnA_Dao();

		
		
		if(q_cid.substring(0,5).equals("admin")) {
			
			ArrayList<Kkg_Question_Dto> dtos  = dao.admin_q_list();
			System.out.println("QListcommand 클래스에서 dots의 크기 "+dtos.size());
			request.setAttribute("qList", dtos);
		}
		
		else
		
		{
		
		

			ArrayList<Kkg_Question_Dto> dtos  = dao.q_list(q_cid);
			
	//		public Kkg_Answer_Dto(int acode, int a_qcode, String a_aid, String atitle, String acontent, Timestamp adate, Timestamp adeldate) {
	
			//ArrayList<Kkg_Answer_Dto> acode =dao.a_list; 
			
			
			System.out.println("QListcommand 클래스에서 dots의 크기 "+dtos.size());
			request.setAttribute("qList", dtos);
			}
		
		
		
		
		
		
		
		//request.setAttribute("acode",acode);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
