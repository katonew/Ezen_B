
var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(37.3218778,126.8308848), // 지도의 중심좌표 
        level : 3 // 지도의 확대 레벨 
});

let productList = null;

// 제품목록 출력
function getproductList(){
	let html = ``;
    productList.forEach((p,i)=>{
		html +=  `<div onclick="productPrint(${i})" class="productbox">
					<div class="pimgbox">
						<img src="/jspweb/product/pimg/${p.pimgList[0]}">
					</div>
					<div class="pcontentbox">
						<div class="pdate">${p.pdate}</div>
						<div class="pname">${p.pname}</div>
						<div class="pprice">${p.pprice.toLocaleString()}원</div>
						<div class="petc">
							<span><i class="fas fa-eye"></i>${p.pview}</span>
							<span class="plikebtn"></span>
							<span><i class="far fa-comment-dots"></i></span>10</span>
						</div>
					</div>
				</div>`
		getplike(p.pno)
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
	    var imageSrc = `/jspweb/img/mapmarker.png`, // 마커이미지의 주소입니다    
	    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
	    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
	    
	    productList = r
	    getproductList()
		// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
		var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)
		
	    var markers = $(r).map((p,i)=>{
			var imageSrc = `/jspweb/product/pimg/${i.pimgList[0]}`, // 마커이미지의 주소입니다    
		    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
		    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
		    
		    productList = r
		    getproductList()
			// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
			var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)
			
	        let marker = new kakao.maps.Marker({
	            position : new kakao.maps.LatLng(i.plat, i.plng),
	            image : markerImage 
	        });
	        // 마커에 클릭이벤트를 등록합니다
			kakao.maps.event.addListener(marker, 'click', function() {
				productPrint(p);
			});
	        return marker;
	    });
	    // 클러스터러에 마커들을 추가합니다
	    clusterer.addMarkers(markers);
	    } // success e
	}); // ajax e
} // fun e

// 제품 개별 조회
function productPrint(i){
	let p = productList[i]
	
	// 이미지 슬라이드에 대입할 html 구성
	let imghtml = ``;
	p.pimgList.forEach((img,k)=>{
		// bs class : active 현재 보여지는 이미지
		if(k==0){
			imghtml += `<div class="carousel-item active">
				      <img src="/jspweb/product/pimg/${img}" class="d-block w-100" alt="...">
				    </div>`
		}else{
			imghtml += `<div class="carousel-item">
				      <img src="/jspweb/product/pimg/${img}" class="d-block w-100" alt="...">
				    </div>`
			
		}
		
	})
	let html = ``
	 html += `<div class="pviewbox">
				<div class="pviewinfo">
					<div class="mimgbox">
						<img alt="" src="/jspweb/member/pimg/${p.mimg==null? "default.webp" : p.mimg}" class="hpimg">
						<span>작성자 : ${p.mid}</span>
					</div>
					<div class="backbtn">
						<button class="pbadge" onclick="getproductList()" type="button">뒤로가기</button>
					</div>
				</div>
				<!-- 이미지 캐러셀 : 이미지 슬라이드 -->
				<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
				  <div class="carousel-inner">
				    ${imghtml}
				  </div>
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
				</div> <!-- 캐러셀 e -->
				<!-- 제품 상세 내용물 -->
				<div class="pdate">${p.pdate}</div>
				<div class="pname">${p.pname}</div>
				<div class="pcomment">${p.pcomment}</div>
				<div class="pstate">
					<span class="pbadge">
						${p.pstate==1? '판매중' : p.pstate==2? '거래중' : '판매완료' }
					</span>
				</div>
				<div class="pprice">${p.pprice.toLocaleString()}원</div>
				<div class="petc">
					<span><i class="fas fa-eye"></i>${p.pview}</span>
					<span><i class="fas fa-thumbs-up"></i>5</span>
					<span><i class="far fa-comment-dots"></i></span>10</span>
				</div>
				<div class="pviewbtnbox">
					<button type="button" class="plikebtn" onclick="setplike(${p.pno})"><i class="far fa-heart"></i></button>
					<button onclick="chatprint(${i})" type="button">쪽지보내기</button>
				</div>
			</div>`
    document.querySelector('.productlistbox').innerHTML = html;
    getplike(p.pno);
}// end

//채팅 페이지 이동
function chatprint(i){
	let p = productList[i]
	let chathtml = '';
	$.ajax({
		url : "/jspweb/product/chat",
		method : "get",
		async : false,
		data : {"pno" : p.pno},
		success : (r)=>{
			console.log(r)
			
			
			r.forEach((o)=>{
				if(o.frommno == memberinfo.mno){
					chathtml += `<div class="sendbox">${o.ncontent}</div>`
				}else{
					chathtml += `<div class="receivebox">${o.ncontent}</div>`
				}
				
			})
		}
	})
	
	let html = `<div class="pchatbox">
					<div class="pviewinfo">
						<div class="mimgbox">
							<img alt="" src="/jspweb/product/pimg/${p.pimgList[0]}" class="hpimg">
							<span class="pname">${p.pname}</span>
						</div>
						<div class="backbtn">
							<button class="pbadge" onclick="productPrint(${i})" type="button">뒤로가기</button>
						</div>
					</div>
				</div>
				<div class="chatcontent">
					${chathtml}
				</div>
				<div class="chatbtn">
					<textarea class="ncontentinput"></textarea>
					<button onclick="sendchat(${p.pno}, ${p.mno})" type="button">전송</button>
				</div>`;
	document.querySelector('.productlistbox').innerHTML = html;
	
}

// 5.
function sendchat(pno, tomno){
	let ncontent = document.querySelector('.ncontentinput').value;
	$.ajax({
		url : "/jspweb/product/chat",
		method : "post",
		data : { 
			"pno" : pno, 
			"ncontent" : ncontent,
			"tomno" : tomno
		},
		success: (r)=>{
			console.log(r)
			if(r=='true'){
				document.querySelector('.ncontentinput').value = '';
			}else{
				
			}
		} // success e
	}) // ajax e
} // sendchat e






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



//해당 회원의 해당 제품 찜하기 상태 호출
function getplike(pno){
	if(memberinfo.mid==null){document.querySelector('.plikebtn').innerHTML = '♡'}
	else{
		$.ajax({
		url : "/jspweb/product/plike",
		method : "get",
		data : {"pno" : pno},
		success : (r)=>{
			if(r =='true'){document.querySelector('.plikebtn').innerHTML = '♥' }
			else{document.querySelector('.plikebtn').innerHTML = '♡'}
		}
	})
		
	}
	
	
}













