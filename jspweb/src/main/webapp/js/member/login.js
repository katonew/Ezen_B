console.log('login js 열림')

function login(){
	console.log('login버튼 눌림')
	// 1. 입력받은 값 가져오기
	let mid = document.querySelector('.mid').value;
	let mpwd = document.querySelector('.mpwd').value;
	
	// 2. 
	$.ajax({
		url : "/jspweb/login",
		method : "post",
		data : { "mid" : mid, "mpwd" : mpwd },
		success : (r)=>{
			console.log('로그인 ajax 통신')
			console.log(r)
		}
	})
	
	
}