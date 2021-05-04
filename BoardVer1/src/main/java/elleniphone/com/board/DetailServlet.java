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


@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int no = Integer.parseInt(iboard);
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.selBoard(no);
		request.setAttribute("data", vo);
		
		Util.goTo(request, response, "detail");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
