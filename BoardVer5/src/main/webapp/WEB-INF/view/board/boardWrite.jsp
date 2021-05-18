<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
</head>
<body>
	<h1>굴 작성</h1>
	<form action="boardWrite" method="post">
		<div>
			<input type="text" name="title" placeholder="제목">
		</div>
		<div>
			<input type="text" name="ctnt" placeholder="내용">
		</div>
		<input type="submit" value="등록">
	</form>
		<a href="/board/boardList"><button>리스트</button></a>
</body>
</html>