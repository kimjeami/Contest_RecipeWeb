let verificationCode = "";
let timer;

$("#sendMailBtn").click(function () {
    let email = $("#email").val().trim();
    if (email === "") {
        alert("이메일을 입력하세요.");
        return;
    }

    $.ajax({
        url: "/mail/send",
        type: "POST",
        contentType: 'application/json',
        data: JSON.stringify({ mail: email }),
        success: function (response) {
            $("#verifySection").show();
            $("#sendMailBtn").hide();

            let timeLeft = 300;
            $("#resultMessage").text(`남은 시간: ${timeLeft}초`);

            if (timer) {
                clearInterval(timer);
            }

            timer = setInterval(function () {
                timeLeft--;
                $("#resultMessage").text(`남은 시간: ${timeLeft}초`);

                if (timeLeft <= 0) {
                    clearInterval(timer);
                    $("#resultMessage").text("인증 시간이 만료되었습니다. 다시 요청해주세요.");
                }
            }, 1000);
            alert(response);
        },
        error: function () {

            alert("이메일 전송 중 오류가 발생했습니다.");
        }
    });
});

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
        contentType: 'application/json',
        data: JSON.stringify({ mail: email, code: inputCode }),
        success: function (response) {
            if (response.trim() === "success") {
                clearInterval(timer);
                $("#resultMessage").text("인증이 완료되었습니다!");
            } else {
                $("#resultMessage").text("인증번호가 일치하지 않습니다.");
            }
        },
        error: function () {
            alert("인증 확인 중 오류가 발생했습니다.");
        }
    });
});