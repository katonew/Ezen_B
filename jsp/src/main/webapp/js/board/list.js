console.log('js 시작')

let boardlist = [
   { no : 5 , title : '안녕하세요A' , writer : '유재석' , date : '2023-01-30' , view:325 , up : 9 , down : 1  } , 
   { no : 4 , title : '안녕하세요B' , writer : '강호동', date : '2023-01-27' , view:123 , up : 2 , down : 0  } , 
   { no : 3 , title : '안녕하세요C' , writer : '신동엽' , date : '2023-01-25' , view:753 , up : 3 , down : 0  } , 
   { no : 2 , title : '안녕하세요D' , writer : '서장훈' , date : '2023-01-24' , view:521 , up : 10 , down : 3  } , 
   { no : 1 , title : '안녕하세요E' , writer : '김희철' , date : '2023-01-23' , view:951 , up : 21 , down : 4 } 
]


boardPrint(null,null)	//첫 출력에는 인수가 없이 모두 출력되기 때문에

//게시물 출력 함수		1. JS 열렸을때 [조건없음] 
//					2. 검색되었을때 [조건있음]
//					3. 페이지 전환되었을때
function boardPrint(keyword, key){
	//1.JAVA[백엔드]로 부터 데이터 요청//~~추후
		//1. 검색이 없는 경우
	if(key==null&&keyword==null){
		//alert('검색이 없는 게시물 출력')
		// JAVA에게 검색이 없는 게시물들을 요청
	}else{
		//alert('검색이 있는 게시물 출력')
		// JAVA에게 keyword,key 보내서 검색에 맞는 게시물들을 요청
	}
		//2. 검색이 있는 경우
		
	// [통신된 결과] 2. DB -> JAVA
	let html = ''
	for(let i = 0;i<boardlist.length;i++){
		html += `<tr>
					<td>${boardlist[i].no}</td>
					<td><a href="view.html">${boardlist[i].title}</a></td>
					<td>${boardlist[i].writer}</td>
					<td>${boardlist[i].date}</td>
					<td>${boardlist[i].view}</td>
					<td>${boardlist[i].up}</td>
					<td>${boardlist[i].down}</td>
				</tr>`
	}
	document.querySelector('.boardlist').innerHTML = html
}

//2.검색버튼 클릭했을때 키워드와 검색어 가져오기
document.querySelector('.searchbtn').addEventListener('click',(e)=>{
	console.log('검색 클릭')
	//1. 키워드 가져오기
	let keyword = document.querySelector('.keyword').value
	//2. 검색어
	let key = document.querySelector('.key').value
	//3. 유효성 검사 생략
	//4. 키워드, 검색어 전달 [JAVA[백엔드]에게]
	boardPrint(keyword,key)
	
})

















