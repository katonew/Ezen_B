<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="/jspweb/css/list.css" rel="stylesheet">
	<link href="/jspweb/css/view.css" rel="stylesheet">
</head>
<body>
	<%@include file = "/header.jsp" %>
	<%
		/* JAVA 코드 들어가는 자리 */
	
		// 1. jsp 이용한 http url 변수 호출
		String bno = request.getParameter("bno");
	%>
	<div hidden="hidden" class="bno"><%=bno%></div>
	<div class="container">
		<div class="boardbox">
			<div class="viewtop">
				<div class="mimg">
					
				</div>
				<div class="rviewtop">
					<div class="mid">작성자</div>
					<div>
						<span class="bdate">작성날짜</span>
						<span><i class="fas fa-eye"></i><span class="bview">조회수</span></span>
						<span><i class="fas fa-thumbs-up"></i><span class="bup">좋아요</span></span>
						<span><i class="fas fa-thumbs-down"></i><span class="bdown">싫어요</span></span>
					</div>
				</div>
			</div>
			
			<div class="btitle">제목자리</div>
			<div class="bcontent">내용자리</div>
			<div class ="updownbox">
				<button onclick="bIncrease(2)" type="button" class="bup"><span><i class="fas fa-thumbs-up"><span class="bup2"></span></i></button>
				<button onclick="bIncrease(3)" type="button" class="bdown"><span><i class="fas fa-thumbs-down"><span class="bdown2"></span></i></button>
			</div>
			<div class="bfilebox"><i class="fas fa-download"></i><span class="bfile"></span></div>
			<div class="btnbox"></div>
			<div class="replycount">댓글개수</div>
			<div class="replywritebox">
				<textarea  class="rcontent"></textarea>
				<button  class="rwritebtn bbtn" type="button" onclick="rwrite()">댓글 등록</button>
			</div>
			<div class="replyListBox">댓글출력 들어갈 부분</div>
		</div>
	</div>
	
	
	<script src="/jspweb/js/board/view.js" type="text/javascript"></script>
</body>
</html>