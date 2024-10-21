<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헬로월드</title>
<link rel="stylesheet" href="/css/faq/faqHome.css">
<link rel="stylesheet" href="/css/layout/footer.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script defer src="/js/faq/faqDataOne.js"></script>
</head>
<body>
    <div id="container">
        <jsp:include page="/WEB-INF/views/layout/upperNav.jsp" />
        <div id="navP">
            <h1><a id="navA">RECIPE:)</a>&nbsp;자주 묻는 질문</h1>
        </div>
        <div id="second-container">
            <div id="sideBar">
                <button id="fa1" value="1" onclick="click(this.value);">비밀번호를 잃어버렸어요</button>
            </div>
            <div id="mainBar">
                <div id="divTitle">
                    
                </div>
                <div id="hrTag">
                <hr>
                </div>
                <div id="divContent">
                    <p>어ㅓㅓㅓㅓㅓㅓㅓㅓㅓ쩌ㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓ구ㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜ</p>
                </div>
            </div>
        </div>
        <hr>
    <div class="container">
        <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
    </div>
    </div>
</body>
</html>