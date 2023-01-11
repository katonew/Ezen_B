/*
과제1 : 입력 상자에 학번[8자리] 입력후 로그인 버튼 클릭시 배열에 존재하면 로그인 성공 출력 / 로그인 실패
	[조건 1] const studentArray = ['20230110' , '20230109' , '20230108' ]
	[조건 2] 입력 < input > 사용
	[조건 3] <button> 사용해서 로그인 이벤트 실행


과제2 :  입력 상자에 학번[8자리] 입력 후에 배열에 저장했으면 성공, 아니면 실패 출력
	[조건 1] const studentArray 배열에 push 등록한다.
	[조건 2] 만약에 동일한 학번이 존재하면 '실패' 출력 아니면 성공 출력
	[조건 3] 등록 <button> 사용해서 등록 이벤트 실행
----------------------------------------------------------------------
	*추가
	 	1. 만약에 입력상자에 공백이면 '학번을 입력해주세요' 출력					[' ']
		2. 등록이나 로그인 시 성공시에 입력상자에 input에 value 다시 공백으로 초기화	[value]
		3. 입력상자[input]에 입력한 데이터가 8자리가 아니면 8자리로 입력해주세요.		[length]
 */

const studentArray = ['20230110' , '20230109' , '20230108' ]

function onLogin(){ //onLogin 함수 시작
	//<input> 마크업을 js변수로 가져오기 [DOM 객체]
	let class_num = document.querySelector('.class_num')
	// <input>마크업에 입력된 데이터 호출
	let sname = class_num.value
	//출력을 위한 지역변수 생성
	let resultBox = document.querySelector('.resultBox')
	// 입력한것이 없으면 학번입력
	if(sname=="") 
		resultBox.innerHTML = '학번을 입력해주세요!';
	// 입력한 숫자가 8자리가 아니면 8자리 입력하라는 출력
	else if(sname.length!=8)
		resultBox.innerHTML = '학번을 8자리로 입력해주세요!';
	// 배열내에 입력한 값이 존재했으면 로그인 성공
	else if(studentArray.indexOf(sname)!=-1){
		resultBox.innerHTML = '로그인성공!';
		// 로그인 성공 시 input의 데이터 공백으로 초기화
		resultBox.value = "";
		}
	//배열내에 입력한 값이 존재하지 않았으면 로그인 실패
	else 
		resultBox.innerHTML = '알수없는 학번입니다!'
	// 배열 확인용
	console.log(studentArray)
	
} //onLogin 함수 끝


function join(){ //join함수 시작
	//<input> 마크업을 js변수로 가져오기 [DOM 객체]
	let class_num2 = document.querySelector('.class_num2')
	// <input>마크업에 입력된 데이터 호출
	let sname2 = class_num2.value
	//출력을 위한 지역변수 생성
	let resultBox2 = document.querySelector('.resultBox2')
	//입력한것이 없으면 학번입력
	if(sname2=="")
		resultBox2.innerHTML = '학번을 입력해주세요!';
	//입력한 숫자가 8자리가 아니면 8자리 입력하라는 출력
	else if(sname2.length!=8)
		resultBox2.innerHTML = '학번을 8자리로 입력해주세요!';
	// 배열내에 입력한 값이 존재했으면 이미 있는 학번이라는 출력
	else if(studentArray.indexOf(sname2) != -1) 
		resultBox2.innerHTML = '이미 있는 학번입니다!';
	// 배열 내에 입력한 값이 존재하지 않으면 배열 내에 입력한 값 등록, 등록 성공 문구 출력, input 초기화
	else {
		studentArray.push(class_num2.value); 
		resultBox2.innerHTML = '학번 등록 성공!'; 
		resultBox2.value = "";
	}
	//배열 확인용
	console.log(studentArray)
} //join함수 끝

function del(){ //del함수 시작
	//<input> 마크업을 js변수로 가져오기 [DOM 객체]
	let class_num3 = document.querySelector('.class_num3')
	// <input>마크업에 입력된 데이터 호출
	let sname3 = class_num3.value
	//출력을 위한 지역변수 생성
	let resultBox3 = document.querySelector('.resultBox3')
	//입력한것이 없으면 학번입력
	if(sname3=="")
		resultBox3.innerHTML = '학번을 입력해주세요!';
	//입력한 숫자가 8자리가 아니면 8자리 입력하라는 출력
	else if(sname3.length!=8)
		resultBox3.innerHTML = '학번을 8자리로 입력해주세요!';
	// 배열내에 입력한 값이 존재하면 학번 삭제
	else if(studentArray.indexOf(sname3) != -1) {
		resultBox3.innerHTML = '학번을 삭제하였습니다.';
		studentArray.splice(studentArray.indexOf(sname3),1); 
		resultBox3.value = "";
		}
	// 배열내에 입력한 값이 존재하지 않으면 학번없음 출력
	else {
		resultBox3.innerHTML = '없는 학번입니다.';
	}
	//배열 확인용
	console.log(studentArray)
} //del함수 끝






