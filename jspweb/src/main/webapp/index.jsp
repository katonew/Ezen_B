<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="/jspweb/css/index.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/header.jsp" %>	<!-- JSP 페이지 포함 -->
	<div class="serchbox">
			검색
	</div>
	<div class="contentbox"> 
		<div id="map" style="width:75%; height:700px;"></div>
		<!-- 사이드바 -->
		<div class="productlistbox">
			
		</div> <!-- productlistbox e -->
	</div>
	
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1e6d590e52408e487c28d9762e541b00&libraries=clusterer""></script>
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>




<!-- 
	<div class="productbox">
		<div class="pimgbox">
			<img src="/jspweb/product/pimg/Noimage.png">
		</div>
		<div class="pcontentbox">
			<div class="pdate">2023-03-28</div>
			<div class="pname">상품설명상품설명상품설명상품설명상품설명상품설명상품설명</div>
			<div class="pprice">15,000</div>
			<div class="petc">
				<span><i class="fas fa-eye"></i>30</span>
				<span><i class="fas fa-thumbs-up"></i>5</span>
				<span><i class="far fa-comment-dots"></i></span>10</span>
			</div>
		</div>
	</div>



 -->



