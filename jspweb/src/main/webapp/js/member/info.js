console.log('info js 열림');

console.log(memberinfo);
console.log(memberinfo.mid)
console.log(memberinfo.memail)

if(memberinfo.mid == null){
	alert('로그인 되어있지 않습니다.')
	location.href="/jspweb/member/login.jsp";
}

// 1. header.js에서 ajax 동기식으로 회원정보 가져온 상태 [ memberinfo ] 
document.querySelector('.mid').innerHTML = memberinfo.mid;
document.querySelector('.memail').innerHTML = memberinfo.memail;
document.querySelector('.mimg').src = `/jspweb/member/pimg/${memberinfo.mimg==null ? "default.webp" : memberinfo.mimg }`
document.querySelector('.mpoint').innerHTML = memberinfo.mpoint;

// * 회원정보.js : 만약 로그인이 안되어 있으면 불가능


// 1. 회원 탈퇴
function setdelete(){
	console.log('setdelete 열림')
	$.ajax({
		url : "/jspweb/member",
		method : "delete",
		//data : "",
		success : (r)=>{
			console.log('통신');
			console.log(r);
			if(r='true'){
				alert('탈퇴 성공')
				location.href="/jspweb/logout.jsp";
			}else{
				alert('탈퇴 실패')
			}
		} // success e
	}) // ajax e
} // setdelete e

// 2. 회원 수정
function setupdate(){
	console.log('setupdate 열림')
	let pwd = prompt('새로운 비밀번호')
	let memail = prompt('새로운 이메일')
	$.ajax({
		url : "/jspweb/member",
		method : "put",
		data : {"mpwd" : mpwd , "memail" : memail},
		success : (r)=>{
			console.log('통신');
			console.log(r);
			if(r='true'){
				alert('수정 성공')
				location.href="/jspweb/logout.jsp";
			}else{
				alert('수정 실패')
			}
		} // success e
	}) // ajax e
}










