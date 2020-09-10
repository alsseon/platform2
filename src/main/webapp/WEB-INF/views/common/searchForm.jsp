<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="result" value="${param.result }" />
<%
  request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>아이디/비밀번호 찾기</title>
<c:choose>
  <c:when test="${result =='loginFailed' }">
    <script>
       window.onload=function(){
    	   alert("아이디나 비밀번호가 틀립니다. 다시 로그인 하세요!");
       }
    </script>
  </c:when>
</c:choose>
<style>
	body{
	 padding-top: 40px;
  	 padding-bottom: 40px;
	 background-color: #eee;	 
	}
	.container{
	 max-width: 500px;
  	 padding: 15px;
  	 padding-left: 70px;
	 margin: 0 auto;	 
	 border: solid;
	 border-color: white;
	 border-radius: 10px;
	 background-color: #ddd;
	}
	.form-group .form-control{
	 height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  	 padding: 10px;
  	 font-size: 16px;
	}
	.form-group-2{
	 margin: 0 auto;
	 max-width: 600px;  	 
  	 padding-top: 50px;
	}
		
</style>
</head>
<body>
<div class="container">

      <form class="form-horizontal" name="frmLogin" method="post" >
  <div class="form-group">
    <h3 class="form-signin-heading">ID</h3>
    <p></p>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputId3" name="id" placeholder="아이디를 입력하세요">
    </div>
  </div>
  <div class="form-group">
    <h3 class="form-signin-heading">Password</h3>
    <p></p>
     <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" name="pwd" placeholder="비밀번호를 입력하세요">
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
     <p><p>
      <input type="submit" class="btn btn-lg btn-primary" value="로그인" formaction="${contextPath}/startup/login.do">
      &emsp;
      <input type="reset" class="btn btn-lg btn-danger" value="다시입력">
    </div>
  </div>
  
</form>

    </div> <!-- /container -->
  <div class="form-group-2">
    <div class="col-sm-offset-2 col-sm-10">
     
      <input type="submit" class="btn btn-lg btn-success" value="아이디/비밀번호 찾기" formaction="${contextPath}/member/searchForm.do">
      &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
      <input type="submit" class="btn btn-lg btn-warning" value="회원가입" formaction="${contextPath}/member/joinForm.do">
    </div>
  </div>  

  <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>