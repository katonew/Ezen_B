
//1. keyup 이벤트 : 키보드 키를 누르고 떼었을때
	//1. <textarea> 마크업 객체화
const textarea = document.querySelector('textarea')
const h3 = document.querySelector('h3')
	//2. 해당 마크업의 이벤트 등록 [ 객체명.addEventListener]
textarea.addEventListener('keyup' , (event) => {
	//3. 해당 마크업 사이에 html 대입 [ 객체명.innerHTML = html형식의 문자]
	h3.innerHTML = `글자 수 : ${textarea.value.length}` 
	//4. 키 상태 확인
		//console.log(event)
		console.log('조합 alt 키 : ' + event.altKey)
		console.log('조합 ctrl 키 : ' + event.ctrlKey)
		console.log('조합 shift 키 : ' + event.shiftKey)
		console.log('code 키 : ' + event.code)
		console.log('name 키 : ' + event.key)
})
//css 조작
textarea.style.position = 'absolute' // static[작성순배치] 기본값으로는 위치지정 불가능
let x = 0; // x축
let y = 0; // y축	/ 상위 마크업 시작점 기준
let block = 10; // 이동단위

print();	//위치 배치 1번 실행

function print(){
	textarea.style.left = `${x*block}px`	//css left = x * 이동단위
	textarea.style.top = `${y*block}px`		//css right = y * 이동단위
}


//2. keydown 이벤트 : 키보드 키를 입력했을때
document.body.addEventListener('keydown', (e) => {
	if(control){ // 만약에 control이 true 인 경우에만 실행
		let key = e.keyCode
		if(key==37){ x--;} 			//왼쪽 키 눌렀을때 		: left에 음수 대입
		else if(key==38){ y--;}  	//윗쪽 키 눌렀을때 		: top에 음수 대입
		else if(key==39){ x++;} 	//오른쪽 키 눌렀을때 	: left에 양수 대입
		else if(key==40){ y++;}		//아래쪽 키 눌렀을때 	: top에 양수 대입
		print();
	} // if e
}) // fun e

// * 이벤트 제어권 변수
let control = true;
//3. 
document.querySelector('.moving').addEventListener('click' , ()=>{
	control = !control //스위치 on/off 변경
	//if(control){control=false} else {control = true}
	//control ? control=false : control = true
	
	
	//고정 스위치
	//control = false; // 제어 변수 변경
})









