
/*
	주제 : 입력 구구단 만들기
		*조건1 : 단[input] 과 곱[input] 입력받기 
		*조건2 : 확인[button] 클릭하면 결과 실행
		*조건3 : 테이블에 출력
 */

function onResult(){ //함수 s
	//반복할때마다 초기화 되기 위해 함수 시작시 입력
	let table = '<tr><th>단</th><th>곱</th><th>값</th></tr>'
	//<input> 단과 곱에 입력된 value 값 각 변수에 저장
	let dan = document.querySelector('.dan').value
	let gob = document.querySelector('.gob').value
	//for문 i=1부터 입력된 곱까지, i * 입력된단을 sum에 대입한 후 table에 입력하는 것까지 반복
	for(i=1; i<=gob; i++){	//for s
		//테이블행에 추가
		table += '<tr><td>'+dan+'</td><td>'+ i +'</td><td>'+(dan * i)+'</td></tr>'
	}	//for e
	//html에 있는 'gu_table' 테이블에 추가
	document.querySelector('.gu_table').innerHTML = table
}	//함수 e
