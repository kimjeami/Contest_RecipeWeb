<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>회원 목록</title>
</head>
<body>
    <h1>회원 목록</h1>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>ID</th>
                <th>비밀번호</th>
                <th>닉네임</th>
                <th>이메일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="member" items="${testVoList}">
                <tr>
                    <td>${member.no}</td>
                    <td>${member.id}</td>
                    <td>${member.pwd}</td>
                    <td>${member.nick}</td>
                    <td>${member.email}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
