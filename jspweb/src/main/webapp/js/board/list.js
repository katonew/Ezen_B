console.log('list js 열림')


// * pageObject : 현재 페이지 , 검색 , 전송타입 보관된 객체
let pageObject = {
	page : 1 , // page : 표시할 페이징번호
	key : "" , 
	keyword : "",
	type : 1, // 1:전체출력 2:개별출력 
	cno : document.querySelector('.cno').value, // 카테고리 번호
	listsize : 3
}

// -- 카테고리 제목 넣어주기 
let cnameHTML ='';
if( pageObject.cno == 1 ){ cnameHTML ='공지사항'; }
if( pageObject.cno == 2 ){ cnameHTML ='커뮤니티'; }
if( pageObject.cno == 3 ){ cnameHTML ='QnA'; }
if( pageObject.cno == 4 ){ cnameHTML ='노하우'; }
document.querySelector('.cname').innerHTML = cnameHTML

getBoardList(1);
// 1. 게시물 호출
function getBoardList(page){
	pageObject.page = page; // 인수로 받은 현재페이지를 객체에 대입
	$.ajax({
		url : "/jspweb/board/info",
		method : "get",
		data : pageObject ,	// 1:전체출력 2:개별출력 / page : 표시할 페이징번호
		success : (r)=>{
			console.log('list ajax 성공')
			console.log(r.boardList)
			let html = ``;
			r.boardList.forEach((o)=>{
				html += `<div class="bcontent">	<!-- 게시글 1개 -->
							<div>
								<img class="hpimg" src="/jspweb/member/pimg/${o.mimg==null ? 'default.webp':o.mimg}">
								<span class="mid">${o.mid}</span>
								<span class="bdate">${o.bdate}</span>
							</div>
							<div>
								<a href="/jspweb/board/view.jsp?bno=${o.bno}"><div class="btitle">${o.btitle}</div></a>
							</div>
							<div class="contentbot">
								<span><i class="fas fa-eye"></i><span class="bview">${o.bview}</span></span>
								<span><i class="fas fa-thumbs-up"></i><span class="bup">${o.bup}</span></span>
								<span><i class="fas fa-thumbs-down"></i><span class="bdown">${o.bdown}</span></span>
								<span><i class="far fa-comment-dots"></i><span class="rcount">${o.rcount}</span></span>
							</div>
						</div>`;
			document.querySelector('.boardTable').innerHTML = html;
			
			}) // forEach e
			// -------------------- 페이징 버튼 출력 --------------------- //
			html = ''; // 기존에 들어있던 내용 제거 
			// 이전 [ 만약에 현재 페이지가 1 이하 이면 이전페이지 없음 ]
			html += page <= 1 ?
					`<button onclick="getBoardList(${ page })" type="button" > < </button>`
					:
					` <button onclick="getBoardList(${ page-1 })" type="button"> < </button> `
			// 페이징 번호 버튼 들 
			for( let i = r.startbtn ; i<=r.endbtn ; i++ ){ // 시작버튼번호 부터 마지막버튼번호 까지 버튼 생성 
				html += `
					<button onclick="getBoardList(${i})" type="button"> ${i} </button>
					`
			}
			// 다음 
			// 다음 [ 만약에 현재 페이지가 총페이지수 이상이면 다음페이지 없음 ]
			html += page >= r.totalpage ?
					`<button onclick="getBoardList(${ page })" type="button"> > </button>`
					:
					`<button onclick="getBoardList(${ page+1 })" type="button"> > </button>`
			document.querySelector('.pagebox').innerHTML = html;
			// -------------------- 게시물수 출력  --------------------- //
			document.querySelector('.seachcount').innerHTML = `게시물 수 : ${ r.totalsize } `
		} // success e
	}) // ajax e
} // getBoardList e

// 2. 검색함수
function getsearch(){
	console.log('getsearch()함수');
	// * 입력받은 데이터를 전역객체내 필드에 대입 
	pageObject.key = document.querySelector('.key').value
	pageObject.keyword = document.querySelector('.keyword').value
	// * 게시물리스트 재호출 
	getBoardList(1);
}

// 3. 검색풀기 : 전체보기 
function setsearch(){
	pageObject.key = '';	// 검색 없애기
	pageObject.keyword ='';	// 검색 없애기
	getBoardList(1);		// 재호출
}

// 4. 화면에 표시할 게시물 수 변경 함수 
function setlistsize(){
	// 1. select 에서 선택된 값 가져오기 
	let listsize 
		= document.querySelector('.listsize').value;
	// 2. pageObject 필드에 대입 
	pageObject.listsize = listsize;
	// 3.  
	getBoardList(1);		// 재호출
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















