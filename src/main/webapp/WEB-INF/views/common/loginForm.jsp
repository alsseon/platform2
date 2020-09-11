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

   <title>회원 로그인</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
   
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
       .container{
        max-width: 500px;
        padding: 15px;
        padding-left: 70px;
        margin: 0 auto;	 
        border: solid;
        border-color: white;
        border-radius: 10px;
        background-color: #eee;
       }
       .select .form-control{
        width: 250px;
        margin-top: 30px;
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
   
   <!-- 로그인 화면 -->
   <div class="container">

     <form class="form-horizontal" id="login" name="frmLogin" method="post" action="${contextPath }">
      <div class="select">
         <select class="form-control input-sm" id="selectid">
         	<option value="admin" id="admin">회원종류를 선택하세요</option>
           <option value="startup" id="startup">스타트업</option>
           <option value="manufac" id="manufac">제조업체</option>
           <option value="expert" id="expert">전문가</option>
         </select>
         
       </div>
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
          <input type="button" value = "로그인" id="loginButton" class="btn btn-lg btn-primary" />
          &emsp;
          
          <button type="reset" class="btn btn-lg btn-danger" >다시입력</button>
        </div>
     	  </div>
 	 	</form>
      </div> <!-- /container -->
      <div class="form-group-2">
        <div class="col-sm-offset-2 col-sm-10">

          <!-- <input type="submit" class="btn btn-lg btn-success" value="아이디/비밀번호 찾기" formaction="${contextPath}/member/searchForm.do"> -->
          <a href="${contextPath}/member/searchForm.do" class="btn btn-lg btn-success" >아이디/비밀번호 찾기</a>
          &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
          <!--  <input type="submit" class="btn btn-lg btn-warning" value="회원가입" formaction="${contextPath}/member/joinForm.do">-->
           <a href="${contextPath}/member/joinForm.do" class="btn btn-lg btn-warning" >회원가입</a>
        </div>
      </div>  

     <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

     <script>
     	var loginbutton = document.querySelector("#loginButton");
     	var formtag = document.querySelector("#login")
     	loginbutton.addEventListener("click",function(){
		var select = document.querySelector("#selectid").value
		if(select === "startup"){
			console.log("startup 선택")
			formtag.action+="/startup/login.do"
			formtag.submit();
		}else if(select === "manufac"){
			console.log("manufac 선택 ")
			formtag.action+="/manufac/login.do"
			formtag.submit();
		}else if(select ==="expert"){
			console.log("expert 선택")
			formtag.action+="/expert/login.do"
			formtag.submit();
		}else{
			console.log("admin 선택")
			formtag.action+="/admin/login.do"
			formtag.submit();
		}
     	})
     </script>
   </body>
   </html>