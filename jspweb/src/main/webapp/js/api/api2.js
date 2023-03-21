// ------------------테스트 객체-------------------------
/*
var positions = [
    {
        title: '한대앞역', 
        latlng: new kakao.maps.LatLng(37.3096197848, 126.853809070)
    },
    {
        title: '이동공원', 
        latlng: new kakao.maps.LatLng(37.308892435, 126.848621556)
    },
    {
        title: '한양대에리카', 
        latlng: new kakao.maps.LatLng( 37.298139167, 126.838830675)
    },
    {
        title: '이젠컴퓨터',
        latlng: new kakao.maps.LatLng(37.3084200584, 126.850920843)
    }
];
*/

/* 전기 충전소 객체 만들기 */
/*
let positions = [];

$.ajax({
	url : "https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=t7sm4Yf%2F52aLATacOjIxj94G3uyWTYCP1%2FI1ONa0JLVa9%2Fhk7vz9mTokTdQ4dYTuVxBadEEVqiqlJhpFj%2FdK4Q%3D%3D",
	method : "get",
	async : false,
	success : (r)=>{
		console.log(r)	// 공공데이터 데이터 요청 결과
		r.data.forEach((o)=>{	// 결과 내 객체 반복문
			let info = { // 마커를 표시할 객체 생성
			        title: o.충전소명,
			        latlng: new kakao.maps.LatLng(o['위도(WGS84)'],o['경도(WGS84)'])
		   	} // push e
		   	console.log(info)
		   	positions.push(info)	// 생성된 객체를 리스트/배열에 담는다.
		}) // forEach e
		console.log(positions)
	} // success e
}) // ajax e
*/


// ------------------지도 옵션 및 생성-------------------------
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(37.3218778, 126.8308848), //지도의 중심좌표.
	level: 5 //지도의 레벨(확대, 축소 정도)
};
var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴



// ---------------------마커이미지 변경------------------------
var imageSrc = 'http://localhost:8080/jspweb/img/markericon.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(50, 49), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다

// ---------------------마커 여러개 생성-----------------------------  
/*
for(let i=0;i<positions.length;i++){
	 // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
    });
    // ---------------------마커 클릭 이벤트---------------------------
	// 마커에 클릭이벤트를 등록합니다
	kakao.maps.event.addListener(marker, 'click', function() {
	      // 마커 위에 인포윈도우를 표시합니다
	      alert(positions[i].title+'의 마커 클릭했습니다.');
	});
} // for e
   
*/
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
var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
    minLevel: 5 // 클러스터 할 최소 지도 레벨 
});

/*
	.forEach ( (o)=>{ }) 	: 실행문에서 반환값이 없다
	.map ( (o)=>{ }) 		: 실행문에서 반환값이 있다 / 반복문에서 리턴된 모든 값들을 배열에 저장
*/

 
// 데이터를 가져오기 위해 jQuery를 사용합니다
// 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
$.get(
"https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=t7sm4Yf%2F52aLATacOjIxj94G3uyWTYCP1%2FI1ONa0JLVa9%2Fhk7vz9mTokTdQ4dYTuVxBadEEVqiqlJhpFj%2FdK4Q%3D%3D", 
function(r) {
	console.log(r)
    // 데이터에서 좌표 값을 가지고 마커를 표시합니다
    // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
    var markers = $(r.data).map(function(i, o) {
		// 마커 생성 객체 1개
        let marker = new kakao.maps.Marker({
			title: o.충전소명,
            position : new kakao.maps.LatLng(o['위도(WGS84)'], o['경도(WGS84)']),
            image: markerImage
        });
        // 위에서 생성된 마커 객체에 클릭이벤트 추가 하기
        kakao.maps.event.addListener(marker, 'click', function() {
			// 모달 띄우기
			openModal();
			console.log(marker)
			document.querySelector('.modal_title').innerHTML = o.충전소명
			document.querySelector('.modal_title').style.fontSize = '20px'; 
			document.querySelector('.modal_content').innerHTML = o.소재지지번주소;
		});
		// 리턴해서 markers에 대입하기 [ map 함수 제공 ]
		return marker;
    });
    // 클러스터러에 마커들을 추가합니다
    clusterer.addMarkers(markers);
});







