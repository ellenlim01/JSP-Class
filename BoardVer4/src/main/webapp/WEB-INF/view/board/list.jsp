<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<div>${loginUser.unm}님(${loginUser.uid})환영합니다(❁´◡`❁)</div>
	<div>
		<a href="/user/logout"><button>Logout</button></a> <a href="write"><button>글쓰기</button></a>
	</div>
	<div>
		<table>
			<tr>
				<th>title</th>
				<th>user</th>
				<th>date</th>
			</tr>
			<c:forEach items="${list}" var="item">
				<tr>
					<td>${list.title}</td>
					<td>${list.unm}</td>
					<td>${list.regdt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>