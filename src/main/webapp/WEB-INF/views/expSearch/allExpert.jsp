<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="expertList" value="${expMap.expertList}" />
<c:set var="expertImgList" value="${expMap.expertImgList}" />
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>Publishing Company - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
  </head>
  <body>
	<section class="ftco-section ftco-degree-bg">
      <div class="container">
        <div class="row">
          <div class="col-lg-9 ftco-animate">
					<div class="row con">
					<c:forEach var = "expert" items = "${expertList}">
						<!--한칸-->
		    			<div class="col-md-4 d-flex">
		    				<div class="book-wrap">
		    				<c:forEach var="expertImg" items="${expertImgList}">
		    					<c:if test="${expert.id == expertImg.id}">
			    					<div class="img d-flex justify-content-end w-100" style="background-image: url(${contextPath}/download.do?id=${expert.id}&imageFileName=${expertImg.imageFileName});">
			    						<div class="in-text">
			    							<a href="${contextPath}/scrap/scrapExpert.do?expId=${expert.id}&compId=${member.id}" class="icon d-flex align-items-center justify-content-center scrapClass" data-toggle="tooltip" data-placement="left" title="Scrap">
			    								<span id="${expert.id}" class="flaticon-heart-1"></span>
			    							</a>
			    							<a href="${contextPath }/expSearch/viewExpert.do?id=${expert.id}" class="icon d-flex align-items-center justify-content-center" data-toggle="tooltip" data-placement="left" title="Quick View">
			    								<span class="flaticon-search"></span>
			    							</a>
			    						</div>
			    					</div>
		    					</c:if>
		    				</c:forEach>
		    					<div class="text px-4 py-3 w-100">
		    						<h2><a href="${contextPath}/expSearch/viewExpert.do?id=${expert.id}"> ${expert.expName}</a></h2>
		    						<p> ${expert.expBizField}</p>
		    					</div>
		    				</div>
		    			</div>
						<!--한칸-->
					</c:forEach>
		    		</div>
	    		<div class="row mt-5">
		          <div class="col">
		            <div class="block-27"><!--페이징처리-->
		              <ul>
             			<c:if test="${pageVO.startPage != 1}">
               				<li><a href="${contextPath}/expSearch/allExpert.do?nowPage=${pageVO.startPage -1}&cntPerPage=${pageVO.cntPerPage}">&lt;</a></li>
           				</c:if>
           				<c:forEach begin = "${pageVO.startPage}" end = "${pageVO.endPage}" var="idx">
	               			<c:choose>
	                			<c:when test="${idx == pageVO.nowPage }">
	                 				<li class="active"><span> ${idx} </span></li>
	                 			</c:when>
	                 			<c:when test="${idx != pageVO.nowPage}">
	                 				<li><a href="${contextPath}/expSearch/allExpert.do?nowPage=${idx}&cntPerPage=${pageVO.cntPerPage}"> ${idx} </a></li>
	                			</c:when>
	                  		</c:choose>
            			</c:forEach>
            			<c:if test="${pageVO.endPage != pageVO.lastPage }">
                			<li><a href="${contextPath }/expSearch/allExpert.do?nowPage=${pageVO.endPage +1}&cntPerPage=${pageVO.cntPerPage}">&gt;</a></li>
            			</c:if>
        			</ul>
	            </div><!--페이징처리-->
	          </div>
	        </div>
          </div> <!-- .col-md-8 -->

          <div class="col-lg-3 sidebar pl-lg-3 ftco-animate">
            <div class="sidebar-box">
              <form action="#" class="search-form">
                <div class="form-group">
                  <span class="fa fa-search"></span>
                  <input type="text" class="form-control" placeholder="검색어를 입력하세요">
                </div>
              </form>
          </div>
          <div id="sidebar" class="sidebar-box ftco-animate">
            <div class="categories">
              <!-- <h5>업종별 검색</h5> -->
              <select id="expertBizType" class="custom-select" style="width:75%">
                <option value="box">업종</option>
                <option value="도서/음반">도서/음반</option>
                <option value="가전/디지털">가전/디지털</option>
                <option value="홈인테리어">홈인테리어</option>
                <option value="패션의류/잡화">패션의류/잡화</option>
                <option value="기타">기타</option>
              </select>
              <button id="serchByTypebtn" class="btn btn-primary">검색</button>
              
              <!-- id기준으로 자바스크립트에서 button선택 하여 onClick메서드 이용하여 ajax작동 -->
              <!-- <h5>전문가 이름 검색</h5> -->
              
              <div class="form-group" style="margin-top:10%">
              	<input type="text" id="expertName" placeholder="전문가 이름 검색"/><span style="margin-left:7%"></span><button id="serchByName" class="btn btn-primary">검색</button>
              </div>
              <!-- <h5>전문가 이름 검색</h5> -->
            </div>
          </div>
        </div>
      </div>
     </div>
   </section> <!-- .section -->
  <!-- loader -->
  <script>
	  var serchArray = document.querySelectorAll("button");
	  var changeHtml ="";
	  console.log(serchArray)
	  var scrapArray = document.querySelectorAll(".scrapClass")
	  
	  for(var i = 0 ; i<scrapArray.length; i++){
			
			scrapArray[i].addEventListener("click",function(e){
				var expertId = e.target.id
				$.ajax({
	          	url:"${contextPath}/scrap/scrapExpert.do",
	          	type:"GET",
	          	data:{"id":expertId},
	          	dataType:"json",
	          	success:function(data){
	          		alert("스크랩에 추가하였습니다.")
	          	}
	          })
			})
		}
	  
	  
        for(var i = 0 ; i<scrapArray.length; i++){
			
			scrapArray[i].addEventListener("click",function(e){
				var expertId = e.target.id
				$.ajax({
	            	url:"${contextPath}/scrap/scrapExpert.do",
	            	type:"GET",
	            	data:{"id":expertId},
	            	dataType:"json",
	            	success:function(data){
	            		console.log("success")
	            	}
	            });
			})
		}
        
        for(var i = 0 ; i<serchArray.length; i++){
            serchArray[i].addEventListener("click",function(e){
                var target = e.target.id
                var select = "";
                
                if(target === "serchByTypebtn"){
                    select = document.querySelector("#expertBizType").value
                    console.log(select)
                    changeHtml ="";
                    if(select != "box"){
	                    typeAjax(select);
                    }else{
                    	window.location.reload(true);
                    }
                }else if(target === "serchByName"){
                    select = document.querySelector("#expertName").value
                    console.log(select)
                    changeHtml ="";
                    nameAjax(select);
                }
            })
        }
		function typeAjax(select){
			$.ajax({
            	url:"${contextPath}/serchByExpertType",
            	type:"GET",
            	data:{"type":select},
            	dataType:"json",
            	success:function(data){
            		for(var i = 0 ; i<Object.keys(data).length; i++){
                		var manuFac = data[i];
                		console.log(manuFac);
          				fixHtml(manuFac);
           			}
            	}
            });
		}
		
		function nameAjax(select){
			$.ajax({
                url:"${contextPath}/serchByExpertName",
                type:"GET",
                data:{"name":select},
                success:function(data){
                	for(var i = 0 ; i<Object.keys(data).length; i++){
                		var manuFac = data[i];
                		console.log(manuFac);
          				fixHtml(manuFac);
           			}
                }
            });
		}
		
		function fixHtml(expert){
				changeHtml += '<div class="col-md-4 d-flex">'        				
				changeHtml += 	'<div class="book-wrap">'
				changeHtml +=		'<div class="img d-flex justify-content-end w-100" style="background-image: url(${contextPath }/resources/images/book-1.jpg);">'
				changeHtml +=			'<div class="in-text">'
				changeHtml +=				'<a href="#" class="icon d-flex align-items-center justify-content-center" data-toggle="tooltip" data-placement="left" title="Add to Wishlist">'
				changeHtml +=						'<span class="flaticon-heart-1"></span>'
				changeHtml +=				'</a>'
				changeHtml +=				'<a href="#" class="icon d-flex align-items-center justify-content-center" data-toggle="tooltip" data-placement="left" title="Quick View">'
				changeHtml +=					'<span class="flaticon-search"></span>'
				changeHtml +=				'</a>'
				changeHtml +=			'</div>'
				changeHtml +=		'</div>'
				changeHtml +=		'<div class="text px-4 py-3 w-100">'
				changeHtml +=			'<h2><a href="#"> '+expert.name+' </a></h2>'
				changeHtml +=			'<p> ' + expert.type + '</p>'
				changeHtml +=		'</div>'
				changeHtml +=	'</div>'
				changeHtml +='</div>'
			
  				console.log(changeHtml);
				$(".con").html(changeHtml);
		}
  </script>
    
  </body>
</html>