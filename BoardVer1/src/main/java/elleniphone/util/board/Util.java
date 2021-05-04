package elleniphone.util.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Util {
	
	public static void goTo(HttpServletRequest request, HttpServletResponse response, String jsp) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/"+ jsp +".jsp").forward(request, response);
	}
}
