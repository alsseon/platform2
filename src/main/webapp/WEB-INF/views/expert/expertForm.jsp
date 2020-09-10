<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<head>
<meta charset="UTF-8">
<title>전문가 등록</title>
</head>
<body>
<div class="container">
<br> 
<hr>


<div class="row justify-content-center">
<div class="col-sm-3">
</div>
<div class="col-sm-6">
<div class="card">
<header class="card-header">
	<a href="" class="float-right btn btn-outline-primary mt-1">Log in</a>
	<h4 class="card-title mt-2">전문가 등록 신청</h4>
</header>
<article class="card-body">
<form method="post" action="${contextPath}/expert/join_expert.do" enctype="multipart/form-data">

	<div class="form-row">
		<div class="col form-group">
			<label>아이디 </label>   
		  	<input type="text" class="form-control" name="id">
		</div> 
		 
		<div class="col form-group">
			<label>비밀번호</label>
		  	<input type="text" class="form-control" name="pwd" value="password">
		</div>
		
		<div class="col form-group">
			<label>회사명</label>
		  	<input type="text" class="form-control" name="expName" value="compname">
		</div>
		
		<div class="col form-group">
			<label>이메일</label>
		  	<input type="email" class="form-control" name="expEmail" value="expert@test.com">
			<small class="form-text text-muted">정확한 이메일 형식을 지켜주세요.</small>
		</div>
		
		<div class="col form-group">
			<label>전화번호</label>
		  	<input type="text" class="form-control" name="expTel" value="010-1234-5667">
		</div> 
	
		<div class="col form-group">
			<label>경력</label>
		  	<input type="text" class="form-control" name="expCareer" value="15년">
		</div> 
		
		<div class="col form-group">
			<label>경력 증빙</label>
			<input type="file" class="form-control" name="expCertif">
		</div> 
		
		<div class="col form-group">
			<label>증명사진</label>
			<input type="file" class="form-control" name="expImg">
		</div>
		
		<div class="col form-group">
			<label>상세 설명</label>
		  	<textarea class="form-control" name="expDetail">어쩌구저쩌구</textarea>
		</div> 
		
	</div> 
	
	<div class="form-row">
		<div class="form-group">
		  <label>업종</label>
			  <select id="expBizField" class="form-control" name="expBizField">
			      <option>가전 / 디지털</option>
			      <option>패션의류 / 잡화</option>
			      <option>홈인테리어</option>
			      <option>도서 / 음반</option>
			      <option>식품</option>
				  <option selected="">기타</option>
			  </select>
		</div>		
	</div> <!-- form-row.// -->
	
    <div class="form-group">
		<button type="submit" class="btn btn-primary btn-block">
			전문가 등록 신청
		</button>
	</div> <!-- form-group// -->      
                                          
</form>
</article> <!-- card-body end .// -->

</div> <!-- card.// -->
</div> <!-- col.//-->
<div class="col-sm-3">
</div>
</div> <!-- row.//-->


</div> 


</body>
</html>