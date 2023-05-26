package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.SDao;

public class SLoginCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String sid = request.getParameter("sid");
		String spw = request.getParameter("spw");
		boolean result;
		String view = "";
		String msg = "";
	
		SDao dao = new SDao();
		result = dao.loginCheck(sid, spw);
		
		if(result == true) {
			view = "login.jsp";
		}else {
			view = "login.jsp";
			msg = "아이디와 비밀번호를 확인해주세요";
		}
		request.setAttribute("login", view);
		request.setAttribute("msg", msg);
	}

}
