<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
	body {
	background-color: #ffd7d7;
	}
	
	table, th, td {
		border: 1px solid #b4cde4;
		border-collapse: collapse;
	}
	#container {
		text-align: center;
	}
</style>
</head>
<body>
<div id="container">
	<div>${loginUser.unm}님(${loginUser.uid})환영합니다(❁´◡`❁)</div>
	<div>
		<a href="/user/logout"><button>Logout</button></a> <a href="write"><button>글쓰기</button></a>
	</div>
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>title</th>
				<th>user</th>
				<th>date</th>
			</tr>
			<c:forEach items="${list}" var="item">
				<tr onclick="moveToDetail(${item.iboard})">
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.unm}</td>
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
	<script>
		function moveToDetail(iboard) {
			location.href='/board/detail?iboard='+iboard;
		}
	</script>
</body>
</html>