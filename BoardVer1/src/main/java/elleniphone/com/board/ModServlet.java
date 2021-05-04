package elleniphone.com.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elleniphone.util.board.BoardDAO;
import elleniphone.util.board.BoardVO;
import elleniphone.util.board.Util;


@WebServlet("/mod")
public class ModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int no = Integer.parseInt(iboard);
		
		BoardDAO dao = new BoardDAO();
		request.setAttribute("data", dao.selBoard(no));
		
		Util.goTo(request, response, "mod");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int no = Integer.parseInt(iboard);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setIboard(no);
		vo.setTitle(title);
		vo.setContent(content);
		
		dao.updBoard(vo);
		response.sendRedirect("/list");
	}

}
