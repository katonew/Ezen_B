


/*



 */

//공통 DB
let categoryList = [ '프리미엄', '스페셜', '와퍼', '올데이킹', '치킨버거' ] 
//등록된 버거 목록
let burgerList = [
	{name : '기네스콰트로치즈와퍼', price : 9500 , img : '기네스콰트로치즈와퍼.png', category : '프리미엄'},
	{name : '몬스터X', price : 8000 , img : '몬스터X.png', category : '치킨버거'},
	{name : '몬스터와퍼', price : 9600 , img : '몬스터와퍼.png', category : '스페셜'},
	{name : '콰트로치즈와퍼', price : 10500 , img : '콰트로치즈와퍼.png', category : '와퍼'},
	{name : '콰트로치즈X', price : 4800 , img : '콰트로치즈X.png', category : '올데이킹'}
]
let cartList = []	//카트 목록
let orderList = []	//주문 목록



//JS 열렸을때 실행될 함수
category_print();	//카테고리 출력해주는 함수 호출 (1회)
category_select(0);	//카테고리 선택시 CSS 변경 / 카테고리별 제품 출력 함수 [기본값 : 프리미엄]
productPrint(0);	//제품 출력 함수 [기본값 : 프리미엄]
orderTable();	//주문 현황 테이블
burgerTable();	//버거 현황 테이블
sellTotal()		//매출 현황 테이블

//1. 카테고리 출력하는 함수 [1.JS 열렸을 때]
function category_print(){
	//1.HTML 구성
	let html = 	`<ul>`
	//*
	for( let i =0; i<categoryList.length;i++){
		html += `<li class="categoryli" onclick="category_select(${i})">${categoryList[i]}</li>`
	} // for e
	html += `</ul>`
	
	//2. 해당 마크업에 html 출력
	document.querySelector('.categorybox').innerHTML = html
}
//2. 카테고리 선택함수
function category_select(i){
	//1. 모든 li 가져와서 배열 저장
	let categoryli = document.querySelectorAll(".categoryli")
	//2. 모든 li 배열 반복문
	for(let j =0; j<categoryli.length; j++){
		if(j==i){	//만약 li배열에서 내가 선택한 li의 인덱스와 같으면 
			categoryli[j].classList.add('categoryselect');	// 해당 마크업의 class 식별자 추가
		}else{	//나머지 li
			categoryli[j].classList.remove('categoryselect');	// 해당 마크업의 calss 식별자 제거
		}
	} // for e
	//3. 제품목록 렌더링 [화면 업데이트]
	productPrint(i)
}

//3. 제품 출력 함수 [1. JS 열렸을때 2.카테고리 바뀌었을때]
function productPrint(x){
	//1. html 구성
	let html = '';
	for(let i =0; i<burgerList.length;i++){ // for s
	// i는 0번째 인덱스부터 마지막 인덱스까지 버거 객체를 가져온다.
		if(burgerList[i].category == categoryList[x]){ //if s
		// i번째 버거객체의 카테고리와 선택된 카테고리가 같으면
		html += `<div onclick="cardadd(${i})" class="product">
						<img src="img/${burgerList[i].img}" width="100%" />
						<div class="productinfo">
							<div class="ptitle">${burgerList[i].name}</div>
							<div class="pprice"> ${burgerList[i].price.toLocaleString()}원 </div>
						</div>
					</div>`
			} // if e
		} // for e
	//2. 구성된 html을 마크업에 대입
	document.querySelector('.productbox').innerHTML = html
}
//4. 선택한 품목 카트에 담기
function cardadd(x){
	//1. 선택한 i번째 버거의 객체를 cartlist에 추가
	cartList.push(burgerList[x])
	cartPrint()
}


//5. 주문 취소 버튼
function cancel(){
	alert('카트를 초기화합니다.')
	cartList.splice(0);
	cartPrint()
}


//6. 주문 하기 버튼

function onOrder(){
	alert('주문합니다.');
	//1.주문번호 만들기
	// * 마지막 인덱스 : 배열명.length-1
	let no = 0;
		// 만약에 길이가 0이면 [이전까지 주문이 하나도 없었으면] 주문번호=1
	if(orderList.length==0){no =1;}
		//아니면 마지막 인덱스의 주문번호 +1
	else {no = orderList[orderList.length-1].no+1}
	
	//2.카트배열 -> 새로운배열 [ 주문객체에 카트배열 대입시 카트배열 초기화시 주문객체내 카트배열도 초기화 = 메모리 동일하기 때문에]
	let map배열 = cartList.map((o)=>{return o;})
	
	
	// 총 가격 만들기
	let total = 0;
	for(let i = 0 ; i<map배열.length; i++){total += map배열[i].price}
	
	//1. 주문
		//1. order 객체 만들기
		let order = {
			no : no,
			items : map배열,		//카트배열 --> 새로운배열
			time : new Date(),	//new Date() : 현재 날짜/시간
			state : true,		//true : 주문시작이기때문에
			complete : 0,		//아직 주문 완료 되기전
			price : total		// cartlist 배열내 버거 객체들의 총금액 합계
		}
		
	
	//2.order 객체 배열에 저장
	orderList.push(order)
	//주문 완료 후
	cartList.splice(0);
	cartPrint()
	orderTable()
}

// 카트리스트 삭제 함수
function onDelete(x){
	cartList.splice(x,1)
	cartPrint()
	orderTable()
}

//7. 출력함수	[1. 제품 클릭할 때 마다]
function cartPrint(){
	//2.버거 개수 카운트
	document.querySelector('.pcount').innerHTML = cartList.length;
	//3. 버거 총 금액
	let total = 0;
	for(let j =0;j<cartList.length;j++){
		total += cartList[j].price
	}
	
	//4. 출력
	let html =''
	for(let j =0;j<cartList.length;j++){
		html += `<div class="item">
					<div class="ititle">
						${cartList[j].name}
						<button onclick="onDelete(${j})" class="delbtn">x</button>
					</div >
					<div class="iprice">${cartList[j].price.toLocaleString()}원</div>
		 		</div>`
	}	
	//2. 구성된 html을 마크업에 대입
	document.querySelector('.cartbot').innerHTML = html
	document.querySelector('.ptotal').innerHTML = '\\' + total.toLocaleString() + '원'
}


//버거 등록 버튼 함수
function addbtn(){
	//burgerinfo에 순서대로 저장된 것을 객체로 만들어 burgerList 배열에 입력해야함
	let burgerbox = {
		name : document.querySelector('.burgername').value, 
		price : Number(document.querySelector('.burgerprice').value) ,
		img : document.querySelector('.burgerimg').value, 
		category : document.querySelector('.burgercate').value
		}
	if(isNaN(burgerbox.price)){
		alert('숫자만 입력하세요')
		return;
	}
	// 카테고리 비교해서 맞는거 없으면 안되는것 구현
	if(categoryList.indexOf(burgerbox.category) == -1 ){
			alert('일치하는 카테고리가 없습니다.')
			return;
	}
	burgerList.push(burgerbox)
	document.querySelector('.burgername').value = ''
	document.querySelector('.burgercate').value = ''
	document.querySelector('.burgerprice').value = ''
	document.querySelector('.burgerimg').value = ''
	burgerTable()
	sellTotal()
}
//버거현황 테이블
function burgerTable(){
	html = `<tr>
				<th>번호</th>
				<th>이미지</th>
				<th>이름</th>
				<th>카테고리</th>
				<th>가격</th>
				<th>비고</th>
			</tr>`
	//orderList에서 주문을 가져와야함
	for(i=0;i<burgerList.length;i++){
			html += `<tr>
					<th>${i+1}</th>
					<th><img src="img/${burgerList[i].img}" width="60px"/></th>
					<th>${burgerList[i].name}</th>
					<th>${burgerList[i].category}</th>
					<th>${burgerList[i].price.toLocaleString()}</th>
					<th><button onclick="burgerDelete(${i})">삭제</button><button onclick="burgerchange(${i})">수정</button></th>
			</tr>`
		
	}
	document.querySelector('.burgerTable').innerHTML = html
	sellTotal()
}

//주문 목록 현황 테이블
function orderTable(){
	//html에 입력될 변수
	html = `<tr>
				<th>주문번호</th>
				<th>이름</th>
				<th>주문상태</th>
				<th>주문시간</th>
				<th>비고</th>
			</tr>`
	//orderList에서 주문을 가져오기
	for(i=0;i<orderList.length;i++){
		let keycount = 0;
		for(let key in orderList[i].items) {
  			keycount++;
		}
		let date = orderList[i].time.getHours() + ':' +
					orderList[i].time.getMinutes() + ':' +
					orderList[i].time.getSeconds()
		for(let j=0; j<keycount;j++){
			html += `<tr>
					<th>${orderList[i].no}</th>
					<th>${orderList[i].items[j].name}</th>
					<th>${orderState(orderList[i].state)}</th>
					<th>${date}</th>
					<th><button onclick="orderEnd(${i})" class="orderBtn(${i})">주문완료</button></th>
					</tr>`
		}
	}
	document.querySelector('.orderTable').innerHTML = html
	sellTotal()
}

//버거 주문현황 출력 함수
function orderState(x){
	if(x==true){return '주문요청';}
	else{return '주문완료';}
}

function orderEnd(x){
	orderList[x].state = false
	//주문완료 버튼 클릭하면 사라지게 하는 버튼 구현
	orderTable();
}

//버거 데이터 삭제 버튼 함수
function burgerDelete(x){
	burgerList.splice(x,1)
	productPrint();
	burgerTable();
}

//버거 가격 수정 버튼 함수
function burgerchange(x){
	let rePrice = Number(prompt('수정가격'))
	burgerList[x].price = rePrice
	productPrint();
	burgerTable();
	
}

//매출현황 함수
function sellTotal(){
	//html에 입력될 변수
	html = `<tr>
				<th>제품번호</th>
				<th>버거이름</th>
				<th>판매수량</th>
				<th>매출액</th>
				<th>순위</th>
			</tr>`
	for(let i=0;i<burgerList.length;i++){
		lank=1;
		let total2 = total(burgerList[i].name) * burgerList[i].price
		for(let j=0;j<burgerList.length;j++){
			if(total2<total(burgerList[j].name) * burgerList[j].price){
				lank++;
			}
		}
		html += `<tr>
				<th>${i+1}</th>
				<th>${burgerList[i].name}</th>
				<th>${total(burgerList[i].name)}</th>
				<th class="abcd">${total2}</th>
				<th>${lank}</th>
		</tr>`
	}
	document.querySelector('.totaltable').innerHTML = html
}

//판매수량 구하는 함수
function total(x){
	let total = 0;
	for(i=0;i<orderList.length;i++){
		let keycount = 0;
		for(let key in orderList[i].items) {keycount++;}
		for(let j=0; j<keycount;j++){
			if(x==orderList[i].items[j].name){
				total++;
			}
		}
	}
	return total;
}




























