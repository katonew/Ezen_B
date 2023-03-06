<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<button onclick="doPOST()" type="button">post 메소드</button>
	<button onclick="doGET()" type="button">get 메소드</button>
	<button onclick="doPUT()" type="button">put 메소드</button>
	<button onclick="doDELETE()" type="button">delete 메소드</button>
	
	
	<h3> 예제 2 : 방문록 </h3>
	내용 : 	<input type="text" class="content"> <br/>
	작성자 : 	<input type="text" class="writer">	<br/>
	<button onclick="onwrite()" type="button"> 방문자 등록 </button>
	
	<table class="boardtable" border="1"></table>
	
	
	<!--  
	
		jsp,js,dao 기존 파일 사용
		dao, dto, servlet 새로운 파일
		
		1. 제품 등록 [ 제품명, 가격 ]
		2. 제품 출력 [ 테이블에 모두 출력 ]
		3. 제품 삭제 [ 제품번호 이용한 삭제 ]
		4. 제품 수정 [ 제품번호 이용한 수정 : 제품명과 가격 수정 = prompt 수정할 데이터 입력받기]
	
	
	 -->
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="index.js"></script>
	

</body>
</html>