allmember();
function allmember(){
	$.ajax({
		url : "/jspweb/member",
		method : "get",
		success : (r)=>{
			//console.log('allmember success')
			//console.log(r)
			let html = `<tr>
							<th width="10%">번호</th>
							<th width="10%">프로필</th>
							<th width="10%">아이디</th>
							<th width="10%">이메일주소</th>
							<th width="10%">비고</th>
						</tr>`;
			r.forEach((o,i)=>{
				// 만약에 회원 mimg 프로필 이미지가 null 이면 기본 프로필 사용
				html += `<tr>
							<td>${o.mno}</td>
							<td ><img src="/jspweb/member/pimg/${o.mimg == null ? "default.webp" : o.mimg }" width="100%"></td>
							<td>${o.mid}</td>
							<td>${o.memail}</td>
							<td>비고</td>
						</tr>`
			})
			document.querySelector('.allmember').innerHTML = html;
		}
		
	})
	
	
}