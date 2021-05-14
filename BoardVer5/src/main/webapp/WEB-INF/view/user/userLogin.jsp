<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div>${errMsg}</div>
	<form action="userLogin" method="post">
		<div>
			<input type="text" name="uid" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="upw" placeholder="비밀번호">
		</div>
		<span>
			<input type="submit" value="Login">
		</span>
	</form>
			<a href="userJoin"><button>Join</button></a>
</body>
</html>