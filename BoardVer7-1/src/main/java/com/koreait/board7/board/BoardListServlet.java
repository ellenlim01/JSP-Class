package com.koreait.board7.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDTO param = new BoardDTO();
		//페이징
		final int recordCnt = 5;
		int cPage = MyUtils.getParamInt("cPage", request);
		if(cPage == 0) {//query string 이 없어서 error 발생 or 내가 0을 보냈거나
			cPage = 1;
		}
		int startIdx = (cPage - 1) * recordCnt;
		param.setRecordCnt(startIdx);
		param.setRecordCnt(recordCnt);
		
		//검색
		int searchType = MyUtils.getParamInt("searchType", request);
		String searchText = request.getParameter("searchText");
		
		if(searchType != 0 && searchText != null && !searchText.equals("")) {
			
		}
		request.setAttribute("pagingCnt", BoardDAO.selPagingCnt(param));
		request.setAttribute("list", BoardDAO.selBoardList(param));
		MyUtils.openJsp("리스트", "board/boardList", request, response);
		
	}

}
