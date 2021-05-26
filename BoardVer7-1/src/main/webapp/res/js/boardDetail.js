var cmtFrmElem = document.querySelector('#cmtFrm');
var cmtListElem = document.querySelector('#cmtList');

function regCmt() {
	var cmtVal = cmtFrmElem.cmt.value;	
	var param = {
		iboard: cmtListElem.dataset.iboard,
		cmt: cmtVal
	};	
	regAjax(param);
}

//서버에게 등록해줘~~~
function regAjax(param) {
	const init = {
		method: 'POST',				
	    body: new URLSearchParams(param)
	};
	
	fetch('cmtInsSel', init)
	.then(function(res) {
		return res.json();
	})
	.then(function(myJson) {
		console.log(myJson);
		
		switch(myJson.result) {
			case 0:
				alert('등록 실패!');
			break;
			case 1:
				cmtFrmElem.cmt.value = '';
				getListAjax();
			break;
		}
	});		
}

//서버에게 댓글 리스트 자료 달라고 요청하는 함수
function getListAjax() {
	var iboard = cmtListElem.dataset.iboard;//${param.iboard}에 담겨있는 값을 가져오기 위해
	
	fetch('cmtInsSel?iboard=' + iboard)
	.then(function(res) {
		return res.json();
	})
	.then(function(myJson) {
		console.log(myJson);
		
		makeCmtElemList(myJson);
	});
}

function makeCmtElemList(data) {
	
	cmtListElem.innerHTML = '';
	var tableElem = document.createElement('table');//메모리 상에 <table></table>이 만들어짐
	var trElemTitle = document.createElement('tr');
	var thElemCtnt = document.createElement('th');
	var thElemWriter = document.createElement('th');
	var thElemRegdate = document.createElement('th');
	var thElemRemarks = document.createElement('th');
	
	thElemCtnt.innerText = '내용';
	thElemWriter.innerText = '작성자';
	thElemRegdate.innerText = '작성일';
	thElemRemarks.innerText = '비고';
	
	trElemTitle.append(thElemCtnt);//append: 뒤쪽에 추가, prepend: 앞에 추가
	trElemTitle.append(thElemWriter);
	trElemTitle.append(thElemRegdate);
	trElemTitle.append(thElemRemarks);
	
	tableElem.append(trElemTitle);
	cmtListElem.append(tableElem);
	
	var loginUserPk = cmtListElem.dataset.login_user_pk;
	
	data.forEach(function(item) {
		var trElemCtnt = document.createElement('tr');
		var tdElem1 = document.createElement('td');
		var tdElem2 = document.createElement('td');
		var tdElem3 = document.createElement('td');
		var tdElem4 = document.createElement('td');
		
		tdElem1.append(item.cmt);//append는 text도 들어감
		tdElem2.append(item.writerNm);
		tdElem3.append(item.regdate);
		
		if(parseInt(loginUserPk) === item.iuser) {//data-login_user_pk 여기서 가져온 거
			var delBtn = document.createElement('button');
			var modBtn = document.createElement('button');
			
			delBtn.addEventListener('click', function() {
				delAjax(item.icmt);//버튼마다 다른 값이 날아가도록 한 것
			});
			
			delBtn.innerText = 'delete';
			modBtn.innerText = 'modify';
			
			tdElem4.append(delBtn);
			tdElem4.append(modBtn);
		}
		
		trElemCtnt.append(tdElem1);
		trElemCtnt.append(tdElem2);
		trElemCtnt.append(tdElem3);
		trElemCtnt.append(tdElem4);
		
		tableElem.append(trElemCtnt);
	})
}
function delAjax(icmt) {
	fetch('cmtDelUpd?icmt=' + icmt)
	.then(function(res) {
		return res.json();
	})
	.then(function(myJson) {
		console.log(myJson);
		
		switch(myJson.result) {
			case 0:
				alert('댓글 삭제를 실패하였습니다');
				break;
			case 1:
				getListAjax();	
			break;
		}
	})
}

getListAjax(); //이 파일이 임포트되면 함수 1회 호출!











