console.log('view js 열림')
getBoard()
function getBoard(){
	console.log('getBoard function s')
	let bno = document.querySelector('.bno').innerHTML
	console.log("bno : "+bno)
	$.ajax({
		url : "/jspweb/board/info",
		method : "get",
		data : {"type" : 2, "bno" : bno},
		success : (r)=>{
			console.log('게시물 개별출력 ajax 성공')
			console.log(r)
			
			let html = `${r.bdate} /
						${r.bview} /
						${r.bup} /
						${r.bdown}`;
			
			document.querySelector('.infobox').innerHTML = html;
			document.querySelector('.pimgbox').innerHTML = r.mid;
			document.querySelector('.btitle').innerHTML = r.btitle;
			document.querySelector('.bcontent').innerHTML = r.bcontent;
			if(r.bfile == null){ // 첨부파일 없을때
				document.querySelector('.bfile').innerHTML = '첨부파일 없음';
			}else{ // 첨부파일 있을때
				html = `${r.bfile} <button type="button" onclick="bdownload('${r.bfile}')">다운로드</button>`
				document.querySelector('.bfile').innerHTML = html;
			}
			
			
		}
	})
}

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
	
}


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



















