  <%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<html>
<div class="container mt-1">
    <ul class="pagination justify-content-center">
        <!-- 처음 페이지 표시 여부 -->
        <c:if test="${page > 1}">
            <li class="page-item">
                <a class="page-link" href="${url}?keyword=${keyword}" title="처음">
                    <i class='fas fa-angle-double-left'></i>
                </a>
            </li>
        </c:if>

        <!-- 이전 페이지 표시 여부 -->
        <c:if test="${startPage > 1}">
            <li class="page-item">
                <a class="page-link" href="${url}?page=${startPage - 1}&keyword=${keyword}">
                    <i class='fas fa-angle-left'></i>
                </a>
            </li>
        </c:if>

        <!-- 페이징 안의 '숫자' 표시 -->
        <c:if test="${totalPage > 1}">
            <c:forEach var="k" begin="${startPage}" end="${endPage}">
                <c:if test="${k != page}">
                    <li class="page-item">
                        <a class="page-link" href="${url}?page=${k}&keyword=${keyword}" >${k}</a>
                    </li>
                </c:if>
                <c:if test="${k == page}">
                    <li class="page-item active">
                        <a class="page-link" href="javascript:void(0);">${k}</a>
                    </li>
                </c:if>
            </c:forEach>
        </c:if>

        <!-- 다음 페이지 표시 여부 -->
        <c:if test="${totalPage > endPage}">
            <li class="page-item">
                <a class="page-link" href="${url}?page=${endPage + 1}&keyword=${keyword}">
                    <i class='fas fa-angle-right'></i>
                </a>
            </li>
        </c:if>

        <!-- 마지막 페이지 표시 여부 -->
        <c:if test="${page < totalPage}">
            <li class="page-item">
                <a class="page-link" href="${url}?page=${totalPage}&keyword=${keyword}">
                    <i class='fas fa-angle-double-right'></i>
                </a>
            </li>
        </c:if>
    </ul>
</div>

</html>