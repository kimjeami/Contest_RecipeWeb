<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>
    <link rel="stylesheet" href="/css/member/information.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <jsp:include page="/WEB-INF/views/layout/util.jsp" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script defer src="/js/member/information.js"></script>
</head>
<body>
    <div class="container">
        <jsp:include page="/WEB-INF/views/layout/nav-back.jsp" />
        <main class="main main-settings">
            <div class="profile">
                <div class="profile-header">
                    <img src="/img/profile/${loginMemberVo.profile}" alt="Profile Image" class="profile-image" />
                    <div class="profile-info">
                        <h2 class="profile-nickname">${loginMemberVo.nick}</h2>
                        <p class="profile-id">${loginMemberVo.id}</p>
                        <p class="profile-email">${loginMemberVo.email}</p>
                    </div>
                </div>
                <div class="profile-stats">
                    <div class="stat" onclick="toggleSection('posts')">
                        <span class="stat-value">${userCountVo.recipeCount}</span>
                        <span class="stat-label">게시물</span>
                    </div>
                    <div class="stat" onclick="toggleSection('followers')">
                        <span class="stat-value">${userCountVo.followerCount}</span>
                        <span class="stat-label">팔로워</span>
                    </div>
                    <div class="stat" onclick="toggleSection('following')">
                        <span class="stat-value">${userCountVo.followingCount}</span>
                        <span class="stat-label">팔로잉</span>
                    </div>
                </div>
                <div id="content-section">
                    <div id="posts" class="content">
                        <div class="recipe_list">
                             <c:forEach var="recipe" items="${myRecipeList}">
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
                    </div>
                    <div id="followers" class="content hidden">
                       <div class="follower-list">
                           <c:forEach var="memberFollower" items="${memberFollowerList}">
                               <div class="follower-item" onclick="location.href='/member/opponent?member_no=${memberFollower.no}'">
                                   <img src="/img/profile/${memberFollower.profile}" alt="${memberFollower.nick}" class="follower-image">
                                   <div class="follower-info">
                                       <h4>${memberFollower.nick}</h4>
                                       <p>ID: ${memberFollower.id}</p>
                                       <p>Email: ${memberFollower.email}</p>
                                   </div>
                                   <c:set var="isFollowing" value="false" />
                                   <c:forEach var="followingMember" items="${memberFollowingList}">
                                       <c:if test="${followingMember.no == memberFollower.no}">
                                           <c:set var="isFollowing" value="true" />
                                       </c:if>
                                   </c:forEach>
                                   <c:if test="${not isFollowing}">
                                       <button class="follow-button" onclick="followMember('${memberFollower.no}'); event.stopPropagation();">팔로우 하기</button>
                                   </c:if>
                               </div>
                           </c:forEach>
                       </div>
                    </div>
                    <div id="following" class="content hidden">
                        <div class="follower-list">
                            <c:forEach var="memberFollowing" items="${memberFollowingList}">
                                <div class="follower-item" onclick="location.href='/member/opponent?no=${memberFollowing.no}'">
                                    <img src="/img/profile/${memberFollowing.profile}" alt="${memberFollowing.nick}" class="follower-image">
                                    <div class="follower-info">
                                        <h4>${memberFollowing.nick}</h4>
                                        <p>ID: ${memberFollowing.id}</p>
                                        <p>Email: ${memberFollowing.email}</p>
                                    </div>
                                    <button class="follow-button" onclick="unfollowMember('${memberFollowing.no}'); event.stopPropagation();">팔로우 취소하기</button>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
    </div>
</body>
</html>
