<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>회원가입</title>

      <!-- 다음 주소 api -->
      <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" defer></script>
      <script defer src="/js/member/join.js"></script>


  </head>

  <body>
      <form action="/member/join" method="post" class="form form__join">

        <input type="text" name="id" id="id" placeholder="아이디" required>
        <br>
        <input type="password" name="pwd" id="pwd" placeholder="비밀번호" required>
        <br>
        <input type="email" name="email" id="email" placeholder="이메일" required>
        <br>
        <input type="text" name="nick" id="nick" placeholder="이름" required>
        <br>
        <input type="text" name="birth" id="birth" placeholder="생년월일" required>
        <br>
        <input type="tel" name="phone" id="phone" placeholder="전화번호" minlength="8" maxlength="11"
          required>
        <br>
        <input type="text" name="postcode" id="postcode" placeholder="우편번호" required>
        <button type="button" class="" onclick="execDaumPostcode()">우편번호
          검색</button>
        <br>
        <input type="text" name="address" id="address" placeholder="주소" required>
        <br>
        <input type="text" name="addressDetail" id="address2" placeholder="상세주소" required>
        <br>
        <input type="text" name="addressExtra" id="extraAddress" placeholder="참고주소" required>
        <br>
        <div class="submit-btn form__join--submit-btn">
          <button type="submit">회원가입</button>
        </div>
      </form>

  </body>

  </html>