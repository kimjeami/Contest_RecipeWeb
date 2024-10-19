<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script defer src="/js/admin/adminSession.js"></script>
<link rel="stylesheet" href="/css/admin/adminSessionHome.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>헬로월드</title>

</head>
<body>
<input type="hidden" name="grantVal" id="grantVal" value="${sessionScope.adminVo.adminNo}">

    <div id="out">
        <nav>
            <h1>Admin Session Home</h1>
        </nav>
        <p>관리자 번호 : ${sessionScope.adminVo.adminNo}</p>
        <p>관리자 아이디 : ${sessionScope.adminVo.adminId}</p>
            <button id="grantBtn" type="button" onclick="grantBtn();">권한 확인하기</button><br><br><hr>
        <c:forEach var="vo" items="${sessionScope.rankVo}">
            <a>${vo.rankName}</a>
        </c:forEach>
        <hr>
        <br>
        <a id="homeLink" href="/admin/testAdminSidebar">홈 이동하기</a>
    </div>
    <br><br>
</body>
</html>