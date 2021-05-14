package com.koreait.board5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board5.user.UserVO;

public class MyUtils {
	public static UserVO getLoginUser(HttpServletRequest req) {
		if(req == null) {
			return null;
		}
		
		HttpSession hs = req.getSession();
		return (UserVO) hs.getAttribute("loginUser");
	}
	
	public static int getLoginUserPk(HttpServletRequest request) {
		if(request == null) {
			return 0;
		}
		
		return getLoginUser(request).getIuser();
	}
	
	public static void openJsp(String fileNm, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/" + fileNm + ".jsp").forward(request, response);
	}
	
	public static int parseStringToInt(String val) {
		try {
			int result = Integer.parseInt(val);
			return result;
		} catch(Exception e) {
			return 0;
		}
	}

	public static int getParamInt(String key, HttpServletRequest request) {
		int value = parseStringToInt(request.getParameter(key));
		return value;
	}

}
