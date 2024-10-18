<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="/css/layout/nav.css">
<nav class="nav">
    <div class="nav__upper">
        <div class="nav__logo-container">
          <a href="#"><img src="/img/image.png" alt="logo"></a>
        </div>
        <div class="nav__right">
            <form action="/recipe/list" method="get">
                <select name="category" class="nav__upper--category">
                    <option value="">전체</option>
                    <option value="1">요리</option>
                    <option value="2">가구</option>
                    <option value="3">컴퓨터</option>
                    <option value="4">칵테일</option>
                    <option value="5">기타</option>
                </select>
                <input type="text" class="nav__upper--search" placeholder="검색해주세요" name="keyword">
            </form>
            <a href="/recipe/write">
              <img src="/img/plus.svg" alt="write">
            </a>
            <a href="/member/mypage">
              <img src="/img/user.svg" alt="mypage">
            </a>
            <a href="/recipe/favorite">
              <img src="/img/heart-straight.svg" alt="favorite">
            </a>
        </div>
    </div>
    <div class="sub-nav">
        <a href="#" class="sub-nav__item">홈</a>
        <a href="#" class="sub-nav__item">음식</a>
        <a href="#" class="sub-nav__item">목공</a>
        <a href="#" class="sub-nav__item">팔로잉</a>
    </div>
</nav>