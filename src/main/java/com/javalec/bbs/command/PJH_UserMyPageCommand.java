package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.SJihwan_MyPage_Dao;
import com.javalec.bbs.dto.SJihwan_MyPage_Dto;

public class PJH_UserMyPageCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cid = request.getParameter("cid");
		SJihwan_MyPage_Dao dao = new SJihwan_MyPage_Dao();
		SJihwan_MyPage_Dto dto = dao.contentView(cid);
		
		request.setAttribute("content_view", dto);
	}

}
