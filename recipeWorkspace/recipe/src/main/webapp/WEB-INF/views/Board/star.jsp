<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/board/star.css">
<title></title>
</head>
<body>
  <div>
            <div class="mb-3 mt-3">
                 <div class="mb-3" name="myform" id="myform" >
                    <input type="hidden" id="recipte_no" name="recipte_no" value="${recipe.recipte_no}">
                    <input type="hidden" id="member_reply_no" name="member_reply_no" value="${loginMemberVo.no}">
                    <fieldset>
                    		<span class="text-bold">별점을 선택해주세요</span>
                    		<input type="radio" name="reviewStar" value="5" id="rate1" checked><label
                    			for="rate1">★</label>
                    		<input type="radio" name="reviewStar" value="4" id="rate2"><label
                    			for="rate2">★</label>
                    		<input type="radio" name="reviewStar" value="3" id="rate3"><label
                    			for="rate3">★</label>
                    		<input type="radio" name="reviewStar" value="2" id="rate4"><label
                    			for="rate4">★</label>
                    		<input type="radio" name="reviewStar" value="1" id="rate5"><label
                    			for="rate5">★</label>
                    	</fieldset>
                    <div>
                    <button type="button" id="btn_comment">등록</button>
                  </div>

                 </div>

                <table class="table table-hover" id="cmt_table">
                    <thead>
                    <tr>
                        <th>작성자</th>
                        <th>내용</th>
                        <th>작성일</th>
                        <th>별점</th>
                    </tr>
                    </thead>
                    <tbody id="comment_list">
                    </tbody>

                </table>
            </div>
        </div>
</body>
</html>