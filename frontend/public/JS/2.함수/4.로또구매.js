console.log('1.js작동')
// 1. 숫자 버튼 출력하는 함수
function 버튼출력(){
	console.log('2.함수작동')
	let 버튼목록 = ''; //for 밖에 만든 이유 : 45개의 버튼을 저장 하려고
	//for
	for(let i=1; i<=45; i++){ //for s
		console.log('3. 함수작동 : ' + i);
		//만약에 i가 5의 배수이면 줄바꿈
		버튼목록 += `<button onclick="버튼클릭(${i})">${i}</button>`
		if(i%5==0){버튼목록 += '<br/>'}
	} // for e
	console.log('4. : ' + 버튼목록)
	//해당 div에 목록값 넣어주기
	document.querySelector('.버튼목록상자').innerHTML = 버튼목록
	
	//취소버튼을 보이게 활성화
	document.querySelector('.취소버튼').style.display = 'inline'
}

//2. 숫자 버튼 삭제하는 함수
function 버튼출력취소(){
	//해당 div에 ''공백으로 변경하기
	document.querySelector('.버튼목록상자').innerHTML = ''
	//취소하면 버튼 안보이게 비활성화
	document.querySelector('.취소버튼').style.display = 'none'
	
	//배열 내 모든 요소 제거
	선택번호목록.splice(0); // 0번 인덱스부터 (개수) 생략했을때 모두 제거
	추첨버튼출력();
}

//1.선택한 숫자를 여섯개 저장하는 배열 생성
let 선택번호목록 = []

//3. 버튼 클릭 함수
function 버튼클릭(i){
	console.log(i + '번 버튼을 클릭하셨군요.')
	
	// 유효성 검사 1. 중복검사/취소
	if(선택번호목록.indexOf(i)>= 0){ //if s
		alert('이미 선택한 번호입니다.[해당 번호는 삭제되었습니다]')
		//배열명.splice(인덱스, 개수) : 해당 인덱스부터 개수만큼 삭제
		선택번호목록.splice(선택번호목록.indexOf(i),1)
		추첨버튼출력();
		return;	//반환값은 없지만 함수를 끝낼 수 있다.[ 더이상 아래로 코드가 실행되지 않는다.]
	} //if e
	
	// 유효성 검사 2. 6개까지만 저장
	if(선택번호목록.length==6){
		alert('이미 모두[6개]를 선택하였습니다.')
		return;
	}
	
	// 위 2가지 유효성 검사를 충족하지 않았을 때 저장
	선택번호목록.push(i)
	추첨버튼출력();		//함수 호출
	//추첨버튼 활성화 / 비활성화

}

//4. 선택번호목록 출력 및 추첨버튼 활성화/비활성화 [1.구매취소 2. 버튼클릭시 숫자등록 3.버튼클릭시 숫자취소]
function 추첨버튼출력(){	
	if(선택번호목록.length==6){
		document.querySelector('.추첨버튼').style.display = "inline"
	}else{
		document.querySelector('.추첨버튼').style.display = "none"
	}
	document.querySelector('.선택번호상자').innerHTML = 선택번호목록
}

//2. 추첨번호목록 배열 선언
let 추첨번호목록 = [ ]

//5. 추첨하기 버튼을 클릭했을때 함수
function 구매추첨(){
	
	//1. 컴퓨터가 난수 발생[1~45사이의 수 6개]
	for( let i =1; i<=6; i++){ // i는 1부터 6까지 1씩 증가 반복처리
		// 1. 난수 만들기
		let 실수난수 = Math.random()*45+1
		//2. 실수 --> 정수 만들기
		let 정수난수 = parseInt(실수난수)
		
			// * 중복검사
			if(추첨번호목록.indexOf(정수난수)>=0){ // 이미 존재한 난수이면
				i--;	//난수가 중복되어 저장하지 못하면 i를 1뺄셈하여 한번더 for문 발생
			}else{ //배열내 존재하지 않는 난수이면
				//3. 정수난수를 배열에 저장
				추첨번호목록.push(정수난수)
			}
		// 1~3 == 추첨번호목록.push(parseInt(Math.random()*45+1))
	} //for e
	console.log(추첨번호목록)
	document.querySelector('.추첨번호상자').innerHTML = 추첨번호목록
	// 추첨결과출력 [두 배열간 동일한개수와 등수[6개->1등, 5개->2등, 4개->3등, 3개->4등, 나머지는 꽝] 출력]
/*	//1.
	let 맞은개수 = 0;
	for(let i= 0; i<추첨번호목록.length; i++){
		for(j=0; j<선택번호목록.length; j++){
			if(추첨번호목록[i]==선택번호목록[j]){맞은개수++}
		}
	}
	//2.
	맞은개수 = 0
	for(let i=0 ; i<추첨번호목록.length;i++){
		if(선택번호목록.indexOf(추첨번호목록[i])>=0){맞은개수++}
	}
	*/
	
	//3. for (반복변수 of 배열) : 배열내 요소 하나씩 마지막 요소까지 반복변수에 대입
	맞은개수 = 0
	for(let value of 추첨번호목록){
		if(선택번호목록.includes(value)){맞은개수++}
	}
	alert("동일한 개수 : " + 맞은개수)
}

/*
	1. 난수만들기
		1. Math 클랙스[미리 만들어둔 설계도]
			1.random() 함수 [ Math클래스가 제공하는 미리 만들어둔 함수]
			예시)
				Math.random() 		: 0 ~ 1 사이의 실수 난수 발생
				Math.random()+1 	: 1 ~ 2 사이의 실수 난수 발생
				Math.random(45)		: 0 ~ 45 사이의 실수 난수 발생 
				Math.random(45)+1	: 1 ~ 46 사이의 실수 난수 발생 
			2. floor( ) : 소수점 버림 함수
				Math.floor(3.14) : 3
				
		2. parseInt( ) : 정수 변환 함수
			parseInt(3.14) : 3
			
	2. 두 배열 비교하기
		1.
			배열1 : 3 7 2 5
			배열2 : 1 5 3 4
 */



/*
		'<button onclick="버튼클릭(' + i + ')">1~45</button>'
		1. 문자열 처리
			'html문자열~~~~~~' + 변수 + 'html문자열~~~~~~'
			ex) '<button onclick="버튼클릭(' + i + ')">1~45</button>'
		2. 백틱 이용한 문자열 처리
			 `(백틱 = esc 아래) : 작음따옴표 아님
			 1. 전체를 ``로 감싼다
			 2. 변수/수식/함수호출 등은 ${ } 감싼다
			 ex) `<button onclick="버튼클릭(${i})">${i}</button>`


*/





