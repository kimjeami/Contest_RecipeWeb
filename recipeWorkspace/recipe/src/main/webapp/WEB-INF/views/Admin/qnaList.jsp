<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Q&A 관리</title>
    <style>
        /* 전체 wrapper */
        #wrap-main {
            display: flex;
        }

        /* 본문 wrapper */
        #wrap-qnalist {

            display: flex;
            flex-wrap: nowrap;
            flex-direction: column;
            gap: 20px;

            width: 100%;

            background-color: rgb(242, 242, 242);
        }

        /* 리스트 컬럼 폭 조절 - 7개, flex 합산 15 */
        .def-admin-list-body-tablerow>div:nth-child(1) {
            flex: 1 1 0;
        }
        .def-admin-list-body-tablerow>div:nth-child(2) {
            flex: 1.5 1 0;
        }
        .def-admin-list-body-tablerow>div:nth-child(3) {
            flex: 1.5 1 0;
        }
        .def-admin-list-body-tablerow>div:nth-child(4) {
            flex: 6 1 0;
        }
        .def-admin-list-body-tablerow>div:nth-child(5) {
            flex: 4 1 0;
        }
        .def-admin-list-body-tablerow>div:nth-child(6) {
            flex: 1.5 1 0;
        }
        .def-admin-list-body-tablerow>div:nth-child(7) {
            flex: 1.5 1 0;
        }
    </style>
    <link rel="stylesheet" href="/css/admin/adminListLayout.css">
</head>
<body>
    <div id="wrap-main">
        <jsp:include page="/WEB-INF/views/admin/adminSidebar.jsp" />
        <div id="wrap-qnalist">
            <div id="qnalist-header" class="def-admin-list-header">
                <h2>Q&A 조회</h2>
            </div>
            <div id="qnalist-body" class="def-admin-list-body">
                <div class="def-admin-list-body-searchbar">
                    <div class="def-admin-list-body-searchbar-searcharea">
                        <select class="def-admin-searcharea-select" name="category">
                            <option value="0" selected>카테고리 전체</option>
                            <option value="1">계정</option>
                            <option value="2">레시피</option>
                            <option value="3">기타</option>
                            <option value="4">광고</option>
                        </select>
                        <select class="def-admin-searcharea-select" name="keywordtype">
                            <option value="0" selected>검색조건 전체</option>
                            <option value="1">계정</option>
                            <option value="2">레시피</option>
                            <option value="3">기타</option>
                            <option value="4">광고</option>
                        </select>
                        <input type="text" class="def-admin-searcharea-input" name="keyword">
                        <button type="button" class="def-admin-searcharea-button">검색</button>
                        <button type="button" class="def-admin-searcharea-button">새로고침</button>
                        <button type="button" class="def-admin-searcharea-button">초기화</button>
                    </div>
                    <div class="def-admin-list-body-searchbar-resultarea">
                        <div>검색된 전체 행 개수 : <span>350</span></div>
                        <div>페이지 수 : <span>18</span></div>
                    </div>
                </div>
                <div class="def-admin-list-body-tablelike">
                    <div class="def-admin-list-body-tablerow-head def-admin-list-body-tablerow">
                        <div>요청 ID</div>
                        <div>카테고리</div>
                        <div>처리 상태</div>
                        <div>제목</div>
                        <div>요청자</div>
                        <div>요청일</div>
                        <div>갱신일</div>
                    </div>
                    <div class="def-admin-list-body-tablerow">
                        <div>0123</div>
                        <div>계정</div>
                        <div>요청중</div>
                        <div>탈퇴시켜줘제발</div>
                        <div>user123</div>
                        <div>24-10-21</div>
                        <div>24-10-21</div>
                    </div>
                    <div class="def-admin-list-body-tablerow">
                        <div>0122</div>
                        <div>레시피</div>
                        <div>진행중</div>
                        <div>레시피 작성할 때 동영상도 넣을 수 있게 해주세요</div>
                        <div>user123</div>
                        <div>24-10-20</div>
                        <div>24-10-21</div>
                    </div>
                    <div class="def-admin-list-body-tablerow">
                        <div>0121</div>
                        <div>기타</div>
                        <div>종료(반려됨)</div>
                        <div>q&a 이거 받아주기는 함?</div>
                        <div>user123</div>
                        <div>24-10-21</div>
                        <div>24-10-21</div>
                    </div>
                    <div class="def-admin-list-body-tablerow">
                        <div>0120</div>
                        <div>계정</div>
                        <div>종료(완료됨)</div>
                        <div>id - 닉네임 말고 id 를 바꾸고 싶어요!!</div>
                        <div>김두루미긴유저id대충적당히길게가나다라마바사아자차카타파하아야어여오요</div>
                        <div>24-10-21</div>
                        <div>24-10-21</div>
                    </div>
                </div>
                <div class="def-admin-list-body-pagination">
                        <a href="#">&lt;&lt;</a>
                        <a href="#">&lt;</a>
                        <a href="#">16</a>
                        <a href="#">17</a>
                        <a href="#">18</a>
                        <a href="#">19</a>
                        <a href="#" class="def-admin-pagination-highlight">20</a>
                        <a href="#">21</a>
                        <a href="#">22</a>
                        <a href="#">23</a>
                        <a href="#">24</a>
                        <a href="#">&gt;</a>
                        <a href="#">&gt;&gt;</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>