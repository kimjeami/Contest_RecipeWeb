function smt(){

    const idVal = document.querySelector("#adminId").value;
    const pwdVal = document.querySelector("#adminPwd").value;
    $.ajax({
        url : "/admin/login",
        method : "post",
        data : {adminId : idVal,
                adminPwd : pwdVal
        },
        success : function(x){
            alert("로그인 완료!");
            console.log(x);
            location.href='/admin/home';         
        },
        error : function(x){
            console.log("에러");
            
        }

    });
}
