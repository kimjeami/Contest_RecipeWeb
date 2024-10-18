<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>
    <link rel="stylesheet" href="/css/member/mypage.css">
    <jsp:include page="/WEB-INF/views/layout/util.jsp" />
</head>
<body>
    <div class="container">
        <main class="main main-settings">
          <div class="settings__upper">
            <span class="settings__name">${loginMemberVo.nick}님, 환영합니다.</span>
            <span class="settings__email">${loginMemberVo.id}</span>
            <span class="settings__phone">${loginMemberVo.email}</span>
          </div>
          <div class="settings__lower">
            <a href="/member/edit" class="settings__link">내 정보 수정</a>
            <a href="#" class="settings__link">내 레시피 관리</a>
            <a href="#" class="settings__link">찜 목록 관리</a>
            <a href="/recipe/inquirylist?write_no=${loginMemberVo.no}" class="settings__link">문의 내역</a>
            <a href="/recipe/answerlist?awnser_no=${loginMemberVo.no}" class="settings__link">답변 내역</a>
            <a href="/member/logout" class="settings__link">로그아웃</a>
          </div>
        </main>
        <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
    </div>
</body>
</html>
