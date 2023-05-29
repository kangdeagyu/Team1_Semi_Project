package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.JDao;

public class JModify implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String pcode = request.getParameter("pcode");
		String pname = request.getParameter("pname");
		String pprice = request.getParameter("pprice");
		String pimagename = request.getParameter("pimagename");
		String pimage = request.getParameter("pimage");
		
		JDao dao = new JDao();
		dao.modify(pcode, pname, pprice, pimagename, pimage);
	}

}
