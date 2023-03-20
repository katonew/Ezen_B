<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="/jspweb/css/list.css" rel="stylesheet">
</head>
<body>

	<%@include file = "/header.jsp" %>
	 <%
	 	// 1. HTTP GET <a href="URL경로?변수명=값"> 전달된 매개변수 가져오기 
	 	String cno = request.getParameter("cno");
	 	// 2. 표현식을 이용한 input , div 등등 대입 
	 %>
	 <!-- cno 숨겨서 js에게 전달  -->
	<input type="hidden" class="cno" value="<%=cno%>">
	
	<!-- HTML/CSS -->
	<div class="container">
		<div class="boardbox">
			<div class="boardtop">
				<h3 class="cname"></h3>
				<p>다양한 사람들과 정보를 공유해보세요</p>
			</div>
			<div class="boardTopETC">
				<button class="bbtn"><a href="write.jsp"><i class="fas fa-pen-nib"></i>글쓰기</a></button>
				<div>
					<span class="seachcount"></span>
					<button class="bbtn" onclick="setsearch()" type="button">전체보기</button>
					<select onchange="setlistsize()" class="listsize">
						<option>3</option>
						<option>5</option>
						<option>10</option>
					</select>
				</div>
			</div>
			<div class="boardTable"></div>
			<div class="boardbot">
				<div class="pagebox"></div>
				<div class="serchbox">
					<select class="key bbtn">	<!-- select 시 사용되는 조건의 필드명 -->
						<option value="b.btitle">제목</option>
						<option value="b.bcontent">내용</option>
						<option value="m.mid">작성자</option>
					</select>
					<input class="keyword" type="text">	<!-- select 시 사용되는 조건의 데이터 -->
					<button class="bbtn" onclick="getsearch()" type="button">검색</button>
				</div>
			</div>
		</div>
	</div>
	
		<!-- 페이징처리 버튼들 -->
		
	
	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
	
</body>
</html>