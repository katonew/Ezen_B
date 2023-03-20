<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	
	<%@include file = "/header.jsp" %>
	
	<%
		// 1.JSP 로그인 여부 제어
		Object o = request.getSession().getAttribute("login");
		if( o==null){
			response.sendRedirect("/jspweb/member/login.jsp");
		}
		// 2.HTTP url 안에 있는 bno 호출
		int bno = Integer.parseInt(request.getParameter("bno"));
	%>
	
	<input type="hidden" class="bno" value="<%=bno%>">
	<div class="container">
		
		<h3>글수정</h3>
		<form class="updateForm">
			<div>
				카테고리 : <select name="cno" class="cno">
							<option value="1">공지사항</option>
							<option value="2">커뮤니티</option>
							<option value="3">QnA</option>
							<option value="4">노하우</option>
						</select>
			</div>
			<div>
				제목 : <input type="text" class="btitle" name="btitle">
			</div>
			<div>
				내용 : <textarea id="summernote" class="bcontent" name="bcontent"></textarea>
			</div>
			<div class="bfilebox"></div>
			<button onclick="bupdate()" type="button"> 수정 </button>
		
		
		</form>
	</div>
	
	
	
	
	<script src="/jspweb/js/board/update.js" type="text/javascript"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<!-- 
		HTML =======> form [ 동기식 : 페이지 전환이 있음 ]
		<form action="통신할URL" method="HTTP메소드">
			1. enctype="application/x-www.form-urlencoded" : 기본 폼 전송타입
			2. enctype="multipart/form-data"
		- 주의 form 태그 안에 있는 button의 type을 생략하면 기본타입이 submit(폼보내기)
				form 태그 안에 있는 button의 type을 button으로 명시
		vs JS ------ > AJAX [ 비동기식 , 동기식 모두가능 ]
		
		
		
	
	 -->
	

</body>
</html>