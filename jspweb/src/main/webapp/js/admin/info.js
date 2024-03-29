console.log( 'js열림')


/* chart.js 차트 
	new Chart('dom객체 , {차트 옵션});
	{ type : '차트이름' : data : { 차트에 표시할 데이터 } , options : { 차트에 적용 될 옵션 } };
	labels : 가로축
*/


/*
	JSON = JS객체
	let 객체명 { 필드명/키 : 데이터, 필드명/키 : 데이터, 필드명/키 : 데이터, 필드명/키 : 데이터}
	
	1. 해당 객체의 필드명만 호출
		Object.keys(객체명)
	2. 해당 객체의 값만 호출
		Object.values(객체명)

 */





const ctx = document.getElementById('myChart');


$.get("/jspweb/point", (r)=>{
	console.log(r)
	console.log(Object.keys(r))
	console.log(Object.values(r))

	new Chart(ctx, {
		type: 'bar',	// bar : 막대차트 / line : 선 차트
		data: {
		  labels: Object.keys(r),
		  datasets: [{
		    label: '포인트 충전 내역',
		    data: Object.values(r),
		    borderWidth: 10
		  }]
		},
		options: {
		  scales: {
		    y: {
		      beginAtZero: true
		    }
		  }
		}
	});

}) // ajax e

let memberObject = {
	page : 1 , // page : 표시할 페이징번호
	key : "" , 
	keyword : "",
	listsize : 3
}

getMemberList(1);
function getMemberList(page){
	memberObject.page = page;
	memberObject.listsize = document.querySelector('.listsize').value;
	$.ajax({
		url: "/jspweb/member",
		method : "get",
		data : memberObject ,
		success : (r)=>{
			console.log('ajax통신');
			// 1. 응답데이터 처리 
				// 1. 테이블 헤더 구성 
			let html = `<tr>
							<th width="10%"> 번호 </th>
							<th width="10%"> 프로필 </th>
							<th width="10%"> 아이디 </th>
							<th width="10%"> 이메일주소 </th>
							<th width="10%"> 비고 </th>
						</tr>`
			r.memberlist.forEach( (o) =>{
				// 2. 테이블 내용물 추가 구성 
				// 만약에 회원 mimg 프로필이미지가 null 이면 기본프로필 사용 / 아니면 mimg 사용 
				html +=	`<tr>
							<td> ${ o.mno } </td>
							<td> <img width="30%" src="/jspweb/member/pimg/${ o.mimg == null ? 'default.webp' : o.mimg }" width="100%">  </td>
							<td> ${ o.mid } </td>
							<td> ${ o.memail } </td>
							<td> 
								<button type="button" disabled="disabled">삭제</button>
								<button type="button" disabled="disabled">수정</button>
							</td>
						</tr>`
			} ); // for end 
				// 3. 구성된html를 table 대입
			document.querySelector('.mListTable').innerHTML = html;
			html = ''; // 기존에 들어있던 내용 제거
			// 이전 버튼
			html += page <= 1 ?
					`<button onclick="getMemberList(${ page })" type="button"> 이전 </button>`
					:
					` <button onclick="getMemberList(${ page-1 })" type="button"> 이전 </button> `
			// 페이징 번호 버튼 들 
			for( let i = r.startbtn ; i<=r.endbtn ; i++ ){ // 시작버튼번호 부터 마지막버튼번호 까지 버튼 생성 
				html += `
					<button onclick="getMemberList(${i})" type="button"> ${i} </button>
					`
			}
			// 다음 [ 만약에 현재 페이지가 총페이지수 이상이면 다음페이지 없음 ]
			html += page >= r.totalpage ?
					`<button onclick="getMemberList(${ page })" type="button"> 다음 </button>`
					:
					`<button onclick="getMemberList(${ page+1 })" type="button"> 다음 </button>`
			document.querySelector('.mpagebox').innerHTML = html;
			// -------------------- 게시물수 출력  --------------------- //
			document.querySelector('.mseachcount').innerHTML = `전체회원 수 : ${ r.totalsize } `
			
		} // success e
	}) // ajax e
} // getmemberlist e


function serchMember(){
	console.log('검색버튼 눌림')
	memberObject.key = document.querySelector('.key').value;
	memberObject.keyword = document.querySelector('.keyword').value;
	getMemberList(1);
}





























