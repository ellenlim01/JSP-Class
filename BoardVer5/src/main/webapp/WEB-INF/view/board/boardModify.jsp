<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
	<h1>굴 수정</h1>
	<form action="boardModify" method="post">
		<input type="hidden" name="iboard" value="${requestScope.data.iboard}">
		<div>
			<input type="text" name="title" value="${data.title}">
		</div>
		<div>
			<input type="text" name="ctnt" value="${data.ctnt}">
		</div>
		<input type="submit" value="수정">
	</form>
	<a href="/board/boardList"><button>리스트</button></a>
</body>
</html>