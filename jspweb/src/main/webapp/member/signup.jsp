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
	<h3> 회원가입 </h3>
	<form class="signupform">	<!-- 폼 전송시 자식 input의 매개변수 식별 : name = "" -->
		아이디 : <input type="text" onkeyup="idcheck()" maxlength="30" name = "mid" class="mid">	
		<span class = "checkconfirm"></span></br>
		비밀번호 : <input type="password" onkeyup="pwdcheck()" maxlength="20" name = "mpwd" class="mpwd"></br>
		비밀번호 확인 : <input type="password" onkeyup="pwdconfirmcheck()" maxlength="20" name = "mpwdconfirm" class="mpwdconfirm">
		<span class = "checkconfirm"></span></br>
		이메일 : <input type="text" onkeyup="emailcheck()" name = "memail" class="memail">	
		<span class = "checkconfirm"></span></br>
		프로필 : <input onchange="premimg(this)" type="file" name = "mimg" class="mimg">	
		미리보기 : <img class="premimg" width="5%" src="/jspweb/member/pimg/default.webp">
		</br>
		
		<button type="button" onclick="signup()"> 가입 </button>
	</form>
	
	
	<%@ include file="../footer.jsp" %>
	<!-- 사용자 정의 -->
	<script src="/jspweb/js/member/signup.js" type="text/javascript"></script>
</body>
</html>