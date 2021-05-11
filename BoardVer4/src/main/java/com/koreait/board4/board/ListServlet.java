package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserDAO;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("/user/login");
			return;
		} 
		
		MyUtils.openJsp("board/list", request, response);
			
//		Boolean loginSuccess = (Boolean) hs.getAttribute("loginSuccess");
//		System.out.println("loginSuccess: " + loginSuccess);
//		if (loginSuccess == null || loginSuccess == false) {    
//			response.sendRedirect("/user/login");
//			return;
//		}
	}
}