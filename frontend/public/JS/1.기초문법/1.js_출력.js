/*
	크롬[브라우저] 개발자 도구 F12
		cosole : 입/출력이 가능한 구역
 */




//	JS : 
//		1. 주석	[ 범위+shift+ctrl+/ ]
//			// 		: 한줄 주석
//			/* 	: 여러줄 주석 */
/*
		2. 출력
			1.console.log( )	: 콘솔에 출력하는 함수 [테스트용]
				- js코드 -----> 브라우저 개발자 도구 console 출력
			2. alert() 			: 알람 메시지를 출력하는 함수
		
		3. 제어문자[이스케이프 문자] 
			- 엔터 위에 원화 기호 [ 백슬래시] : \
			1. \n 	: 줄바꿈
			2. \t 	: 들여쓰기
			3. \\ 	: \ 출력	[ 백슬래시 출력시 \\]
			4. \'	: ' 출력
			5. \"	: " 출력
			
			
			
			
		* 
			키워드 : 미리 만들어진 단어들[ 명령어]
			데이터 : 
				1. 문자 : 1. ' ' 2. " "
				2. 숫자 : 숫자로 된 키워드가 없기 때문에 그대로 입력 가능
				3. 논리 : ture, false
					
*/
//1. 출력 [console.log(출력할 데이터/값 )]
console.log('Hello World')	//	' ' 안에 있는 데이터는 문자처리
//console.log(Hello World)	//	문자처리 생략시 오류 발생
console.log("Hello World")	//	" " 안에 있는 데이터는 문자처리
console.log(200)			//	숫자는 문자처리 안함
console.log("200")			// 	숫자에 문자처리 하면 문자로 출력
console.log(true)			//	논리는 문자처리 안함

//2. 출력	[alert(출력할 데이터/값)]
//alert('Hello World2')
//alert('Hello World3')
//alert(200+200)
//alert(true)


//3. 제어문자
console.log('안녕하세요\njs 처음입니다.')
console.log('안녕하세요\tjs 처음입니다.')
console.log('안녕하세요\\js 처음입니다.')
console.log('안녕하세요\'js 처음입니다.\'')
console.log('안녕하세요\"js 처음입니다.\"')

















