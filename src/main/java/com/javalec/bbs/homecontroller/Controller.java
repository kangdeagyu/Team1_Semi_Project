package com.javalec.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.command.AViewCommand;
import com.javalec.bbs.command.AWriteCommand;
import com.javalec.bbs.command.JListCommand;
import com.javalec.bbs.command.Kms_BasketCommand;
import com.javalec.bbs.command.Kms_ListCommand;
import com.javalec.bbs.command.Kms_UserBuyCommand;
import com.javalec.bbs.command.Kms_UserSearchCommand;
import com.javalec.bbs.command.PJH_Basket_ListCommand;
import com.javalec.bbs.command.PJH_DeleteOrPurchaseCommand;
import com.javalec.bbs.command.PJH_UserMyPageCommand;
import com.javalec.bbs.command.PJH_UserOrderListCommand;
import com.javalec.bbs.command.QDeleteCommand;
import com.javalec.bbs.command.QInsertCommand;
import com.javalec.bbs.command.QListCommand;
import com.javalec.bbs.command.QUpdateCommand;
import com.javalec.bbs.command.QViewCommand;
import com.javalec.bbs.command.RDeleteCommand;
import com.javalec.bbs.command.RInsertCommand;
import com.javalec.bbs.command.RListCommand;
import com.javalec.bbs.command.RUpdateCommand;
import com.javalec.bbs.command.RViewCommand;
import com.javalec.bbs.command.RWriteCommand;
import com.javalec.bbs.command.SCommand;
import com.javalec.bbs.command.SJoinCommand;
import com.javalec.bbs.command.SLoginCommand;
import com.mysql.cj.Session;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		
		String viewPage = null;
		SCommand command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		
		String com = uri.substring(conPath.length());
	
		
		switch (com) {
		case("/loginview.do"):
			viewPage = "login.jsp";
			break;
		case ("/login.do"):
			command = new SLoginCommand();
			command.execute(request, response);
			session.setAttribute("sid", (String)request.getAttribute("cid"));
			viewPage = (String)request.getAttribute("login");
			break;
		case ("/joinview.do"):
			viewPage = "join.jsp";
			break;
		case("/join.do"):
			command = new SJoinCommand();
			command.execute(request, response);
			viewPage = (String)request.getAttribute("join");
			break;
		case("/usermain.do"):
			command = new Kms_ListCommand();
			command.execute(request, response);
			viewPage = "Kms_UserMain.jsp";
			break;
		case("/search.do"):
			command = new Kms_UserSearchCommand();
			command.execute(request, response);
			viewPage = "Kms_UserMain.jsp";
			break;
		case("/buy.do"):
			command = new Kms_UserBuyCommand();
			command.execute(request, response);
			viewPage = "Kms_userbuy.jsp";
			break;
		case("/basket.do"):
			command = new Kms_BasketCommand();
			command.execute(request, response);
			viewPage = "cartlist.do";
			break;
		case("/cartlist.do"):
			command = new PJH_Basket_ListCommand();
			command.execute(request, response);
			viewPage = "PJH_basketlist.jsp";
			break;
		case("/mypage.do"):
			command = new PJH_UserMyPageCommand();
			command.execute(request, response);
			viewPage = "PJH_MyPage.jsp";
			break;
		case("/userorderlist.do"):
			command = new PJH_UserOrderListCommand();
			command.execute(request, response);
			viewPage = "PJH_userOrderList.jsp";
		break;
		case("/admin.do"):
			command = new JListCommand();
			command.execute(request, response);
			viewPage = "admin.jsp";
			break;
		case("/deleteOrPurchase.do"):
			command = new PJH_DeleteOrPurchaseCommand();
			command.execute(request, response);
			viewPage = "cartlist.do";
			viewPage = "PJH_userOrderList.jsp";
		break;
		case ("/reviewlist.do"):
			System.out.println("컨트롤러 스위치 안에 들어왔음.");
			command = new RListCommand();
			System.out.println("커맨드 선언 되었음");
			command.execute(request, response);
			System.out.println("커맨드 실행 완료 되었음.");
			viewPage = "reviewList.jsp";
			System.out.println("다음 화면 입력 되었음.");
			break;
			
			
		case ("/review_view.do"):			

			System.out.println("리뷰내용보기 스위치 안에 들어왔음.");
			command = new RViewCommand();
			System.out.println("리뷰내용보기 커맨드 선언 되었음");
			command.execute(request, response);
			System.out.println("리뷰내용보기 커맨드 실행 완료 되었음.");
			viewPage = "review_view.jsp";
			System.out.println("리뷰내용보기 다음 화면 입력 되었음.");
			break;
			
		case ("/review_write.do"):
			System.out.println("리뷰작성 스위치 안에 들어왔음.");
			command = new RWriteCommand(session);
			//System.out.println("리뷰작성 커맨드 선언 되었음");
			command.execute(request, response);
			System.out.println("리뷰작성 커맨드 실행 완료 되었음.");
			viewPage = "review_write.jsp";
			System.out.println("리뷰작성 다음 화면 입력 되었음.");
			break;
			
		case("/review_insert.do"):
			System.out.println("리뷰수정하기 스위치 안에 들어왔음.");
			command = new RInsertCommand(session);
			System.out.println("리뷰수정하기 커맨드 선언 되었음");
			command.execute(request, response);
			System.out.println("리뷰수정하기 커맨드 실행 완료 되었음.");
			//viewPage = "reviewlist.do?pcode="+request.getParameter("pcode");
			viewPage = "review_temp_start.jsp";

			System.out.println("리뷰수정하기 다음 화면 입력 되었음.");
			break;
			
			
			
			
		case("/review_update.do"):
			viewPage = "review_update.jsp";
			System.out.println("리뷰업데이트 다음 화면 입력 되었음.");
			break;
			
			
		case("/review_update_execute.do"):
			System.out.println("리뷰수정하기 스위치 안에 들어왔음.");
			command = new RUpdateCommand();
			System.out.println("리뷰수정하기 커맨드 선언 되었음");
			command.execute(request, response);
			System.out.println("리뷰수정하기 커맨드 실행 완료 되었음.");
			//viewPage = "reviewlist.do?pcode="+request.getParameter("pcode");
			viewPage = "review_temp_start.jsp";
			System.out.println("리뷰수정하기 다음 화면 입력 되었음.");
			break;
	
		case("/review_delete.do"):
			System.out.println("리뷰삭제 스위치 안에 들어왔음.");
			command = new RDeleteCommand();
			System.out.println("리뷰삭제 커맨드 선언 되었음");
			command.execute(request, response);
			System.out.println("리뷰삭제 커맨드 실행 완료 되었음.");
			//viewPage = "reviewlist.do?pcode="+request.getParameter("pcode");
			viewPage = "review_temp_start.jsp";

			System.out.println("리뷰삭제 다음 화면 입력 되었음.");
			break;
			
			
		case("/Q_Write.do"):
			viewPage = "Q_Write.jsp";
			System.out.println("Q_Write.do 다음 화면 입력 되었음.");
			break;

		case("/Q_Insert.do"):

			System.out.println("Q_Insert 스위치 안에 들어왔음.");
			command = new QInsertCommand(session);
			System.out.println("Q_Insert 커맨드 선언 되었음");
			command.execute(request, response);
			System.out.println("Q_Insert 커맨드 실행 완료 되었음.");
			
			
			viewPage = "review_temp_start.jsp";

			System.out.println("Q_Insert 다음 화면 입력 되었음.");
			break;
		
		case("/Q_list.do"):
			System.out.println("Q_list 스위치 안에 들어왔음.");
			command = new QListCommand(session);
			System.out.println("q_list 선언 되었음");
			command.execute(request, response);
			System.out.println("q_list 실행 완료 되었음.");
			viewPage = "q_List.jsp";
			System.out.println("다음 화면 입력 되었음.");
			break;

			
		case("/question_view.do"):
			System.out.println("question_view.do 스위치 안에 들어왔음.");
			command = new QViewCommand(session);
			System.out.println("question_view.do 커맨드 선언 되었음");
			command.execute(request, response);
			System.out.println("question_view.do 커맨드 실행 완료 되었음.");
			viewPage = "Q_view.jsp";
			System.out.println("question_view.do 다음 화면 입력 되었음.");
			break;
			
		case("/question_update.do"):
			viewPage = "question_update.jsp";
			System.out.println("리뷰업데이트 다음 화면 입력 되었음.");
			break;
			
			
		case("/question_update_execute.do"):
			System.out.println("리뷰수정하기 스위치 안에 들어왔음.");
			command = new QUpdateCommand(session);
			System.out.println("리뷰수정하기 커맨드 선언 되었음");
			command.execute(request, response);
			System.out.println("리뷰수정하기 커맨드 실행 완료 되었음.");
			//viewPage = "reviewlist.do?pcode="+request.getParameter("pcode");
			viewPage = "review_temp_start.jsp";
			System.out.println("리뷰수정하기 다음 화면 입력 되었음.");
			
			
			break;
			
			
			
		case("/question_delete.do"):  
			
			System.out.println("질문삭제 스위치 안에 들어왔음.");
			command = new QDeleteCommand(session);
			System.out.println("질문삭제 커맨드 선언 되었음");
			command.execute(request, response);
			System.out.println("질문삭제 커맨드 실행 완료 되었음.");
			//viewPage = "reviewlist.do?pcode="+request.getParameter("pcode");
			viewPage = "review_temp_start.jsp";

			System.out.println("질문삭제 다음 화면 입력 되었음.");
			break;
			
		case("/answer_view.do"):
			System.out.println("answer_view.do 스위치 안에 들어왔음.");
			command = new AViewCommand(session);
			System.out.println("answer_view.do 커맨드 선언 되었음");
			command.execute(request, response);
			System.out.println("answer_view.do 커맨드 실행 완료 되었음.");
			viewPage = "A_view.jsp";
			System.out.println("answer_view.do 다음 화면 입력 되었음.");
			break;
			
			
		case("/admin_q_list.do"):
			System.out.println("admin_q_list 스위치 안에 들어왔음.");
			command = new QListCommand(session);
			System.out.println("admin_q_list 선언 되었음");
			command.execute(request, response);
			System.out.println("admin_q_list 실행 완료 되었음.");
			viewPage = "q_List_admin.jsp";
			System.out.println("다음 화면 입력 되었음.");
			break;
			
		case("/question_check_view.do"): //
			System.out.println("question_check.do 스위치 안에 들어왔음.");
			command = new QViewCommand(session);
			System.out.println("question_check.do 커맨드 선언 되었음");
			command.execute(request, response);
			System.out.println("question_check.do 커맨드 실행 완료 되었음.");
			viewPage = "Q_check_view.jsp";
			System.out.println("question_check.do 다음 화면 입력 되었음.");
			break;
			
		case("/answer_write.do"):
			
			System.out.println("answer_write.do 스위치 안에 들어왔음.");
			command = new AViewCommand(session);
			System.out.println("answer_write.do 커맨드 선언 되었음");
			command.execute(request, response);
			System.out.println("answer_write.do 커맨드 실행 완료 되었음.");
			viewPage = "A_write.jsp";
			System.out.println("answer_write.do 다음 화면 입력 되었음.");
			

			break;
			
		case("/A_insert.do"):
			System.out.println("answer_insert.do 스위치 안에 들어왔음.");
			command = new AWriteCommand(session);
			System.out.println("answer_insert.do 커맨드 선언 되었음");
			command.execute(request, response);
			System.out.println("answer_insert.do 커맨드 실행 완료 되었음.");
			viewPage = "review_temp_start.jsp";
			System.out.println("answer_insert.do 다음 화면 입력 되었음.");
			break;
		}
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
}// end