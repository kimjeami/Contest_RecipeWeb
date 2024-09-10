<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성 페이지 입니다.</title>
<script src="/js/board/write.js"></script>
</head>
<body>
    <h2>레시피 등록</h2>

    <form th:action="@{/board/write}" method="post" enctype="multipart/form-data">
        레시피 제목 <input type="text" id="title" name="title">
        <br/><br/>
        <input type="file" id="thumbnal" name="thumbnal"/>
        썸네일
        <br/><br/>
        요리 소개
        <textarea rows="5" placeholder="내용을 입력하세요" name="introduce" id="introduce"></textarea>
        <br/>

        <div style="flex: 1; margin-left: 20px;">
            <label class="input">카테고리:</label><br>
            <select id="recipe_cate_no" name="recipe_cate_no">
                  <option value="">카테고리 선택</option>
                  <option value="1">요리</option>
                  <option value="2">가구</option>
                  <option value="3">컴퓨터</option>
                  <option value="4">칵테일</option>
                  <option value="5">기타</option>
            </select>
        </div>
        <br/>

        요리정보
        <label>인분<input type="text" id="serving" name="serving"/></label>
        <label>시간<input type="text" id="time_taken" name="time_taken"/></label>
        <label>난이도<input type="text" id="step" name="step"/></label>
        <br/><br/>

        재료 정보
        <br/><br/>
        이름 수량 링크
        <br/><br/>
        <div id="things_container">
            <label><input type="text" name="things_name[]" id="things_name[]"/></label>
            <label><input type="text" name="ea[]" id="ea[]"/></label>
            <label><input type="text" name="things_url[]" id="things_url[]"/></label>
        </div>
        <br/><br/>

        <div class="btn_add" style="padding:0 0 20px 350px; width:800px;">
            <button type="button" onclick="addThings()">
                <span class="glyphicon glyphicon-plus-sign"></span> 추가
            </button>
        </div>

        요리 순서
        <div id="recipe-container">
            <textarea rows="5" placeholder="내용을 입력하세요" name="explanation[]" id="explanation"></textarea>
            <input type="file" name="recipe_seq_img[]" id="recipe_seq_img[]"/>
        </div>
        <br/><br/>

        <div class="btn_add2" style="padding:0 0 20px 350px; width:800px;">
            <button type="button" onclick="addRecipe()">
                <span class="glyphicon glyphicon-plus-sign"></span> 추가
            </button>
        </div>

        요리 팁
        <textarea rows="5" placeholder="내용을 입력하세요" name="tip" id="tip"></textarea>
        <br/><br/>

        <button type="submit">레시피 등록</button>&nbsp&nbsp<button type="reset">취소</button>
    </form>
</body>
</html>
