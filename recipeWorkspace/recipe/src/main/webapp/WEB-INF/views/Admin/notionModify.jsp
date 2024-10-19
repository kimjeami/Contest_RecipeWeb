<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헬로월드</title>
<script defer src="/js/admin/notionModify.js"></script>
<link rel="stylesheet" href="/css/admin/notionDetail.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <div id="divMain">
        <div id="divTitle">
            <input type="text" class="title" placeholder="${vo.title}" value="${vo.title}"><hr>
            <h3 class="enrollDate"></h3><hr>
        </div><br>

        <h2>내용</h2>
        <textarea name="content" id="notionContent" style="font-size : large"></textarea><br>
        <br>
        <div id="modifyButton">
            <button id="mBtn" onclick="modifyBtn();">수정</button>;            
        </div>
    </div>
</body>
</html>