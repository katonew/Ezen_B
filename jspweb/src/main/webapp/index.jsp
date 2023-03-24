<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height:100%">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="height:100%">
	<%@ include file="/header.jsp" %>	<!-- JSP 페이지 포함 -->
	
	<div class="container" style="display: flex; width: 80%"> 
		<div id="map" style="width:80%; height:800px;"></div>
		<div style="position: fixed; left: 10px; top : 40%; 
				width: 200px; height: 200px; z-index: 999; background-color: white;">
			검색
		</div>
		<div class="productlistbox" style=" width : 20%">
			사이드바
		</div>
	</div>
	<%@ include file="/footer.jsp" %>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1e6d590e52408e487c28d9762e541b00&libraries=clusterer""></script>
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>