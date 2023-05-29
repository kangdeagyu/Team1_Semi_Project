package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.SJihwan_UserOrderList_Dao;
import com.javalec.bbs.dto.SJihwan_UserOrderList_Dto;

public class PJH_UserOrderListCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String cid=(String)session.getAttribute("sid");
		request.setAttribute("cid", cid);
		SJihwan_UserOrderList_Dao dao = new SJihwan_UserOrderList_Dao();
		ArrayList<SJihwan_UserOrderList_Dto>dtos = dao.list(cid);
		int total = 0;
		for (SJihwan_UserOrderList_Dto dto : dtos) {
			dto.setCname((String) session.getAttribute("cname"));
			int price = dto.getPprice();
			total +=price;
		}
		
		request.setAttribute("olist", dtos);
		request.setAttribute("total", total);
	}

}
