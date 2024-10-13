<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="/css/layout/upperNav.css">
<div class="nav__upper">
    <div class="nav__logo-container">
      <a href="#"><img src="/img/image.png" alt="logo"></a>
    </div>
    <div class="nav__right">
        <form action="/recipe/list" method="get">
            <input type="text" class="nav__upper--search" placeholder="검색해주세요" name="keyword" id="keyword">
            <button type="submit">검색</>
        </form>
        <i>＋</i>
        <i>👤</i>
        <i>❤️</i>
    </div>
</div>