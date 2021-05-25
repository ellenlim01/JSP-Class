var frmElem = document.querySelector('#frm');
var uidElem = frmElem.uid;
var upwElem = frmElem.upw;
var chkUpwElem = frmElem.chkUpw;
var unmElem = frmElem.unm;

//아이디 확인
var chkUidResultElem = frmElem.querySelector('#ChkUidResult');
var btnChkIdElem = frmElem.btnChkId;
btnChkIdElem.addEventListener('click', function() {
	idChkaJAX(uidElem.value);
});

function idChkAjax(uid) {
	
}

function frmChk(){
	// 아이디 글자 수
	var uidVal = uidElem.value;
	
	if(uidVal.length < 4) {
		if(uidVal.length == 0) {
			alert('아이디를 작성해주세요')
		} else {
			alert('아이디는 4자 이상 작성해주세요')
		}
		return false;
	}
	
	
	var upwVal = upwElem.value;
	var chkUpwVal = chkUpwVal.value;
	//비밀번호 확인 및 글자 수
	if (upwVal.length < 4) {
		if (upwVal.length == 0) {
			alert('비밀번호를 작성해주세요');
		} else {
			alert('비밀번호는 4자 이상 작성해주세요');
		}
		return false;
	} else if (upwVal !== chkUpwVal) {
		alert('비밀번호를 확인해주세요');
		return false;
	}
	//비밀번호 특수문자
	if(!checkSpecial(upwElem.value)){
		alert('비밀번호에 특수문자를 넣어주세요')
	}
	
	if(unmElem.value.length < 2) {
		if(unmElem.value.length == 0) {
			alert('이름을 작성해주세요');
		} else {
		alert('이름은 2자 이상 작성해주세요');
		}
		return false;
	}
}

function checkSpecial(str) {
	var special_pattern = /[~!@#$%^&*()_+|<>?:{}]/;
	if(special_pattern.test(str) == true) {
		return true;
	} else {
		return false;
	}
}