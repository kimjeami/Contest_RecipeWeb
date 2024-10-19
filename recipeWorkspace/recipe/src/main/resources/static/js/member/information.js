function toggleSection(section) {
    const sections = document.querySelectorAll('.content');
    sections.forEach((sec) => {
        if (sec.id === section) {
            sec.classList.remove('hidden');
        } else {
            sec.classList.add('hidden');
        }
    });
}




function followMember(memberNo) {
    $.ajax({
        url: '/member/follow',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ no: memberNo }),
        success: function(response) {
            alert('팔로우되었습니다.');
            location.reload();
        },
        error: function(xhr, status, error) {
            console.error('팔로우 실패.. ', error);
            alert('팔로우 실패...');
        }
    });
}







function unfollowMember(memberNo) {
    $.ajax({
        url: '/member/unfollow',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ no: memberNo }),
        success: function(response) {
            alert('팔로우가 취소되었습니다.');
            location.reload();
        },
        error: function(xhr, status, error) {
            console.error('팔로우 취소 실패.. ', error);
            alert('팔로우 취소 실패...');
        }
    });
}

