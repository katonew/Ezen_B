console.log('point.js 시작')
IMP.init("imp40531535"); // 예: imp00000000a

let pay =0;

document.querySelector('.mpoint').innerHTML = '현재 보유 포인트 : '+memberinfo.mpoint
function setpay(p){
	pay = p;
	document.querySelector('.selectpay').innerHTML = "결제금액 : "+pay+"원"
}

function requestPay() {
	 if(pay==0){
		 alert('충전할 금액을 선택해주세요');
		 return;
	 }
	 
	IMP.request_pay({
	  pg: "INIpayTest",							// 각 PG사 별 이름
	  pay_method: "card",						// 결제 방법
	  merchant_uid: "ORD20180131-0000011",   	// 주문번호 == 결제 DB에서 사용할 PK
	  name: "나이키 신발 외 3개",
	  amount: pay,                         		// 숫자 타입 == 결제금액
	  buyer_email: "gildong@gmail.com",
	  buyer_name: "홍길동",
	  buyer_tel: "010-4242-4242",
	  buyer_addr: "서울특별시 강남구 신사동",
	  buyer_postcode: "01181"
	}, 
	function (rsp) { 
	  if (rsp.success) { 
	    // 결제 성공 시 로직
	    console.log(rsp)
	  } else {
	    // 결제 실패 시 로직
	    // 결제 성공 했다는 가정
	    let info = {
			mpcomment : pay+'포인트 충전',
			mpamount : pay,
			mno : memberinfo.mno
		}
	    $.ajax({
			url : "/jspweb/point",
			method : "post",
			data : info,
			success : (r)=>{
				if(r=='true'){
					alert('충전 완료')
					location.href="/jspweb/member/point.jsp"
				}
			}
		})
	    
	  }
	});
}






