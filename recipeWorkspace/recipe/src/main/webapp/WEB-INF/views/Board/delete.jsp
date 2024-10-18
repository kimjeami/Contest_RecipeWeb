<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>삭제 결과</title>
    <script>
        window.onload = function() {
            const result = <%= request.getAttribute("result") %>;

            if (result > 0) {
                alert("삭제 성공");
                window.location.href = "list";  // 삭제 후 목록 페이지로 이동
            } else {
                alert("삭제 실패");
                history.back();  // 실패 시 이전 페이지로 돌아감
            }
        };
    </script>
</head>
<body>
</body>
</html>
