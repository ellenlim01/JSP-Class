<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
	background-color: #ffd7d7;
	}
</style>
</head>
<body>
	<h1>${data.title}</h1>
	<div>${param.iboard}</div>	
	<div>register date: ${data.regdt}</div>
	<div>user: ${data.unm}</div>
	<div>${data.ctnt}</div>
	<c:if test="${loginUser.iuser == data.iuser}">
	<div>
		<a href="del?iboard=${param.iboard}">삭제</a>
		<a href="">수정</a>
	</div>
	</c:if>
</body>
</html>