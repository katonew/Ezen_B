console.log('update js 열림')
console.log(memberinfo)

let bno = document.querySelector('.bno').value;
console.log('bno : '+bno)
getBoard()

// 1. 수정할 게시물 출력
function getBoard(){
	$.ajax({
		url : "/jspweb/board/info",
		method : "get",
		data : {"type" : 2 , "bno" : bno },
		success : (r)=>{
			document.querySelector('.btitle').value = r.btitle
			document.querySelector('.bcontent').value = r.bcontent
			// 1. 기존 select option 가져와서 selected
			let cnoSelect = document.querySelector('.cno');
			console.log('cnoSelect : '  + cnoSelect);
			console.log('cnoSelect.options[0] : '  + cnoSelect.options[0]); // select 안에 있는 첫번째 option
			for(let i=0;i<cnoSelect.options.length;i++){
				// i는 0부터 옵션태그 개수만큼 반복
				if(cnoSelect.options[i].value== r.cno){
					// i번째 옵션태그의 값과 현재 게시물의 카테고리번호가 일치하면
					cnoSelect.options[i].selected = true;
				}
			} // for e
			// 2. 첨부파일 있을때 / 없을때
			let html='';
			if(r.bfile==null){ // 없을때
				 html += '<div>첨부파일 없음</div>';
			}else{ //있을때
			html += `<div>
						기존 첨부파일 : <span class="oldbfile"></span> 
						<button onclick="bfileDelete(${bno})" type="button">첨부파일 삭제</button>
					</div>`
			}
			html += `변경할 첨부파일 : <input type="file" name="bfile">`
			document.querySelector('.bfilebox').innerHTML = html;
			document.querySelector('.oldbfile').innerHTML = r.bfile;
		}//success e
	
	}) // ajax e
} // getboard e

// 2. 게시글 수정
function bupdate(){
	let updateForm = document.querySelectorAll('.updateForm')[0];
	
	// 1. form 안에 있는 데이터 객체화
	let updateFormData = new FormData(updateForm);
		// form 밖에 있거나 JS에 있는 추가 데이터는 fromData에 추가 가능
		// formdata객체명.set('변수명' , 데이터)
	// 수정할 대상이 필요하기 때문에 (게시글 등록때는 bno이 생성되는 것이지만 수정은 수정할 대상이 필요)
	updateFormData.set('bno',bno); 
	
	$.ajax({
		url : "/jspweb/board/info",
		method : "put",
		data : updateFormData,
		processData : false,
		contentType : false,
		success : (r)=>{
			if(r=='true'){
				alert('수정완료')
				location.href="/jspweb/board/view.jsp?bno="+bno
			}else{alert('수정실패')}
		}
	})
}

// 3. 첨부파일만 삭제
function bfileDelete(bno){
	alert('첨부파일을 삭제합니다.')
	$.ajax({
		url : "/jspweb/board/info",
		method : "delete",
		data : {"type" : 2 , "bno" : bno},
		success : (r)=>{
			if(r=='true'){
				// 특정 div만 reload[랜더링] 방법
				$(".oldbfile").load(location.href+' .oldbfile')
				/*
					// 주의점!! : 클래스명 앞의 . 앞에 띄어쓰기
						location.href+' .클래스명'
					// load : jquery에서 제공하는 랜더링 함수
				
				
				
					해당 클래스명을 가진 태그 객체화
					Jquery : $(".클래스명")
					vs
					js : document.queryselector('.bfilebox)
				
				 */
			}else{alert('첨부파일 삭제 실패')}
		} // success e
	}) // ajax e
}

 $(document).ready(function() {
        $('#summernote').summernote(
			{height : 700}			
		);
    });



























