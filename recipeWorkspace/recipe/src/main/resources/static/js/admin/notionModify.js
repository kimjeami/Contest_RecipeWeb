function getNo(param){
    const url = new URLSearchParams(window.location.search);
    return url.get(param);
}


$(document).ready(()=>{
    const no = getNo("no");
    if(no){
        $.ajax({
            url : '/admin/notionDetailData',
            method : 'GET',
            data : {no : no},
            success : function(detailData){
                console.log("상세 정보 통신 성공");
                console.log(detailData);

                const title = document.querySelector(".title");
                const content = document.querySelector("#notionContent");
                const enrollDate = document.querySelector(".enrollDate");

                let str1 = "";
                let str2 = "";
                let str3 = "";

                str1 += "제목 : " + detailData.title;
                title.innerHTML = str1;
                
                str2 += detailData.content;
                content.innerHTML = str2;

                str3 +=  "등록일 : "
                str3 += detailData.enrollDate;
                enrollDate.innerHTML = str3;
                
            }
        })
    }
  
    
})






function modifyBtn(){
    const title = document.querySelector(".title").value;
    const content = document.querySelector("#notionContent").value;

        const no = getNo("no");
        if(no){
            $.ajax({
                url : "/admin/notionModify",
                method : "POST",
                data : {
                    no : no,
                    title : title,
                    content : content
                },
                success : function(data){
                    alert("수정완료");
                    location.href='/admin/notionList';
                },
                error : function(x){
                    console.log("에러",x);
                    
                }
        
            });
        }

}
