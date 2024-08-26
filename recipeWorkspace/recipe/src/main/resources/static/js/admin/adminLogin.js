function login(){

    const idVal = document.querySelector("#adminId").value;
    const pwdVal = document.querySelector("#adminPwd").value;
    $.ajax({
        url : '/admin/login',
        method : "post",
        data : {id : idVal,
                pwd : pwdVal
        },
        success : function(x){
            alert("로그인 완료!");
            console.log(x);
            
        },
        error : function(x){
            console.log("에러");
            
        }

    });
}
