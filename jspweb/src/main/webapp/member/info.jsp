<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/header.jsp" %>
	
	<div class="container">
		<h3> 회원 정보 </h3>
		<div>
			<img class="mimg" width="100px" src="/jspweb/member/pimg/default.webp">
		</div>
		<div>
			<div>아이디</div>
			<div class="mid"></div>
		</div>
		<div>
			<div>이메일</div>
			<div class="memail"></div>
		</div>
		<div>
			<div>보유포인트</div>
			<div class="mpoint"></div>
		</div>
		<button onclick="setupdate()" type="button">회원정보수정</button>
		<button onclick="setdelete()" type="button">회원탈퇴</button>
	</div>


	<script src="/jspweb/js/member/info.js" type="text/javascript"></script>
</body>
</html>

<!--  
	동일한 HTML에서 열리는 JS파일은 메모리 공유
	* 단 먼저 호출된 js순
	* 주의 ajax
		1. $.ajax({}) 비동기통신 [ 요청보내고 응답을 기다리지 않음 ]
		
			요청			응답
			
			요청1=======>
			|			요청1 처리
			|			
			|
			|
			|
			요청2=======> 요청2 처리
			|
			|
			|
			|
			|
			|<========== 요청2 응답
			|
			|
		2. $.ajax({async : false}) : 동기 통신
		
		요청			응답
			
			요청1=======>
			|			요청1 처리
							|			
							|
							|
							|
			|<========== 요청1 응답
			|
			|
			요청2=======> 요청2 처리
							|
							|
							|
							|
			|<========== 요청2 응답
						
 -->
 
 
 
 
 
 
 
 
 
 
 
 
 