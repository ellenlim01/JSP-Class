<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>리스트</h1>

<div>
	<table>
		<tr>
			<th>no</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>일시</th>
		</tr>
		<c:forEach items="${requestScope.data}" var="item">
			<tr class="record" onclick="moveToDetail(${item.iboard})">
				<td>${item.iboard}</td>
				<td>${item.title}</td>
				<td>${item.unm}</td>
				<td>${item.regdt}</td>
			</tr>
		</c:forEach>
	</table>
</div>