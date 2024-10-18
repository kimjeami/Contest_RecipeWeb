    <%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    <!DOCTYPE html>
    <head>
        <meta charset="UTF-8">
        <title>목록 페이지 입니다.</title>
        <link rel="stylesheet" href="/css/board/boardlist.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
            <div class="container">
                <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
                <main class="main">
                <div class="recipe-container">
                    <c:forEach var="recipe" items="${recipe}">
                            <div class="recipe-item">

                                <c:if test="${recipe.thumbnail == 'nan'}">
                                    <img src="/images/sample.png" width="200px" height="200px">
                                </c:if>
                                <c:if test="${recipe.thumbnail != 'nan'}">
                                    <img src="/images/${recipe.thumbnail}" width="200px" height="200px">
                                </c:if>
                                <br/>
                                <a href="${contextPath}/recipe/detail?recipte_no=${recipe.recipte_no}">${recipe.title}</a>
                                <br/>
                                <c:choose>
                                    <c:when test="${recipe.state == 0}">
                                        <i class="status selling"></i>
                                    </c:when>
                                    <c:when test="${recipe.state == 1}">
                                        <i class="status sold-out"></i>
                                    </c:when>
                                </c:choose>

                            </div>
                    </c:forEach>
                      <a href="${contextPath}/recipe/inquirylist?write_no=${loginMemberVo.no}">문의 내역</a>
                      <a href="${contextPath}/recipe/answerlist?awnser_no=${loginMemberVo.no}">답변 내역</a>
                </div>
                    <jsp:include page="/WEB-INF/views/Board/pagination.jsp" />
             </div>
                </main>
                <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
            </div>
    </body>
    </html>
