
//JS 함수
// function 함수명(매개변수){실행코드}
Ex2();
q1output();
function Ex1(){
	let data = document.querySelector('.inputdata').value;
	console.log(data)
	
	$.ajax({
		url : "/jspweb/Ex1",		// 통신할 서블릿 주소
		method : "post",									// HTTP 메소드
		data : { "data" : data },							// 데이터 보내기
		success : function(result){							// 데이터 받기
			console.log(result)
			Ex2();
		}
	});

}

// 페이지 열리면
function Ex2(){
	
	$.ajax({
		url : "/jspweb/Ex1",		// 통신할 서블릿 주소
		method : "get",									// HTTP 메소드
		data : {},										// 
		success : function(result){						// 
			console.log(result)
			document.querySelector('.ex2box').innerHTML = result
		}
	});
	
}

// 과제 1번 입력값 받기
function q1input(){
	let data = document.querySelector('.qinput').value
	$.ajax({
		url : "/jspweb/Q1",
		method : "post",
		data : {"data" : data},
		success : function(result){
			console.log(data)
			q1output();
		}
	}) // ajax e
} // f e

function q1output(){
	$.ajax({
		url : "/jspweb/Q1",
		method : "get",
		data : {},
		success : function(result){
			document.querySelector('.q1printbox').innerHTML = result
		}
		
		
	})
}


// document : 미리 만들어진 DOM객체
		// 1.querySelector(식별자) : tag 한개 -> 변수/객체에 저장
			// 1. document.querySelector('.클래스명')
			// 2. document.querySelector('#id명')
			// 3. document.querySelector('tag명[name="name"]')
		// 2. querySelectorAll(식별자) : tag 여러개 -> 배열/리스트에 저장
		
		// 3. querySelectorAll.속성명
			// 1.  querySelector().value : input,select,textarea [ div X , table X]
			// 2.  querySelector().innerHTML : div, span, td 등등


/*
	
	JS --> 서블릿 이동
	0. $ : jqeury 표현식 [jquery 라이브러리 필요]
	1. ajax 메소드 사용 : $.ajax();
	2. ajax 매개변수 [속성:객체형태] : {  } --> $.ajax({ });
	3. 속성
		1. url : 통신할 경로[서블릿(클래스) 주소 : /프로젝트명/클래스명
			1. url : "http://localhost:8080/jspweb/indextest"
			2. url : "http://192.168.17.40:8080/jspweb/indextest"
			3. url : "/jspweb/indextest"
		2. method : http 메소드방식
			1. get 
			2. post 
		3. data : 통신할 때 보낼 데이터 보내기
			1. js객체 형태 : { 매개변수명 : 데이터, 매개변수명 : 데이터 }
		4. success : 통신 후 응답 받기
			1. success : 함수명(매개변수){}
			2. success : (매개변수)=>{}
		
	예시
		$.ajax({
			url : "" , 
			method : "",
			data:{매개변수명 : 데이터},
			succes : function(result){
			}
		});
	*/





















