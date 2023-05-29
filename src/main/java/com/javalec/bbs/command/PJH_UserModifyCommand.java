package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.SJihwan_MyPage_Dao;

public class PJH_UserModifyCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String cid=(String)session.getAttribute("sid");
		request.setAttribute("cid", cid);
		
		
		String cpw= request.getParameter("cpw");
		String cname= request.getParameter("cname");
		String ctelno= request.getParameter("ctelno");
		String caddress= request.getParameter("caddress");
		String cemail= request.getParameter("cemail");
		SJihwan_MyPage_Dao dao = new SJihwan_MyPage_Dao();
		dao.modify(cpw, cname, ctelno, caddress, cemail, cid);
	}

}
