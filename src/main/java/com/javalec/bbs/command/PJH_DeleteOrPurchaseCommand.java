package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.SJihwan_Cart_Purchase_Dao;

public class PJH_DeleteOrPurchaseCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String[] selectedItems = request.getParameterValues("selectedItems");
			if(action.equals("삭제")) {
	                for (String bcode : selectedItems) {
	                	 SJihwan_Cart_Purchase_Dao dao = new SJihwan_Cart_Purchase_Dao();
	     		        dao.delete(bcode);
	     		    }
	        } else if (action.equals("구매")) {
	            // 구매 버튼이 클릭되었을 때 수행할 동작을 구현합니다.
	            if (selectedItems != null) {
	                for (String selectedItem : selectedItems) {
	                    // 선택된 상품을 구매하는 동작을 수행합니다.
	                    // selectedItem 변수를 활용하여 해당 상품을 구매하는 로직을 작성합니다.
	                }
	            }
	        }
		    for (String bcode : selectedItems) {
		        SJihwan_Cart_Purchase_Dao dao = new SJihwan_Cart_Purchase_Dao();
		        
		        dao.delete(bcode);
		    }
	}

}
