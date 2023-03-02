
//JS 함수
// function 함수명(매개변수){실행코드}

function 예제1(){
	// document : 미리 만들어진 DOM객체
		// 1.querySelector(식별자) : tag 한개 -> 변수/객체에 저장
			// 1. document.querySelector('.클래스명')
			// 2. document.querySelector('#id명')
			// 3. document.querySelector('tag명[name="name"]')
		// 2. querySelectorAll(식별자) : tag 여러개 -> 배열/리스트에 저장
		
		// 3. querySelectorAll.속성명
			// 1.  querySelector().value : input,select,textarea [ div X , table X]
			// 2.  querySelector().innerHTML : div, span, td 등등
			
			
			
	let data = document.querySelector('.inputdata').value;
	console.log(data)
	
}
