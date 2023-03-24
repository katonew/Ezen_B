<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="/jspweb/css/chatting.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/header.jsp" %>
	
	<div class="container chattingwrap">
	
		<!-- 접속 명단 출력구역 -->
		<div class="connectlistbox">
		
		</div>
		<div class="chatbox">
			
			<div class="contentbox"><!-- 채팅창 -->
			</div>
			<div>
				<!-- form-control : 부트스트랩 -->
				<textarea onkeydown="enterchat()" onkeyup="msgcheck()" class="form-control msgbox" rows="" cols=""></textarea>
			</div>
			
			
			<div class="chattingbtnbox">
				<!-- 
					bs : 드롭다운 
						클릭위치 :  data-bs-toggle="dropdown"
						드롭다운 표시할 위치 : class="dropdown-menu"
				-->
				<button class="emobtn" type="button" data-bs-toggle="dropdown">
					<i class="far fa-smile"></i>
				</button>
				<!-- 드롭다운 클릭시 보이는 구역 -->
				<div class="dropdown-menu emolist">
					
				</div>
				<button class="sendbtn" disabled="disabled" onclick="보내기()" type="button">보내기</button>
			</div>
			
		</div>
		
	</div>
	
	<script src="/jspweb/js/board/chatting.js" type="text/javascript"></script>

</body>
</html>