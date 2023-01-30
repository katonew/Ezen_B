

let productList = [
	{title : '게이밍추천PC_i5463 (12400F/3060)',cpu : '코어i5-12400F (엘더레이크)',price : 1133000, discount : 0.23, like : 54, review : 132, img : 'c1.jpg' },
	{title : '게이밍 추천 조립PC_i5783 (12400F/3060Ti)',cpu : '코어i5-12400F (엘더레이크)',price : 1290000, discount : 0.1, like : 123, review : 234, img : 'c2.jpg' },
	{title : '게이밍 추천 조립PC_i5790 (12400F/3060Ti)',cpu : '라이젠5 5600 (버미어)',price : 1250000, discount : 0.23, like : 74, review : 23, img : 'c3.jpg' },
	{title : '사무용 추천 조립PC_i7284 (12700/내장그래픽)',cpu : '코어i7-12700 (엘더레이크)',price : 1100000, discount : 0.4, like : 32, review : 232, img : 'c4.jpg' },
	{title : 'MiniPC PN51-S1 R7 5700U',cpu : 'Ryzen7 5700U (4.3GHz)',price : 596400, discount : 0.15, like : 64, review : 35, img : 'c5.jpg' },
	{title : 'Victus VOLT 15-fb0059AX R5-5600H',cpu : 'R5-5600H',price : 699000, discount : 0.21, like : 123, review : 623, img : 'c6.jpg' }
]


product_print();
//1. 제품 출력 함수 [ 1. JS 열릴 때]
function product_print(){
	let html = ``
	productList.forEach( (o, i)=>{
		html += `
				<div class="item">		<!--  제품 1개 -->
					<img src="img/${o.img}">	<!-- 제품 이미지 -->
					<div class="item_info">	<!-- 제품 정보 구역 -->
						<div class="item_title">${o.title}</div>	<!-- 제품명 -->
						<div class="item_cpu">${o.cpu}</div>							<!-- 제품사이즈 -->
						<div class="item_price">${o.price.toLocaleString()}</div>						<!-- 원가 -->
						<div>
							<span class="item_sale">${(o.price-parseInt(o.price*o.discount)).toLocaleString()}</span>						<!-- 판매가 -->
							<span class="item_discount">${parseInt(o.discount*100)}%</span>						<!-- 할인율 -->
						</div>
					</div>
					<div class="item_bottom">	<!-- 제품 정보 하단 구역 -->
						<div>
							<span class="badge rounded-pill text-bg-warning">주문폭주</span>	<!-- 배지 -->
							<span class="badge rounded-pill text-bg-danger">1+1</span> 		<!-- 배지 -->
						</div>
						<div class="item_review">찜 ${o.like} · 리뷰 : ${o.review}</div>
						<!-- · : 특수문자 alt + 1 + 8 + 3 -->
					</div>
				</div>
				`
	})
	
	document.querySelector('.itembox').innerHTML = html
}

































