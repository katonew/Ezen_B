<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 회원가입 </h3>
	<form class="signupform">	<!-- 폼 전송시 자식 input의 매개변수 식별 : name = "" -->
		아이디 : <input type="text" onkeyup="idcheck()" maxlength="30" name = "mid" class="mid">	
		<span class = "idcheckconfirm"></span></br>
		비밀번호 : <input type="text" name = "mpwd" class="mpwd">	</br>
		비밀번호 확인 : <input type="text" name = "mpwdconfirm" class="mpwdconfirm">	</br>
		이메일 : <input type="text" name = "memail" class="memail">	</br>
		프로필 : <input type="file" name = "mimg" class="mimg">	</br>
		<button type="button" onclick="signup()"> 가입 </button>
	</form>
	
	
	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 사용자 정의 -->
	<script src="/jspweb/js/member/signup.js" type="text/javascript"></script>
</body>
</html>