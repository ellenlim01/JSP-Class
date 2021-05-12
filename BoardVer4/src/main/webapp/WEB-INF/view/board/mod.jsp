<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<form action="mod" method="post">
		<input type="hidden" name ="iboard" value="${data.iboard}" readonly>
		<div>
			<div>
				<input type="text" name="title" value="${data.title}">
			</div>
			<div>
				<textarea name="ctnt">${data.ctnt}</textarea>
			</div>
			<div>
				<input type="submit" value="수정">
				<input type="reset" value="초기화">
			</div>
		</div>
	</form>
</body>
</html>