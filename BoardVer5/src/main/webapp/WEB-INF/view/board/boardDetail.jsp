<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
<script defer src="/res/js/boardDetail.js?ver=1"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css
">
<style>
.hidden {
	display: none;
}

.fa-heart, fa-heart {
	color: #E49A9B;
}
</style>
</head>
<body>
	<h1>
		${requestScope.data.title} 
		<a href="fav?iboard=${param.iboard}&fav=1"><i class="far fa-heart"></i></a> 
		<a href="fav?iboard=${param.iboard}&fav=0"><i class="fas fa-heart "></i></a>
	</h1>
	<div>작성일 : ${requestScope.data.regdt}</div>
	<div>글쓴이 : ${requestScope.data.unm}</div>
	<div>내용 : ${requestScope.data.ctnt}</div>

	<h3>댓글</h3>
	<div>
		<form id="insFrm" action="cmt" method="post">
			<input type="hidden" name="icmt" value="0"> <input
				type="hidden" name="iboard" value="${requestScope.data.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글 내용"></textarea>
				<input type="submit" value="댓글 작성">
			</div>
		</form>

		<form id="updFrm" action="cmt" method="post" class="hidden">
			<input type="hidden" name="icmt" value="0"> <input
				type="hidden" name="iboard" value="${requestScope.data.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글 내용"></textarea>
				<input type="submit" value="댓글 수정"> <input type="button"
					onclick="showInsFrm();" value="수정 취소">
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
					<td><c:if test="${sessionScope.loginUser.iuser == item.iuser}">
							<input type="button" value="수정"
								onclick="updCmt(${item.icmt}, '${item.cmt.trim()}');">
							<button
								onclick="delCmt(${requestScope.data.iboard}, ${item.icmt})">삭제</button>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<a href="/board/boardList"><button>리스트</button></a> <a
			href="/board/boardDel?iboard=${param.iboard}"><button>삭제</button></a>
		<a href="/board/boardModify?iboard=${param.iboard}"><button>수정</button></a>
	</div>
</body>
</html>