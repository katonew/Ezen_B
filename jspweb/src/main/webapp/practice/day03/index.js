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

//---------------------제품 -------------------

function addproduct(){
	console.log('addproduct() 함수 실행')
	
	let product = {
		pname : document.querySelector('.pname').value,
		pprice : document.querySelector('.pprice').value
	}
	console.log(product)
	
	$.ajax({
		url : "/jspweb/Ex3/Product",
		method : "post",
		data : product,
		success : (r) => {
			console.log('post 응답성공');
			if(r == 'true'){
				alert('등록성공');
				document.querySelector('.pname').value = "";
				document.querySelector('.pprice').value = "";
				plist();
			}
			else(alert('등록실패'))
		} // success e
	}) // ajax e
	
	
} // 제품 등록 함수  e
plist();
function plist(){
	$.ajax({
		url : "/jspweb/Ex3/Product",
		method : "get",
		success : (r) =>{
			console.log('get 응답 성공');
			console.log(r);
			let html = 
			`<tr>
					<th>제품번호</th>
					<th>제품명</th>
					<th>제품가격</th>
					<th>비고</th>
				</tr>`;
			r.forEach((o,i) => {
				html += 
				`<tr>
					<td>${o.pno}</td>
					<td>${o.pname}</td>
					<td>${o.pprice}</td>
					<td>
						<button onclick="pdelete(${o.pno})" type="button">삭제</button>
						<button onclick="pupdate(${o.pno})" type="button">수정</button>
					</td>
				</tr>`;
			});
		document.querySelector('.producttable').innerHTML = html;
		} // success e
	}) // ajax e
} // 제품출력함수 e

// 제품 삭제
function pdelete(pno){
	$.ajax({
		url : "/jspweb/Ex3/Product",
		method : "delete",
		data : { "pno" : pno},
		success : (r) =>{
			console.log('delete 함수 성공')
			console.log(r)
			if(r=='true'){
				alert('삭제성공')
			}else{alert('삭제실패')}
			plist();
		} // success e
	}) // ajax e
} // ondelete e

// 수정 함수
function pupdate(pno){
	console.log('pupdate('+pno+')열림')
	let newName = prompt('수정할 제품명 입력');
	let newPrice = prompt('수정할 가격 입력');
	$.ajax({
		url : "/jspweb/Ex3/Product",
		method : "put",
		data : { "pno" : pno , "newName" : newName, "newPrice" : newPrice},
		success : (r)=>{
			console.log('put 함수 성공')
			console.log(r)
			if(r=='true'){alert('수정성공')
			}else{alert('수정실패')}
			plist();
		}
	})
}













