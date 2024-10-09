<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성 페이지 입니다.</title>
<script src="/js/board/write.js"></script>
<link rel="stylesheet" href="/css/board/boardWrite.css">
<jsp:include page="/WEB-INF/views/layout/util.jsp" />
</head>
<body>
      <div class="container">
           <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
           <main class="main">
              <div id="write_main">
                 <h2 id="recipe_submit">레시피 등록</h2>
                 <form th:action="@{/recipe/write}" method="post" enctype="multipart/form-data" id="boardWriteForm", name="boardWriteForm">
                     <input type="hidden" id="write_no" name="write_no" value="${loginMemberVo.no}">
                     레시피 제목 <input type="text" id="title" name="title">
                     <br/><br/>
                   <div id="thumbnal_css">
                     <input type="file" id="thumbnal" name="thumbnal"/>
                       <br/><br/>
                     썸네일
                    </div>
                     <br/><br/>
                     <div id="introduce_css">
                     <label id="recipe_introduce" name="recipe_introduce">레시피 소개</label>
                         <textarea rows="5" placeholder="내용을 입력하세요" name="introduce" id="introduce"></textarea>
                     </div>
                     <br/>
                     <div style="flex: 1; margin-left: 20px;">
                         <label class="input">카테고리</label>
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

                     레시피 정보
                     <label>인분<input type="text" id="serving" name="serving"/></label>
                     <label>시간<input type="text" id="time_taken" name="time_taken"/></label>
                     <label>난이도<input type="text" id="step" name="step"/></label>
                     <br/><br/>

                     재료들
                     <br/><br/>
                     <div id="things_css">

                     이름 &emsp; &emsp; &emsp; &emsp; &emsp; &emsp;&nbsp;&nbsp; 수량 &emsp; &emsp; &emsp; &emsp; &emsp; &emsp;&nbsp;&nbsp;링크

                     <br/><br/>
                         <div id="things_container">
                             <label><input type="text" name="things_name[]" id="things_name[]"/></label>
                             <label><input type="text" name="ea[]" id="ea[]"/></label>
                             <label><input type="text" name="things_url[]" id="things_url[]"/></label>
                         </div>
                     </div>
                     <br/><br/>

                     <div class="btn_add" style="padding:0 0 20px 350px; width:800px;">
                         <button type="button" onclick="addThings()">
                             <span class="glyphicon glyphicon-plus-sign" id="add"></span> 추가
                         </button>
                     </div>

                     레시피 순서
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

                     레시피 팁
                     <textarea rows="5" placeholder="내용을 입력하세요" name="tip" id="tip"></textarea>
                     <br/><br/>

                     <div id="submit_css">
                         <button type="button" onclick="RecipeCheck()">레시피 등록</button>
                         &emsp; &emsp;&emsp; &emsp;
                         <button type="reset">취소</button>
                     </div>
                 </form>
                </div>
           </main>
           <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
       </div>

</body>
</html>
