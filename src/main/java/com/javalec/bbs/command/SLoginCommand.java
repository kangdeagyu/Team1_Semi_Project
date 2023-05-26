package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.SDao;

public class SLoginCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cid = request.getParameter("cid");
		String cpw = request.getParameter("cpw");
		boolean result;
		String view = "";
		String msg;
	
		SDao dao = new SDao();
		result = dao.loginCheck(cid, cpw);
		
		if(result == true) {
			if(cid.equals("admin")) {
				view = "login.jsp";			// 관리자 화면으로 변경
			}else {
				view = "login.jsp";			// 홈 화면으로 변경		
			}
		}else {
			view = "login.jsp";
			msg = "아이디와 비밀번호를 확인해주세요";
			request.setAttribute("msg", msg);
		}
		request.setAttribute("login", view);
	}

}
