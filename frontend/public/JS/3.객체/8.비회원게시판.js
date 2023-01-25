console.log('1.JS열림')
// * 함수 밖에 만드는 이유 : 전역변수 = 모든 함수에서 동일한 메모리 사용
let contents = []
onprint()

	//이벤트함수
		//1.<button type="button" onclick="onwrite()">글 등록</button>
		//2.<button type="button" class="onwriteBtn">글 등록</button>
			//document.querySelector('.onwriteBtn').addEventListener('click', ()=>{})
//1. 글 등록함수
function onwrite(){ // 글 등록 버튼 함수 s
	console.log('2.onwrite 함수 열림')
	
	//1.입력받은 4개 데이터를 하나의 객체 선언
	let info = {
		bwriter : document.querySelector('.bwriter').value,
		bpassword : document.querySelector('.bpassword').value,
		btitle : document.querySelector('.btitle').value,
		bcontent : document.querySelector('.bcontent').value,
		bdate : new Date(), // 현재의 날짜와 시간
		bview : 0 // 조회수
	}
	console.log(info) //객체 정보 출력시 문자열 연결 연산자 금지
	
	//2. 유효성 검사
		//1. 입력받은 데이터 길이 체크
	if(info.bwriter.length <= 0 || info.bpassword.length <= 0 
		|| info.btitle.length <= 0 || info.bcontent.length <= 0){
		alert('작성이 안 된 구역이 있습니다.')
		return; // 함수 종료
	}
	//3.배열에 저장	*추후 : 백엔드에게 통신하여 데이터 전달 [ 백엔드 : java, db ] 
	contents.push(info)
	alert('글 등록 성공')
	console.log(contents)
	onprint()
	document.querySelector('.bwriter').value = ''
	document.querySelector('.bpassword').value = ''
	document.querySelector('.btitle').value = ''
	document.querySelector('.bcontent').value = ''
} // 글 등록 버튼 함수 e

//2. 글 목록 출력 함수 [1.js 열렸을때 2. 글 등록했을때 3. 글 삭제했을때 4. 글 수정했을때]
function onprint(){	//출력함수 s
	console.log('onprint 열림')
	//1. 기본 html 구성
	let html = `<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>`
	//2. 내용 html 구성
	for(let i = 0 ; i<contents.length;i++){
		let date = contents[i].bdate.getFullYear() + '년 ' +
					contents[i].bdate.getMonth()+1 + '월 ' +
					contents[i].bdate.getDate() + '일 ' +
					contents[i].bdate.getHours() + ':' +
					contents[i].bdate.getMinutes() + ':' +
					contents[i].bdate.getSeconds()
		
		html += `<tr onclick="onview(${i})">
					<td>${i+1}</td>
					<td>${contents[i].btitle}</td>
					<td>${contents[i].bwriter}</td>
					<td>${date}</td>
					<td>${contents[i].bview}</td>
				</tr>`
	}
	//3. 테이블 마크업에 html 대입
	document.querySelector('.boardtable').innerHTML = html
} // 글 목록 출력함수 e

//3. 글 보기 함수	[1. 글 목록에서 해당 행을 클릭했을때 ]
function onview(x){ //글보기 함수 s
	contents[x].bview +=1; onprint()
	console.log(x)
	let html = `<div> 제목 : ${contents[x].btitle} </div>
				<div> 내용 : ${contents[x].bcontent}</div>
				<div> 작성자 : ${contents[x].bwriter} </div>
				<div> <button onclick="ondelete(${x})">삭제</button></div>`
	document.querySelector('.viewbox').innerHTML = html
} // 글 보기 함수 e




//4. 글 삭제 함수
function ondelete(x){
	let password = prompt('비밀번호 : ')
	if(password==contents[x].bpassword){
		alert('삭제성공')
		contents.splice(x,1)
		onprint()
		document.querySelector('.viewbox').innerHTML = ''
	}else{
		alert('비밀번호가 다릅니다.')
	}
}

























