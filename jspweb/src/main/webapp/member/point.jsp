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
		<h3>포인트 결제</h3>
		<div class="mpoint"></div>
		<button type="button" onclick="setpay(10000)">10000원</button>
		<button type="button" onclick="setpay(20000)">20000원</button>
		<div class="selectpay"></div>
		</br>
		<button onclick="requestPay()">결제하기</button> <!-- 결제하기 버튼 생성 -->
	</div>
	
	<!-- 포트원 결제 JS -->
	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.4.js"></script>
	<!-- 사용자 정의 JS -->
	<script src="/jspweb/js/member/point.js" type="text/javascript"></script>
	
</body>
</html>