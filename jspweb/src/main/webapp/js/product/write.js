console.log('상품등록 js 열림')

let plat = 0;
let plng = 0;

function onwrite(){
	
	// 1. 폼전송
	let writeForm = document.querySelectorAll('.writeForm')[0]
	// 2. 폼데이터 객체 선언
	let writeFormData = new FormData(writeForm);
	// 3. 위도 경도 입력받기
	// 폼 데이터 격체에 필드 추가
	writeFormData.set( "plat" , plat );
	writeFormData.set( "plng" , plng );
	if(plat!=0&&plng!=0){
			$.ajax({
			url : "/jspweb/product/info",
			method : "post",
			data : writeFormData,
			contentType : false,
			processData : false,
			success : (r)=>{
				console.log(r)
				if(r=='true'){
					alert('상품 등록이 성공되었습니다.')
					location.href="/jspweb/index.jsp"
				}else{alert('상품 등록에 실패하였습니다.')}
			}
		})
	}
	 
}


var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.308411, 126.8509293), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//----------------------------지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

//-----------------------------지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
   plat = latlng.getLat()
   plng = latlng.getLng()

});