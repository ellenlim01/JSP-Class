<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	<h1>${data.title}</h1>
	<div>작성일 : ${data.regdt}</div>
	<div>글쓴이 : ${data.unm}</div>
	<div>내용 : ${data.ctnt}</div>
	
	<h3>댓글</h3>
	<div>
		<form action="regCmt" method="post">
			<input type="hidden" name="iboard" value="${data.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글 내용"></textarea>
				<input type="submit" value="댓글 작성">
			</div>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>
			</tr>
		</table>
	</div>
	<div>
		<a href="/board/boardList"><button>리스트</button></a>
		<a href="/board/boardDel?iboard=${param.iboard}">삭제</a>
	</div>
</body>
</html>