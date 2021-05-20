<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script defer src="/res/js/boardList.js?ver=1"></script>
	<!-- defer: 화면을 먼저 띄우라는 의미 -->
<link rel="stylesheet" href="/res/css/boardList.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css
">
</head>
<body>
	<h1>${sessionScope.loginUser.unm}님 환영합니다ヾ(•ω•`)o</h1>
	<h2>게시팜</h2>
	<div>
		<div>
			<table>
				<tr>
					<th>no</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>일시</th>
				</tr>
				<c:forEach items="${requestScope.data}" var="item">
					<tr class="record" onclick="moveToDetail(${item.iboard})">
						<td>${item.iboard}</td>
						<td>${item.title}</td>
						<td>${item.unm}</td>
						<td>${item.regdt}</td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<a href="/board/boardWrite"><button>글 작성</button></a> 
				<a href="/user/userLogout"><button>Logout</button></a>
			</div>
		</div>
	</div>
</body>
</html>