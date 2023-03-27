
var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(37.3218778,126.8308848), // 지도의 중심좌표 
        level : 3 // 지도의 확대 레벨 
});

let productList = null;

function getproductList(){
	let html = `<h3>제품 목록 페이지</h3>`;
    productList.forEach((p)=>{
		html +=  `<div>
 					<span>${p.pname}</span>
	  				<span>${p.pcomment}</span>
	  				<span>${p.pprice}</span>
	  				<span>${p.pstate==1? '판매중' : '판매완료' }</span>
	  				<span>${p.pview}</span>
	  				<span>${p.pdate}</span>
	  				<span>
		  				<button class="plikebtn" onclick="setplike(${p.pno})" type="button">
		  					${getplike(p.pno)}
		  				</button>
	  				</span>
	 			  </div>`
	  })
      document.querySelector('.productlistbox').innerHTML = html;
}



// 마커 클러스터러를 생성합니다 
var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
    minLevel: 5 // 클러스터 할 최소 지도 레벨 
});
 

// 1. 제품목록 호출 [ 1. 현재 보이는 지도 좌표 내 포함된 제품만]
function getproductbox(동,서,남,북){
	// 클러스터 비우기
	clusterer.clear()
	$.ajax({
		url : "/jspweb/product/info",
		method : "get",
		data : { "동": 동, "서" : 서, "남" : 남, "북" : 북},
		success : (r)=>{
		console.log(r)
	    // map ( (인덱스,반복객체명))
	    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png', // 마커이미지의 주소입니다    
	    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
	    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
	    
	    productList = r
	    getproductList()
		// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
		var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)
		
	    var markers = $(r).map((i,p)=>{
	        let marker = new kakao.maps.Marker({
	            position : new kakao.maps.LatLng(p.plat, p.plng),
	            image : markerImage 
	        });
	        // 마커에 클릭이벤트를 등록합니다
			kakao.maps.event.addListener(marker, 'click', function() {
				
				let html =  `<button onclick="getproductList()">뒤로</button>
							 <h3>제품 상세 페이지</h3>
							 <div>
				  				<div>${p.pname}</div>
				  				<div>${p.pcomment}</div>
				  				<div>${p.pprice}</div>
				  				<div>${p.pstate==1? '판매중' : '판매완료' }</div>
				  				<div>${p.pview}</div>
				  				<div>${p.pdate}</div>
				  				<div>
					  				<button class="plikebtn" onclick="setplike(${p.pno})" type="button">
					  					${getplike(p.pno)}
					  				</button>
				  				</div>
				 			</div>`
			    document.querySelector('.productlistbox').innerHTML = html;
			});
	        return marker;
	    });
	    // 클러스터러에 마커들을 추가합니다
	    clusterer.addMarkers(markers);
	    } // success e
	}); // ajax e
} // fun e
get동서남북();
function get동서남북(){
	// 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds();
    
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest(); 
    
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); 
    
    let 남 = swLatLng.getLat();
    let 서 = swLatLng.getLng();
    let 북 = neLatLng.getLat();
    let 동 = neLatLng.getLng();
    getproductbox(동,서,남,북);
}


// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'dragend', function() {get동서남북()});

// 3. 찜하기 버튼을 눌렀을때 [ 첫클릭시 찜하기 다음 클릭시 찜하기 취소 다음 클릭시 찜하기]
function setplike(pno){
	if(memberinfo.mid==null){
		alert('회원기능입니다.'); return;
	}
	$.ajax({
		url : "/jspweb/product/plike",
		method : "post",
		data : {"pno" : pno},
		success : (r)=>{
			console.log(r)
			if(r==1){
				alert('찜취소')
				document.querySelector('.plikebtn').innerHTML = '♡'
			}else if(r==2){
				alert('찜하기')
				document.querySelector('.plikebtn').innerHTML = '♥'
			}else{alert('오류')}
		}
	})
	
	//$.post("/jspweb/product/plike" , {"pno" : pno} , (r)=>{});
	
	
}



// 해당 회원의 해당 제품 찜하기 상태 호출
function getplike(pno){
	if(memberinfo.mid==null){document.querySelector('.plikebtn').innerHTML = '♡'}
	$.ajax({
		url : "/jspweb/product/plike",
		method : "get",
		async : "false",
		data : {"pno" : pno},
		success : (r)=>{
			console.log(r)
			if(r =='true'){document.querySelector('.plikebtn').innerHTML = '♥' }
			else{document.querySelector('.plikebtn').innerHTML = '♡'}
		}
	})
	
}













