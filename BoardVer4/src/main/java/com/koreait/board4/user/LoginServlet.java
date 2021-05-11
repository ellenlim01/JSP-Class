package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		if(loginUser != null) {
			response.sendRedirect("/board/list");
			return;
		}
		
		MyUtils.openJsp("user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");

		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpw(upw);
		
		int result = UserDAO.loginUser(vo);
		System.out.println("result : " + result);

		if (result == 1) {
			HttpSession hs = request.getSession();
			vo.setUpw(null);
			hs.setAttribute("loginUser", vo);
			//vo가 가리키는 UserVO객체는 (iuser, uid, unm 값만 담고 있음)
			
			response.sendRedirect("/board/list");
			return;
		}
		String errMsg = null;
		switch (result) {
		case 0:
			errMsg = "에러가 발생했습니다.";
			break;
		case 2:
			errMsg = "아이디를 확인해주세요.";
			break;
		case 3:
			errMsg = "비밀번호를 확인해주세요.";
			break;
		}
		request.setAttribute("errMsg", errMsg);
		doGet(request, response); // 메소드 호출로 해결-> 보낸 주소 값과 받는 주소 값이 같아서 login.jsp까지 감
//		response.sendRedirect("login?err=" + result); 호출하는 순간 주소 값이 이동됨, 위의 request와 다름. query string으로만 값 전달
	
	}
}
