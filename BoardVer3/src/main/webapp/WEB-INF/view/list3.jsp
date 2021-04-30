<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
.record {
	cursor: pointer;
}
table, td, th {
	border: 1px solid black;
	border-collapse: collapse;
}
.record:hover {
	background-color: goldenrod;
}
</style>
</head>
<body>
	<div>
		<a href="/write3">글 쓰기</a>
	</div>
	<div>
		<table>
			<tr>
				<td>no</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
			
			<c:forEach items="${list}" var="item">
				<tr class="record" onclick="moveToDetail(${item.iboard});">
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>
		</table>
	<script>
		function moveToDetail(iboard) {
			//console.log('iboard: %d', iboard);
			location.href = '/detail3?iboard=' + iboard;
		}
	</script>
	</div>
</body>
</html>