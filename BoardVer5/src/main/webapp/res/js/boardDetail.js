var updFrmElem = document.querySelector('#updFrm');
var insFrmElem = document.querySelector('#insFrm');

//댓글 삭제
function delCmt(iboard, icmt) {
	console.log(`iboard: ${iboard}, icmt: ${icmt}`);

	if (confirm('삭제하시겠습니까?')) {
		location.href = `/board/cmt?icmt=${icmt}&iboard=${iboard}`;
	}

}

//댓글 수정
function updCmt(icmt, cmt) {
	insFrm.className = 'hidden';
	updFrm.className = '';// 아이디만 적어줘도 주소 값을 가져오긴 함
	
	updFrmElem.icmt.value = icmt;
	updFrmElem.cmt.value = cmt;
}

function showInsFrm() {
	insFrmElem.className = '';
	updFrmElem.className = 'hidden';
}