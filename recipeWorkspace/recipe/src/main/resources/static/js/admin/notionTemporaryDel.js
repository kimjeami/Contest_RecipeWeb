function getNo(param){
    const url = new URLSearchParams(window.location.search);
    return url.get(param);
}

function tempDel(){
    $(document).ready( ()=> {
        const no = getNo("no");
        if(no){
            $.ajax({
                url : '/admin/notionTemporaryDelete',
                method : 'POST',
                data : {no : no},
                success : function(x){
                    alert("임시삭제 완료");
                    location.href='/admin/notionList';
                },
                error : function(x){
                    console.log(x);
                    alert("임시삭제 실패");
                    
                }
            });
        }
    });
}