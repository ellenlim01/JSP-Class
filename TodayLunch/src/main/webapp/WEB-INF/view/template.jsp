<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${requestScope.title}</title>
</head>
<body>
	<header>
		<h1>TODAY'S LUNCH</h1>
		<c:if test="${not empty sessionScope.loginUser}">
			<a href="/user/logout"><button>로그아웃</button></a>
		</c:if>
	</header>
	<section>
		<jsp:include page="/WEB-INF/view/${requestScope.jsp}.jsp"></jsp:include>
	</section>
</body>
</html>