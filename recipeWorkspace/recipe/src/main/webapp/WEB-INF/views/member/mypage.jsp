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
        <jsp:include page="/WEB-INF/views/layout/nav-back.jsp" />
        <main class="main main-settings">
          <div class="settings__upper">
            <img src="/img/profile/${loginMemberVo.profile}" alt="logo">
            <span class="settings__name">${loginMemberVo.nick}님, 환영합니다.</span>
            <span class="settings__email">${loginMemberVo.id}</span>
            <span class="settings__phone">${loginMemberVo.email}</span>
            <table class="my_count">
                <tr>
                    <th>팔로잉</th>
                    <th>팔로워</th>
                    <th>게시글</th>
                </tr>
                <tr>
                    <td>${userCountVo.followingCount}</td>
                    <td>${userCountVo.followerCount}</td>
                    <td>${userCountVo.recipeCount}</td>
                </tr>
            </table>
          </div>
          <div class="settings__lower">
            <a href="/member/edit" class="settings__link">내 정보 수정</a>
            <a href="/member/information" class="settings__link">내 레시피 관리</a>
            <a href="#" class="settings__link">찜 목록 관리</a>
            <a href="/recipe/inquirylist?write_no=${loginMemberVo.no}" class="settings__link">레시피 문의 내역</a>
            <a href="/recipe/answerlist?awnser_no=${loginMemberVo.no}" class="settings__link">답변 내역</a>
            <a href="/recipe/qna?member_no=${loginMemberVo.no}" class="settings__link">1:1 문의 내역</a>
            <a href="/member/logout" class="settings__link">로그아웃</a>
          </div>
        </main>
        <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
    </div>
</body>
</html>
