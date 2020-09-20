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
    <title>Publishing Company - Free Bootstrap 4 Template by Colorlib</title>
        <meta charset="utf-8">
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet">

        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="${contextPath }/resources/css/animate.css">

        <link rel="stylesheet" href="${contextPath }/resources/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${contextPath }/resources/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="${contextPath }/resources/css/magnific-popup.css">

        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">

        <link rel="stylesheet" href="${contextPath }/resources/css/flaticon.css">
        <link rel="stylesheet" href="${contextPath }/resources/css/style.css">
    <style>
    .sidebar{
    	position: absolute;
		top:20px;
		right:-150px;
		width:130px;
    }
    </style>
  </head>
  <body>
	<section class="ftco-section ftco-degree-bg">
      <div class="container">
        <div class="row">
        	<!-- 소개 사진 한칸 -->
          	<div class="col-lg-5 ftco-animate" style="height:500px">
	          	<p>
	              <img src="${contextPath }/resources/images/image_1.jpg" alt="" class="img-fluid">
	            </p>
           </div> <!-- .col-md-8 -->
           <!-- 소개 사진 한칸 -->
           <!-- user정보 -->
           <div class="col-lg-7 ftco-animate">
	          		<h3>${user.id }</h3>
	          		<h3>${user.compName }</h3>
	          		<h3>${user.compEmail }</h3>
	          		<h3>${user.compBizType }</h3>
	          		<h3>${user.compTel }</h3>
           </div>

          <!-- user정보 -->
          <!-- user정보가 스타트업 이라면 모두 출력 -->
          <!-- user정보가 제조업체라면 견적내역만 출력-->
          <!-- user정보가 전문가라면 컨설팅내역만 출력-->
          <!-- 전문가 스크랩 한칸 -->
          <!-- 더보기 버튼 필요 -->
          <c:if test="${userType eq 'startup' }">
          
	          <div class="col-md-12">
	          <div>
		          <h3 style="display: inline-block;">전문가 스크랩 리스트</h3>&nbsp;
		          <a href="${contextPath }/scrap/printExpertScrap.do" class="btn btn-primary" >More</a>
	          </div>
	          <c:forEach items="${expertList }" var="expert">
		        <div class="col-md-3 ftco-animate" style="display: inline-block;">
					<div class="staff">
						<div class="img-wrap d-flex align-items-stretch" >
							<div class="img align-self-stretch" style="background-image: url(${contextPath}/resources/images/staff-6.jpg);"></div>
						</div>
						<div class="text pt-3 px-3 pb-4 text-center">
							<h3>${expert.expName }</h3>
							<div class="faded">
								<p>${expert.expBizField }</p>
								<a href="${contextPath }/viewExpert?id=${expert.id }" class="btn btn-primary">상세페이지</a>
		            		</div>
						</div>
					</div>
				</div>
				</c:forEach>
			  </div>
			  <!-- 전문가 스크랩 한칸 -->
			  <div class="col-md-12" style="height: 250px;"></div>
			  <!-- 제조업체 한칸 -->
			  <!-- 더보기 버튼 필요 -->
			  <div class="col-md-12">
			  <div>
				  <h3 style="display: inline-block;">제조업체 스크랩 리스트</h3>
				  <a href="${contextPath }/scrap/printManuScrap.do" class="btn btn-primary" >More</a>
			  </div>
			  <c:forEach items="${manuList }" var="manu">
				  <div class="col-md-3 ftco-animate" style="display: inline-block;">
		 				<div class="book-wrap">
		 					<div class="img d-flex justify-content-end w-100" style="background-image: url(${contextPath}/resources/images/book-1.jpg);">
		 						<div class="in-text">
									<a href="${contextPath }/viewManufac?id=${manu.id }" class="btn btn-primary">상세페이지</a>
		 						</div>
		 					</div>
		 					<div class="text px-4 py-3 w-100">
		 						<p class="mb-2"><span class="price">${manu.productPrice }</span></p>
		 						<h2><a href="${contextPath }/viewManufac?id=${manu.id }">${manu.manuName }</a></h2>
		 						<p>${manu.manuBizType }</p>
		 					</div>
		 				</div>
				  	</div>
				  </c:forEach>
			  </div>
			  <!-- 제조업체 한칸 -->
			  
		  </c:if>
		  
		  <div class="col-md-12" style="height: 250px;"></div>
		  
		  <c:if test="${userType eq 'startup'||userType eq 'manu' }">
		  
			  <!-- 더보기 버튼 필요 -->
				  <div class="col-md-6">
					  <div class="col-md-12">
						  <h1 class="mb-3" style="display: inline-block;">Quotation List</h1>&nbsp;
						  <a href="${contextPat }/startuppage/consultinglist.do" class="btn btn-primary" >More</a>
					  </div>
					  <ul style="line-height: 55px; list-style: none; font-size: 40px;">
					  	<c:forEach items="${quotationList }" var="quotation" >
					  		<li>${quotation.item } / ${quotation.quantity }</li>
					  	</c:forEach>
					  </ul>
				  </div>
			</c:if>
			<c:if test="${userType eq 'startup'||userType eq 'expert' }">
			  <!-- 요청 컨설팅 리스트 -->
			  <!-- 더보기 버튼 필요 -->
				  <div class="col-md-6">
					  <div class="col-md-12">
						  <h1 class="mb-3" style="display: inline-block;">Consulting List</h1>&nbsp;
						  <a href="${contextPat }/startuppage/consultinglist.do" class="btn btn-primary" >More</a>
					  </div>
					  <ul style="line-height: 55px; list-style: none; font-size: 40px;">
					  	<c:forEach items="${consultingList }" var="consulting" >
					  		<li>${consulting.title }</li>
					  	</c:forEach>
					  </ul>
		        </div>
		        
	        </c:if>
        </div>
      </div>
    </section> <!-- .section -->
    
    <!-- side bar -->
	<div class="col-lg-4 sidebar pl-lg-5 ftco-animate" style="position:absolute; top: 1000px; right:0px; width:500px;">
	     <div class="sidebar-box ftco-animate">
	       <div class="categories">
	         <h3>Services</h3>
	         <ul style="list-style: none;">
		         <li><a href="${contextPath}/">내 정보 관리 <span class="fa fa-chevron-right"></span></a></li>
		         <li><a  href="${contextPath}/scrap/printScrapAll.do">스크랩 리스트<span class="fa fa-chevron-right"></span></a></li>
		         <li><a  href="${contextPath}/startuppage/manu_estilist.do">견적 관리<span class="fa fa-chevron-right"></span></a></li>
		         <li><a  href="${contextPath}/startuppage/consultinglist.do">컨설팅 관리<span class="fa fa-chevron-right"></span></a></li>
		         <li><a  href="${contextPath}/com_startuppage/com_estlist.do">견적 완료 내역 관리<span class="fa fa-chevron-right"></span></a></li>
		         <li><a  href="${contextPath}/com_startuppage/com_consultinglis">컨설팅 완료 내역 관리<span class="fa fa-chevron-right"></span></a></li>
		         <li><a  href="${contextPath}/">로그아웃<span class="fa fa-chevron-right"></span></a></li>
	         </ul>
	       </div>
	     </div>
    </div>
    <!-- side bar -->
    
  

	  <!-- loader -->
	  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>
	
	
	  <script src="${contextPath }/resources/js/jquery.min.js"></script>
        <script src="${contextPath }/resources/js/jquery-migrate-3.0.1.min.js"></script>
        <script src="${contextPath }/resources/js/popper.min.js"></script>
        <script src="${contextPath }/resources/js/bootstrap.min.js"></script>
        <script src="${contextPath }/resources/js/jquery.easing.1.3.js"></script>
        <script src="${contextPath }/resources/js/jquery.waypoints.min.js"></script>
        <script src="${contextPath }/resources/js/jquery.stellar.min.js"></script>
        <script src="${contextPath }/resources/js/owl.carousel.min.js"></script>
        <script src="${contextPath }/resources/js/jquery.magnific-popup.min.js"></script>
        <script src="${contextPath }/resources/js/jquery.animateNumber.min.js"></script>
        <script src="${contextPath }/resources/js/scrollax.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
        <script src="${contextPath }/resources/js/main.js"></script>
	  <script>
	  $(function(){
	
			//사이드바 스크롤
			const scrollHeight = 62;
	
			function sidebar(){
				if($(window).scrollTop() > scrollHeight){
					let top = $(window).scrollTop() - scrollHeight + 20;
					document.querySelector('.sidebar').style.top = top+'px';
				}else{
					document.querySelector('.sidebar').style.top = '20px';
				}
			}
	
			sidebar();
	
			$(window).scroll(()=>{
				sidebar();
			});
	
		});
	  </script>
  </body>
</html>