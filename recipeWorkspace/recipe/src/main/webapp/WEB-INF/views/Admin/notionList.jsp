<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헬로월드</title>
<script defer src="/js/admin/notionList.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <div id="out">
    <table>
        <thead>
            <tr>
                <td>번호</td>
                <td>제목</td>
                <td>조회수</td>
                <td>등록일</td>
                <td>삭제 여부</td>
            </tr>
        </thead>
        <tbody id="notionList">

        </tbody>
    </table>
    </div>
</body>
</html>