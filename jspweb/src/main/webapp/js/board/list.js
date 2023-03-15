console.log('list js 열림')

getBoardList();
function getBoardList(){
	$.ajax({
		url : "/jspweb/board/info",
		method : "get",
		data : {"type" : 1}, // 1. 전체 출력 2.개별출력(view.js에 있음)
		success : (r)=>{
			console.log('list ajax 성공')
			console.log(r)
			let html = `<tr>
							<th width="10%">번호</th>
							<th width="30%">제목</th>
							<th width="10%">작성자</th>
							<th width="20%">작성일</th>
							<th width="10%">조회수</th>
							<th width="10%">좋아요</th>
							<th width="10%">싫어요</th>
						</tr>`;
			r.forEach((o)=>{
				html += `<tr>
							<td>${o.bno}</td>
							<td><a href="/jspweb/board/view.jsp?bno=${o.bno}">${o.btitle}</a></td>
							<td>${o.mid}</td>
							<td>${o.bdate}</td>
							<td>${o.bview}</td>
							<td>${o.bup}</td>
							<td>${o.bdown}</td>
						</tr>`;
			document.querySelector('.boardTable').innerHTML = html;
			})
		}
		
	})
}

/* - 클릭한 pk[식별자] dlehdgksms 경우의 수
	1. HTTP get메소드 방식의 a태그 이용한 pk 이동
		<a href="/jspweb/board/view.jsp">
		=> 그냥 view.jsp로 이동
		<a href="/jspweb/board/view.jsp?변수명=데이터">
		=> a태그에 변수 넘기기
		두개 이상일때는 &를 이용
		
	2.
	
	
	
	
*/















