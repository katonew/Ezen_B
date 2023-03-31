console.log('header js열림');

let memberinfo = null;

// 로그인한 회원정보 호출 
getLogin();
function getLogin(){
	$.ajax({
		url : "/jspweb/login" ,
		method : "get" , 
		async : false,
		success : (r) => {
			console.log('통신성공');
			console.log( r );	// Dto1개회원 --> r객체1개 회원
			memberinfo = r;	// 응답 결과를 전역변수로 옮기리 [다름 함수에서 쓰기 위해]
			let html = '';	// 1. html 구성 
			if( r.mid == null ){	// 2. 로그인 안했으면 
				html += `<a href="/jspweb/member/signup.jsp">회원가입</a>`;
				html += `<a href="/jspweb/member/login.jsp">로그인</a>`;
				
			}else{	// 3.로그인 했으면
			
				html += 
						`
						<div class="dropdown"> <!-- bs : 드롭다운 -->
							<button class="hpimghtn" type="button" data-bs-toggle="dropdown">
								<img src="/jspweb/member/pimg/${ r.mimg == null ? 'default.webp' : r.mimg }" class="hpimg">
							</button>
							<ul class="dropdown-menu">	<!-- 드롭다운시 표기되는 구역 -->
								<li> <a class="dropdown-item" href="/jspweb/member/info.jsp"> 내프로필 </a></li>
								<li> <a class="dropdown-item" href="#"> 친구목록 </a></li>
								<li> <a class="dropdown-item" href="/jspweb/member/logout.jsp"> 로그아웃 </a></li>
							</ul>
						</div>	<!-- 드롭다운 end  -->
						${r.mid}님
						<a href="#"> 쪽지함 </a>
						<a href="/jspweb/member/point.jsp"> 포인트 </a>
						`
			
			
				if( r.mid == 'admin'){ // 관리자이면 
					html += `<a href="/jspweb/admin/info.jsp">관리자</a>`
				}
			
			}
			document.querySelector(".submenu").innerHTML = html;
		} // success e
	}) // ajax e
} // getlogin e
//----------------------알림용 클라이언트 소켓 ---------------------------
let 알림용소켓 = null;

if(memberinfo.mid == null){}
else{
	// JS 실행주체 = 클라이언트 // JAVA = 서버
	// 1. JS : 클라이언트 소켓 생성
	알림용소켓 = new WebSocket('ws://localhost:8080/jspweb/alarm/'+memberinfo.mid);
	// 2. 클라이언트 소켓 이벤트 메소드 정의
	알림용소켓.onopen = (e)=>{console.log('알림용 서버 소켓 열림')}
	알림용소켓.onclose = (e)=>{console.log('알림용 서버 소켓 닫힘')}
	알림용소켓.onerror = (e)=>{console.log('알림용 서버 소켓 오류')}
	알림용소켓.onmessage = (e)=>{onalarm(e)}
}

//
function onalarm(e){
	let msgbox = document.querySelector('.msgbox')
	
	msgbox.style.opacity = "1";
	
	// 4초 후에 자동으로 내려가기
	// n초 후에 이벤트 실행 setTimeout( ()=> {} , 밀리초)
	// n초 마다 이벤트 실행 setInterval( ()=> {} , 밀리초)
	setTimeout(()=>{
		msgbox.style.opacity = "0";
	},4000);
	
	//여러명이 채팅을 요청하면 Dao 메소드 충돌가능
	// Dao 메소드에 synchronized 키워드 사용
	// 스레드1이 해당 메소드를 사용하고 있을때 [ return 전] 다른 스레드2 해당 메소드에 대기상태
	getcontent();
	
}








