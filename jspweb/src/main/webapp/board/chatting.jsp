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
	
	<div class="container">
	
	
		<div class="chatbox">
			
			<div class="contentbox"><!-- 채팅창 -->
			</div>
			<div>
				<!-- form-control : 부트스트랩 -->
				<textarea onkeydown="enterchat()" onkeyup="msgcheck()" class="form-control msgbox" rows="" cols=""></textarea>
			</div>
			
			
			<div class="chattingbtnbox">
				<div>이모티콘</div>
				<div>첨부파일</div>
				<button class="sendbtn" disabled="disabled" onclick="보내기()" type="button">보내기</button>
			</div>
			
		</div>
		
	</div>
	
	<script src="/jspweb/js/board/chatting.js" type="text/javascript"></script>

</body>
</html>