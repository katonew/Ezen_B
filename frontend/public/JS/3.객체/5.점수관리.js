/*
	- 점수관리
		1. 학생 점수 등록 페이지
		2. 학쟁 점수 현황 페이지
*/

// * 학생들의 점수객체를 여러개 저장할 배열
let studentArray = []

//1. JS 열렸을때 <button> 객체 가져오기
let addbtn = document.querySelector('.addbtn')
//2. 해당 버튼에 클릭 이벤트
addbtn.addEventListener('click', ()=>{
	
	//1. 입력받은 데이터 가져와서 객체화
		// * input에 숫자를 입력해도 value는 무조건 문자열로 가져온다. => 형변환 필요
	let info = {
		name : document.querySelector('.name').value,
		kor : parseInt(document.querySelector('.kor').value),
		eng : parseInt(document.querySelector('.eng').value),
		mat : parseInt(document.querySelector('.mat').value)
	}
	console.log(info)
	
	//2. 유효성 검사 [ 데이터 체크 ]
	let check = true; //유효성 검사 상태 저장하는 변수 [아래 4개중 하나라도 충족하면 저장 실패]
		//1. 이름 중복체크
	for(let i = 0; i<studentArray.length;i++){
		if(studentArray[i].name==info.name){
			alert('이미 등록된 이름입니다.')
			check = false;
		}
	}
	
		//2. 점수 0~100 사이만 입력
	if(	(info.kor < 0 || info.kor > 100) ||
		(info.eng < 0 || info.eng > 100) ||
		(info.mat < 0 || info.mat > 100)){
		alert('입력할 수 없는 숫자입니다.')
		check = false;
	} //if e
	
		//3. 이름이 3~5 사이만 입력가능
	if(info.name.length<3 || info.name.length>5){ // if s
		alert('이름은 3~5글자 사이로 입력해주세요')
		check = false;
	} // if e
	
		//4. 점수가 숫자가 아닐경우	[isNaN() : 숫자체크 => [true or false]]
	if(isNaN(info.kor)||isNaN(info.eng)||isNaN(info.mat))	{ //if s
		alert('숫자로 입력하세요.')
		check = false;
	} // if e
	
	//3. 저장 [ 위 유효성검사에서 하나라도 충족하지 않았을 때]
	if(check){
		studentArray.push(info)
		printTable()
	}
	
	console.log(studentArray)
}) //addEvent end

// 배열 내 객체 정보를 테이블에 출력하는 함수 [1.html 열렸을떄 2.등록할 때마다 3.삭제 4.수정]
// 출력 1.번호 2.이름 3.국어 4.영어 5.수학 6.총점 7.평균 8.순위[총점기준]
printTable()
function printTable(){	//출력함수 s
	//1. html 구성
	let html = `<tr>
					<th>번호</th><th>이름</th><th>국어</th>
					<th>영어</th><th>수학</th><th>총점</th>
					<th>평균</th><th>순위</th><th>비고</th>
				 </tr>`
	//2. 배열 내 객체 정보를 html 대입
	studentArray.forEach((o,i) => {		
		//1. 총점
		let total = o.kor+o.eng+o.mat
		//2. 순위 구하기
		let lank = 1;
		studentArray.forEach((o2) => {
			let total2 = o2.mat + o2.kor + o2.eng
			if(total < total2){lank++}
		})
		html += 
				`<tr>
					<th>${i+1}</th>
					<th>${o.name}</th>
					<th>${o.kor}</th>
					<th>${o.eng}</th>
					<th>${o.mat}</th>
					<th>${total}</th>
					<th>${parseInt((total)/3)}</th>
					<th>${lank}</th>
					<th>
						<button onclick="onDelete(${i})">삭제</button>
						<button onclick="onUpdate(${i})">수정</button>
					</th>
				</tr>`
	})
	document.querySelector('.listtable').innerHTML = html
} // 출력함수 e

//3. 배열 내 객체정보 삭제 [ 삭제할 인덱스]
function onDelete(i){ // 삭제함수 s
			studentArray.splice(i,1);	//i번째 인덱스 = 객체 삭제
			//삭제 후 새로고침/ 업데이트
			printTable();
} //삭제함수 e

//4. 수정버튼을 클릭했을때 [ 수정할 인덱스 !!]
let upindex = -1;	// 수정할 인덱스 : 여럿 { }에서 사용하기 위해 밖에서 선언 -> 전역 변수
function onUpdate(i){ // 수정함수 s
	upindex = i
	// 1. 수정페이지 보여주기
	document.querySelector('.updatebox').style.display = 'block'
	
	// 2. 기존의 데이터를 대입
	document.querySelector('.upname').value = studentArray[upindex].name
	document.querySelector('.upkor').value = studentArray[upindex].kor
	document.querySelector('.upeng').value = studentArray[upindex].eng
	document.querySelector('.upmat').value = studentArray[upindex].mat
	
	
	printTable();
} //수정함수 e

// 5. 수정 완료 버튼을 클릭했을때
let updatebtn = document.querySelector('.updatebtn')
updatebtn.addEventListener('click', ()=> {addbtn
	//1.수정될 데이터 가져오기 // 2.해당 객체의 속성 값 변경
	studentArray[upindex].kor = parseInt( document.querySelector('.upkor').value)
	studentArray[upindex].eng = parseInt( document.querySelector('.upeng').value)
	studentArray[upindex].mat = parseInt( document.querySelector('.upmat').value)
	
	// 2. 수정페이지 사라지기
	document.querySelector('.updatebox').style.display = 'none'
	// 3. 수정 후 새로고침
	printTable();
})










/*
	for(i=0;i<studentArray.length;i++){
		let temp = studentArray[i].mat + studentArray[i].kor + studentArray[i].eng
		
		html += `<tr>
					<th>${i+1}</th>
					<th>${studentArray[i].name}</th>
					<th>${studentArray[i].kor}</th>
					<th>${studentArray[i].eng}</th>
					<th>${studentArray[i].mat}</th>
					<th>${temp}</th>
					<th>${temp/3}</th>
					<th>${a}</th>
					<th><button>삭제</button><button>수정</button></th>
				</tr>`
	}
*/


/*
	studentArray.forEach((obj) => { //forEach s
		if(obj.name==info.name){ // if s
			alert('이미 등록된 학생명입니다.')
			return;
		} //if e
	}) //forEach e
*/











