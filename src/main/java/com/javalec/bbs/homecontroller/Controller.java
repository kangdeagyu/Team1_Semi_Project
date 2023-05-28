package com.javalec.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.command.Kms_BasketCommand;
import com.javalec.bbs.command.Kms_ListCommand;
import com.javalec.bbs.command.Kms_UserBuyCommand;
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
		case("/buy.do"):
			command = new Kms_UserBuyCommand();
			command.execute(request, response);
			viewPage = "userbuy.jsp";
			break;
		case("/basket.do"):
			command = new Kms_BasketCommand();
			command.execute(request, response);
			viewPage = "cartlist.do";
			break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
}// end