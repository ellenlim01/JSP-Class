package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod3")
public class BoardModServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		BoardVO3 data = BoardDAO.selboard(Integer.parseInt(iboard));
		
		request.setAttribute("data", data);
		
		//BoardDAO.modboard(data);
		
		request.getRequestDispatcher("/WEB-INF/view/mod3.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		System.out.println(iboard);
		System.out.println(title);
		System.out.println(ctnt);
		
		BoardVO3 vo = new BoardVO3();
		vo.setIboard(Integer.parseInt(iboard));
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		BoardDAO.updboard(vo);
		
		response.sendRedirect("/detail3?iboard=" + iboard);
	}

}
