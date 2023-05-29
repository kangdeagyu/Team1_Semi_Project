package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.JDao;

public class JDeleteCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String pcode = request.getParameter("pcode");
		JDao dao = new JDao();
		dao.Delete(pcode);
	}

}
