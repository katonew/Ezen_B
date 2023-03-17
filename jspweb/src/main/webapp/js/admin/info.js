console.log( 'js열림')

let memberObject = {
	page : 1 , // page : 표시할 페이징번호
	key : "" , 
	keyword : "",
	type : 1 // 1:전체출력 2:개별출력 
}

getMemberList(1);
function getMemberList(page){
	let listsize = document.querySelector('.listsize').value;
	$.ajax({
		url: "/jspweb/member",
		method : "get",
		data : memberObject ,
		success : (r)=>{
			console.log('ajax통신');
			console.log( r );	// 응답 결과 데이터 확인 
			// 1. 응답데이터 처리 
				// 1. 테이블 헤더 구성 
			let html = `<tr>
							<th width="10%"> 번호 </th>
							<th width="10%"> 프로필 </th>
							<th width="10%"> 아이디 </th>
							<th width="10%"> 이메일주소 </th>
							<th width="10%"> 비고 </th>
						</tr>`
			r.forEach( (o) =>{
				// 2. 테이블 내용물 추가 구성 
				// 만약에 회원 mimg 프로필이미지가 null 이면 기본프로필 사용 / 아니면 mimg 사용 
				html +=	`<tr>
							<td> ${ o.mno } </td>
							<td> <img width="30%" src="/jspweb/member/pimg/${ o.mimg == null ? 'default.webp' : o.mimg }" width="100%">  </td>
							<td> ${ o.mid } </td>
							<td> ${ o.memail } </td>
							<td> </td>
						</tr>`
			} ); // for end 
				// 3. 구성된html를 table 대입 
			document.querySelector('.mListTable').innerHTML = html;
			
		} // success e
	}) // ajax e
} // getmemberlist e


function serchMember(){
	pageObject.key = document.querySelector('.key').value;
	pageObject.keyword = document.querySelector('.keyword').value;
	getMemberList(1);
}













