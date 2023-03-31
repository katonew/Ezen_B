<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	
	<div class="container">
		<h3>chart.js 사용</h3>
		<canvas id="myChart"></canvas>
	</div>

	
	<div class="container">
		<h3> 모든 회원 명단 </h3>
		<table class="mListTable" border="1"></table>
		<div>
			<select onchange="getMemberList(1)" class="listsize">
				<option>3</option>
				<option>5</option>
				<option>10</option>
			</select>
			<div class="mpagebox"></div>
			<div class="mseachcount"></div>
		</div>
		<div>
			<select class="keyword">
				<option value="">검색</option>
				<option value="mno">번호</option>
				<option value="mid">아이디</option>
				<option value="memail">이메일</option>
			</select>
			<input type="text" class="key" placeholder="검색내용">
			<button type="button" onclick="serchMember()">검색</button>
		</div>
	</div>
	<%@ include file="../footer.jsp" %>
	
	<!-- chart js -->
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<!-- 사용자 정의 -->
	<script src="/jspweb/js/admin/info.js" type="text/javascript"></script>
	

</body>
</html>