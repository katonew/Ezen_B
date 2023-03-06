//alert('js 열림')

function doPOST(){
	alert('http post 메소드 실행합니다.')
	$.ajax({
		url : "/jspweb/Ex3",
		method : "post",
		success : (result)=>{}
	});
}

function doGET(){
	alert('http get 메소드 실행합니다.')
	$.ajax({
		url : "/jspweb/Ex3",
		method : "get",
		success : (result)=>{}
	});
}


function doPUT(){
	alert('http put 메소드 실행합니다.')
	$.ajax({
		url : "/jspweb/Ex3",
		method : "put",
		success : (result)=>{}
	});
	
}

function doDELETE(){
	alert('http delete 메소드 실행합니다.')
	$.ajax({
		url : "/jspweb/Ex3",
		method : "delete",
		success : (result)=>{}
	});
}

// -------------------------------------//

// 1. 등록
function onwrite(){
	console.log('onwrite 함수 실행')
	
	let info = {
		content : document.querySelector('.content').value,
		writer : document.querySelector('.writer').value
	}
	console.log(info)
	
	$.ajax({
		url : "/jspweb/Ex3/Board",
		method : "post",
		data : info,
		success : (r) => {
			console.log('post 응답성공');
			if(r == 'true'){
				alert('등록성공');
				document.querySelector('.content').value = "";
				document.querySelector('.writer').value = "";
				onlist();
			}
			else(alert('등록실패'))
		} // success e
	}) // ajax e
	
	
} // 등록 함수  e
onlist();
// 2. 모든 게시물 출력 [ 1. js 열릴때  2. 글작성할때마다]
function onlist(){
	$.ajax({
		url : "/jspweb/Ex3/Board",
		method : "get",
		success : (r) =>{
			console.log('get 응답 성공');
			console.log(r);
			let html = 
			`<tr>
					<th>번호</th>
					<th>내용</th>
					<th>작성자</th>
					<th>비고</th>
				</tr>`;
			r.forEach((o,i) => {
				html += 
				`<tr>
					<td>${o.bno}</td>
					<td>${o.bcontent}</td>
					<td>${o.bwriter}</td>
					<td>
						<button onclick="ondelete(${o.bno})" type="button">삭제</button>
						<button onclick="onupdate(${o.bno})" type="button">수정</button>
					</td>
				</tr>`;
			});
		document.querySelector('.boardtable').innerHTML = html;
		} // success e
	}) // ajax e
	
} // 출력함수 e

// 특정 게시물 삭제
function ondelete(bno){
	$.ajax({
		url : "/jspweb/Ex3/Board",
		method : "delete",
		data : { "bno" : bno},
		success : (r) =>{
			console.log('delete 함수 성공')
			console.log(r)
			if(r=='true'){
				alert('삭제성공')
			}else{alert('삭제실패')}
			onlist();
		} // success e
	}) // ajax e
} // ondelete e

// 수정 함수
function onupdate(bno){
	console.log('onupdate('+bno+')열림')
	let newContent = prompt('수정할 내용 입력');
	$.ajax({
		url : "/jspweb/Ex3/Board",
		method : "put",
		data : { "bno" : bno , "newContent" : newContent},
		success : (r)=>{
			console.log('put 함수 성공')
			console.log(r)
			if(r=='true'){alert('수정성공')
			}else{alert('수정실패')}
			onlist();
		}
	})
}



















