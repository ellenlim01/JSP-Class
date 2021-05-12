<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<style>
	body {
	background-color: #ffd7d7;
	}
</style>
</head>
<body>
	<form action="write" method="post">
		<div>
			<div><input type="text" name="title" placeholder="제목"></div>
			<div>
				<textarea name="ctnt"></textarea>
			</div>
			<div>
				<input type="submit" value="글쓰기">
				<input type="reset" value="초기화">
			</div>
		</div>
	</form>
</body>
</html>