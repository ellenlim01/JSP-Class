<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div><a href="list"><button>리스트</button></a></div>
	<h1 id="title"></h1>
	<div>글 번호: <span id="iboard"></span></div>
	<div>
		글쓴이 : <span id="unm"></span>
		작성일 : <span id="regdt"></span>
	</div>
	<div id="regdt"></div>

<script>
	function ajax(iboard) {
		console.log('iboard : ' + iboard);
		const param = { iboard }
		const init = {
				method: 'POST',
				body: new URLSeachParams(param)
		}
		fetch('/board/detail', init)
		.then(function(res) {
			return res.json();
		})
		.then(function(myJson) {
			console.log(myJson);
			setData(myJson);
		})
	
	}
	
	function setData(data) {
		var iboardElem = document.querySelector('#iboard');
		var titleElem = document.querySelector('#title');
		var regdtElem = document.querySelector('#regdt');
		var ctntElem = document.querySelector('#ctnt');
		
		iboardElem.innerText = data.iboard;
		titleElem.innerText = data.title;
		regdtElem.innerText = data.regdt;
		ctntElem.innerText = data.ctnt;
	}
	ajax(${param.iboard})
</script>