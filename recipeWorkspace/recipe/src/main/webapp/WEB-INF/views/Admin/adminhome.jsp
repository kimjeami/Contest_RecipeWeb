<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>adminHome</title>
    <style>
        /* 할일 */
        /*
            width, height 등 공유하는 속성값용 클래스 따로 뽑기
                나중에 폭 변경이라도 해야되면 잦댐
            메인/서브 사이드바 스크롤바 디자인 만지기
                지금꺼는 끔찍함
            사이드바 애니메이션
                ㅇㅇ
            jsp 적용
                ㅅㅂ 나중에

            전체적인 디자인 수정
                ㅇㅇㅇㅇㅇㅇ
        */
        /* 
            링크 관련
            일단 아래처럼 해둠
            /admin/home     여기 - 관리자 홈페이지
            이랃ㄴ
        */

        /* 초기화 */
        
            /* 전체 초기화 */
            * {
                margin: 0; padding: 0;
                box-sizing: border-box;
            }
        
        /* 메인 래퍼 */
            #wrap-main {

            }
        
        /* 사이드바 */
            
            /* 사이드바 전체 래퍼 */
            #wrap-sidebar {
                display: flex;
                /* width: auto; */
            }

            /* 메인 사이드바 */
            
                /* 메인 사이드바 래퍼 */
                #wrap-sidebar-main {
                    width: 300px; height: 100vh;
                }

                /* 메인 사이드바 헤더 */
                #head-sidebar-main {
                    height: 150px;
                    background-color: #000;
                }

                /* 메인 사이드바 바디 */
                #body-sidebar-main {
                    height: calc(100% - 150px);
                    background-color: #9E9E9E;

                    overflow: auto;
                }

                /* 메인 사이드바 내부 요소 */
                .ele-sidebar-main {
                    height: 80px;

                    font-size: 25px;
                    /* font-weight: bold; */
                    text-align: center;
                    line-height: 80px;

                    color: #fff;
                    

                }
                /* 메인 사이드바 내부 요소 :hover */
                .ele-sidebar-main:hover {
                    background-color: #7b7b7b;
                }
            
            /* 서브 사이드바 */
                
                /* 서브 사이드바 래퍼 */
                #wrap-sidebar-sub {
                    width: 300px; height: 100vh;
                }

                /* 서브 사이드바 헤더 */
                #head-sidebar-sub {
                    /* 지금은 안씀 */
                }

                /* 서브 사이드바 바디 */
                #body-sidebar-sub {
                    height: 100%;
                    background-color: #D9D9D9;
                }
                /* 서브 사이드바 바디 내부요소(#innerbody-*-sub) 기본으로 숨기기 */
                #body-sidebar-sub>div {
                    display: none;
                }
                
                /* 서브 사이드바 내부 요소 */
                .ele-sidebar-sub {
                    display: block;

                    height: 80px;

                    font-size: 18px;
                    text-align: center;
                    line-height: 80px;
                    text-decoration: none;
                    white-space: nowrap;
                    overflow: hidden;

                    color: #7b7b7b;
                }
                /* ㅅㅂ 링크 숨기기 */
                #wrap-sidebar-sub.adj-sidebar-sub--close>div#body-sidebar-sub>div>a.ele-sidebar-sub {
                    display: none;
                }

            /* 사이드바 폭 조절 */

                /* 메인 사이드바 */
                /*
                    #wrap-sidebar-main 쪽 width 지워라
                */

                    /* open */
                    #wrap-sidebar-main.adj-sidebar-main--open {
                        width: 300px;
                        transition: 
                            width 0.5s
                        ;
                    }

                    /* close */
                    #wrap-sidebar-main.adj-sidebar-main--close {
                        width: 150px;
                        transition: 
                            width 0.5s
                        ;
                    }

                /* 메인 사이드바 요소 */
                /*
                    실제 위치는 요소들의 부모 (#body-sidebar-main) 임
                    이거 특성상 임마쪽 html 구조가 바뀌면 선택자도 바꿔줘야함

                    현재 구조
                        #body-sidebar-main.adj-body-sidebar-main--close
                            .ele-sidebar-main
                                카테고리 <span>편집</span>
                            .ele-sidebar-main
                            ...
                */

                    /* close */
                    .adj-body-sidebar-main--close#body-sidebar-main>.ele-sidebar-main>span {
                        display: none;
                    }

                /* 서브 사이드바 */

                    /* open */
                    #wrap-sidebar-sub.adj-sidebar-sub--open {
                        width: 300px;
                        transition: 
                            width 0.5s
                        ;
                    }

                    /* close */
                    #wrap-sidebar-sub.adj-sidebar-sub--close {
                        /* display: none; */
                        width: 0px;
                        transition: 
                            width 0.5s
                        ;
                    }
                
                /* 서브 사이드바 요소 바디 */

                    /* open */
                    #body-sidebar-sub>div.adj-sidebar-sub-ele--open {
                        display: block;
                    }
    </style>
</head>
<body>
    <div id="wrap-main">
        <div id="wrap-sidebar">
            <!-- 사이드바 -->
            <div id="wrap-sidebar-main" class="adj-sidebar-main--open">
                <!-- 메인 사이드바 -->
                <div id="head-sidebar-main">
                    <!-- 메인 사이드바 헤더 -->
                    <div id="wrap-ele-titleimg">
                        <!-- 타이틀 이미지 위치 - 나중에 추가 -->
                    </div>
                    <div id="wrap-ele-loginuser">
                        <!-- 로그인유저 이름 위치 -->
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
    </div>
</body>
<script>
    // 초기화
    const mainSidebarWrapper = document.getElementById("wrap-sidebar-main");
    const mainSidebarBody = document.getElementById("body-sidebar-main");
    const subSidebarWrapper = document.getElementById("wrap-sidebar-sub");

    // 현재 열린 항목의 id (메인 사이드바)
    let openedElementId = null;

    // 사이드바 열고 닫기
    //클릭가능한 메인 사이드바 요소들 가져오기
    const adjTestElements = document.getElementsByClassName("ele-sidebar-main");
    //배열화후 forEach(각각 실행해줄 함수) 로 각 요소들에게 클릭이벤트 할당
    Array.from(adjTestElements).forEach(function(element) {
        //클릭이벤트 할당
        element.addEventListener("click", function(event) {
            //테스트
            console.log("openedElementId = " + openedElementId);
            console.log("event.target.id = " + event.target.id);

            //현재 열렸는지 체크
            if(openedElementId === null) {
                //닫혀있음 - 열어준다(메인/서브 둘다 개봉)
                //열린항목 id 저장
                openedElementId = event.target.id;
                //메인사이드바 조절
                mainSidebarWrapper.classList.remove("adj-sidebar-main--open");
                mainSidebarWrapper.classList.add("adj-sidebar-main--close");
                //메인사이드바 항목 줄이기
                mainSidebarBody.classList.add("adj-body-sidebar-main--close");
                //서브사이드바 조절
                subSidebarWrapper.classList.remove("adj-sidebar-sub--close");
                subSidebarWrapper.classList.add("adj-sidebar-sub--open");

                //서브사이드바 내부 항목 열기
                document.getElementById(exchange_clickableToInnerbody(openedElementId)).classList.add("adj-sidebar-sub-ele--open");
            } else {
                //열려있음 - 열린놈이 클릭되었는지 다른 놈이 클릭되었는지 체크
                if(openedElementId != event.target.id) {
                    //다른놈이 클릭됨 - 서브 사이드바만 교체
                    document.getElementById(exchange_clickableToInnerbody(openedElementId)).classList.remove("adj-sidebar-sub-ele--open");
                    document.getElementById(exchange_clickableToInnerbody(event.target.id)).classList.add("adj-sidebar-sub-ele--open");
                    //열린항목 id 갱신
                    openedElementId = event.target.id;
                } else {
                    //같은놈 클릭시 메인을 열고 서브를 닫아준다
                    //메인사이드바 조절
                    mainSidebarWrapper.classList.remove("adj-sidebar-main--close");
                    mainSidebarWrapper.classList.add("adj-sidebar-main--open");
                    //메인사이드바 항목 원복
                    mainSidebarBody.classList.remove("adj-body-sidebar-main--close");
                    //서브사이드바 조절
                    subSidebarWrapper.classList.remove("adj-sidebar-sub--open");
                    subSidebarWrapper.classList.add("adj-sidebar-sub--close");
                    //서브사이드바 내부항목 숨기기
                    document.getElementById(exchange_clickableToInnerbody(openedElementId)).classList.remove("adj-sidebar-sub-ele--open");
                    //열린항목 id 리셋
                    openedElementId = null;
                }
            }
        });
    });

    //clickable-*-main 을 innerbody-*-sub 로 바꿔주는 함수
    function exchange_clickableToInnerbody(clickableId) {
        return "innerbody-" + clickableId.split("-")[1] + "-sub";
    }
</script>
</html>