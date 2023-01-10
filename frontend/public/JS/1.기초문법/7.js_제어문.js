/*
	삼항연산자 : 조건 ? 참 : 거짓
	제어문
		If : 만약에~ [ 경우의 수 판단]
		1. 형태
			1. 	if( 조건 ) [true]실행문
			2. 	if( 조건 ) { [true]실행문1; 실행문2; 실행문3; }
				* 실행문 2개 이상일때는 { } 이용한 묶음처리
			3. 	if( 조건 ) { true 실행문;}
				else{false 실행문;]}
			4. 	if( 조건 ){true1 실행문;}
				else if(조건2){true2 실행문;}
				else if(조건3){true3 실행문;}
				else if(조건4){true3 실행문;}
				else{false 실행문;}
			5. 중첩
				if(조건1){
					if(조건2){
						if(조건3){
							
							
						}
						
					}
					
				}
 */

//if 형태1
if(10>3) 	console.log('[참1] 10이 더 크다')
if(10>20) 	console.log('[참2] 10이 더 크다')
if(10>20); 	console.log('[참3] 10이 더 크다') // [틀린 예제]

/*
	; : 세미콜론 [명령어 단위 마침표] 		/ 		: 콜론
	실행문 
	실행문; 실행문;
	if( ) [참] 실행문;		[if() 뒤에 ; 하지 말 것]
 */

//if 형태2
if(10>3) console.log('참1'); console.log('1.10이 더 크다.');		//[x]2번째 console은 if와 상관없이 무조건 출력
if(10>20) console.log('참2'); console.log('2.10이 더 크다.');		//[x]2번째 console은 if와 상관없이 무조건 출력
if(10>20) { console.log('참3');console.log('3.10이 더 크다');}		//[O]

//3. if 형태3
if(10>3) {console.log('[참1] 10이 더 크다.'); }
else{console.log('[거짓1] 10이 더 작다.');}
	// vs 삼항연산자 [ 코드가 길어지면 가독성 떨어짐]
10>3 ? console.log('[참2]') : console.log('[거짓2]')

//4.if 형태4
if(10>=20){ console.log('[참1] 10이 20보다 이상이다.');}			// 만약에 10>=20이면
else if(10>=15){console.log('[참2] 10이 15보다 이상이다.');}		// 아니면서 만약에 10>=15이면
else if(10>=10){console.log('[참3] 10이 10보다 이상이다.');}		// 아니면서 만약에 10>=10이면
else{console.log('[거짓] 10이 10미만이다.');}						// 그외

	// vs 삼항연산자
10>=20 ? console.log('[참1] 10이 20보다 이상이다.') :
10>=15 ? console.log('[참2] 10이 15보다 이상이다.') :
10>=10 ? console.log('[참3] 10이 10보다 이상이다.') :
console.log('[거짓] 10이 10미만이다.')



/*
	1. prompt로 정수 1개 입력받아 90이상이면 합격 아니면 탈락 console 출력
	
	2. prompt로 성별 입력받아 
		'M'또는 'm' 또는 '남' 또는 '남자' 일 경우 ' 남자이군요' console 출력
		'W'또는 'w' 또는 '여' 또는 '여자' 일 경우 ' 여자이군요' console 출력
		그외 '남자' : m,M,남,남자 여자 : w,W,여,여자 로 입력해주세요' 라고 console 출력
		
	3. prompt로 점수 1개 입력받아
		90점 이상이면 A등급 console 출력
		80점 이상이면 B등급 console 출력
		70점 이상이면 C등급 console 출력
		그외 ' 탈락 console 출력
*/

/*
// 문제 1
let n1 = Number( prompt('값을 입력하세요') )
if(n1>=90) console.log('합격');
else console.log('탈락');

// 문제 2
let a = prompt('성별을 입력하세요')
console.log(a)
if(a=='m'||a=='M'||a=='남'||a=='남자') {console.log('남자이군요')}
else if(a=='w'||a=='W'||a=='여'||a=='여자') {console.log('여자이군요')}
else {console.log('남자 : m,M,남,남자 여자 : w,W,여,여자 로 입력해주세요')}


//문제 3
let n2 = Number( prompt('성적을 입력하세요'))
if(n2>=90) console.log('A등급');
else if(n2>=80) console.log('B등급');
else if(n2>=70) console.log('C등급');
else console.log('탈락');
*/





















