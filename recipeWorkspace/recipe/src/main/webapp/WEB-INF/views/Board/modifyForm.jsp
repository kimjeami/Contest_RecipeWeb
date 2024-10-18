<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 페이지 입니다..</title>
<script src="/js/board/modifyForm.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="crossorigin="anonymous"></script>
<script type="text/javascript">
	function readURL(input, previewId) {
		var file = input.files[0];
		if(file != null) {
			var reader = new FileReader();
			reader.readAsDataURL(file); // 파일 정보 읽어오기
			reader.onload = function(e) { // 읽기에 성공하면 결과 표시
				$("#" + previewId).attr("src", e.target.result); // src 속성을 파일의 URL로 설정
			}
		}
	}
</script>

<link rel="stylesheet" href="/css/board/boardWrite.css">
<jsp:include page="/WEB-INF/views/layout/util.jsp" />

</head>
<body>
      <div class="container">
           <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
           <main class="main">
              <div id="write_main">
                 <h2 id="recipe_submit">레시피 수정</h2>
                 <form action="${contextPath }/recipe/modify"  method="post" enctype="multipart/form-data" id="modifyForm", name="modifyForm">
                     <input type="hidden" id="recipte_no" name="recipte_no" value="${recipe.recipte_no}">
                     <input type="hidden" id="write_no" name="write_no" value="${loginMemberVo.no}">
                     레시피 제목 <input type="text" id="title" name="title" value="${recipe.title}">
                     <br/><br/>
                   <div id="thumbnal_css">
                      <input type="file" id="thumbnal" name="thumbnal" onchange="readURL(this, 'preview')"/>
                     <img src="/images/${recipe.thumbnail}" id="preview" width="200px" height="200px" alt="선택된 이미지가 없습니다." data-default="/images/${recipe.thumbnail}">



                     <br/><br/>
                     썸네일
                    </div>
                     <br/><br/>
                     <div id="introduce_css">
                     <label id="recipe_introduce" name="recipe_introduce">레시피 소개</label>
                         <textarea rows="5" placeholder="내용을 입력하세요" name="introduce" id="introduce">${recipe.introduce}</textarea>
                     </div>
                     <br/>
                     <div style="flex: 1; margin-left: 20px;">
                         <label class="input">카테고리</label>
                         <select id="recipe_cate_no" name="recipe_cate_no">
                               <option value="">카테고리 선택</option>
                               <option selected="${recipe.recipe_cate_no == 1}" value="1">요리</option>
                               <option selected="${recipe.recipe_cate_no == 2}" value="2">가구</option>
                               <option selected="${recipe.recipe_cate_no == 3}" value="3">컴퓨터</option>
                               <option selected="${recipe.recipe_cate_no == 4}" value="4">칵테일</option>
                               <option selected="${recipe.recipe_cate_no == 5}" value="5">기타</option>
                         </select>
                     </div>
                     <br/>

                     레시피 정보
                     <label>인분<input type="text" id="serving" name="serving" value="${recipe.serving}"/></label>
                     <label>시간<input type="text" id="time_taken" name="time_taken" value="${recipe.time_taken}"/></label>
                     <label>난이도<input type="text" id="step" name="step" value="${recipe.step}"/></label>
                     <br/><br/>

                     재료들
                     <br/><br/>
                     <div id="things_css">

                     이름 &emsp; &emsp; &emsp; &emsp; &emsp; &emsp;&nbsp;&nbsp; 수량 &emsp; &emsp; &emsp; &emsp; &emsp; &emsp;&nbsp;&nbsp;링크

                     <br/><br/>
                       <div id="things_container">
                           <c:set var="thingsNames" value="${fn:split(recipe.things_name, '-')}" />
                           <c:set var="ea" value="${fn:split(recipe.ea, '-')}" />
                           <c:set var="things_url" value="${fn:split(recipe.things_url, '-')}" />
                           <c:set var="length" value="${fn:length(thingsNames)}"/>

                          <c:forEach var="i" begin="0" end="${length - 1}">
                               <label><input type="text" name="things_name[]" id="things_name[]" value="${thingsNames[i].trim()}"/></label>
                               <label><input type="text" name="ea[]" id="ea[]" value="${ea[i].trim()}"/></label>
                               <label><input type="text" name="things_url[]" id="things_url[]" value="${things_url[i].trim()}"/></label>
                                <br/>
                           </c:forEach>
                       </div>
                     <br/><br/>

                     <div class="btn_add" style="padding:0 0 20px 350px; width:800px;">
                         <button type="button" onclick="addThings()">
                             <span class="glyphicon glyphicon-plus-sign" id="add"></span> 추가
                         </button>
                     </div>

                     레시피 순서
                    <div id="recipe-container">
                        <c:set var="explanations" value="${recipe.explanation.split('-')}"/>
                        <c:set var="imageFiles" value="${recipe.recipe_seq_img.split('-')}"/>

                        <c:set var="length" value="${fn:length(explanations)}"/>

                    <c:forEach var="i" begin="0" end="${length - 1}">
                        <textarea rows="5" name="explanation[]" id="explanation">${explanations[i].trim()}</textarea>
                        <input type="file" name="recipe_seq_img[]" id="recipe_seq_img[]" onchange="readURL(this, 'preview_${i}')"/>
                        <img src="/images/${imageFiles[i].trim()}" id="preview_${i}" width="200px" height="200px" data-default="/images/${imageFiles[i].trim()}"><br>
                        <br/><br/>
                    </c:forEach>

                    </div>
                     <br/><br/>

                     <div class="btn_add2" style="padding:0 0 20px 350px; width:800px;">
                         <button type="button" onclick="addRecipe()">
                             <span class="glyphicon glyphicon-plus-sign"></span> 추가
                         </button>
                     </div>

                     레시피 팁
                     <textarea rows="5" placeholder="내용을 입력하세요" name="tip" id="tip">${recipe.tip}</textarea>
                     <br/><br/>

                     <div id="submit_css">
                         <button type="button" onclick="RecipeCheck()">레시피 수정하기</button>
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
