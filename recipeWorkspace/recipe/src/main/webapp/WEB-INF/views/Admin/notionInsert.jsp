<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헬로월드</title>
<script defer src="/js/admin/notionInsert.js"></script>
<link rel="stylesheet" href="/css/admin/notionInsert.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <div id="divMain">
        <div id="divTitle">
            <p>제목 :</p> <input type="text" id="title"><br><hr>
        </div><br>

        <h2>내용</h2>
        <textarea name="content" id="notionContent" style="font-size : large"></textarea><br>
        <br>
        <button id="smtbtn" onclick="smt();">등록하기</button>
    </div>
</body>
</html>