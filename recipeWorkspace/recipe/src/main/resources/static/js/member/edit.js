const changePasswordBtn = document.getElementById("changePasswordBtn");
const modal = document.getElementById("passwordModal");
const closeModal = document.querySelector(".close");

changePasswordBtn.onclick = function () {
    modal.style.display = "block";
}

closeModal.onclick = function () {
    modal.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

document.getElementById("changePasswordForm").addEventListener("submit", function(event) {
    event.preventDefault();
    const newPwd = document.getElementById("newPwd").value;
    const confirmNewPwd = document.getElementById("confirmNewPwd").value;

    console.log(newPwd);
    console.log(confirmNewPwd);

    if (newPwd === confirmNewPwd) {
        $.ajax({
            url: '/member/changePassword',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                currentPwd: document.getElementById("currentPwd").value,
                newPwd: newPwd
            }),
            success: function(response) {
                if (response.success) {
                    alert('비밀번호가 변경되었습니다.');
                    $.ajax({
                        url: '/member/logout',
                        type: 'GET',
                        success: function(response) {
                            location.reload();
                        },
                        error: function() {
                            alert('로그아웃 실패.');
                        }
                    });
                    modal.style.display = "none";
                } else {
                    alert('비밀번호 변경 실패: ' + response.message);
                }
            },
            error: function() {
                alert('비밀번호 변경 요청 실패.');
            }
        });
    } else {
        alert('비밀번호가 일치하지 않습니다.');
    }
});



const postcode = document.querySelector("#postcode");
const address = document.querySelector("#address");
const address2 = document.querySelector("#address2");
const extraAddress = document.querySelector("#extraAddress");

function execDaumPostcode() {
  new daum.Postcode({
    oncomplete: function (data) {
      var addr = "";
      var extraAddr = "";

      if (data.userSelectedType === "R") {
        addr = data.roadAddress;
      } else {
        addr = data.jibunAddress;
      }

      if (data.userSelectedType === "R") {
        if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
          extraAddr += data.bname;
        }
        if (data.buildingName !== "" && data.apartment === "Y") {
          extraAddr +=
            extraAddr !== "" ? ", " + data.buildingName : data.buildingName;
        }
        if (extraAddr !== "") {
          extraAddr = " (" + extraAddr + ")";
        }
        extraAddress.value = extraAddr.trim();
      } else {
        extraAddress.value = "";
      }

      postcode.value = data.zonecode;
      address.value = addr;
      address2.focus();
    },
  }).open();
}