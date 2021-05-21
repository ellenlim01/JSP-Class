<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>${errMsg}</div>
<form action="userLogin" method="post">
	<div>
		<input type="text" name="uid" placeholder="아이디">
	</div>
	<div>
		<input type="password" name="upw" placeholder="비밀번호">
	</div>
	<input type="submit" value="Login">
	
</form>
<div>
	<a href="userJoin"><button>Join</button></a>
</div>