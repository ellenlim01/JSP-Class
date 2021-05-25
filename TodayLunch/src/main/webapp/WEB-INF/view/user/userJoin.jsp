<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form id="frm" action="join" method="post" onsubmit="return frmChk();">
	<div>
		아이디: <input type="text" name="uid">
		<input type="button" id="btnChkId" value="ID 중복 체크" >
	</div>
	<div id="chkUidResult"></div>
	<div>
		비밀번호: <input type="password" name="upw">
	</div>
	<div>
		비밀번호 확인: <input type="password" name="chkUpw">
	</div>
	<div>
		이름: <input type="text" name="unm">
	</div>
	<span> 
	<input type="submit" value="Join">
	</span>
</form>
	<a href="login"><button>Login</button></a> 
<script src="/res/js/userJoin.js"></script>