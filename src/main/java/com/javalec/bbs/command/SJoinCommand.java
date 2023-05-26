package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.SDao;

public class SJoinCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			String cid = request.getParameter("cid");
			String cpw = request.getParameter("cpw");
			String cname = request.getParameter("cname");
			String ctelno = request.getParameter("ctelno");
			String caddress = request.getParameter("caddress");
			String cemail = request.getParameter("cemail");
			
			SDao dao = new SDao();
			dao.join(cid, cpw, cname, ctelno, caddress, cemail);
	}

}
