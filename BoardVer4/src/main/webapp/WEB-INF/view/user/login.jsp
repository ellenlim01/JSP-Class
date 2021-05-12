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
	#center {
		position: relative;
		margin: 50px auto;
		text-align: center;
		display: inline-block;
		width: 100%;
	}
	#form {
		margin: auto;
	
	}
	.ddong {
		background-color: #b4cde4;
		border:none;
		width: 150px;
		height: 20px;
	
	}
	.poo {
		background-color: #b4cde4;
		border:none;
		width: 60px;
		height: 20px;
	}
	#btn {
		position: absolute;
		top: 47px;
		left: 680px;
	}
	#btn2 {
		position: relative;
		right: 40px;
		display: inline-block;
		width: 60px;
	}

</style>
</head>
<body>
	<div id="center">
		<div class="errMsg">${errMsg}</div>
		<div id="form">
			<form action="login" method="post">
				<div>
					<input class="ddong" type="text" name="uid" placeholder="아이디">
				</div>
				<div>
					<input class="ddong" type="password" name="upw" placeholder="비밀번호">
				</div>
				<div id="btn2">
					<input class="poo" type="submit" value="Login">
				</div>
			</form>
		</div>
		<div id="btn">
			<a href="join"><button class="poo">Join</button></a>
		</div>
	</div>
</body>
</html>