<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헬로월드</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>

    <h1>멤버 로그인</h1>
     <form action="/member/login" method="post">
        <input type="text" id="id" name="id" placeholder="아이디를 입력하세요">
        <input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력하세요">
        <button type="submit">Login</button>
    </form>
    <c:if test="${not empty errMsg}">
        <div class="error-message">${errMsg}</div>
    </c:if>
</body>
</html>