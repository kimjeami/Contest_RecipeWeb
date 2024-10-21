<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Home</title>
    <style>
        #wrap-main {
            display: flex;
        }
        #wrap-adminhome {
            display: flex;
            flex-wrap: wrap;
            flex-direction: row;
            gap: 20px;

            width: 100%;

            padding: 20px 10px 0 20px;

            background-color: rgb(242, 242, 242);
        }
        .adminhome-item-wrapper {
            /* flex-grow: 1; */
            flex: 1 1 calc(50% - 20px);

            margin: 0 0 20px 0;

            background-color: white;
        }
        @media (max-width: 1700px) {
            .adminhome-item-wrapper {
                flex: 1 1 100%;
                min-height: 500px;
            }
        }

        .adminhome-item-header {
            height: 40px;
            width: 100%;

            border-bottom: 1px solid rgb(242, 242, 242);

            padding: 0 15px 0 15px;

            display: flex;
            flex-direction: row;
        }
        .adminhome-item-name {
            font-weight: 100;
            font-size: 20px;

            align-self: center;
        }

        .adminhome-inneritem-container {
            display: flex;
            flex-direction: column;
            justify-content: flex-start;

            height: 360px;
        }
        /* a 태그 스타일 제거 */
        .adminhome-inneritem-container a {
            text-decoration: none;
            color: inherit;
        }
        /* 머리행 포함 각 행 */
        .adminhome-inneritem-row {
            display: flex;
            flex-direction: row;

            width: 100%;
            height: 30px;

            border-bottom: 1px solid rgb(242, 242, 242);
        }
        .adminhome-inneritem-row:hover {
            background-color: rgb(250, 250, 250);
        }
        /* 머리행 호버 효과 없애기 */
        .adminhome-inneritem-headrow:hover {
            background-color: inherit;
        }
        .adminhome-inneritem-row>div {
            font-size: 12px;
            line-height: 30px;
            text-align: center;
        }
        /* 머리행 */
        .adminhome-inneritem-container>div:nth-child(1) {
            color: rgb(140, 140, 140);
        }
        .adminhome-its-really-empty-or-error {
            width: 100%;
            height: 30px;
            font-size: 12px;
            line-height: 30px;
            text-align: center;
        }
        /* Q&A(#wrap-qna) 각 항목 내부 비율 */
        #wrap-qna .adminhome-inneritem-row>div:nth-child(1) {
            flex: 2 1 0;
        }
        #wrap-qna .adminhome-inneritem-row>div:nth-child(2) {
            flex: 2 1 0;
        }
        #wrap-qna .adminhome-inneritem-row>div:nth-child(3) {
            flex: 5 1 0;
        }
        #wrap-qna .adminhome-inneritem-row>div:nth-child(4) {
            flex: 3 1 0;
        }
        #wrap-qna .adminhome-inneritem-row>div:nth-child(5) {
            flex: 1.5 1 0;
        }
        #wrap-qna .adminhome-inneritem-row>div:nth-child(6) {
            flex: 1.5 1 0;
        }
        /* 신고(#wrap-report) 각 항목 내부 비율 */
        #wrap-report .adminhome-inneritem-row>div:nth-child(1) {
            flex: 2 1 0;
        }
        #wrap-report .adminhome-inneritem-row>div:nth-child(2) {
            flex: 5.5 1 0;
        }
        #wrap-report .adminhome-inneritem-row>div:nth-child(3) {
            flex: 3 1 0;
        }
        #wrap-report .adminhome-inneritem-row>div:nth-child(4) {
            flex: 3 1 0;
        }
        #wrap-report .adminhome-inneritem-row>div:nth-child(5) {
            flex: 1.5 1 0;
        }
        /* 최근 가입자(#wrap-recentregi) 각 항목 내부 비율 */
        #wrap-recentregi .adminhome-inneritem-row>div:nth-child(1) {
            flex: 2 1 0;
        }
        #wrap-recentregi .adminhome-inneritem-row>div:nth-child(2) {
            flex: 4 1 0;
        }
        #wrap-recentregi .adminhome-inneritem-row>div:nth-child(3) {
            flex: 3.5 1 0;
        }
        #wrap-recentregi .adminhome-inneritem-row>div:nth-child(4) {
            flex: 4 1 0;
        }
        #wrap-recentregi .adminhome-inneritem-row>div:nth-child(5) {
            flex: 1.5 1 0;
        }
    </style>
</head>
<body>
    <div id="wrap-main">
        <jsp:include page="/WEB-INF/views/admin/adminSidebar.jsp" />
        <div id="wrap-adminhome">
            <div id="wrap-stats" class="adminhome-item-wrapper">
                <div class="adminhome-item-header">
                    <h2 class="adminhome-item-name">통계</h2>
                </div>
            </div>
            <div id="wrap-qna" class="adminhome-item-wrapper">
                <div class="adminhome-item-header">
                    <h2 class="adminhome-item-name">Q&A 요청</h2>
                </div>
                <div class="adminhome-inneritem-container">
                    <div class="adminhome-inneritem-headrow adminhome-inneritem-row">
                        <div>요청 ID</div>
                        <div>카테고리</div>
                        <div>제목</div>
                        <div>요청자</div>
                        <div>요청일</div>
                        <div>갱신일</div>
                    </div>
                    <!-- 여기 아래 .adminhome-inneritem 이 친구가 동적으로 뽑아야 하는 친구임 - 까먹을까봐 적음 -->
                    <c:choose>
                        <%-- 조회 실패시 --%>
                        <c:when test="${not empty isLoadFailed}">
                            <div class="adminhome-its-really-empty-or-error">
                                오류가 발생하였습니다
                            </div>
                        </c:when>
                        <%-- 조회 결과가 없는 경우 --%>
                        <c:when test="${not empty isQnaEmptyResult}">
                            <div class="adminhome-its-really-empty-or-error">
                                Q&A 요청이 없습니다
                            </div>
                        </c:when>
                        <%-- 정상적인 경우 --%>
                        <c:otherwise>
                            <c:forEach var="qnaRow" items="${qnaList}">
                                <a href="#">
                                    <div class="adminhome-inneritem-row">
                                        <div>${qnaRow.QNA_REQUEST_NO}</div>
                                        <div>${qnaRow.QNA_CATEGORY_NAME}</div>
                                        <div>${qnaRow.QNA_REQUEST_TITLE}</div>
                                        <div>${qnaRow.ID}</div>
                                        <div>${qnaRow.QNA_REQUEST_CREATED_DATE}</div>
                                        <div>${qnaRow.QNA_REQUEST_LAST_ACTIVITY_DATE}</div>
                                    </div>
                                </a>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div id="wrap-report" class="adminhome-item-wrapper">
                <div class="adminhome-item-header">
                    <h2 class="adminhome-item-name">신고 요청</h2>
                </div>
                <div class="adminhome-inneritem-container">
                    <div class="adminhome-inneritem-headrow adminhome-inneritem-row">
                        <div>신고 ID</div>
                        <div>제목</div>
                        <div>요청자</div>
                        <div>대상자</div>
                        <div>요청일</div>
                    </div>
                    <!-- .adminhome-inneritem-row 동적생성 대충 10개까지 -->
                    <c:choose>
                        <%-- 조회 실패시 --%>
                        <c:when test="${not empty isLoadFailed}">
                            <div class="adminhome-its-really-empty-or-error">
                                오류가 발생하였습니다
                            </div>
                        </c:when>
                        <%-- 조회 결과가 없는 경우 --%>
                        <c:when test="${not empty isReportEmptyResult}">
                            <div class="adminhome-its-really-empty-or-error">
                                신고 요청이 없습니다
                            </div>
                        </c:when>
                        <%-- 정상적인 경우 --%>
                        <c:otherwise>
                            <c:forEach var="reportRow" items="${reportList}">
                                <a href="#">
                                    <div class="adminhome-inneritem-row">
                                        <div>wip</div>
                                    </div>
                                </a>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div id="wrap-recentregi" class="adminhome-item-wrapper">
                <div class="adminhome-item-header">
                    <h2 class="adminhome-item-name">최근 가입자</h2>
                </div>
                <div class="adminhome-inneritem-container">
                    <div class="adminhome-inneritem-headrow adminhome-inneritem-row">
                        <div>NO</div>
                        <div>ID</div>
                        <div>닉네임</div>
                        <div>이메일</div>
                        <div>가입일자</div>
                    </div>
                    <!-- 동적 최대 10개 -->
                    <c:choose>
                        <%-- 조회 실패시 --%>
                        <c:when test="${not empty isLoadFailed}">
                            <div class="adminhome-its-really-empty-or-error">
                                오류가 발생하였습니다
                            </div>
                        </c:when>
                        <%-- 조회 결과가 없는 경우 --%>
                        <c:when test="${not empty isRecentRegiEmptyResult}">
                            <div class="adminhome-its-really-empty-or-error">
                                최근 가입자가 없습니다
                            </div>
                        </c:when>
                        <%-- 정상적인 경우 --%>
                        <c:otherwise>
                            <c:forEach var="recentRegiRow" items="${recentRegiList}">
                                <a href="#">
                                    <div class="adminhome-inneritem-row">
                                        <div>wip</div>
                                    </div>
                                </a>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</body>
</html>