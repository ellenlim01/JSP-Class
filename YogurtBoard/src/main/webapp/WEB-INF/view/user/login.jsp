<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="login" method="post">
		<div>
			<input type="text" name="uid" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="upw" placeholder="비밀번호">
		</div>
		<div>
			<input type="submit" value="login">
			<a href="join"><button>Join</button></a>
		</div>
	</form>
</body>
</html>