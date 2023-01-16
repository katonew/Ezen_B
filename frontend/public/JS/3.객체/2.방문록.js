console.log('1.js 실행')

//*배열선언 [ board 객체 여러개를 저장하는 배열 / 함수 밖에 있는 이유 : 누적 저장]
let boardArray = []
	//예시 : [{속성:값}, {속성:값}, {속성:값}, {속성:값}, {속성:값}]
//1. 작성 버튼 클릭 시 실행되는 함수
function 작성(){ //작성함수 s onclick
	console.log('2.함수실행')
	
	//1. 입력받은 데이터 가져오기
	let 작성자 = document.querySelector('.작성자').value;
	let 내용 = document.querySelector('.내용').value;
	let 비밀번호 = document.querySelector('.비밀번호').value;
	console.log('작성자 : ' + 작성자)
	console.log('내용 : ' + 내용)
	console.log('비밀번호 : ' + 비밀번호)
	
	//2. 입력받은 여러개의 데이터를 하나로 객체화
	let board = {writer : 작성자 , content : 내용, password : 비밀번호}
	console.log(board)
	
	//3. 객체를 배열에 저장 [ 여러개 객체를 저장하기 위해]
	boardArray.push(board)
	console.log(boardArray)
	출력()
} //작성함수 e


//2. 해당 인덱스의 객체를 1개 삭제 함수
function 삭제(i){ // 삭제함수 s
	//1. [비밀번호 검증] 비밀번호를 입력받는다.
	let 비밀번호확인 = prompt('게시물 비밀번호 입력 : ')
	//2. 입력받은 비밀번호와 내가 선택한 게시물의 비밀번호가 같으면 삭제한다.
		if(boardArray[i].password == 비밀번호확인){ //if s
			boardArray.splice(i,1);	//i번째 인덱스 = 객체 삭제
			alert('게시물 삭제 성공');
			출력();
		} //if e		
		else{alert('비밀번호가 다릅니다. 삭제 실패')}
} //삭제함수 e

//3. 게시물 출력 함수 [1.작성 성공시 2.삭제 성공시]
function 출력(){
	//4. 배열 내 객체 출력
		//1. 테이블의 제목행 만들기
	let html = `<tr><th>번호</th><th>내용</th><th>작성자</th><th>비고</th></tr>`
		//2. 반복문 이용한 배열 내 모든 요소를 행으로 만들기[누적]
			//1. 반복 이용해서 배열 내 객체 하나씩 호출 	: boardArray[i]
			//2. 객체 내 속성 호출 					: boardArray[i].속성명
	for(let i=0; i<boardArray.length; i++){ //for s
		html += `<tr>
					<td> ${i+1} </td>
					<td> ${boardArray[i].content} </td>
					<td> ${boardArray[i].writer} </td>
					<td>
						<button onclick="삭제(${i})">삭제</button>
						<button onclick="수정(${i})">수정</button>
					</td>
				</tr>`;
	} // for e
		//3. 반복문 종료시 누적된 html 해당 table 출력
	document.querySelector('.게시물테이블').innerHTML = html;
}

//4. 해당 인덱스의 객체를 1개 수정 함수
function 수정(i){ // 수정함수 s
	//1. [비밀번호 검증] 비밀번호를 입력받는다.
	let 비밀번호확인 = prompt('게시물 비밀번호 입력 : ')
	//2. 입력받은 비밀번호와 내가 선택한 게시물의 비밀번호가 같으면 수정한다.
		if(boardArray[i].password == 비밀번호확인){ //if s
			let 수정내용 = prompt('수정할 내용 : ')
			//boardArray = 배열
			//boardArray[i] = 배열의 i번째 요소 == 객체
			//boardArray[i].content = 배열의 i번째 요소의 content == board.content
			boardArray[i].content = 수정내용;
			alert('게시물 수정 성공');
			출력();
		} //if e		
		else{alert('비밀번호가 다릅니다. 수정 불가')}
} //수정함수 e

















