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
                 <div class="mb-3" name="myform" id="myform" >
                    <input type="hidden" id="recipte_no" name="recipte_no" value="${recipe.recipte_no}">
                    <input type="hidden" id="member_reply_no" name="member_reply_no" value="${loginMemberVo.no}">
                    <input type="hidden" id="member_name" name="member_name" value="${loginMemberVo.nick}">
                    <div>
                    <textarea class="col-auto form-control" type="text" id="input_comment"
                    				  placeholder="댓글을 남겨주세요"></textarea>
                    <button type="button" id="btn_comment">등록</button>
                  </div>

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