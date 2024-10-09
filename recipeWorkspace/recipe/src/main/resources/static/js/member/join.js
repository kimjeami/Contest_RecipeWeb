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

