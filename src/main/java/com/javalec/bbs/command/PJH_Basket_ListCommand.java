package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.SJihwan_Cart_Purchase_Dao;
import com.javalec.bbs.dto.SJihwan_Cart_Purchase_Dto;

public class PJH_Basket_ListCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		SJihwan_Cart_Purchase_Dao dao = new SJihwan_Cart_Purchase_Dao();
		int total=0;
		String cid=(String)session.getAttribute("sid");
		request.setAttribute("cid", cid);
		ArrayList<SJihwan_Cart_Purchase_Dto>dtos = dao.list(cid);
		
		for (SJihwan_Cart_Purchase_Dto dto: dtos) {
			int price = dto.getPprice();
			total +=price;
		}
		
		request.setAttribute("list", dtos);
		request.setAttribute("total", total);
		
		boolean hasSelectedItems = dtos.stream()
                .anyMatch(dto -> dto.isSelected());
        request.setAttribute("hasSelectedItems", hasSelectedItems);
		
	}

}
