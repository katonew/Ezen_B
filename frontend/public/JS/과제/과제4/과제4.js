/*
	주제 : 도서 관리 시스템 (1월 17일까지)
	파일 : 과제4.html, 과제4.js, 과제4.css
		* 배열 두개 : 
					1. let = 도서목록[]
					2. let = 대여목록[]
		
		1. 관리자 입장
			-기능
			1.도서 등록	[도서명]
				1.중복검사
				2.5~10글자 사이의 도서명만 가능	[띄어쓰기 포함]

			2.도서 현황 출력
				1.번호 2.도서명 3.도서대여여부 4.도서삭제[대여중에는 불가능]
								
			도서현황예시)
				번호	도서				도서대여여부		비고
				1	혼자공부하는자바		대여가능 or 대여중	삭제버튼
				2	이것이자바다		대여가능 or 대여중	삭제버튼
				2	C언어				대여가능 or 대여중	삭제버튼
					
		2. 고객 입장
			-기능
			1.도서 목록
				1.번호 2.도서명 3.도서대여버튼 4.도서반납버튼
				
			도서목록예시)
				번호	도서				도서대여여부		비고
				1	혼자공부하는자바		대여가능 or 대여중	대여버튼/반납버튼
				2	이것이자바다		대여가능 or 대여중	대여버튼/반납버튼
				2	C언어				대여가능 or 대여중	대여버튼/반납버튼
				
			2.도서 대여
				대여중인 도서 불가능
				
			3.도서 반납
				대여중이 아닌 도서는 불가능
 */

 //도서입력부분은 내가 작성하는 부분이 아니기 때문에 확인을 위해 먼저 입력
 let 도서목록 = ['혼자공부하는자바','이것이자바다','C언어']
 //대여목록은 빈채로 선언
 let 대여목록 = []
 //반복되는 출력부분 output으로 선언
 let output = document.querySelector('.textBox')
 //첫 페이지 시작 때 출력함수 ( 없으면 테이블이 출력되지 않아 기능사용 불가)
 print()
 
 
 function take(x){ //대여 함수
 	//도서목록에서 데이터 가져옴
 	let book = 도서목록[x]
 	//데이터값이 도서목록에 있는지 확인 [ 있으면 인덱스 번호 들어가고 없으면 -1]
 	let bookname = 도서목록.indexOf(book)
 	//데이터값이 대여목록에 있는지 확인 [ 있으면 인덱스 번호 들어가고 없으면 -1]
 	let noneBook = 대여목록.indexOf(book)
 	//대여목록에 있으면 이미 대여된거
 	if(noneBook!=-1){
		 output.innerHTML = '이미 대여된 책입니다.'
		 return;
	}
	//대여목록에 없으면 대여실행 
 	else{
		 //도서목록에 있는 데이터를 대여목록에 삽입
		 대여목록.push(도서목록[x])
		 output.innerHTML = '대여하였습니다.'
 	}
 	//출력함수
	print()
 } //대여 함수 끝
 
 function retrun(x){ // 반납함수
 	//도서목록에서 데이터 가져옴
  	let book = 도서목록[x]
  	//데이터값이 도서목록에 있는지 확인 [ 있으면 인덱스 번호 들어가고 없으면 -1]
 	let bookname = 도서목록.indexOf(book)
 	//데이터값이 대여목록에 있는지 확인 [ 있으면 인덱스 번호 들어가고 없으면 -1]
 	let noneBook = 대여목록.indexOf(book)
 	//대여목록에 없으면 대여안한 책이라고 뜸
 	if(noneBook==-1){
		 output.innerHTML = '대여하지 않은 책입니다.'
		 return;
	}
	//대여목록에 없으면 대여목록배열에서 삭제하고 반납되었습니다.
 	else{
		 대여목록.splice(noneBook,1)
		 output.innerHTML = '반납되었습니다.'
 	}
 	//출력함수
	print()
	 
 }// 반납함수 끝
 
 function print(){ // 출력함수
 	//초기 헤드라인
 	let html = `<tr><th>번호</th><th>도서</th><th>대여여부</th><th>대여/반납</th></tr>`
	// 내용추가
	for(i=0;i<도서목록.length;i++){
		// 첫째칸 = i+1 = 번호
		// 둘째칸 = 	대여가능여부함수를 사용하기 위해 td에 class를 순차입력, 
		// 			내용물에 대여가능여부함수 순차입력 
		html += `<tr>
					<td>${i+1}</td>
					<td> ${도서목록[i]}</td>
					<td class="list(${i})"> ${possible(i)} </td>
					<td><button onclick="take(${i})">대여</button>
					<button onclick="retrun(${i})">반납</button></td>
					</tr>` 
 	}
 	//출력
 	document.querySelector('.book_table').innerHTML = html
 }

 function possible(x){ //대여여부함수
 	//도서목록에서 데이터 가져옴
   	let book = 도서목록[x]
   	//데이터값이 대여목록에 있는지 확인 [ 있으면 인덱스 번호 들어가고 없으면 -1]
 	let noneBook = 대여목록.indexOf(book)
 	//대여목록에 없으면 대여가능 return
 	if(noneBook==-1){
		 return '대여가능'
	 }
	 //대여목록에 있으면 대여중 return
	 else{ return '대여중'}
 } // 대여 여부 함수 끝
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 