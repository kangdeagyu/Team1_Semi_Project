package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.SJihwan_Cart_Purchase_Dao;
import com.javalec.bbs.dto.SJihwan_Cart_Purchase_Dto;

public class PJH_Basket_ListCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SJihwan_Cart_Purchase_Dao dao = new SJihwan_Cart_Purchase_Dao();
		ArrayList<SJihwan_Cart_Purchase_Dto>dtos = dao.list();
		request.setAttribute("list", dtos);
	}

}