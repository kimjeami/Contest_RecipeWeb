$.ajax({
    url : '/rank/data',
    method : 'GET',
    data : {},
    sucess : function(x){
        console.log(x);
    },
    error : function(x){
        console.log('에러');
    }
})