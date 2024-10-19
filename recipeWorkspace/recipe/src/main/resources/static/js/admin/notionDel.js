function del(no){
    $.ajax({
        url : "/admin/notionDel",
        type : "DELETE",
        data : {no : no},
        success : function(x){
            alert("삭제 완료");
            location.href='/admin/notionList';
        },
        error : function(x){
            console.log("삭제실패");
            
        }
    })
}