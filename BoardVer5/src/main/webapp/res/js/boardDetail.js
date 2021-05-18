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
	updFrm.className = '';
	updFrm.icmt.value = icmt;
	updFrm.cmt.value = cmt;
}

function showInsFrm() {
	insFrm.className = '';
	updFrm.className = 'hidden';
}