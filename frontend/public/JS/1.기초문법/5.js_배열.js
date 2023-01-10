

/*
	데이터[자료] : 문자,숫자,그림 형태의 단위 
		자료 증가 --> 메모리 증가 --> 금액 증가 
	메모리[휘발성]: 사용중에만 저장 / 종료시 사라짐 : JS  
		- 보조기억장치[비휘발성] : 데이터베이스
	
	변수와 상수 : 데이터[자료] 1개를 메모리[주기억장치] 저장
	배열 : 데이터 여러개를 저장
		1. 배열 : [ ]
		2. 식별번호 : 인덱스 0번 시작
		3. 선언방법
			let 배열명 = [ 자료1, 자료2, 자료3]
			const 배열명 = [ 자료1, 자료2, 자료3]
		예시)
			let 학년3_2반 			=	 [ '유재석', '강호동', '신동엽', '김현수']
			!!인덱스[순서번호 = 고유번호] 		 0		  1 	   2		3
			마지막 인덱스 	= 	3
			학생길이 		=	4
		4. 배열길이 : length
			학년3_2반.length : 4
		5. 요소[자료] 추가
			배열명.push( 새로운 요소) : 마지막 요소 뒤에 새로운 요소를 추가한다.
			배열명.splice(추가할 인덱스 , 삭제할 개수, '새로운 요소') : 해당 인덱스에 새로운 요소 추가 
				[추가 된 인덱스 뒤로 한칸씩 이동]
		6. 요소 제거
			- 인덱스 이용한 제거
				배열명.splice( 제거인덱스의 삭제시간지점 , 제거개수 , [새로운 요소])
				배열명.splice(0) 			: 모든 요소 삭제
				배열명.splice( 0 , 1) 	: 0번 인덱스 1개 제거
				배열명.splice( 3 , 1)		: 3번 인덱스 1개 제거
				배열명.splice( 2 , 3)		: 2,3,4번 인덱스 제거
				[ 삭제된 요소 뒤로 한칸씩 당기기]
			- 요소의 값으로 제거
				*값으로 인덱스 찾기 : 배열명.indexOf(데이터)
				배열명.splice( 배열명.indexOf(데이터), 1)
			- 요소에 새로운 값으로 변경
				배열명.splice( 0, 1, 새로운 요소 )
			
			
*/
//1. 배열선언 [] 안에 ,로 구분하여 여러개의 자료를 입력한다.
let 배열명 = ['유재석', '강호동', '신동엽', '김현수' ]

//2. 배열 호출
console.log(배열명)
document.write(배열명)
document.write('<h3>'+배열명+'<h3>')

//3. 배열 내 특정 요소만 호출 : 배열명[인덱스]
 console.log(배열명[0] + 배열명[1] + 배열명[2] + 배열명[3])
 document.write('<ol>')
 document.write('<li>' +배열명[0]+'</li>')		//  변수/배열 명은 문자열 처리 X // HTML은 문자열 처리 
 document.write('<li>' +배열명[1]+'</li>')		//  변수/배열 명은 문자열 처리 X // HTML은 문자열 처리 
 document.write('<li>' +배열명[2]+'</li>')		//  변수/배열 명은 문자열 처리 X // HTML은 문자열 처리 
 document.write('<li>' +배열명[3]+'</li>')		//  변수/배열 명은 문자열 처리 X // HTML은 문자열 처리 
 document.write('</ol>')
 
//4. 배열의 길이
console.log(배열명.length + "명")
document.write('<p>현재 인원수 : '+배열명.length+ '명</p>')

//5. 배열의 요소 추가
배열명.push('전현무')
console.log(배열명)

//6. 배열의 특정 요소 제거
배열명.splice( 0 , 1); console.log(배열명)
	// 한줄에 두개 이상의 명령어 작성시에는 ;로 구분

//7. 데이터로 인덱스 찾기
let sindex = 배열명.indexOf('신동엽'); console.log('신동엽 인덱스 : ' + sindex)	// 배열 내 신동엽 인덱스 순서를 찾아 sindex에 입력
	
//8. 데이터로 요소 삭제
배열명.splice(배열명.indexOf('신동엽'), 1); console.log(배열명)					// 배열 내 신동엽을 찾아 삭제함

//9. 배열내 요소 데이터 변경
배열명.splice(0 ,1,'서장훈'); console.log(배열명)								// 배열내 0번째 인덱스 1개를 '서장훈'으로 변경함

//10. 배열내 요소 사이 요소 추가
배열명.splice(1 , 0, '유재석')													// 배열 내 1번 인덱스 자리에 0개를 제거 후 '유재석' 인덱스 추가
console.log(배열명)






















