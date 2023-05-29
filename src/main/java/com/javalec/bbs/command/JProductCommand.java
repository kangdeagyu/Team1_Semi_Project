package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.JDao;
import com.javalec.bbs.dto.JDto;

public class JProductCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		 JDao dao = new JDao();
	      ArrayList<JDto> dtos = dao.product();
	      request.setAttribute("product", dtos);
	}

}
