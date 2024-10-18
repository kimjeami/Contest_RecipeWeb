<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인홈</title>
    <link rel="stylesheet" href="/css/member/login.css">
    <jsp:include page="/WEB-INF/views/layout/util.jsp" />
</head>
<body>
    <div class="container">
        <jsp:include page="/WEB-INF/views/layout/nav-mini.jsp" />
        <main class="main main-login">
          <img src="/img/image.png" alt="logo">
          <form action="/member/login" method="post" class="form form__login">
            <input type="text" name="id" id="id" placeholder="아이디">
            <input type="password" name="pwd" id="pwd" placeholder="비밀번호">
            <div class="submit-btn form__login--submit-btn"><button type="submit">로그인</button></div>
          </form>
          <div class="login__links">
            <a href="/member/find">아이디 · 비밀번호 찾기</a>
            <span>|</span>
            <a href="/member/join">회원가입</a>
          </div>
        </main>
        <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
    </div>
</body>
</html>
