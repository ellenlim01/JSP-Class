<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
</head>
<body>
	<h1>글 작성</h1>
	<form action="/write" method="post">
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			내용 :
			<textarea name="content"></textarea>
		</div>
		<div>
			<input type="submit" value="등록"> 
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>