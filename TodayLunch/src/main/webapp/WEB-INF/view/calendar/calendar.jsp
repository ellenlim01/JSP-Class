<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
	<tr>
		<th colspan="7">${data.year}년 ${data.month}월</th>
	</tr>
<%--
	String[] dates = {"일","월","화","수","목","금","토"};
 --%>	
	<tr>
	<c:forEach items="${dates}" var="date">
		<th>${date}</th>	
	</c:forEach>
	</tr>
	<c:forEach begin="1" end="6" var="i">
	<tr>
		<c:forEach begin="1" end="7" var="j">
			<td id="imsi${(i-1)*7 + j}">
		</c:forEach>
	</tr>
	</c:forEach>
	<tr>
	
	</tr>
</table>
