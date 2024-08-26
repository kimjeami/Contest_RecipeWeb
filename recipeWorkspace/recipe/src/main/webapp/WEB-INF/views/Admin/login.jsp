<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헬로월드</title>
<link rel="stylesheet" href="/css/admin/adminLogin.css">
</head>
<body>
    <div id="out">
        <nav>
            <h1>Recipe Admin</h1>
        </nav>
        <br>
        <form id="formDiv" action="/admin/login" method="post">
        <span id="idText">아이디</span><br>
        <input type="text" name="adminId" id="adminId"><br><br><br>
        <span id="pwdText">비밀번호</span><br>
        <input type="password" name="adminPwd" id="adminPwd"><br><br>

        <a href="#">관리자 문의</a>
        <div id="loginBtnDiv">
            <button id="loginButton"><p>로그인</p></button>
        </div>
        </form>

    </div>
</body>
</html>