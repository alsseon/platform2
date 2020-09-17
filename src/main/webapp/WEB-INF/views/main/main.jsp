<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="expertList" value="${expMap.expertList}" />
<c:set var="expertImgList" value="${expMap.expertImgList}" />

<%
  request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
  <head>
    <title>Publishing Company - Free Bootstrap 4 Template by Colorlib</title>
<style>
	#detail{
		width: 350px;
		height: 50px;
	}
	#expertDetail{
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
	}
</style>
    <meta charset="utf-8">
  </head>
  <body>
    
    <section class="hero-wrap" style="background-image: url();" data-stellar-background-ratio="0.5"><!--이미지 삽입부-->
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-center">
          <div class="col-md-8 ftco-animate d-flex align-items-end">
             <div class="text w-100">
               <h1 class="mb-4">스타트 업의 고민을 해결하기 위한 사이트</h1>
               <p class="mb-4">작은 고민부터 시제품 제작 까지 전문가와 제조업체가 함께합니다.</p>
               <p><a href="#" class="btn btn-primary py-3 px-4">전문가 컨설팅 검색</a> <a href="#" class="btn btn-white py-3 px-4">제조 업체 매칭</a></p>
            </div>
          </div>
        </div>
      </div>
    </section>

   
   
   <section class="ftco-section ftco-no-pt">
   <div class="container-fluid px-md-4">
      <div class="row justify-content-center pb-5 mb-3">
      <div class="col-md-7 heading-section text-center ftco-animate">
      <span class="subheading">분야별</span>
      <h2>제조업체 리스트</h2>
      </div>
      </div>
   </div>
   
   <div class="row">
   	<c:forEach var="manufac" items="${manufacVO}" begin="0" end="2">
   		<div class="col-md-6 col-lg-4 d-flex"><!-- 제조 업체 사진 , 제조업체 간단 소개  시작-->
         <div class="book-wrap d-lg-flex">
            <div class="img d-flex justify-content-end" style="background-image: url(${contextPath}/download.do?id=${manufac.id}&imageFileName=${manufac.manuImg});">
               <div class="in-text">
                  <a href="#" class="icon d-flex align-items-center justify-content-center" data-toggle="tooltip" data-placement="left" title="Add to Wishlist">
                     <span class="flaticon-heart-1"></span>
                  </a>
                  <a href="#" class="icon d-flex align-items-center justify-content-center" data-toggle="tooltip" data-placement="left" title="Quick View">
                     <span class="flaticon-search"></span>
                  </a>
               </div>
            </div>
            <div class="text p-4">
               <p class="mb-2"><span class="price">최소발주금액&nbsp; ${manufac.productPrice}만원</span></p>
               <h2><a href="#">${manufac.manuName}</a></h2>
               <span class="position">${manufac.manuAddr}</span>
               <div>
               		<span class="position">${manufac.manuBizType}</span>
               </div>
            </div>
         </div>
      </div><!-- 제조 업체 사진 , 제조업체 간단 소개  끝-->
   	</c:forEach>
   	
   	<c:forEach var="manufac" items="${manufacVO}" begin="3" end="5">
   		<div class="col-md-6 col-lg-4 d-flex">
         <div class="book-wrap d-lg-flex">
            <div class="img d-flex justify-content-end" style="background-image: url(${contextPath}/download.do?id=${manufac.id}&imageFileName=${manufac.manuImg});">
               <div class="in-text">
                  <a href="#" class="icon d-flex align-items-center justify-content-center" data-toggle="tooltip" data-placement="left" title="Add to Wishlist">
                     <span class="flaticon-heart-1"></span>
                  </a>
                  <a href="#" class="icon d-flex align-items-center justify-content-center" data-toggle="tooltip" data-placement="left" title="Quick View">
                     <span class="flaticon-search"></span>
                  </a>
               </div>
            </div>
            <div class="text p-4 order-md-first">
               <p class="mb-2"><span class="price">최소발주금액&nbsp; ${manufac.productPrice}만원</span></p>
               <h2><a href="#">${manufac.manuName}</a></h2>
               <span class="position">${manufac.manuAddr}</span>
            </div>
         </div>
      </div>
   	</c:forEach>
   </div>
   
</section>
  
    <section class="ftco-section testimony-section ftco-no-pb">
      <div class="container">
        <div class="row justify-content-center mb-5">
          <div class="col-md-7 text-center heading-section heading-section-white ftco-animate">
             <span class="subheading">Testimonial</span>
            <h2 class="mb-3">Kinds Words From Clients</h2>
          </div>
        </div>
        <div class="row ftco-animate">
          <div class="col-md-12">
            <div class="carousel-testimony owl-carousel ftco-owl">
            
            <!-- 전문가 목록 -->
            <c:forEach var="expert" items="${expertList}" begin="0" end="4">
              <div class="item">
                <div class="testimony-wrap py-4">
                   <div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-quote-left"></span></div>
                  <div class="text">
                  	<div id="detail">
	                    <p class="mb-4" id="expertDetail"><a href="#">${expert.expDetail}</a></p>
                  	</div>
                    <div class="d-flex align-items-center">
                      <c:forEach var="expImage" items="${expertImgList}">
                      	<c:if test="${expert.id == expImage.id}">
	                       <div class="user-img" style="background-image: url(${contextPath}/download.do?id=${expImage.id}&imageFileName=${expImage.imageFileName})"></div>
                      	</c:if>
                      </c:forEach>
                       <div class="pl-3">
                          <p class="name">${expert.expName}</p>
                          <span class="position">${expert.expBizField}</span>
                        </div>
                     </div>
                  </div>
                </div>
              </div>            
            </c:forEach>
            
              
            </div>
          </div>
        </div>
      </div><!--전문가 진짜 끝-->
    </section>
    
  </body>
</html>