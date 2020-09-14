<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="articlesList" value="${articlesMap.articlesList}" />
<c:set var="total" value="${articlesMap.total}" />
<c:set var="section" value="${articlesMap.section}" />
<c:set var="pageNum" value="${articlesMap.pageNum}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A게시판</title>
</head>
<body>
	<div class="container" align="center">
        <div class="col-sm-8">
            <table class="table table-striped table-hover table-sm table-bordered">
                <thead align="center">
                    <tr class="table-active">
                        <th style="width:20%">작성자</th>
                        <th style="width:60%">제목</th>
                        <th style="width:20%">작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                    	<c:when test="${articlesList.isEmpty()}">
                    		<tr align="center">
	                    		<td colspan='3'>
	                    			<p align="center">
										<b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
									</p>
	                    		</td>
                    		</tr>
                    	</c:when>
                    	<c:when test="${articlesList != null}">
                    		<c:forEach var="article" items="${articlesList}" varStatus="articleNum">
                    			<tr align="center">
                    			<c:choose>
                    				<c:when test="${article.writer == 'admin'}">
                    					<td>관리자<input type="hidden" name="no" value="${article.no}"></td>
                    				</c:when>
                    				<c:otherwise>
                    					<td>${article.writer}<input type="hidden" name="no" value="${article.no}"></td>
                    				</c:otherwise>
                    			</c:choose>
									<td align="left">
									<c:choose>
										<c:when test="${article.lvl > 1}">
											<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-return-right" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  											<path fill-rule="evenodd" d="M10.146 5.646a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L12.793 9l-2.647-2.646a.5.5 0 0 1 0-.708z"/>
  											<path fill-rule="evenodd" d="M3 2.5a.5.5 0 0 0-.5.5v4A2.5 2.5 0 0 0 5 9.5h8.5a.5.5 0 0 0 0-1H5A1.5 1.5 0 0 1 3.5 7V3a.5.5 0 0 0-.5-.5z"/>
											</svg>
											</span>
											<a href="${contextPath}/adminQnA/viewArticle.do?no=${article.no}&level=${article.lvl}"><span>A.</span>${article.title}</a>
										</c:when>
										<c:otherwise>
											<a href="${contextPath}/adminQnA/viewArticle.do?no=${article.no}&level=${article.lvl}"><span>Q.</span>${article.title}</a>
										</c:otherwise>
									</c:choose>
									</td>
									<td>${article.writeDate}</td>
								</tr>
							</c:forEach>
                    	</c:when>
                    </c:choose>
                </tbody>
            </table>
            <div>
            	<c:if test="${total != null}">
            		<c:choose>
            			<c:when test="${total > 100}">
            				<c:forEach var="page" begin="1" end="10" step="1">
            					<c:if test="${section > 1 && page == 1}">
            						<a href="${contextPath}/adminQnA/listArticles.do?section=${section-1}&pageNum=${(section-1)*10+1}">&nbsp;pre</a>
            					</c:if>
            					<a href="${contextPath}/adminQnA/listArticles.do?section=${section}&pageNum=${page}">${(section-1)*10+page}</a>
            					<c:if test="${page==10}">
            						<a href="${contextPath}/adminQnA/listArticles.do?section=${section+1}&pageNum=${section*10+1}">&nbsp;next</a>
            					</c:if>
            				</c:forEach>
            			</c:when>
            			<c:when test="${total == 100}">
            				<c:forEach var="page" begin="1" end="10" step="1">
            					<a href="#">${page}</a>
            				</c:forEach>
            			</c:when>
            			<c:when test="${total < 100}">
            				<c:forEach var="page" begin="1" end="${total/10+1}" step="1">
            					<c:choose>
            						<c:when test="${page==pageNum}">
            							<a class="active" href="${contextPath}/adminQnA/listArticles.do?section=${section}&pageNum=${page}">${page}</a>
            						</c:when>
            						<c:otherwise>
            							<a href="${contextPath}/adminQnA/listArticles.do?section=${section}&pageNum=${page}">${page}</a>
            						</c:otherwise>
            					</c:choose>
            				</c:forEach>
            			</c:when>
            		</c:choose>
            	</c:if>
            </div>
            
            
        </div>
    </div>
		<c:if test="${member.type == 'startup'}">
		<div class="text-center">
			<a href="${contextPath}/adminQnA/articleForm.do">질문작성</a>
		</div>
		</c:if>
</body>
</html>