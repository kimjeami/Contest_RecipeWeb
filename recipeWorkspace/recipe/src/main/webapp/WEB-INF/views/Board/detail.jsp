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

</head>
<body>

                <h2>썸네일</h2>
                <br/><br/>
                 <c:if test="${recipe.thumbnail == 'nan'}">
                    <b>이미지가 없습니다..</b>
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
                 이름  수량 링크
                 <br/><br/>
                <c:forEach var="thing" items="${thingsNames}">
                    <c:set var="details" value="${fn:split(thing, '-')}" />
                    <c:forEach var="detail" items="${details}">
                        ${detail.trim()}
                    </c:forEach>
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
                      <img src="/images/${imageFiles[i].trim()}" width="200px" height="200px"><br>
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
                <br/><br/>
                <label>레시피 문의하기</label>
                <label>리뷰</label>
                <c:import url="comment.jsp"/>



</body>
</html>
