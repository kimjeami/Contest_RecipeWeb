<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>회원가입</title>

      <!-- 다음 주소 api -->
      <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" defer></script>
      <script defer src="/js/member/join.js"></script>

      <link rel="stylesheet" href="/css/member/join.css">
      <jsp:include page="/WEB-INF/views/layout/util.jsp" />

      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


  </head>

  <body>
    <div class="container">
        <jsp:include page="/WEB-INF/views/layout/nav-mini.jsp" />
        <main class="main main-join">
            <form action="/member/join" method="post" class="form form__join">
                <div class="form-group">
                    <input type="text" name="id" id="id" placeholder="아이디" required>
                    <button type="button" id="checkIdBtn">아이디 중복 체크</button>
                </div>

                <div class="form-group">
                    <input type="password" name="pwd" id="pwd" placeholder="비밀번호" required>
                    <input type="password" name="confirmPwd" id="confirmPwd" placeholder="비밀번호 확인" required>
                    <button type="button" id="checkPwdBtn">비밀번호 확인</button>
                </div>

                <div class="form-group">
                    <input type="email" name="email" id="email" placeholder="이메일" required>
                </div>

                <div class="form-group">
                    <input type="text" name="nick" id="nick" placeholder="이름" required>
                </div>

                <div class="form-group">
                    <input type="text" name="birth" id="birth" placeholder="생년월일" required>
                </div>

                <div class="form-group">
                    <input type="tel" name="phone" id="phone" placeholder="전화번호" minlength="8" maxlength="11" required>
                </div>

                <div class="form-group">
                    <input type="text" name="postcode" id="postcode" placeholder="우편번호" required>
                    <button type="button" class="" onclick="execDaumPostcode()">우편번호 검색</button>
                </div>

                <div class="form-group">
                    <input type="text" name="address" id="address" placeholder="주소" required>
                </div>

                <div class="form-group">
                    <input type="text" name="addressDetail" id="address2" placeholder="상세주소" required>
                </div>

                <div class="form-group">
                    <input type="text" name="addressExtra" id="extraAddress" placeholder="참고주소">
                </div>

                <div class="submit-btn form__join--submit-btn">
                    <button type="submit">회원가입</button>
                </div>
            </form>
        </main>
        <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
    </div>

  </body>

  </html>