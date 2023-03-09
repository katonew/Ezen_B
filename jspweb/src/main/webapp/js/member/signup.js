/*
	JS 정규표현식 : 문자 특정 규칙, 패턴, 집합 표현할때 사용되는 언어
	-- 문법
		/^ 					: 정규표현식 시작
		$/ 					: 정규표현식 끝
		[a-z] 				: 소문자 a~z 패턴
		[A-Z]				: 대문자 A~Z 패턴
		[0~9]				: 숫자 0~9 패턴		\d
		[가-힣]				: 한글 패턴
		{ 최소길이, 최대길이 }	: 문자열 길이 패턴
		+ 					: 앞에 있는 패턴 1개이상 반복
		= 					: 앞에 있는 패턴 0개 혹은 1개이상 반복
		* 					: 앞에 있는 패턴 0개 반복
		
		\ : 이스케이프 문자
		이스케이프 문자를 사용해야하는 문자
		. [ ] \ { } * + ? ^ $ ( ) |
		
		-----
		[a-zA-Z] 			: 영문만입력
		[a-zA-Z0-9] 		: 영문+숫자 입력
		[a-zA-Z0-9가-힣]		: 영문 + 숫자 + 한글 입력
		
		/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
		(?=.*[A-Za-z]) 	: 영대소문자 한개이상 입력
		(?=.*\d)		: 숫자 한개이상 입력
		[A-Za-z\d]		: 영문+숫자
		{5,20}			: 5~20글자 제한
		
		/^(?=.*[A-Z])(?=.*[a-z)(?=.*\d)[A-Za-z\d]{5,20}$/
		--> 영대문자1개+영소문자1개+숫자1개를 필수로 갖는 5~20글자사이
		
		/^(?=.*[A-Z])(?=.*[a-z)(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d]{5,20}$/
		--> 영대문자1개+영소문자1개+숫자1개+특정특수문자1개를 필수로 갖는 5~20글자사이
		
		------
		1개 이상 문자가 포함되어야 하는 경우
		(?=.*[패턴문자])
		(?=.*[a-z]) : 소문자 한개 이상
		(?=.*[A-Z]) : 대문자 한개 이상
		(?=.*[0~9]) : 숫자 한개 이상
		(?=.*[!@#$%^&*]) : 해당하는 특수문자가 한개이상 입력
		
		
	-- 패턴 검사 함수
		정규표현식.test(데이터) : 패턴이 적합하면 true
			ex)
			/^[a-z]$/.test(qwe) --> true
			/^[a-z]$/.test(QWE) --> false
	
*/

//* 첨부파일 이미지 미리보기 [ 업로드와 상관없음 ]
	// 정책 : 사용자[클라이언트]의 운영체제 접근 불가
function premimg(object){
	// 1. JS 파일 클래스 선언
	let file = new FileReader();	// 파일 읽기
	// 2. 해당 첨부된 파일 읽어오기 ( file.readAsDataURL(첨부파일) )
	file.readAsDataURL(object.files[0]);	// 해당 파일 읽어오기 .files[0] : 첨부파일 1개
	// 3. 읽어온 파일 꺼내기 (바이트)
	file.onload = (object)=>{
		document.querySelector('.premimg').src = object.target.result;
	}
}


// checkconfirm span 모두 가져오기 --> 여러개의 span이 배열/리스트 객체에 대입
let checkconfirm = document.querySelectorAll('.checkconfirm')

// 2. 아이디 유효성 검사 [ 1. 문자체크 2. 중복검사 ] 
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
					checkconfirm[0].innerHTML = "사용중인 아이디"
				}else{
					checkconfirm[0].innerHTML = "사용가능"
				}
			}// success e		
		}) // ajax e
	}else{
		checkconfirm[0].innerHTML = "[조건] 영소문자+숫자 / 5~30글자"
	}
	
}



// 1. 회원가입
function signup(){
	//* 유효성 검사에 대한 체크
	let count = 0;
	for(let i=0;i<checkconfirm.length;i++){
		if(checkconfirm[i].innerHTML == '사용가능'){
			count++;
		}
	}
	
	if(count!=3){alert('데이터가 모두 입력되지 않았습니다.'); return;}
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
			if(r=='true'){
				alert('회원가입 성공')
				location.href="/jspweb/index.jsp" // 해당 페이지로 이동
			}else{alert('회원가입 실패')}
		}
		
	})
	
} // signup e

// 3. 비밀번호 유효성 검사
function pwdcheck(){
	// 1. 입력받은 값 가져오기
	let mpwd = document.querySelector('.mpwd').value;
	// 2. 정규표현식 : 영대소문자 + 숫자조합 5~20글자
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
	// (?=.*[A-Za-z]) 	: 영대소문자 한개이상 입력
	// (?=.*\d)			: 숫자 한개이상 입력
	// [A-Za-z\d]		: 영문+숫자
	// {5,20}			: 5~20글자 제한
	
	console.log(mpwdj.test(mpwd))
	// 3. 제어
	if(mpwdj.test(mpwd)){
		// 비밀번호 확인도 체크해야하기때문에 실행
		pwdconfirmcheck();
	}else{
		checkconfirm[1].innerHTML = '[조건] 영대소문자+숫자 혼합 / 5~20글자'
	}
} // pwdcheck e

// 4. 비밀번호 확인 유효성 검사
function pwdconfirmcheck(){
	let mpwd = document.querySelector('.mpwd').value;
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value;
	// 2. 정규표현식
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
	// 3. 제어
	if(mpwdj.test(mpwdconfirm)){
		// 두 비밀번호 간의 동일성 체크 
		if(mpwd!=mpwdconfirm){ // [ 두 비밀번호가 다르면]
			checkconfirm[1].innerHTML = '비밀번호가 일치 하지 않습니다.'
		}else{ // [ 두 비밀번호가 같으면]
			checkconfirm[1].innerHTML = '사용가능'
		}
	}else{ 
		checkconfirm[1].innerHTML = '비밀번호가 일치 하지 않습니다.'
	}
} // pwdconfirmcheck e

// 5. 이메일 유효성 검사
function emailcheck(){
	let memail = document.querySelector('.memail').value;
	let memailj = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/
		// 아이디 구역
		// [A-Za-z\d] 		: 영문+숫자
		// [A-Za-z\d_-] 	: 영문+숫자 + _ + -
	// @
		// +@				: 아이디와 도메인 사이의 @
		
	// 도메인 구역
		// [a-zA-Z0-9-]		: 영문+숫자 + -
		// +\.				: 도메인 중간에 .
		// [a-zA-Z0-9-]		: 영문+숫자 + -
		// +				: .			
	if(memailj.test(memail)){
		checkconfirm[2].innerHTML = '사용가능'
	}else{
		checkconfirm[2].innerHTML = '이메일 형식으로 입력해주세요'
	}
}// emailcheck e


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