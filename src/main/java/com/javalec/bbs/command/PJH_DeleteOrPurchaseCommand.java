package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.SJihwan_Cart_Purchase_Dao;

public class PJH_DeleteOrPurchaseCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		String action = request.getParameter("action");
		String cid=(String)session.getAttribute("sid");
		
		
		
		
		String[] selectedItems = request.getParameterValues("selectedItems");
			if(action.equals("삭제")) {
	                for (String bcode : selectedItems) {
	                	 SJihwan_Cart_Purchase_Dao dao = new SJihwan_Cart_Purchase_Dao();
	     		        dao.delete(bcode);
	     		    }
	        } else if (action.equals("구매")) {
	            // 구매 버튼이 클릭되었을 때 수행할 동작을 구현합니다.
	            if (selectedItems != null) {
	                for (String bcode : selectedItems) {
	                	String pcode = request.getParameter("pcode"+bcode);
	            		String qty= request.getParameter("bqty"+bcode);
	                	SJihwan_Cart_Purchase_Dao dao = new SJihwan_Cart_Purchase_Dao();
	                    dao.purchase(cid, pcode, qty);
	                }
	            }
	        }
		    }
		}
