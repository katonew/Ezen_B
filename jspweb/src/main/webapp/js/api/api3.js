

// ------------------지도 옵션 및 생성-------------------------
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(37.3218778, 126.8308848), //지도의 중심좌표.
	level: 5 //지도의 레벨(확대, 축소 정도)
};
var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

// ---------------------마커이미지 변경1------------------------
var imageSrc = 'http://localhost:8080/jspweb/img/markericon.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(50, 49), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다
    
// ---------------------마커 1개 생성-----------------------------
// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter(),
    image: markerImage
});

// 지도에 마커를 표시합니다
marker.setMap(map);


// ---------------------지도 클릭 이벤트---------------------------

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    
});



// ------------------마커 클러스터 생성-------------------------
// 마커 클러스터러를 생성합니다 
let clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
    minLevel: 5 // 클러스터 할 최소 지도 레벨 
});

// ------------------주소로 좌표를 표현하고 클러스터에 넣기-------------------------

function getaddress(address){
	console.log(address)
	var geocoder = new kakao.maps.services.Geocoder();
    return new Promise((resolve, reject) => {
	    geocoder.addressSearch(address, function(result, status) {
		    if (status === kakao.maps.services.Status.OK) {
			    resolve({"lat": result[0].y, "lng": result[0].x});
		    }else{
				
			}
	    });
    });
};

// 병원출력 버튼 함수
function drugstore(){
	// ---------------------마커이미지 변경2------------------------
	var imageSrc = 'http://localhost:8080/jspweb/img/drugstore.png', // 마커이미지의 주소입니다    
	    imageSize = new kakao.maps.Size(50, 49), // 마커이미지의 크기입니다
	    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
	      
	// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
	var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
	    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다
	$.ajax({
	url : "https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=100&serviceKey=t7sm4Yf%2F52aLATacOjIxj94G3uyWTYCP1%2FI1ONa0JLVa9%2Fhk7vz9mTokTdQ4dYTuVxBadEEVqiqlJhpFj%2FdK4Q%3D%3D",
	method : "get",
	async : false,
	success : (r) => {
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		r.data.forEach( (o) =>{
		
				// 주소로 좌표를 검색합니다
				geocoder.addressSearch( o.주소, function(result, status) {
					
				    // 정상적으로 검색이 완료됐으면 
				     if (status === kakao.maps.services.Status.OK) {
				    
				    	// 결과값으로 받은 위치를 마커로 표시합니다
				        let marker =  new kakao.maps.Marker({
				            position : new kakao.maps.LatLng(result[0].y, result[0].x),
				            image : markerImage
				        });
				        
				        kakao.maps.event.addListener(marker, 'click', function() {
							// 모달 띄우기
							openModal();
							document.querySelector('.modal_title').innerHTML = `<h3>${o.약국명}</h3>`
							document.querySelector('.modal_title').style.fontSize = '20px'; 
							document.querySelector('.modal_content').innerHTML = 
							`
							<div>주소 : ${o.주소}</div>
							<div>대표전화 : ${o.대표전화}</div>
							`;
						}); // addlistener e
				        
				        clusterer.addMarker(marker);
				    } 
				});
		})

	}
})
} // 병원출력함수 e
	




/*
// async-await
(async () => {
    try {
        const positions = [];

        for(const address of list) {
            const result = await addressSearch(address);
            positions.push(result)
        }

        var markers = positions.map(function(position) {
            return new kakao.maps.Marker({
                position : new kakao.maps.LatLng(position.lat, position.lng)
            });
        });


        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
    } catch (e) {
        console.log(e);
    }
})();
*/




































// 식당출력 버튼 함수
function restaurant(){
	// ---------------------마커이미지 변경2------------------------
	var imageSrc = 'http://localhost:8080/jspweb/img/restaurant.png', // 마커이미지의 주소입니다    
	    imageSize = new kakao.maps.Size(50, 49), // 마커이미지의 크기입니다
	    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
	      
	// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
	var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
	    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다
	$.get(
		"http://api.odcloud.kr/api/3071314/v1/uddi:e4e7774d-0b16-4299-b830-dee5045df70f_201909291441?page=1&perPage=100&serviceKey=t7sm4Yf%2F52aLATacOjIxj94G3uyWTYCP1%2FI1ONa0JLVa9%2Fhk7vz9mTokTdQ4dYTuVxBadEEVqiqlJhpFj%2FdK4Q%3D%3D", 
		function(r) {
			console.log(r)
		    // 데이터에서 좌표 값을 가지고 마커를 표시합니다
		    // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
		    var markers = $(r.data).map(function(i, o) {
				// 마커 생성 객체 1개
		        let marker = new kakao.maps.Marker({
					title: o.업소명,
		            position : new kakao.maps.LatLng(o.위도, o.경도),
		            image: markerImage
		        });
		        // 위에서 생성된 마커 객체에 클릭이벤트 추가 하기
		        kakao.maps.event.addListener(marker, 'click', function() {
					// 모달 띄우기
					openModal();
					console.log(marker)
					document.querySelector('.modal_title').innerHTML = `<h3>${o.업소명}</h3>`
					document.querySelector('.modal_title').style.fontSize = '20px'; 
					document.querySelector('.modal_content').innerHTML = 
					`
						<div>분야 : ${o.분야명}</div>
						<div>주메뉴 : ${o.주메뉴}</div>
						<div>주소 : ${o.소재지도로명주소}</div>
						<div>영업시간 : ${o.영업시간==null?"내용없음":o.영업시간}</div>
					`;
				});
				// 리턴해서 markers에 대입하기 [ map 함수 제공 ]
				return marker;
		    });
		    // 클러스터러에 마커들을 추가합니다
		    console.log(markers)
		    clusterer.addMarkers(markers);
		});
} // 병원 출력 e











