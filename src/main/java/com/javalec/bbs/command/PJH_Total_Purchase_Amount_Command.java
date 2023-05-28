package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.SJihwan_Cart_Purchase_Dao;
import com.javalec.bbs.dto.SJihwan_Cart_Purchase_Dto;

public class PJH_Total_Purchase_Amount_Command implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cid = request.getParameter("cid");
		SJihwan_Cart_Purchase_Dao dao = new SJihwan_Cart_Purchase_Dao();
		System.out.println(cid);
		SJihwan_Cart_Purchase_Dto dto=dao.total(cid);
		request.setAttribute("total", dto);
	}

}
