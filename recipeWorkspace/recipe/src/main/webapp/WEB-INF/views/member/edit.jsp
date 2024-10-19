<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
    <link rel="stylesheet" href="/css/member/edit.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script defer src="/js/member/edit.js"></script>
    <jsp:include page="/WEB-INF/views/layout/util.jsp" />
</head>

<body>
    <div class="container">
        <jsp:include page="/WEB-INF/views/layout/nav-back.jsp" />
        <main class="main main-join">
            <h1>회원 정보 수정</h1>
            <div class="edit-form">
                <form action="/member/edit" method="post" class="form form__edit">
                    <div class="input-container">
                        <div class="form-group">
                            <label for="nick">닉네임</label>
                            <input type="text" name="nick" id="nick" value="${loginMemberVo.nick}" required>
                        </div>
                        <div class="form-group">
                            <label for="email">이메일</label>
                            <input type="email" name="email" id="email" value="${loginMemberVo.email}" required>
                        </div>
                        <div class="form-group">
                            <label for="birth">생년월일</label>
                            <input type="text" name="birth" id="birth" value="${loginMemberVo.birth}" required>
                        </div>
                        <div class="form-group">
                            <label for="phone">전화번호</label>
                            <input type="tel" name="phone" id="phone" value="${loginMemberVo.phone}" required>
                        </div>
                        <div class="form-group">
                            <label for="postcode">우편번호</label>
                            <input type="text" name="postcode" id="postcode" value="${loginMemberVo.postcode}">
                            <button type="button" onclick="execDaumPostcode()">우편번호 검색</button>
                        </div>
                        <div class="form-group">
                            <label for="address">주소</label>
                            <input type="text" name="address" id="address" value="${loginMemberVo.address}">
                        </div>
                        <div class="form-group">
                            <label for="addressDetail">상세주소</label>
                            <input type="text" name="addressDetail" id="addressDetail" value="${loginMemberVo.addressDetail}">
                        </div>
                        <div class="form-group">
                            <label for="addressExtra">참고주소</label>
                            <input type="text" name="addressExtra" id="addressExtra" value="${loginMemberVo.addressExtra}">
                        </div>
                    </div>

                    <div class="change-password">
                        <button type="button" id="changePasswordBtn">비밀번호 변경</button>
                    </div>

                    <div class="submit-btn">
                        <button type="submit">정보 수정</button>
                    </div>
                </form>

                <div class="withdraw-btn">
                    <button onclick="location.href='/member/delete'">회원 탈퇴</button>
                </div>
            </div>

            <div id="passwordModal" class="modal">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <h2>비밀번호 변경</h2>
                    <form id="changePasswordForm">
                        <br>
                        <label for="currentPwd">현재 비밀번호</label>
                        <input type="password" name="currentPwd" id="currentPwd" required>
                        <br>
                        <br>

                        <label for="newPwd">새&nbsp; 비밀번호</label> &nbsp;
                        <input type="password" name="newPwd" id="newPwd" required>
                        <br>
                        <br>

                        <label for="confirmNewPwd">비밀번호 확인</label>
                        <input type="password" name="confirmNewPwd" id="confirmNewPwd" required>
                        <br>
                        <br>

                        <button type="submit">변경하기</button>
                    </form>
                </div>
            </div>
        </main>
        <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
    </div>
</body>

</html>
