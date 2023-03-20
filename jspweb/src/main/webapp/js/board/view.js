console.log('view js 열림')
console.log(memberinfo)
if(memberinfo.mid==null){
	document.querySelector('.rcontent').disabled ="true";
	document.querySelector('.rcontent').value ="로그인 후 사용 가능";
	document.querySelector('.rwritebtn').disabled ="true";
}

// 현재 보고 있는 게시글 번호
let bno = document.querySelector('.bno').innerHTML

// 1. 해당 게시물 호출
getBoard();
function getBoard(){
	console.log('getBoard function s')
	
	$.ajax({
		url : "/jspweb/board/info",
		method : "get",
		data : {"type" : 2, "bno" : bno},
		success : (r)=>{
			console.log('게시물 개별출력 ajax 성공')
			console.log(r)
			
			let html = '';
			document.querySelector('.mimg').innerHTML = `<img src="/jspweb/member/pimg/${r.mimg==null? "default.webp" : r.mimg}" class="hpimg">`;
			document.querySelector('.mid').innerHTML = r.mid;
			document.querySelector('.bdate').innerHTML = r.bdate;
			document.querySelector('.bview').innerHTML = r.bview;
			document.querySelector('.bup').innerHTML = r.bup;
			document.querySelector('.bdown').innerHTML = r.bdown;	
			document.querySelector('.bup2').innerHTML = r.bup;
			document.querySelector('.bdown2').innerHTML = r.bdown;				
			document.querySelector('.replycount').innerHTML = '댓글개수 : ' + r.rcount ;
			document.querySelector('.btitle').innerHTML = r.btitle;
			document.querySelector('.bcontent').innerHTML = r.bcontent;
			if(r.bfile == null){ // 첨부파일 없을때
				document.querySelector('.bfile').innerHTML = '첨부파일 없음';
			}else{ // 첨부파일 있을때
				html = `${r.bfile} <button class="bbtn" type="button" onclick="bdownload('${r.bfile}')">다운로드</button>`
				document.querySelector('.bfile').innerHTML = html;
			}
			// 로그인 된 회원과 작성자가 일치하면 수정/ 삭제 버튼 출력
			if(memberinfo.mid==r.mid){
				html = `<button onclick="bdelete(${bno},${r.cno})" type="button">삭제</button>
						<button onclick="bupdate(${bno})" type="button">수정</button>`;
				document.querySelector('.btnbox').innerHTML = html;
			}
			// 댓글 출력
			getReplyList(bno);
			
		} // success e
	}) // ajax e
} // getBoard e

function bdownload(bfile){
	console.log('bdownload s')
	console.log(bfile)
	/*
	$.ajax({
		url : "/jspweb/filedownload",
		method : "get",
		data : { "bfile" : bfile},
		success : (r)=>{
			console.log('bdownload ajax s')
			console.log(r)
		} // success e
	}) // ajax e
	*/
	location.href="/jspweb/filedownload?bfile="+bfile;
	
} // bdownload e

// 3. 조회수[1] 좋아요수[2] 싫어요수[3]
bIncrease( 1 ); // 현재 jsp/js가 열리는 순간 [ 조회수 증가 ]
function bIncrease( type ){
	// 2. 
	$.ajax({
		url : "/jspweb/board/view",
		method: "get" , 
		data : { "type" : type , "bno" : bno  },
		success : (r)=>{
			getBoard(); // 새로고침
		} // success e
	}) // ajax e
} // bIncrease e


// 4. 게시글 삭제
function bdelete(bno,cno){
	$.ajax({
		url : "/jspweb/board/info",
		method : "delete",
		data : { "type" : 1 , "bno" : bno},
		success : (r)=>{
			if(r=='true'){
				alert('삭제 성공')
				location.href="/jspweb/board/list.jsp?cno="+cno;
			}else{alert('삭제 실패')}
		} // success e
	}) // ajax e
} // bdelete e

// 수정함수 = 수정페이지로 이동
function bupdate(bno){
	location.href = "/jspweb/board/update.jsp?bno="+bno;
}


// 6. 댓글쓰기 함수
function rwrite(){
	console.log('rwrite 함수 시작')
	$.ajax({
		url : "/jspweb/board/reply",
		method : "post",
		// 타입 1 : 최상위 댓글 작성, 타입 2 : 대댓글 작성
		data : { "type" : 1 ,"bno" :bno , "rcontent" : document.querySelector('.rcontent').value},
		success : (r)=>{
			console.log('write ajax 성공')
			if(r=='true'){
				alert('최상위 댓글 작성 성공')
				document.querySelector('.rcontent').value = '';
				// 특정 div만 새로고침[랜더링]
				// $(".replyListBox").load(location.href+' .replyListBox');
				// 현재페이지 새로고침[랜더링]
				location.reload();
			}else{alert('최상위 댓글 작성 실패')}
		} // success e
	}) // ajax e
} // rwrite e

// 7. 상위 댓글 출력 함수
function getReplyList(){
	$.ajax({
		url : "/jspweb/board/reply",
		method : "get",
		data : {"type" : 1, "bno" : bno},
		success : (r)=>{
			console.log('댓글출력 ajax 성공')
			let html = '';
			r.forEach((o)=>{
				console.log(o)
				if(o.rindex==0){
					html += `<div classs="reply${o.rno}">
								<span><img src="/jspweb/member/pimg/${o.mimg==null? "default.webp" : o.mimg}" class="replyimg"></span>
								<span>${o.mid}</span>
								<span>${o.rdate}</span>
								<span>${o.rcontent}</span>	
								<button class="bbtn" onclick="rereplyview(${o.rno})" type="button">답글보기</button>
								<div class="rereplybox${o.rno}">
								</div>				
							</div>`
				} // if e
			}) // forEach e
			document.querySelector('.replyListBox').innerHTML = html;
		} // success e
	}) // ajax e
} // getReplyList e

// 8. 하위 댓글 출력 함수
function rereplyview(rno){
	console.log('대댓글 출력 함수 s')
	let rereplybox = `rereplybox${rno}`
	let html = ``;
	$.ajax({
		url : "/jspweb/board/reply",
		async : 'false', //동기식 통신
		method : "get",
		data : { "type" : 2, "rindex" : rno, "bno" : bno},
		success : (r)=>{
			console.log('댓글출력 ajax 성공')
			r.forEach((o)=>{
				if(o.rindex==rno){
					html += `<div class="rreply">
								<span><img src="/jspweb/member/pimg/${o.mimg==null? "default.webp" : o.mimg}" class="replyimg"></span>
								<span>${o.mid}</span>
								<span>${o.rdate}</span>
								<span>${o.rcontent}</span>	
								<button onclick="rereplyview(${o.rno})" type="button">답글보기</button>
								<div class="rereplybox${o.rno}">
								</div>				
							</div>`
				} // if e
			}) // forEach e
			html += `
					<div class="rreply">
						<textarea class="rrcontent${rno}"></textarea>
						<button onclick="rrWrite(${rno})" type="button" >대댓글달기</button>
					</div>
					`;
			document.querySelector('.'+rereplybox).innerHTML = html
		} // rereplyview e
	}) // ajax e
} // getReplyList e

// 9. 최상위 댓글 외 댓글 작성 함수
function rrWrite(rno){
	// bno, mno, rrcontent, rindex(현재 입력하려는 댓글의 상위댓글번호), type
	let rrcontent = `rrcontent${rno}`
	$.ajax({
		url : "/jspweb/board/reply",
		method : "post",
		// 타입 1 : 최상위 댓글 작성, 타입 2 : 대댓글 작성
		data : {"type" : 2, "bno" : bno , "rindex" : rno, "rcontent" : document.querySelector('.'+rrcontent).value },
		success : (r)=>{
			console.log('대댓글 작성 ajax 성공')
			console.log(r)
			if(r=='true'){
				alert('대댓글 작성 성공')
				document.querySelector('.'+rrcontent).value = '';
				// 특정 div만 새로고침[랜더링]
				// $(".replyListBox").load(location.href+' .replyListBox');
				// 현재페이지 새로고침[랜더링]
				location.reload();
			}else{alert('대댓글 작성 실패')}
		} // success e
	}) // ajax e
} // rrwrite e















/*
	함수에 가져오는 매개변수를 문자로 가져오지 않고 파일명.확장자로 가져오면 
	.확장자를 구분기호가 아닌  .접근연산자로 사용됨
	-> 파일명.확장자 	[ X ]
	-> '파일명.확장자' [ O ]
	
	2. 
		전송 방법
			HTML 	: 	1.<form> 2.<a href="">
			JS 		: 	1.location.href=""
			JQUERY 	:	1.$.ajax({})
			servlet :	
				1.response.getwriter.print(); 
				2.response.sendRedirect('경로');


 */



















