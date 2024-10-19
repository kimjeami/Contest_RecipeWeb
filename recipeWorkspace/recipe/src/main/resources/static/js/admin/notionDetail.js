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
                const mBtn = document.querySelector("#modifyButton")

                let str1 = "";
                let str2 = "";
                let str3 = "";
                let str4 = "";

                str1 += "제목 : " + detailData.title;
                title.innerHTML = str1;
                
                str2 += detailData.content;
                content.innerHTML = str2;

                str3 +=  "등록일 : "
                str3 += detailData.enrollDate;
                enrollDate.innerHTML = str3;

                str4 += "<button id='mBtn' data-id='"+detailData.no+"'>" + "수정하기";
                str4 += "</button>";
                mBtn.innerHTML = str4;


                document.querySelectorAll("#mBtn").forEach((mBtn)=>{
                    mBtn.addEventListener("click",()=>{
                        const dataNo = mBtn.getAttribute("data-id");
                        location.href="/admin/notionModify?no="+dataNo;
                    });
                });
                
            }
        })
    }
})