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




let isIdChecked = false;
let isPasswordConfirmed = false;

document.getElementById('checkIdBtn').addEventListener('click', function() {
    const id = document.getElementById('id').value;

    $.ajax({
        url: '/member/checkId',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ id: id }),
        success: function(response) {
            if (response.isAvailable) {
                alert('사용 가능한 아이디입니다.');
                isIdChecked = true;
            } else {
                alert('사용 중인 아이디 입니다.');
                isIdChecked = false;
            }
        },
        error: function() {
            alert('아이디 중복 체크 실패...');
        }
    });
});

document.getElementById('checkPwdBtn').addEventListener('click', function() {
    const pwd = document.getElementById('pwd').value;
    const confirmPwd = document.getElementById('confirmPwd').value;

    if (pwd === confirmPwd) {
        alert('비밀번호가 일치합니다.');
        isPasswordConfirmed = true;
    } else {
        alert('비밀번호가 일치하지 않습니다.');
        isPasswordConfirmed = false;
    }
});


document.querySelector('.form__join').addEventListener('submit', function(event) {
    if (!isIdChecked) {
        alert('아이디 중복 체크를 해주세요.');
        event.preventDefault();
    }
    if (!isPasswordConfirmed) {
        alert('비밀번호를 확인해주세요.');
        event.preventDefault();
    }
});
