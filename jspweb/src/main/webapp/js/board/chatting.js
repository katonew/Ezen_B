/*
	소켓 : 두 프로그램간의 양방향 통신 종착점
	서버소켓 		: [JAVA]서버가 가지고 이는 소켓
	클라이언소켓 	: [JS]클라이언트가 각각 가지고 있는 소켓
	
	JS WebSocket
		1. JS에서 제공하는 클래스 => WebSocket
		2. 소켓객체만들기
			let 소켓객체명 = new WebSocket('ws://ip:포트번호/프로젝트명/서버소켓URL');
		3. 소켓이 서버 소켓과 연동
			- 소켓객체명.onopen()		: 클라이언트 소켓이 열렸을때
			- 소켓객체명.send()			: 클라이언트 소켓에서 서버소켓으로 보낼때
			- 소켓객체명.onmessage()	: 서버소켓에서 받을때
			
	JAVA serverSocket
		1. 임의의 클래스 생성
		2. 서버소켓 만들기
			- 클래스 위에 @ServerEndpoint("/서버소켓경로URL")
			- @ServerEndpoint	: WS의 URL 만들기
			- @WebServlet		: HTTP의 URL 만들기
		3. 클라이언트소켓이 서버소켓[엔드포인트]으로 접속했을때 
			- @OnOpen 				: 클라이언트소켓이 접속했을때 매핑	[onopen]
			- @OnMessage			: 클라이언트소켓이 메세지를 보냈을때 	[send]
			- 세션명.getBasicRemote()	: 클라이언트에 객체를 보낼때		[onmessage]
			- @OnClose				: 클라이언트소켓이 접속을 종료했을때
			
	
 */
let contentbox = document.querySelector('.contentbox')
let 클라이언트소켓 = null;

if(memberinfo.mid==null){ //memberinfo => headr.js에 존재하는 로그인 정보 객체
	alert('로그인해야 사용가능 합니다.')
	location.href="/jspweb/member/login.jsp"
}else{
	클라이언트소켓 = new WebSocket('ws://localhost:8080/jspweb/chatting/'+memberinfo.mid);
	클라이언트소켓.onopen = function(e){서버소캣연결(e);}
	클라이언트소켓.onmessage = function(e){메세지받기(e);}
	클라이언트소켓.onclose = (e)=>{연결해제(e)}
	
}

// 클라이언트 소켓 생성


//2. 클라이언트 소켓이 접속했을때 이벤트/함수 정의 [@OnOpen]
function 서버소캣연결(e){
	document.querySelector('.contentbox').innerHTML += 
	`<div class="alarm">
		<span>-----${memberinfo.mid}님 채팅방입장-----</span>
	</div>`
	
	}	// 접속했을때 하고싶은 함수 정의

//3. 클라이언트소켓이 서버소켓에 메세지를 보내기 [@OnMessage]
function 보내기(){
	console.log('메세지 전송')
	let msgbox = document.querySelector('.msgbox').value
	
	// * 서버소켓에 메세지 전송하기
	클라이언트소켓.send(msgbox);
	
	// 전송성공시 입력창 초기화
	document.querySelector('.msgbox').value = '';
}

//4. 클라이언트 소켓으로부터 메세지가 왔을때
function 메세지받기(e){
	console.log(e)
	console.log(e.data)
	console.log(JSON.parse(e.data))	 //문자열 JSON -> JS문자열
	if(JSON.parse(e.data).frommid==memberinfo.mid){
		contentbox.innerHTML += `
		<div class="sendmsg">
			<div class="date">${JSON.parse(e.data).time}</div>
			<div class="content">${JSON.parse(e.data).msg}</div>
		</div>`
	}else{
		contentbox.innerHTML += 
					`<div class="tomsg">
						<span><img src="/jspweb/member/pimg/${JSON.parse(e.data).frommimg==null?"default.webp": JSON.parse(e.data).frommimg}" class="hpimg"></span>
						<div class="rcontent">
							<div class="name"> ${JSON.parse(e.data).frommid} </div>
							<div class="tocontent">
								<div class="content"> ${JSON.parse(e.data).msg} </div>
								<div class="date">${JSON.parse(e.data).time}</div>
							</div>
						</div>
					<div>`
	}
	// 스크롤이 내려갈때 항상 하단에 위치하기
	// 현재 스크롤의 상단위치좌표 = 현재스크롤 전체의 높이 [ 기본값 content height]
	contentbox.scrollTop = contentbox.scrollHeight;
	
}

// 5. 서버와 연결이 끊겼을때 [ 클라이언트 소켓 객체가 초기화 될때 -> 새로고침했을때, 페이지가 전환될 때]
function 연결해제(e){
	console.log('연결해제')
}


function enterchat(){
	if(window.event.keyCode == 13){
		보내기();
	}
}

function msgcheck(){
	let msgbox = document.querySelector('.msgbox').value;
	console.log(msgbox)
	if(msgbox!=''){
		document.querySelector('.sendbtn').disabled = '';
	}else{
		document.querySelector('.sendbtn').disabled = 'disabled';
	}
}











/*
	클라이언트 소켓 필드
		onopen		= 
		onclose		= 
		onmessage	= 
		
		// 통신 결과
		클라이언트 소켓.onclose	=  function(e){console.log('연결해제')}
			vs
		클라이언트 소켓.onclose	=  (e)=>{console.log('연결해제')}
			vs
		function 함수명(e){}
		클라이언트 소켓.onclose	=  function(e){ 함수명(e) }
	
	AJAX 필드
		// 통신 결과
		success : function(r){}
		success : (r)=>{}
 */









