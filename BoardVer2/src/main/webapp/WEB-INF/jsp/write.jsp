<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.ctnt {
		width: 80%;
		height: 80%;
	}
</style>
<title>글 쓰기</title>
</head>
<body>
	<h1>글 쓰기</h1>
	<form action="/write" method="post">
		<div>
			제목: <input type="text" name="title">	
		</div>
		<div id="ctnt">
			내용: <textarea name="ctnt" rows="10" cols="10"></textarea>
		</div>
		<div>
			<input type="submit" value="등록">
		</div>
	</form>

</body>
</html>