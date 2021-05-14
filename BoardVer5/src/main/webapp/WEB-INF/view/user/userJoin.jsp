<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="userJoin" method="post">
		<div>
			아이디 : <input type="text" name="uid">
		</div>
		<div>
			비밀번호 : <input type="password" name="upw">
		</div>
		<div>
			이름 : <input type="text" name="unm">
		</div>
		<div>
			성별 : 여자 <input type="radio" name="gender" value="0" checked>
			남자 <input type="radio" name="gender" value="1">
		</div>
		<div>
			<input type="submit" value="Join">
			<a href="userLogin"><button>로그인 돌아가기</button></a>
		</div>
	</form>
</body>
</html>