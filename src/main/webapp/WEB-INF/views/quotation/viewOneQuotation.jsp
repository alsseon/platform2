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
</head>
<body>
	<section class="ftco-section bg-light">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-12">
                        <div class="wrapper px-md-4">
                            <div class="row no-gutters">
                                <div class="contact-wrap w-100 p-md-5 p-4">
                                    <h3 class="mb-4">견  적  서</h3>
                                    <form method="POST" class="contactForm">
                                        <div class="row">
                                        	<div class="col-md-6">
                                                <div class="form-group">
                                                    <div style="float:left"><label class="label" for="no">NO</label></div>
                                                    <div style="float:left; padding-left: 2%">
	                                                    <input
	                                                        type="text"
	                                                        class="random"
	                                                        name="no"
	                                                        style="border:none;"
	                                                        value="${quotationVO.no}" readonly />
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <div style="float:left"><label class="label" for="tempSave">임시저장</label></div>
                                                    <div style="float:left; padding-left: 2%">
                                                    	<input
	                                                        type="checkbox"
	                                                        name="tempSave"
	                                                        value="false" readonly />
                                                    </div>
                                                </div>
                                            </div>
                                            <br>
                                            <br>
                                            <br>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="label" for="compId">요청업체</label>
                                                    <input
                                                        type="text"
                                                        class="form-control"
                                                        name="compId"
                                                        value="${quotationVO.compId}" readonly><!--requeset.getSession("userId") 으로 차후 교체-->
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="label" for="manuId">견적업체</label>
                                                    <input
                                                        type="text"
                                                        class="form-control"
                                                        name="manuId"
                                                        value="${quotationVO.manuId}" readonly />
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="label" for="item">견적품목</label>
                                                    <input
                                                        type="text"
                                                        class="form-control"
                                                        name="item"
                                                        value="${quotationVO.item}"
                                                        placeholder="item">
                                                </div>
											</div>
											<div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="label" for="quantity">수량</label>
                                                    <input
                                                        type="text"
                                                        class="form-control"
                                                        name="quantity"
                                                        value="${quotationVO.quantity}"
                                                        placeholder="수량">
                                                </div>
											</div>
											<div class="col-md-1">
                                                <div class="form-group">
                                                    <label class="label" for="#">금액</label>
                                                    <div style="text-align:right; padding-right: 20px;">
														<span>&#8361;</span>
													</div>
                                                </div>
                                            </div>
											<div class="col-md-5">
                                                <div class="form-group">
                                                    <label class="label" for="price">    </label>
                                                    <input
                                                        type="text"
                                                        class="form-control price"
                                                        name="price"
                                                        value="${quotationVO.price}"
                                                        placeholder="가격">
                                                </div>
											</div>
											<div class="col-md-1">
                                                <div class="form-group">
                                                    <label class="label" for="subject">VAT</label>
                                                    <div style="text-align:right; padding-right: 20px;">
														<span>&#8361;</span>
													</div>
                                                </div>
                                            </div>
											<div class="col-md-5">
                                                <div class="form-group">
                                                    <label class="label" for="vat">    </label>
                                                    <input
                                                        type="text"
                                                        class="form-control vat"
                                                        name="vat"
                                                        value="" readonly />
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="label" for="detail">Detail</label>
													<input
														type="text"
                                                        name="detail"
                                                        class="form-control"
                                                        value="${quotationVO.detail}"
                                                        placeholder="내용 상세"  />
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="label" for="fileName">첨부</label>
													<input
														type="text" 
                                                        name="fileName"
                                                        class="form-control"
                                                        value="${quotationVO.fileName}"  />
                                                </div>
                                            </div>
                                            <c:if test="${member.type == 'startup'}">
                                            	<div class="col-md-12">
	                                                <div class="form-group">
	                                                    <input type="submit" value="Quotation withdrawal" class="btn btn-primary">
	                                                    <div class="submitting"></div>
	                                                </div>
                                            	</div>
                                            </c:if>
                                            <!--<c:if test="${member.type == 'manufac'}"> 로그인 기능 결합 되면 주석 해제-->
                                            <!--</c:if>-->
                                           	<div class="col-md-12">
	                                            <c:if test="${quotationVO.quoteStatus == 0 }">
	                                               	<div class="form-group" style="display: inline-block;">
	                                                   <a href= "${contextPath}/manufacpage/estilist_updatestatus.do?quotestatus=${quotationVO.quoteStatus}&no=${quotationVO.no}" class="btn btn-info">Quotation accept</a>
	                                                   <div class="submitting"></div>
	                                               	</div>
	                                               	<div class="form-group" style="display: inline-block;">
	                                                   	<a href= "${contextPath}/manufacpage/estilist_updatestatus_de.do?quotestatus=${quotationVO.quoteStatus}&no=${quotationVO.no}" class="btn btn-primary">Quotation reject</a>
	                                                   <div class="submitting"></div>
	                                               </div>
	                                            </c:if>
	                                            <c:if test="${quotationVO.quoteStatus == 1 }">
	                                               <div class="form-group">
	                                                   <a href= "${contextPath}/manufacpage/estilist_updatestatus.do?quotestatus=${quotationVO.quoteStatus}&no=${quotationVO.no}" class="btn btn-primary">Quotation complete</a>
	                                                   <div class="submitting"></div>
	                                               </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen">
    
        </div>
		<script>
			
			var price = document.querySelector(".price")
			var vat = document.querySelector(".vat")
			
			
			
			addEventListener("load",function(e){
				vat.value = Math.round(price.value/10)
			})
		</script>

</body>
</html>