<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script defer src="/js/admin/adminSession.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>헬로월드</title>

</head>
<body>
<input type="hidden" name="grantVal" id="grantVal" value="${sessionScope.adminVo.adminNo}">


    <h1>홈입니다~~</h1>
    <a>관리자 번호 : ${sessionScope.adminVo.adminNo}</a>
    <button id="grantBtn" type="button" onclick="grantBtn();">권한 확인하기</button><br><br><hr>
    <c:forEach var="vo" items="${sessionScope.rankVo}">
        <a>권한 : ${vo.rankNo}</a>
    </c:forEach>
</body>
</html>