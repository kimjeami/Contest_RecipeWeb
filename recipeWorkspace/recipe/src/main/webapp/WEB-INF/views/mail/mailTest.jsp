<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>이메일 인증 테스트</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <h2>이메일 인증</h2>

    <label for="email">이메일 입력: </label>
    <input type="email" id="email" placeholder="example@email.com">
    <button id="sendMailBtn">인증번호 발송</button>

    <div id="verifySection" style="display: none;">
        <label for="verifyCode">인증번호 입력: </label>
        <input type="text" id="verifyCode">
        <button id="checkCodeBtn">인증 확인</button>
    </div>

    <p id="resultMessage"></p>

    <script>
        let verificationCode = "";

        // 이메일 인증번호 발송 요청
        $("#sendMailBtn").click(function () {
            let email = $("#email").val().trim();
            if (email === "") {
                alert("이메일을 입력하세요.");
                return;
            }

            $.ajax({
                url: "/mail/send",
                type: "POST",
                contentType: 'application/json', // 서버에 JSON 형식으로 전송
                data: JSON.stringify({ mail: email }), // JSON 데이터 전송
                success: function (response) {
                    verificationCode = response.trim();
                    $("#verifySection").show();
                    alert("인증번호가 발송되었습니다.");
                },
                error: function (e) {

                    alert(e+"이메일 전송 중 오류가 발생했습니다.");
                }
            });
        });

        // 입력한 인증번호 확인 (AJAX 요청 추가)
        $("#checkCodeBtn").click(function () {
            let email = $("#email").val().trim();
            let inputCode = $("#verifyCode").val().trim();



            if (inputCode === "") {
                alert("인증번호를 입력하세요.");
                return;
            }

            $.ajax({
                url: "/mail/verify",
                type: "POST",
                contentType: 'application/json', // 서버에 JSON 형식으로 전송
                data: JSON.stringify({ mail: email, code: inputCode }), // JSON 데이터 전송
                success: function (response) {
                    if (response.trim() === "success") {
                        $("#resultMessage").text("✅ 인증이 완료되었습니다!");
                    } else {
                        $("#resultMessage").text("❌ 인증번호가 일치하지 않습니다.");
                    }
                },
                error: function () {
                    alert("인증 확인 중 오류가 발생했습니다.");
                }
            });
        });
    </script>
</body>
</html>
