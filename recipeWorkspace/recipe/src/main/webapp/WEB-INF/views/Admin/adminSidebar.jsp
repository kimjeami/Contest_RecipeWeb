<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="/css/admin/adminSidebar.css">
<div id="wrap-sidebar">
    <!-- 사이드바 -->
    <div id="wrap-sidebar-main" class="adj-sidebar-main--open">
        <!-- 메인 사이드바 -->
        <div id="head-sidebar-main">
            <!-- 메인 사이드바 헤더 -->
            <div id="wrap-ele-titleimg">
                <!-- 타이틀 이미지 위치 -->
                <img src="/img/admin_logo_upper.svg" alt="logo1" class="img-logo-upper">
                <img src="/img/admin_logo_lower.svg" alt="logo2" class="img-logo-lower">
                <img src="/img/admin_logo_small.png" alt="smllogo" class="img-logo-small">
            </div>
            <div id="wrap-ele-loginuser">
                <!-- 로그인유저 이름 위치 -->
                <h3 style="color: white; text-align: center; font-weight: 150;"><span>관리자 </span>관리자001</h3>
            </div>
        </div>
        <div id="body-sidebar-main">
            <!-- 메인 사이드바 바디 -->
            <div id="clickable-category-main" class="ele-sidebar-main">
                카테고리 <span>관리</span>
            </div>
            <div id="clickable-notion-main" class="ele-sidebar-main">
                공지사항 <span>관리</span>
            </div>
            <div id="clickable-qna-main" class="ele-sidebar-main">
                Q&A <span>관리</span>
            </div>
            <div id="clickable-faq-main" class="ele-sidebar-main">
                FAQ <span>관리</span>
            </div>
            <div id="clickable-account-main" class="ele-sidebar-main">
                계정 <span>관리</span>
            </div>
            <div id="clickable-post-main" class="ele-sidebar-main">
                게시글 <span>관리</span>
            </div>
            <div id="clickable-report-main" class="ele-sidebar-main">
                신고 <span>관리</span>
            </div>
            <div id="clickable-ad-main" class="ele-sidebar-main">
                광고 <span>관리</span>
            </div>
            <div id="clickable-stats-main" class="ele-sidebar-main">
                사이트 <span>통계</span>
            </div>
        </div>
    </div>
    <div id="wrap-sidebar-sub" class="adj-sidebar-sub--close">
        <!-- 서브 사이드바 -->
        <div id="head-sidebar-sub">
            <!-- 이건 쓸 일은 없을듯함 -->
        </div>
        <div id="body-sidebar-sub">
            <div id="innerbody-category-sub">
                <a href="#" target="_self" class="ele-sidebar-sub">
                    카테고리 조회
                </a>
                <a href="#" target="_self" class="ele-sidebar-sub">
                    카테고리 편집
                </a>
            </div>
            <div id="innerbody-notion-sub">
                <a href="#" target="_self" class="ele-sidebar-sub">
                    공지사항 조회
                </a>
                <a href="#" target="_self" class="ele-sidebar-sub">
                    공지사항 작성
                </a>
                <a href="#" target="_self" class="ele-sidebar-sub">
                    공지사항 편집
                </a>
            </div>
            <div id="innerbody-qna-sub">
                <a href="#" target="_self" class="ele-sidebar-sub">
                    Q&A 조회
                </a>
                <a href="#" target="_self" class="ele-sidebar-sub">
                    Q&A 작성
                </a>
            </div>
            <div id="innerbody-faq-sub">
                <a href="#" target="_self" class="ele-sidebar-sub">
                    FAQ 조회
                </a>
                <a href="#" target="_self" class="ele-sidebar-sub">
                    FAQ 편집
                </a>
            </div>
            <div id="innerbody-account-sub">
                <a href="#" target="_self" class="ele-sidebar-sub">
                    계정 조회
                </a>
                <a href="#" target="_self" class="ele-sidebar-sub">
                    계정 관리
                </a>
            </div>
            <div id="innerbody-post-sub">
                <a href="#" target="_self" class="ele-sidebar-sub">
                    게시글 조회
                </a>
                <a href="#" target="_self" class="ele-sidebar-sub">
                    게시글 관리
                </a>
            </div>
            <div id="innerbody-report-sub">
                <a href="#" target="_self" class="ele-sidebar-sub">
                    신고 조회
                </a>
                <a href="#" target="_self" class="ele-sidebar-sub">
                    신고 관리
                </a>
            </div>
            <div id="innerbody-ad-sub">
                <a href="#" target="_self" class="ele-sidebar-sub">
                    광고 관리
                </a>
            </div>
            <div id="innerbody-stats-sub">
                <a href="#" target="_self" class="ele-sidebar-sub">
                    통계
                </a>
            </div>
        </div>
    </div>
</div>
<script defer src="/js/admin/adminSidebar.js"></script>