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
		
		<form class="writeForm">
			제품명 : 		<input name="pname" type="text">	</br>
			제품 설명 : 	<input name="pcomment" type="text">	</br>
			제품 가격 : 	<input name="pprice" type="text">	</br>
			거래 위치 : 	
			<div id="map" style="width:100%;height:350px;"></div>
			<button onclick="onwrite()" type="button">제품등록</button>
		
		</form>
		
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1e6d590e52408e487c28d9762e541b00"></script>
	<script src="/jspweb/js/product/write.js" type="text/javascript"></script>
</body>
</html>