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
                    <input type="hidden" id="member_no" name="member_no" value="${loginMemberVo.no}">
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
                        <button type="button" id="btn_star">별점 등록</button>
                    <div>

                    </div>
                 </div>
            </div>
        </div>
</body>
</html>