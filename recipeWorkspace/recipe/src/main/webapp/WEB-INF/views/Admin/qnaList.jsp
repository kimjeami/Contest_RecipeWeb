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

                </div>
            </div>
        </div>
    </div>
</body>
</html>