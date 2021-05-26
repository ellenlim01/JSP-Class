package com.todaylunch.main.calendar;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todaylunch.main.MyUtils;


@WebServlet("/calendar")
public class CalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar cal = Calendar.getInstance();
		CalendarEntity ce = new CalendarEntity();
		ce.setLastDay(cal.getActualMaximum(Calendar.DATE));
		ce.setYear(cal.get(Calendar.YEAR));
		ce.setMonth(cal.get(Calendar.MONTH)+1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		ce.setFirstDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));
		
		request.setAttribute("data", ce);
		String[] dates = {"일","월","화","수","목","금","토"};
		request.setAttribute("dates", dates);
		
		MyUtils.openJsp("calendar", "calendar/calendar", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
