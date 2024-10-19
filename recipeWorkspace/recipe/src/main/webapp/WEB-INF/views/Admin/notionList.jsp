<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헬로월드</title>
<script defer src="/js/admin/notionList.js"></script>
<script defer src="/js/admin/notionDel.js"></script>
<link rel="stylesheet" href="/css/admin/notionList.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <div id="divMain">
        <nav>
            <h1>공지사항 리스트 조회</h1>
        </nav>
    <table id="mainTable">
        <thead>
            <tr>
                <td>번호</td>
                <td>제목</td>
                <td>조회수</td>
                <td>등록일</td>
                <td>삭제 여부</td>
                <td>폐기</td>
            </tr>
        </thead>
        <tbody id="notionList">

        </tbody>
    </table>
    </div>
</body>
</html>