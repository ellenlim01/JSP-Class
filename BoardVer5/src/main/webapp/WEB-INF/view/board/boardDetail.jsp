<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
<script defer src="/res/js/boardDetail.js"></script>
</head>
<body>
	<h1>${data.title}</h1>
	<div>작성일 : ${data.regdt}</div>
	<div>글쓴이 : ${data.unm}</div>
	<div>내용 : ${data.ctnt}</div>

	<h3>댓글</h3>
	<div>
		<form action="cmt" method="post">
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
			<c:forEach items="${requestScope.cmtList}" var="item">
				<tr>
					<td>${item.cmt}</td>
					<td>${item.unm}</td>
					<td>${item.regdate}</td>
					<td>
						<c:if test="${sessionScope.loginUser.iuser == item.iuser}">
							<button>수정</button>
							<button onclick="delCmt(${requestScope.data.iboard}, ${item.icmt})">삭제</button>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<a href="/board/boardList"><button>리스트</button></a> <a
			href="/board/boardDel?iboard=${param.iboard}">삭제</a>
	</div>
</body>
</html>