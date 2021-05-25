package com.todaylunch.main.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.todaylunch.main.MyUtils;


@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJsp("회원가입", "user/userJoin", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserEntity param = new UserEntity();
		param.setUid(request.getParameter("uid"));
		param.setUnm(request.getParameter("unm"));
		String hashedUpw = BCrypt.hashpw(request.getParameter("upw"), BCrypt.gensalt());
		param.setUpw(hashedUpw);
		UserDAO.joinUser(param);
		
		response.sendRedirect("login");
	}

}
