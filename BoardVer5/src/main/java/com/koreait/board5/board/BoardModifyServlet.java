package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;


@WebServlet("/board/boardModify")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int iboard = MyUtils.parseStringToInt("iboard");
		int iuser = MyUtils.getLoginUserPk(request);
		BoardVO param = new BoardVO();
		param.setIboard(iboard);
		param.setIuser(iuser);
		request.setAttribute("data", BoardDAO.selBoard(param));
		MyUtils.openJsp("board/boardModify", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
