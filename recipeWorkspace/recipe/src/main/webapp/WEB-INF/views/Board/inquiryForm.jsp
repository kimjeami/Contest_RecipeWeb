<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의하기</title>
 <jsp:include page="/WEB-INF/views/layout/util.jsp" />
 <link rel="stylesheet" href="/css/board/inquiryForm.css">
</head>
<body>
    <div class="container">
            <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
            <main class="main">
    <h2>레시피 문의하기</h2>
    <form action="/recipe/inquirysave"  method="post">
        <input type="hidden" value="${recipe.recipte_no}" id="recipte_no" name="recipte_no">
        <input type="hidden" value="${loginMemberVo.no}" id="write_no" name="write_no">
        <input type="hidden" value="${recipe.write_no}" id="awnser_no" name="awnser_no">
        <label>제목</label>
        <input type="text" id="title" name="title">
        <label>내용</label>
        <input type="text" id="content" name="content">
         <br/>
         <div class="button-container">
             <input type="submit" value="등록" class="submit-btn"/>&nbsp;
             <input type="reset" value="취소" class="submit-btn"/>
         </div>
     </form>
        </main>
    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
    </div>

</body>
</html>