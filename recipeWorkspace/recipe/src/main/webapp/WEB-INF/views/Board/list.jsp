<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>목록 페이지 입니다.</title>
</head>
<body>
    <table border="1">
        <tbody>
            <c:forEach var="recipe" items="${recipe}">

                <th>

                </th>
                <tr>
                    <td>
                        <c:if test="${recipe.thumbnail == 'nan'}">
                            <b>이미지가 없습니다..</b>
                        </c:if>
                        <c:if test="${recipe.thumbnail != 'nan'}">
                     <img src="/images/${recipe.thumbnail}" width="200px" height="200px">
                        </c:if>
                    </td>
                    <td>
                        <dl>
                             <dt><a href="${contextPath}/recipe/detail?recipte_no=${recipe.recipte_no}">${recipe.title }</dt>
                        </dl>

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
