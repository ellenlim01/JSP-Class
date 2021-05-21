<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>${errMsg}</div>
<div>
	<form id="frm">
		<div>
			<input type="text" name="uid" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="upw" placeholder="비밀번호">
		</div>
		<div>
			<input type="text" name="unm" placeholder="이름">
		</div>
		<div>
			성별: <label>여성<input type="radio" name="gender" value="0"
				checked></label> <label>남성<input type="radio" name="gender"
				value="1"></label>
		</div>
	</form>
	<input type="button" value="Join" onclick="join()">

	<script>
		function join() {
			var frmElem = document.querySelector('#frm');
			var uid = frmElem.uid.value;
			var upw = frmElem.upw.value;
			var unm = frmElem.unm.value;
			var gender = frmElem.gender.value;
			
			console.log('uid: ' + uid);
			console.log('upw: ' + upw);
			console.log('unm: ' + unm);
			console.log('gender: ' + gender);
			
			var param = {
					uid: uid,
					upw: upw,
					unm: unm,
					gender: gender
			};
			
			var param2 = { uid, upw, unm, gender };
			console.log(param);
			console.log(param2);//변수명==멤버 필드명일때만 쓸 수 있는 것
			ajax(param);
		}
		
		function ajax(param) {//화면 refresh가 없음, 주소값 이동이 없음
			const init = {
				method: 'POST',
				body: new URLSearchParams(param)
			}
		
			fetch('/user/join', init)
			.then(function(res) {//promise객체
				return res.json();
			})
			.then(function(myJson){//알아서 객체화 된다, myJson에 응답이 객체로 들어옴
				console.log(myJson);
				switch(myJson.result) {
				case 0:
					alert('회원가입 실패');
					break;
				case 1:
					location.href = 'user/';
					break;
				}
			});
		}
	</script>
</div>