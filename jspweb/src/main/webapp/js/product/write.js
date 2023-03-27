console.log('상품등록 js 열림')
if(memberinfo.mid==null){
	alert('로그인 후 이용하세요')
	location.href="/jspweb/member/login.jsp";
}


let plat = 0;
let plng = 0;

function onwrite(){
	
	// 1. 폼전송
	let writeForm = document.querySelectorAll('.writeForm')[0]
	// 2. 폼데이터 객체 선언
	let writeFormData = new FormData(writeForm);
	// 3. 위도 경도 입력받기
	// 폼 데이터 격체에 필드 추가 [set : 필드명 중복 불가능]
	writeFormData.set( "plat" , plat );
	writeFormData.set( "plng" , plng );
	
	
	if(plat!=0&&plng!=0){
		if(fileList.length<1){
			alert('하나 이상의 이미지를 등록해주세요')
			return;
		}
		fileList.forEach((f=>{
			// 배열에 존재하는 파일들을 하나씩 폼에 등록 [append 필드명 중복 가능]
			writeFormData.append("fileList",f);
		}))
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
			} // success e
		}) // ajax e
	} // if e
} // onwrite e


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

//--------------드래그 앤 드랍--------------------//


let fileList = [];

// 1. 드래그앤드랍 할 구역[DOM] 객체 호출
let fileDrop = document.querySelector('.fileDrop');

// 2. 해당 구역에 이벤트 등록
	// 1. dragenter
fileDrop.addEventListener( "dragenter" ,(e)=>{
	e.preventDefault(); // 고유이벤트 [ 브라우저 내 ] 제거
	console.log('드래그 요소가 해당 구역에 닿았을때')
})
	// 2. dragover
fileDrop.addEventListener( "dragover" ,(e)=>{
	e.preventDefault(); //  고유이벤트 [ 브라우저 내 ] 제거
	console.log('드래그 요소가 해당 구역에 위치하고 있을때')
	fileDrop.style.backgroundColor = "gray";
})
	// 3. dragleave
fileDrop.addEventListener( "dragleave" ,(e)=>{
	e.preventDefault(); //  고유이벤트 [ 브라우저 내 ] 제거
	console.log('드래그 요소가 해당 구역을 나갔을때')
	fileDrop.style.backgroundColor = "#ffffff";
})
	// 4. drop
fileDrop.addEventListener( "drop" ,(e)=>{
	// drop을 사용할 때의 문제점 : 브라우저에 사용했을때 해당 파일을 실행
	e.preventDefault(); //  고유이벤트 [ 브라우저 내 ] 제거
	console.log('드래그 요소가 해당 구역에 드롭 되었을때')
	// 1. 드랍된 파일[dataTransfer]을 호출
	let files = e.dataTransfer.files
	for(let i =0;i<files.length;i++){
		if(files[i]!=-null&&files[i]!=undefined){
			fileList.push(files[i]) // 각 파일들을 하나씩 배열에 저장
		} // if e
	} // for e
	fileDrop.style.backgroundColor = "#ffffff";
	printfiles();
})

// 3. 해당 구역에 드랍된 파일 목록 출력
function printfiles(){
	let html = '';
	fileList.forEach((f,i)=>{
		let fname = f.name	// 파일명 호출
		let fsize = (f.size/1024).toFixed(1); // 파일용량[바이트--> kB로 변경] // toFixed :  소수점자르기
		console.log(fname)
		console.log(fsize)
		html += `<div>
					<span>${fname} / </span>
					<span>${fsize}kb</span>
					<span><button type="button" onclick="filedelete(${i})">삭제</button></span>
				</div>`
	})
	fileDrop.innerHTML = html;
}


// 드래그앤드랍된 파일 목록에서 특정 파일 제거

function filedelete(i){
	fileList.splice(i,1);
	printfiles()
}















