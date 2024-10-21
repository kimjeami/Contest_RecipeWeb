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
        <jsp:include page="/WEB-INF/views/layout/util.jsp" />
    </head>
    <body>
            <div class="container">
                <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
                <main class="main">

                <div class="recipe-container">
                    <c:forEach var="recipe" items="${recipe}">

                         <div class="recipe-item">
                                <c:if test="${recipe.thumbnail == 'nan'}">
                                     <a href="${contextPath}/recipe/detail?recipte_no=${recipe.recipte_no}">
                                        <img src="/images/sample.png" width="200px" height="200px">
                                     </a>
                                </c:if>
                                <c:if test="${recipe.thumbnail != 'nan'}">
                                        <a href="${contextPath}/recipe/detail?recipte_no=${recipe.recipte_no}">
                                            <img src="/images/${recipe.thumbnail}" width="200px" height="200px">
                                       </a>
                                </c:if>
                                <br/>
                                <a href="${contextPath}/recipe/detail?recipte_no=${recipe.recipte_no}">${recipe.title}</a>
                                <br/>
                          </div>

                    </c:forEach>
                </div>
                      <div>
                        <jsp:include page="/WEB-INF/views/Board/pagination.jsp" />
                      </div>
             </div>
                </main>
                <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
            </div>
    </body>
    </html>
