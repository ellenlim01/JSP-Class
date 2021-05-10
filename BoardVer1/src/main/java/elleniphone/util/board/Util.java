package elleniphone.util.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Util {
	
	public static int getParamInt(String iboard, HttpServletRequest request) {
		return parseStringToInt(request.getParameter(iboard));
	}
	
	public static int parseStringToInt(String strNum) {
		try {
			return Integer.parseInt(strNum);
		} catch (Exception e) {
			return 0;
		}
		
	}

	public static void goTo(HttpServletRequest request, HttpServletResponse response, String jsp)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/" + jsp + ".jsp").forward(request, response);
	}
}
