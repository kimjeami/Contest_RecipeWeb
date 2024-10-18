<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상세 페이지입니다.</title>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="/js/board/detail.js"></script>
  <script type="text/javascript">
      const recipeData = [[${recipe}]];
  </script>
 <link rel="stylesheet" href="/css/board/detail.css">
   <jsp:include page="/WEB-INF/views/layout/util.jsp" />

</head>
<body>
          <div class="container">
                <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
                <main class="main">
           <div class="things_url_css">
                <h2>썸네일</h2>
                <br/><br/>

              <c:if test="${recipe.thumbnail == 'nan'}">
                   <img src="/images/sample.png" width="400px" height="400px">
              </c:if>
              <c:if test="${recipe.thumbnail != 'nan'}">
                   <img src="/images/${recipe.thumbnail}" width="400px" height="400px">
              </c:if>
            </div>
<br/><br/>

             <div class="center_css">
                <h2>레시피 제목</h2>
                <br/><br/>
                <label>${recipe.title }</label>
                <br/><br/>
                <h2>레시피 소개</h2>
                <br/><br/>
                <label>${recipe.introduce}</label>
                <br/><br/>
               </div>

                <div class="recipe_information">
                <h2>레시피 정보</h2>
                     <br/>
                     <div class="recipe_information_font">
                             ${recipe.serving}인분
                             ${recipe.time_taken}시간
                             ${recipe.step}
                     </div>

                </div>
                <br/><br/>
              <div class="ingredient_information">
              <h2>재료 정보</h2>
                <br/><br/>

                <c:set var="thingsNames" value="${fn:split(recipe.things_name, '-')}" />
                 <c:set var="ea" value="${fn:split(recipe.ea, '-')}" />
                 <c:set var="things_url" value="${fn:split(recipe.things_url, '-')}" />
                 <c:set var="length" value="${fn:length(thingsNames)}"/>

                 <table border="1">
                 <tr>
                     <td>이름</td>
                     <td>수량</td>
                     <td>링크</td>
                 </tr>
                  <c:forEach var="i" begin="0" end="${length - 1}">
                    <tr>
                      <td>${thingsNames[i].trim()}</td>
                      <td>${ea[i].trim()}</td>
                      <td><a href=${things_url[i].trim()}>구매</a></td>
                    </tr>
                  </c:forEach>
                  </table>
                </div>
                <br/><br/>

                <h2>레시피 순서</h2>
                <br/><br/>
                 <div class="recipe_steps">
                  <c:set var="explanations" value="${recipe.explanation.split('-')}"/>
                  <c:set var="imageFiles" value="${recipe.recipe_seq_img.split('-')}"/>
                  <c:set var="length" value="${fn:length(explanations)}"/>

                  <c:forEach var="i" begin="0" end="${length - 1}">
                      ${i+1}.
                      ${explanations[i].trim()} <br/>
                      <c:if test="${ imageFiles[i].trim() == null}">
                             <img src="/images/sample.png" width="200px" height="200px"><br/>
                      </c:if>
                      <c:if test="${imageFiles[i].trim() != null}">
                         <img src="/images/${imageFiles[i].trim()}" width="200px" height="200px"><br/>
                      </c:if>

                  </c:forEach>

                 </div>
                <br/><br/>
                <h2>레시피 팁</h2>
                <br/><br/>
                 <div>
                    ${recipe.tip}
                </div>
                <br/><br/>
                <label>레시피 작성자</label>
                ${recipe.write_name}
                <br/><br/>
                <input type="button" value="레시피 문의하기" onclick="location.href='${contextPath}/recipe/inquiryForm?recipte_no=${recipe.recipte_no}'">
                <br/><br/>
                <div class="submit_css">
                <c:if test="${recipe.write_no == loginMemberVo.no}">
                    <button type="button" class="submit-btn"  onclick="location.href='${contextPath}/recipe/modifyForm?recipte_no=${recipe.recipte_no}'">수정하기</button>&nbsp;
                    <button type="button" class="submit-btn"  onclick="location.href='${contextPath}/recipe/delete?recipte_no=${recipe.recipte_no}'">삭제하기</button> &nbsp;
                </c:if>
                </div>
                <br/><br/>
                <label>리뷰</label>
                <c:import url="comment.jsp"/>

                </main>
                <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
            </div>




</body>
</html>
