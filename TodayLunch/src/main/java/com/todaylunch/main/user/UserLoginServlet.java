package com.todaylunch.main.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.todaylunch.main.MyUtils;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserEntity loginUser = MyUtils.getLoginUser(request);
		if(loginUser != null) {
			response.sendRedirect("/calendar");
			return;
		}
		MyUtils.openJsp("로그인", "user/userLogin", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		UserEntity param = new UserEntity();
		param.setUid(uid);
		
		UserEntity result = UserDAO.selUser(param);
		
		if(result == null) { //아이디 없음
			request.setAttribute("errMsg", "아이디가 없습니다.");
		} else if(BCrypt.checkpw(upw, result.getUpw())) {//로그인 성공
			result.setUpw(null);
			HttpSession hs = request.getSession();
			hs.setAttribute("loginUser", result);

			response.sendRedirect("/calendar");
			return;
		} else {
			request.setAttribute("errMsg", "비밀번호를 확인해주세요.");
		}
		doGet(request, response);
	}

}
