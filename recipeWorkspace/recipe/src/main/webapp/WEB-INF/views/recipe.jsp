<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인홈</title>
    <link rel="stylesheet" href="/css/member/recipe.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script defer src="/js/member/recipe.js"></script>
    <jsp:include page="/WEB-INF/views/layout/util.jsp" />
</head>


<body>
    <div class="container">
        <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
        <main class="main">
             <div class="ad-slider-container">
                 <div class="ad-slider">
                     <div class="ad-slide">
                         <a href="https://www.naver.com" class="edA"><img src="/img/upEd/upEd1.png" alt="Ad 1"></a>
                     </div>
                     <div class="ad-slide">
                         <a href="https://www.google.com" class="edA"><img src="/img/upEd/upEd2.png" alt="Ad 2"></a>
                     </div>
                     <div class="ad-slide">
                         <a href="https://www.daum.com" class="edA"><img src="/img/upEd/upEd3.png" alt="Ad 3"></a>
                     </div>
                 </div>
                 <button class="prev">◀</button>
                 <button class="next">▶</button>
             </div>
             <br><hr><br>
             <h3 class="section-title">최신순</h3>
             <div class="recipe_list">
                 <c:forEach var="recipe" items="${recipeList}">
                     <div class="recipe-item"  onclick="location.href='/recipe/detail?recipte_no=${recipe.recipteNo}'">
                         <img src="/images/${recipe.thumbnail}" alt="${recipe.title}">
                         <div class="recipe-info">
                             <h4>${recipe.title}</h4>
                             <p>작성자: ${recipe.writeName}</p>
                             <div class="stars">
                                 <c:forEach begin="1" end="5" var="star">
                                     <i class="<c:if test='${star <= recipe.averageScope}'>fas fa-star</c:if><c:if test='${star > recipe.averageScope}'>far fa-star</c:if>"></i>
                                 </c:forEach>
                             </div>
                         </div>
                     </div>
                 </c:forEach>
             </div>

            <br><hr><br>
             <h3 class="section-title">인기순</h3>
             <div class="recipe_list">
                 <c:forEach var="recipe" items="${recipeListHit}">
                     <div class="recipe-item" onclick="location.href='/recipe/detail?recipte_no=${recipe.recipteNo}'">
                         <img src="/images/${recipe.thumbnail}" alt="${recipe.title}">
                         <div class="recipe-info">
                             <h4>${recipe.title}</h4>
                             <p>작성자: ${recipe.writeName}</p>
                             <div class="stars">
                                 <c:forEach begin="1" end="5" var="star">
                                     <i class="<c:if test='${star <= recipe.averageScope}'>fas fa-star</c:if><c:if test='${star > recipe.averageScope}'>far fa-star</c:if>"></i>
                                 </c:forEach>
                             </div>
                         </div>
                     </div>
                 </c:forEach>
             </div>
        </main>
        <aside class="sidebar">
            <div class="ad">
                <a href="https://www.example1.com"><img src="/img/sideEd/re_1.png" alt="Ad 1"></a>
            </div>
            <div class="ad">
                <a href="https://www.example2.com"><img src="/img/sideEd/re_2.png" alt="Ad 2"></a>
            </div>
            <div class="ad">
                <a href="https://www.example3.com"><img src="/img/sideEd/re_3.png" alt="Ad 3"></a>
            </div>
        </aside>
        <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
    </div>
</body>
</html>
