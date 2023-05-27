package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.SJihwan_UserOrderList_Dao;
import com.javalec.bbs.dto.SJihwan_UserOrderList_Dto;

public class PJH_UserOrderListCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SJihwan_UserOrderList_Dao dao = new SJihwan_UserOrderList_Dao();
		ArrayList<SJihwan_UserOrderList_Dto>dtos = dao.list();
		request.setAttribute("list", dtos);
	}

}
