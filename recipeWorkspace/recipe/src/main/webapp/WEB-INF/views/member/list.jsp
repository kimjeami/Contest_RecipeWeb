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
                <th>생일</th>
                <th>성별</th>
                <th>전화번호</th>
                <th>우편번호</th>
                <th>주소</th>
                <th>상세주소</th>
                <th>추가주소</th>
                <th>가입일</th>
                <th>탈퇴일</th>
                <th>삭제 여부</th>
                <th>차단 여부</th>
                <th>프로필</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="member" items="${memberVoList}">
                <tr>
                    <td>${member.no}</td>
                    <td>${member.id}</td>
                    <td>${member.pwd}</td>
                    <td>${member.nick}</td>
                    <td>${member.email}</td>
                    <td>${member.birth}</td>
                    <td>${member.gender}</td>
                    <td>${member.phone}</td>
                    <td>${member.postcode}</td>
                    <td>${member.address}</td>
                    <td>${member.addressDetail}</td>
                    <td>${member.addressExtra}</td>
                    <td>${member.enrollDate}</td>
                    <td>${member.delDate}</td>
                    <td>${member.delYn}</td>
                    <td>${member.banYn}</td>
                    <td>${member.profile}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
