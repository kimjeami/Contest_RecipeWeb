
$.ajax({
    url : "/admin/notionData",
    method : "get",
    data : {} ,
    success : function(x){
        console.log(x);      
        const tbodyVal = document.querySelector("#notionList");
        
        let str = "";
        
        for(let i=0;i<x.length;i++){
            str += "<tr id='noParam' data-id='"+x[i].no+"'>";
            str += "<td>" + x[i].no + "</td>";
            str += "<td>" + x[i].title + "</td>";
            str += "<td>" + x[i].hit + "</td>";
            str += "<td>" + x[i].enrollDate + "</td>";
            str += "<td>" + x[i].delYn + "</td>";
            str += "</tr>";
        }
        tbodyVal.innerHTML = str;

        document.querySelectorAll("#noParam").forEach((tbodyVal)=>{
            tbodyVal.addEventListener("click",()=>{
                const no = tbodyVal.getAttribute("data-id");
                location.href="/admin/notionDetail?no="+no;
            });
        });
    },
    error : function(x){
        console.log("에러...");        
    }
});