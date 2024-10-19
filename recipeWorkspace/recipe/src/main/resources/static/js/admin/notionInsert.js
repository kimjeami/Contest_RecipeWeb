function smt(){
    const title = document.querySelector("#title").value;
    const content = document.querySelector("#notionContent").value;

    title != null ? title : alert("제목을 입력하세요");
    content != null ? content : alert("내용을 입력하세요");

    $.ajax({
        url : '/admin/notionInsert',
        method : 'POST',
        data : {
            title : title,
            content : content
        },
        success : function(x){
            alert("등록완료!");
            location.href='/admin/notionList';
        },
        error : function(x){
            alert("등록실패...");
            location.href='/admin/notionList';
        }
    });
}