<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h1>여기는 게시판</h1>
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>title</th>
				<th>date</th>
			</tr>
			<c:forEach var="item" items="${data}">
			<tr id="record" onclick="goDetail(${item.iboard})">
				<th>${item.iboard}</th>
				<th>${item.title}</th>
				<th>${item.regitime}</th>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<a href="/write">글 쓰기</a>
	</div>
	<script>
		function goDetail(iboard) {
			location.href = "/detail?iboard=" + iboard;
		}
	</script>
</body>
</html>