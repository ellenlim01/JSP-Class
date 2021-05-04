<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/mod" method="post">
	<input type="hidden" name="no" value="${data.iboard}">
		<div>
			제목 : <input type="text" name="title" value="${data.title}">
		</div>
		<div>
			내용 : <textarea name="ctnt">${data.content}</textarea>
		</div>
		<div>
			<a href="mod?iboard=${param.iboard}"><input type="submit" value="수정"></a>
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>