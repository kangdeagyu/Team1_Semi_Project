package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.Kms_UserMain_Dao;

public class Kms_BasketCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String cid=(String)session.getAttribute("sid");
		request.setAttribute("cid", cid);
		String pcode = request.getParameter("pcode");
		int qty = Integer.parseInt(request.getParameter("bqty"));
		
		Kms_UserMain_Dao dao = new Kms_UserMain_Dao();
		dao.basketAction(cid, pcode, qty);
	}

}
