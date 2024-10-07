<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/board/comment.css">
<title></title>
</head>
<body>
  <div>
            <div class="mb-3 mt-3">
                <label>댓글: <span id="cmt_cnt"></span> 개</label>

                 <div class="input-group my-2">
                    <input type="hidden" id="recipte_no" name="recipte_no" value="${recipe.recipte_no}">
                    <input type="text" id="input_comment" placeholder="댓글을 남겨보세요">
                    <button type="button" id="btn_comment">등록</button>
                 </div>

                <table class="table table-hover" id="cmt_table">
                    <thead>
                    <tr>
                        <th>작성자</th>
                        <th>내용</th>
                        <th>작성일</th>
                    </tr>
                    </thead>
                    <tbody id="comment_list">
                    </tbody>

                </table>
            </div>
        </div>
</body>
</html>