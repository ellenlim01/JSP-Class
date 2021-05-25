<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>리스트</h1>

<div>
	<div>
		<form action="list" method="get">
			<div>
				<input type="search" name="search">
				<input type="submit" name="검색">
			</div>
		</form>
	</div>
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
	<div>
		<c:forEach begin="1" end="${requestScope.totalPage}" var="cnt">
			<a href="list?page=${cnt}&search=${param.search}"><span>${cnt}</span></a>
		</c:forEach>
	</div>
</div>
<div>
	<form action="list" method="get">
		<div>
			<select name="searchType">
				<option value="1">제목+내용</option>
				<option value="2">제목</option>
				<option value="3">내용</option>
				<option value="4">글쓴이</option>
			</select>
			<input type="search" name="searchText">
			<input type="submit" value="검색">
		</div>
	</form>
</div>