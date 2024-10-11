
$.ajax({
    url : "/admin/notionData",
    method : "get",
    data : {} ,
    success : function(x){
        console.log(x);      
        const tbodyVal = document.querySelector("#notionList");
        
        let str = "";
        
        for(let i=0;i<x.length;i++){
            str += "<tr>";
            str += "<td>" + x[i].no + "</td>";
            str += "<td>" + x[i].title + "</td>";
            str += "<td>" + x[i].hit + "</td>";
            str += "<td>" + x[i].enrollDate + "</td>";
            str += "<td>" + x[i].delYn + "</td>";
            str += "</tr>";
        }
        tbodyVal.innerHTML = str;
    },
    error : function(x){
        console.log("에러...");        
    }
});