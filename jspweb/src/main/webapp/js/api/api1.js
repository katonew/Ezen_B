/* ajax 이용한 데이터포털의 데이터 가져오기 */

/*
$.ajax({
	url : "신청한 공공데이터 URL",
	method : "get",
	success : (r)=>{
		
	}
})

*/
// 공공 데이터 : 시도별 미세먼지 실시간 현황
getApi2()
function getApi2(){
	$.ajax({
		url : "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=t7sm4Yf%2F52aLATacOjIxj94G3uyWTYCP1%2FI1ONa0JLVa9%2Fhk7vz9mTokTdQ4dYTuVxBadEEVqiqlJhpFj%2FdK4Q%3D%3D&returnType=json&numOfRows=200&pageNo=1&sidoName=%EA%B2%BD%EA%B8%B0&ver=1.0",
		method : "get",
		success : (r)=>{
			console.log(r)
			console.log(r.response.body.items)
		}
	})
}





// 공공데이터 : 전기차 충전소 현황
getApi1();
function getApi1(){
	$.ajax({
		url : "https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=t7sm4Yf%2F52aLATacOjIxj94G3uyWTYCP1%2FI1ONa0JLVa9%2Fhk7vz9mTokTdQ4dYTuVxBadEEVqiqlJhpFj%2FdK4Q%3D%3D",
		method : "get",
		success : (r)=>{
			console.log(r)
			document.querySelector('.totalcount').innerHTML = '안산시 전기차 충전소 총 개수 : '+r.totalCount;
			let html = `<tr>
							<th>도로명주소</th>
							<th>우편번호</th>
							<th>지번주소</th>
							<th>시군명</th>
							<th>운영기관명</th>
							<th>충전기타입명</th>
							<th>충전소명</th>
							<th>위도</th>
							<th>경도</th>
						<tr>`;
			r.data.forEach((o)=>{
				// 객체 내 필드 호출하는 방법 : 1.객체명.필드명		2.객체명['필드명']
				html += `<tr>
							<td>${o.소재지도로명주소}</td>
							<td>${o.소재지우편번호}</td>
							<td>${o.소재지지번주소}</td>
							<td>${o.시군명}</td>
							<td>${o.운영기관명}</td>
							<td>${o.충전기타입명}</td>
							<td>${o.충전소명}</td>
							<td>${o['위도(WGS84)']}</td>
							<td>${o['경도(WGS84)']}</td>
						<tr>`;
			})
			document.querySelector('.table').innerHTML = html;
		}
	})
}