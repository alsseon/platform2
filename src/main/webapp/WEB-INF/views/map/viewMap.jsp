<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>마커 클러스터러 사용하기</title>
    
</head>
<body>
<div style="width:100%;height:350px;"></div>
<div class="container">
	<div id="map" style="width:100%;height:600px;"></div>
</div>
<div style="width:100%;height:350px;"></div>
<div>${manuAddrList }</div>



<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5cb49ebebf3987887f76ee04385397f2&libraries=services,clusterer"></script>
<script>
    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 
        level : 14 // 지도의 확대 레벨 
    });
    
    var manuAddrList = "<c:out value='${manuAddrList}'/>";
	var arr = new Array();
	<c:forEach items="${manuAddrList}" var="manu">
		arr.push("${manu.manuAddr }")
	</c:forEach>
	console.log(arr);
    // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 10 // 클러스터 할 최소 지도 레벨 
    });

    
    /* data 자리에 좌표 넣어야함
    var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667);
    // 클러스터러에 마커들을 추가합니다
    */
    
    var geocoder = new kakao.maps.services.Geocoder();
	var data = []
 // 주소로 좌표를 검색합니다
 for(var i = 0; i<arr.length; i++){
	 geocoder.addressSearch(arr[i], function(result, status) {
    	var markers = new kakao.maps.Marker({
    		position : new kakao.maps.LatLng(result[0].y, result[0].x)
    				});
    	clusterer.addMarkers(markers);
 	});
 }
	
</script>
</body>
</html>