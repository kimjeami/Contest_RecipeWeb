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
   <jsp:include page="/WEB-INF/views/layout/util.jsp" />

</head>
<body>
          <div class="container">
                <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
                <main class="main">

                <h2>썸네일</h2>
                <br/><br/>
                <c:if test="${recipe.thumbnail == 'nan'}">
                   <img src="/images/sample.png" width="200px" height="200px">
              </c:if>
              <c:if test="${recipe.thumbnail != 'nan'}">
                   <img src="/images/${recipe.thumbnail}" width="200px" height="200px">
              </c:if>
<br/><br/>
                <h2>제목</h2>
                <br/><br/>
                <h3>${recipe.title }</h3>
                <br/><br/>
                <h2>레시피 소개</h2>
                 <label>${recipe.introduce}</label>
                <br/><br/>
                <h2>레시피 정보</h2>
                <br/><br/>
                <div>
                        인분: ${recipe.serving}
                        시간: ${recipe.time_taken}
                        난이도: ${recipe.step}
                </div>
                <br/><br/>
              <h2>재료 정보</h2>
                <br/><br/>
              <div>
                <c:set var="thingsNames" value="${fn:split(recipe.things_name, ',')}" />
                 <c:set var="ea" value="${fn:split(recipe.ea, ',')}" />
                 <c:set var="things_url" value="${fn:split(recipe.things_url, ',')}" />
                 <c:set var="length" value="${fn:length(thingsNames)}"/>
                 이름  수량 링크
                 <br/><br/>
                  <c:forEach var="i" begin="0" end="${length - 1}">
                      ${thingsNames[i].trim()}
                      ${ea[i].trim()}
                      <a href=${things_url[i].trim()}>${things_url[i].trim()}</a>
                       <br/><br/>
                  </c:forEach>
                </div>
                <br/><br/>
                <h2>레시피 순서</h2>
                <br/><br/>
                 <div>
                  <c:set var="explanations" value="${recipe.explanation.split(',')}"/>
                  <c:set var="imageFiles" value="${recipe.recipe_seq_img.split(',')}"/>
                  <c:set var="length" value="${fn:length(explanations)}"/>

                  <c:forEach var="i" begin="0" end="${length - 1}">
                      내용: ${explanations[i].trim()} <br>
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
                <input type="button" value="문의하기" onclick="location.href='${contextPath}/recipe/inquiryForm?recipte_no=${recipe.recipte_no}'">
                <label>리뷰</label>
                <br/><br/>
                <c:if test="${recipe.write_no == loginMemberVo.no}">
                    <input type="button" value="수정하기" onclick="location.href='${contextPath}/recipe/modifyForm?recipte_no=${recipe.recipte_no}'"> &nbsp;
                    <input type="button" value="삭제하기" onclick="location.href='${contextPath}/recipe/delete?recipte_no=${recipe.recipte_no}'"> &nbsp;
                </c:if>


                <c:import url="comment.jsp"/>

                </main>
                <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
            </div>




</body>
</html>
