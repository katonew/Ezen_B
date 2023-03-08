console.log('js 열림')

/*
	JS 정규표현식 : 문자 특정 규칙, 패턴, 집합 표현할때 사용되는 언어
	-- 문법
		/^ 					: 정규표현식 시작
		$/ 					: 정규표현식 끝
		[a-z] 				: 소문자 a~z 패턴
		[A-Z]				: 대문자 A~Z 패턴
		[0~9]				: 숫자 0~9 패턴
		[가-힣]				: 한글 패턴
		{ 최소길이, 최대길이 }	: 문자열 길이 패턴
		
		[a-zA-Z] 			: 영문만입력
		[a-zA-Z0-9] 		: 영문+숫자 입력
		[a-zA-Z0-9가-힣]		: 영문 + 숫자 + 한글 입력
		
	-- 패턴 검사 함수
		정규표현식.test(데이터) : 패턴이 적합하면 true
			ex)
			/^[a-z]$/.test(qwe) --> true
			/^[a-z]$/.test(QWE) --> false
	
*/

// 2. 아이디 유효성 검사 [ 1. 문자체크 2. 중복검사]
function idcheck(){ // onkeyup
	// 1. 입력할때마다 입력값 가져오기
	let mid = document.querySelector('.mid').value;
	// 2. 정규표현식 [ 대소문자+숫자 / 5~30글자 ]
	let midj = /^[a-z0-9]{5,30}$/
	// 3. 정규 표현식 검사
	if(midj.test(mid)){
		// 아이디 중복검사 [ js -> 서블릿 -> dao 에게 해당 아이디 검색 select]
		$.ajax({
			url : "/jspweb/mconfirm",
			method : "get",
			data : {"mid" : mid},
			success : (r)=>{
				console.log('ajax 통신');
				// 응답결과 중복이 있으면 true
				if(r=="true"){
					document.querySelector('.idcheckconfirm').innerHTML = "사용중인 아이디"
				}else{
					document.querySelector('.idcheckconfirm').innerHTML = "사용가능한 아이디"
				}
			}// success e		
		}) // ajax e
	}else{
		document.querySelector('.idcheckconfirm').innerHTML = "[조건] 영소문자+숫자 / 5~30글자"
	}
	
}



// 1. 회원가입
function signup(){
	console.log('가입버튼 눌림')
	// * 첨부파일 있을때 [html 파일을 직접적으로 조작 불가능]
	// 1. 입력받은 값을 모두 가져와서 객체화
		// 1. form 객체 가져오기
	let signupform = document.querySelectorAll('.signupform')[0]; // 첫번째 form 가져오기
	 	// 2. form 안에 있는 data 객체 호출
	let signupformData = new FormData(signupform);
	console.log(signupformData);
	
	// 2. ajax 통신을 이용한 서블릿에게 데이터 보내고 응답 받기
	$.ajax({
		url : "/jspweb/member",
		method : "post",				// 첨부파일은 무조건 post/put
		data : signupformData,			// FormData 객체 전송
		// 첨부파일 있을때 추가되는 속성
		contentType : false,			// true : 매개변수 형식의 문자열 타입 [ 기본값]
											// form-urlencoded 형식으로 전송
										// false : 해제
											// multipart/form 형식
		processData : false,			
		success : (r)=>{
			console.log('ajax 응답');
			console.log(r);
			if(r=='true'){
				alert('회원가입 성공')
				location.href="/jspweb/index.jsp" // 해당 페이지로 이동
			}else{alert('회원가입 실패')}
		}
		
	})
	
	
	
	
} // signup e

/*	
	// * 첨부파일 없을때
	// 1. 입력받은 값을 모두 가져와서 객체화
	let info = {
		mid : document.querySelector('.mid').value,
		mpwd : document.querySelector('.mpwd').value,
		mpwdconfirm : document.querySelector('.mpwdconfirm').value,
		memail : document.querySelector('.memail').value,
		mimg : document.querySelector('.mimg').value
	// 2. ajax 통신을 이용한 서블릿에게 데이터 보내고 응답 받기
	
	$.ajax({
		url : "/jspweb/member",	// 서블릿 클래스의 @WebServlet
		method : "post",		// 메소드 선택
		data : info,
		success : (r) =>{
			console.log('ajax 응답');
			console.log(r);
			if(r=='true'){
				alert('회원가입 성공')
				location.href="/jspweb/index.jsp" // 해당 페이지로 이동
			}else{alert('회원가입 실패')}
		} // suc e
	}) // ajax e	
		
	}*/