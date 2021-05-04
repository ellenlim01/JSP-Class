<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/detail" method="post">
		<div>제목 : ${data.title}</div>
		<div>작성일 : ${data.regitime}</div>
		<div>내용 : ${data.content}</div>
		<br> 
		<span> 
			<a href ="/mod?iboard=${data.iboard}"><input type="submit" value="수정"></a>

		</span>
	</form>
</body>
</html>