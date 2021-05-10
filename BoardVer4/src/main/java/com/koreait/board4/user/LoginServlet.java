package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;


@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJsp("user/login", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		UserVO vo = new UserVO();
		
		vo.setUid(uid);
		vo.setUpw(upw);
		
		int result = UserDAO.loginUser(vo);
		System.out.println("result : " + result);
		switch (result) {
		case 1:
			response.sendRedirect("/board/list");
			break;
		default:
			doGet(request, response); //메소드 호출로 해결-> 보낸 주소 값과 받는 주소 값이 같아서 login.jsp까지 감
//			response.sendRedirect("login?err=" + result); 호출하는 순간 주소 값이 이동됨, 위의 request와 다름. query string으로만 값 전달
			break;
		}
	}

}
