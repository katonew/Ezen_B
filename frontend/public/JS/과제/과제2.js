
/*
	주제 : 입력 구구단 만들기
		*조건1 : 단[input] 과 곱[input] 입력받기 
		*조건2 : 확인[button] 클릭하면 결과 실행
		*조건3 : 테이블에 출력
 */
//table의 초기 값 가져오기
let table = ''

function onResult(){ //함수 s
	//반복할때마다 초기화 되기 위해 선언당시에는 비우고 함수 시작시 단곤값 입력
	table = '<tr><th>단</th><th>곱</th><th>값</th></tr>'
	
	//<input> 마크업을 js변수로 가져와 바로 대입
	let dan = document.querySelector('.dan').value
	let gob = document.querySelector('.gob').value
	
//for문 i=1부터 입력된 곱까지, i * 입력된단을 sum에 대입한 후 table에 입력하는 것까지 반복
	for(i=1; i<=곱; i++){	//for s
		//곱셈 결과값 
		sum = (단 * i);
		//테이블행에 추가
		table += '<tr><td>'+단+'</td><td>'+ i +'</td><td>'+sum+'</td></tr>'
	}	//for e
	//html에 있는 'gu_table' 테이블에 추가
	document.querySelector('.gu_table').innerHTML = table
}	//함수 e
