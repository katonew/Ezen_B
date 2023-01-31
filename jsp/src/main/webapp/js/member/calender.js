/*
	new Date() 날짜/시간 관련된 클래스
		1. let date = new Date() :  현재 날짜/ 시간 객체
		2. let date = new Date( year, month, day) : 사용자 정의 날짜/시간 객체
		3. date.getDate(year,month,0) : 마지막 일을 구해줌
		4. date.getDate(year,month,1) : 첫 일을 구해줌
			1.get 함수제공
				1.getFullYear() 	: 연도
				2.date.getMonth()	: 월 [0~11로 표현]
				3.date.getDate()	: 일
				4.date.getDay()		: 요일 [ 0~6으로 표현 0이 일요일]
				
	` 백틱 `
		` 문자열 ${함수}`
*/

let content = []
// 전역변수 사용 : 모든 함수 { }에서 공용으로 사용되는 메모리[변수]
// 1. JS 열렸을때 현재 연도와 월을 구하여 변수에 저장
let year = new Date().getFullYear(); 	// 기본값 : 현재 연도
let month = new Date().getMonth()+1;	// 기본값 : 현재 월

cal_print() //JS 열렸을때 표시
// 2. 캘린더 상단에 표시 [1.js열렸을때 2.이전/다음버튼 눌렀을때]
function cal_print(){
	// 1. 상단에 년/월 표시
	document.querySelector('.top_date').innerHTML = `${year}년 ${month}월`;
	
	// 2. 현재 설정된 날짜 객체
	let date = new Date( year, month , 0); 
	//console.log('현재 캘린더 날짜 : ' + date);
	
	// 3. html '요일' 구성
	let html = `<div class="day weekday sunday">일</div>
				<div class="day weekday">월</div>
				<div class="day weekday">화</div>
				<div class="day weekday">수</div>
				<div class="day weekday">목</div>
				<div class="day weekday">금</div>
				<div class="day weekday">토</div>`
				
	
		// * 1.현재 설정된 월의 마지막 일 구하는 방법
	let lastday = new Date(year, month, 0).getDate();
		// * 2. 현재 캘린더 설정된 날짜의 1일 시작요일 구하기
	let weekday = new Date(year, month-1, 1).getDay();
	
	//console.log(weekday);
	
	// 1일 시작 전 공백 만들기
	for(let b=0; b<weekday;b++){
		html += `<div class="day"></div>`
	}
	
	// 일 만들기 [1일부터 ~ 마지막 일(월마다 다름)까지]
	for(let day=1;day<=lastday;day++){
		// 4. 1일~마지막일 날짜확인
		let date = dateformat(new Date(year,month-1,day));
		//현재 날짜의 요일
		let today = new Date(year, month-1, day).getDay();
		//console.log(date)
		html += `<div class="day ${today==0?`sunday`:``}" onclick="openModal(${date})">${day}${content_print(date)}</div>`
	}
	// 4. 마크업 출력
	document.querySelector('.cal_day').innerHTML = html;
	
}

// 3. 이전달 다음달 버튼 이벤트에 따른 연도와 월이 변경

document.querySelector('.previousbtn').addEventListener('click',()=>{
	//console.log('이전버튼 클릭')
	//1.만약에 month를 1 차감한 후 1보다 작다면 연도에서 1차감 후 월 12로 설정
	month--;
	if(month<1){year--;	month = 12;cal_print();}
	cal_print();
})

document.querySelector('.nextbtn').addEventListener('click',()=>{
	//console.log('다음버튼 클릭')
	//1.만약에 month를 1 증감한 후 12보다크면 연도에서 12차감 후 월 1로 설정
	month++;
	if(month>12){year++; month = 1;cal_print();}
	cal_print();
})



// 4. 날짜 포멧 함수 [인수 : 날짜---로직[포멧]--> 반환 : 변경된 날짜형식]
function dateformat(date){
	let d_year = date.getFullYear();
		//만약에 월/요일이 한자리수 이면 앞에 0 붙이기
	let d_month = (date.getMonth()+1) <= 9? '0'+(date.getMonth()+1) : (date.getMonth()+1);
	let d_day = date.getDate() <=9? '0'+date.getDate() : date.getDate();
	return `${d_year}${d_month}${d_day}`;
}


// 5. 일정출력함수
function content_print(date){
	console.log(date)
	//1.인수로 전달 된 날짜와 동일한 일정 날짜 찾기
		//1.html 선언
	let html = ``
	content.forEach((o)=>{
		if(date==o.date){
			html += `<div class="content" style="background-color : ${o.bg_color}">${o.content}</div>`
		}
	}) // for end
	return html;
}

// 6. 모달 열기 함수
function openModal(date){
	// 1. 모달 보이게 하는 설정
	document.querySelector('.modal_wrap').style.display = 'flex'
	// 2. 모달에 선택된 날짜 출력
	document.querySelector('.modal_date').innerHTML = date;
	// 3. 모달에 선택된 날짜에 있는 모든 일정 출력
	let temp = 0; // 해당 날짜의 일정 순서 변수
	// 기본 html
	let html = '<tr><th width="5%">#</th><th>일정내용</th><th width="20%">비고</th></tr>'
	for(let i=0;i<content.length;i++){
		if(content[i].date==date){
			temp++; //일정 순서 ++
			html += `<tr>
					<td>${temp}</td>
					<td>${content[i].content}</td>
					<td>
						<button type="button" onclick="onDelete(${i},${date})">삭제</button>
					</td>`
		} // if e
	} // for e
	document.querySelector('.modal_table').innerHTML = html;
} // fun e

// 7.모달에서 닫기 버튼 함수
document.querySelector('.modal_close').addEventListener('click',()=>{
	document.querySelector('.modal_wrap').style.display = 'none'
})


// 8. 모달에서 등록 버튼 함수
document.querySelector('.modal_write').addEventListener('click' , (e) => {
	//1. 입력받은 내용과 선택된 날짜를  가져온다.
	let contents = {
		date : document.querySelector('.modal_date').innerHTML,
		content : document.querySelector('.modal_input').value,
		bg_color : document.querySelector('.modal_color').value
	}
	//2. 유효성검사 - 생략
	//3. 배열저장
	console.log(contents)
	content.push(contents);
	//4. 화면 업데이트
	document.querySelector('.modal_input').value = '' // 1. 입력칸 초기화
	document.querySelector('.modal_wrap').style.display = 'none' // 2. 모달 닫기
	cal_print(); // 3. 캘린더 재출력[렌더링]
})
//모달 삭제 버튼 함수
function onDelete(i,date){
	console.log('삭제버튼 실행')
	content.splice(i,1)
	openModal(date);
	cal_print()
}











/*let date = new Date();
console.log('date : ' + date)
let date2 = new Date(2020,1,31)
console.log('date : ' + date2)
console.log('연도 :' + date.getFullYear())
console.log('월 : ' + date.getMonth())
console.log('일 : ' + date.getDate())
console.log('요일 : ' + date.getDay())
*/














