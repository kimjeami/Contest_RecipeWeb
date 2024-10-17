function getParam(param){
    const url = new URLSearchParams(location.search);
    return url.get(param);
}

$(document).ready(()=>{
    const no = getParam("no");
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