package com.koreait.board7.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;
import com.koreait.board7.cmt.BoardCmtDAO;
import com.koreait.board7.cmt.BoardCmtEntity;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);

		BoardDTO param = new BoardDTO();
		param.setIboard(iboard);
		
		BoardCmtEntity vo = new BoardCmtEntity();
		vo.setIboard(iboard);
		
		request.setAttribute("data", BoardDAO.selBoard(param));
		request.setAttribute("cmtList", BoardCmtDAO.selBoardCmtList(vo));
		MyUtils.openJsp("디테일", "board/boardDetail", request, response);
	}
}
