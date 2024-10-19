
function grantBtn(){
    const grantVal = document.querySelector("#grantVal").value;
    $.ajax({
        url : "/admin/rankData",
        method : 'get',
        data : {adminNo : grantVal},
        success : function(x){
            console.log("세션 값 가져옴~~~");        
            console.log(x);
            location.href='/admin/sessionHome';
            
        },
        error : function(x){
            console.log("세션 값 가져오기 실패");
            
        }
    });
}