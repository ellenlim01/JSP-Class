<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
body {
	background-color: #ffd7d7;
}
.ddong {
background-color: #b4cde4;
border:none
}

</style>
</head>
<body>
	<div>
		<div>
			<form>
				<div><input class="ddong" type="text" name="uid" placeholder="아이디"></div>
				<div><input class="ddong" type="password" name="upw" placeholder="비밀번호"></div>
				<div>
					<input class="ddong" type="submit" value="Login">
				</div>
			</form>
		</div>
		<div>
			<a href="join"><button class="ddong">Join</button></a>
		</div>
	</div>
</body>
</html>