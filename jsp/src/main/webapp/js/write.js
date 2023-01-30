
let 게시물임시저장소 = []

//1. 글 등록 버튼을 클랙했을때 함수
function board_write(){
	// [ 첨부파일이 없는 경우]
	//1. 입력받은 데이터 하나씩 가져와서 객체화
	let board={
		btitle : document.querySelector('.btitle').value,
		bcontent: document.querySelector('.bcontent').value,
		bwriter : document.querySelector('.bwriter').value,
		bpassword : document.querySelector('.bpassword').value
		//첨부파일은 가져올 수 없음
	}
	// [첨부파일 있을 경우]
		// 1. 입력양식 form을 가져와서 하나의 객체화 가져오기
	let writeform = document.querySelector('.writeform');
	let formdata = new FormData(writeform)
	
	//* 유효성 검사 생략
	
	//2. JAVA에게 데이터 전송후 전송된 결과를 받는다 [통신-AJAX 등] //생략
		//*
		게시물임시저장소.push(board)	
		console.log(게시물임시저장소)
	//3. 결과에 따른 이벤트
	let result = false; //JAVA로 부터 전송결과
	if(result) { alert('글쓰기 성공'); location.href = 'list.html';}
	else{alert('글쓰기 실패')}
	/*
		페이지 전환 함수
			location.href = '경로'
	
	 */
}




























// 섬머노트 api 실행
/*$(document).ready(function() {
  $('#summernote').summernote({
	  
	  height : 300,
	  lang: 'ko-KR'
	  
	  });
});*/