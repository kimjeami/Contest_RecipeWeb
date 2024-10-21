const title = document.querySelector("#divTitle");

function click(value){
    $.ajax({
        url : 'faq/home',
        method : 'get',
        data : {no : value},
        success : function(x){
            console.log("값 전달 성공~~");
            console.log(x);

            str = "";
            str += "<h1>" + x.title + "</h1>";

            title.innerHTML = str;

        },
        error : function(x){
            console.log("에러~~");
            
        },
    });
}