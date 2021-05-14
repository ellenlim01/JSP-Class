<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	<h1>${data.title}</h1>
	<div>등록일 : ${data.regdt}</div>
	<div>글쓴이 : ${data.unm}</div>
	<div>내용 : ${data.ctnt}</div>
	<div>
		<a href="/board/boardList"><button>리스트</button></a>
	</div>
</body>
</html>