/*
	주제 : 방문록 게시판 구현
	조건1 : 방문록 내용을 여러개 담는 배열 선언
		let contentArray =[]
	조건2 : 	내용작성<input> 입력받기
	조건3 : 	등록버튼<button> 등록버튼 클릭시 입력된 데이터가 
			배열에 저장되는 addContent() 함수 실행
	조건4 : 	현재 배열에 저장된 모든 방문록을 <table> 에 출력
	
	<tr>
		<th>번호</th><th>방문록</th>
	</tr>
 */

/*
 //내가 한것
 let contentArray =[]

 function addContent(){
	 //table 시작 부분 입력
	 document.querySelector('.text_table').innerHTML 
	 = "<tr><th>번호</th><th>방문록</th></tr>"
	 //text박스에서 데이터 가져와서 배열에 넣기
	 contentArray.push(document.querySelector('.text').value)
	 // 배열 0번째 인덱스부터 배열길이까지 table에 입력
	 for(i=0;i<contentArray.length;i++){
		 document.querySelector('.text_table').innerHTML 
		 +='<tr><th>'+(i+1)+'</th><th>'+ contentArray[i]+'</th></tr>'; 
 	}
 }
 */

 	//강사님 식
 	contentArray =[]

	function addContent(){
		//text박스에서 데이터 가져와서 배열에 넣기
		let content = document.querySelector('.text').value
		
		// 배열내에 입력받은 변수 저장
		contentArray.push(content)
		
		// 출력할 html 구성
		let html = `<tr><th>번호</th><th>방문록</th></tr>`
		
		// 내용추가
		for(i=0;i<contentArray.length;i++){
			html += '<tr><td>'+(i+1)+'</td><td>'+ contentArray[i]+'</td></tr>'; 
	 	}
	 	
		//위에서 구성된 html을 해당 마크업에 대입
		document.querySelector('.text_table').innerHTML = html

 }
 
