console.log('header js 열림')
getlogin();
// 로그인한 회원정보 호출
function getlogin(){
	$.ajax({
		url : "/jspweb/login",
		method : "get",
		success : (r)=>{
			console.log('통신성공')
			console.log(r)
			// 1. html 구성
			let html = '';
			if(r == null){
				html += `<a href="/jspweb/member/signup.jsp">회원가입</a></br>`;
				html += `<a href="/jspweb/member/login.jsp">로그인</a>`;
			}else if(r.mid=='admin'){
				html += `관리자님 안녕하세요 `;
				html += `<a href="/jspweb/admin/info.jsp">관리자페이지 </a></br>`;
				html += `<a href="/jspweb/member/logout.jsp">로그아웃 </a>`;
			}else {
				html += `<img src="/jspweb/member/pimg/${r.mimg==null ? "default.webp" : r.mimg}" class="hpimg">`
				html += `${r.mid}님 안녕하세요 `
				html += `<a href="/jspweb/member/logout.jsp">로그아웃</a>`;
			}
			document.querySelector('.header').innerHTML = html;
		}
	})
}