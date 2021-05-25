package com.todaylunch.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todaylunch.main.user.UserEntity;


public class MyUtils {
	public static void openJsp(String title, String jsp, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", title);
		request.setAttribute("jsp", jsp);
		request.getRequestDispatcher("/WEB-INF/view/template.jsp").forward(request, response);
	}

	public static int parseStringToInt(String val) {
		try {
			int result = Integer.parseInt(val);
			return result;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static int getParamInt(String key, HttpServletRequest request) {
		int value = parseStringToInt(request.getParameter(key));
		return value;
	}
	
	public static UserEntity getLoginUser(HttpServletRequest req) {
		if(req == null) {
			return null;
		}
		
		HttpSession hs = req.getSession();
		return (UserEntity) hs.getAttribute("loginUser");
	}
	
	public static int getLoginUserPk(HttpServletRequest request) {
		if(request == null) {
			return 0;
		}
		
		return getLoginUser(request).getIuser();
	}
}
