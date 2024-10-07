

$(document).ready(function() {

     // 현재 글의 id
     const recipte_no = $("input[name='recipte_no']").val().trim();
     loadComment(recipte_no);


    $('#btn_comment').click(function() {

        const answer = $('#input_comment').val();
        const member_name = $('#member_name').val();
        const scope = $('input[name="reviewStar"]:checked').val();


        if (answer.trim() === '') {
            alert('댓글 내용을 입력하세요.');
            return;
        }

        $.ajax({
            type: 'POST',
            url: '/comment/write',
            data: {
                recipte_no: recipte_no,
                answer: answer,
                member_name: member_name,
                scope: scope
            },
            success: function(response) {
                // 댓글 등록 후 UI 업데이트
                $('#input_comment').val(''); // 입력 필드 초기화
                loadComment(recipte_no); // 댓글 목록 다시 불러오기
            },
            error: function(xhr, status, error) {
                alert('댓글 등록에 실패했습니다: ' + error);
            }
        });
    });
});


// 특정 글의 댓글 목록 불러오기
function loadComment(recipte_no) {
    $.ajax({
        url: "/comment/list?recipte_no=" + recipte_no,
        type: "GET",
        dataType: "json", // JSON 데이터 형식으로 응답받음
        cache: false,
        success: function(data, status) {
            if (status == "success") {
                buildComment(data); // 서버에서 받은 댓글 데이터를 화면에 출력
            }
        },
        error: function(xhr, status, error) {
            alert('댓글을 불러오는데 실패했습니다: ' + error);
        }
    });
}

// 댓글들 보여주기
function buildComment(comments) {
    const commentList = $('#comment_list');
    commentList.empty();

    comments.forEach(function(recipte_comment) {
        // write_date를 Date 객체로 변환하고 원하는 형식으로 포맷
        const writeDate = new Date(recipte_comment.write_date);
        const formattedDate = writeDate.toLocaleDateString('ko-KR'); // 'ko-KR'은 한국 형식으로 출력

        const row = `
          <tr>
              <td>${recipte_comment.member_name}</td>
              <td>${recipte_comment.answer}</td>
              <td>${formattedDate}</td>
              <td>${recipte_comment.scope}</td>
          </tr>
        `;
        commentList.append(row); // 댓글 목록에 새로운 행 추가
    });
}



