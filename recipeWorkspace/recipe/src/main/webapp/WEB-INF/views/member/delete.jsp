<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
    <link rel="stylesheet" href="/css/member/edit.css">
    <link rel="stylesheet" href="/css/member/delete.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script defer src="/js/member/delete.js"></script>
    <jsp:include page="/WEB-INF/views/layout/util.jsp" />
</head>

<body>
    <div class="container">
        <jsp:include page="/WEB-INF/views/layout/nav-back.jsp" />
        <main class="main main-join">
            <h1>회원 탈퇴</h1>
            <div class="edit-form">
                <p style="color: red; font-weight: bold;">회원 탈퇴 시 다음과 같은 정보가 사라집니다!/p>
                <ul>
                    <li>회원 가입 정보 (이름, 이메일 등)</li>
                    <li>가입한 모든 게시물 및 댓글</li>
                    <li>좋아요 및 즐겨찾기한 항목</li>
                    <li>활동 기록 및 통계</li>
                    <li>개인 정보 및 프로필 사진</li>
                </ul>
                <div class="dl-member">
                    <button type="button" id="deleteMemberBtn">삭제하기</button>
                </div>
            </div>
            <div id="passwordModal" class="modal">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <h2>회원 탈퇴하기</h2>
                    <form action="/member/delete" method="post">
                        <br>
                        <label for="currentPwd">비밀번호</label> &nbsp;&nbsp;
                        <input type="password" name="pwd" id="pwd" required>
                        <br>
                        <br>
                        <button type="submit" id="deleteButton">삭제하기</button>
                    </form>
                </div>
            </div>
        </main>
        <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
    </div>
</body>

</html>
