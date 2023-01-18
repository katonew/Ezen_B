


/*



 */

//공통
let cateforyList = [ '프리미엄', '스페셜', '와퍼', '올데이킹', '치킨버거' ] 
category_print()

//1. 카테고리 출력하는 함수 [1.JS 열렸을 때]
function category_print(){
	//1.HTML 구성
	let html = 	`<ul>`
	
	//*
	for( let i =0; i<cateforyList.length;i++){
		html += `<li>${cateforyList[i]}</li>`
	} // for e
	html += `</ul>`
	
	//2. 해당 마크업에 html 출력
	document.querySelector('.categorybox').innerHTML = html
}