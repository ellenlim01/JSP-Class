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
	#btn {
		background-color: #b4cde4;
		border: none;
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
		<a href="mod?iboard=${param.iboard}">수정</a>
		<a href="list"><button id="btn">글 목록</button></a>
	</div>
	</c:if>
</body>
</html>