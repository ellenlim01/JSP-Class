<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h1>게시팜</h1>
	<div>
		<div>
			<table>
				<tr>
					<th>no</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>일시</th>
				</tr>
				<c:forEach items="${data}" var="item">
					<tr onclick="goToDetail(${item.iboard})">
						<td>${item.iboard}</td>
						<td>${item.title}</td>
						<td>${item.unm}</td>
						<td>${item.regdt}</td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<a href="/board/boardWrite"><button>글 작성</button></a>
			</div>
		</div>
	</div>
	<script>
		function goToDetail(iboard) {
			location.href = "/board/boardDetail?iboard=" + iboard;
		}
	</script>
</body>
</html>