console.log('write js 열림')

console.log(memberinfo)
/*if(memberinfo.mid==null){
	alert('로그인하지 않으면 글을 쓸 수 없습니다.')
	location.href= "/jspweb/member/login.jsp";
}*/

function bwrite(){
	// 1. 폼 가져오기
	let writeForm = document.querySelectorAll('.writeForm')[0];
	// 2. 폼 객체 ---> new FormData 클래스
	let writeFormData = new FormData(writeForm);
	console.log(writeFormData);
	
	
	$.ajax({
		url : "/jspweb/board/info",
		method : "post",
		data : writeFormData,
		contentType : false ,			
		processData : false ,	
		success : (r)=>{
			console.log('write ajax 응답');
			console.log(r)
			if(r=='true'){
				alert('글쓰기 성공')
				console.log(document.querySelector('.cno').value)
				//location.href="/jspweb/board/list.jsp?cno="+document.querySelector('.cno').value;
			}else{alert('글쓰기 실패')}
			
		} // success e
	}) // ajax e
} // bwrite e