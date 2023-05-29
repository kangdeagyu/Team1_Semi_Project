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
		int result;
		String view = "";
		String msg;
		SDao dao = new SDao();
		result = dao.loginCheck(cid, cpw);
		
		if(result == 2) {
			view = "login.jsp";
			msg = "탈퇴한 회원입니다.";
			request.setAttribute("msg", msg);
		}else if(result == 1) {
			if(cid.equals("admin")) {
				view = "admin.do";			// 관리자 화면으로 변경
			}else {
				view = "usermain.do";  // 홈 화면으로 변경	
				request.setAttribute("cid", cid);
			}
		}else{
			view = "login.jsp";
			msg = "아이디와 비밀번호를 확인해주세요";
			request.setAttribute("msg", msg);
		}
		request.setAttribute("login", view);
	}

}
