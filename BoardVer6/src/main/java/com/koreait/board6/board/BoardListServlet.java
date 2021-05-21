package com.koreait.board6.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board6.MyUtils;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = MyUtils.getParamInt("page", request);
		if(page == 0) {//query string 안보냈을 때, 만약을 생각해서 쓴 것
			page = 1;
		}
		int recordCnt = 3;
		int sIdx = (page - 1) * recordCnt;
		
		BoardVO param = new BoardVO();
		param.setsIdx(sIdx);
		param.setPage(recordCnt);
		
		request.setAttribute("list", BoardDAO.selBoardList(param));
		
		MyUtils.openJsp("리스트", "board/boardList", request, response);
	}

}