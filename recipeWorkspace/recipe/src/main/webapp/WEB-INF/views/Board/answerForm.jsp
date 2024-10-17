<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의하기</title>
 <jsp:include page="/WEB-INF/views/layout/util.jsp" />
</head>
<body>
    <h1>문의하기</h1>
    <div class="container">
            <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
            <main class="main">

    <form action="/recipe/answer"  method="post">
        <input type="hidden" value="${recipe_inquiry.recipte_no}" id="recipte_no" name="recipte_no">
        <input type="hidden" value="${recipe_inquiry.write_no}" id="write_no" name="write_no">
        <input type="hidden" value="${recipe_inquiry.awnser_no}" id="awnser_no" name="awnser_no">
        <h2>답변 내용</h2>
        <input type="text" id="answer" name="answer">
         <br/>
         <input type="submit" value="등록"/>&nbsp;
         <input type="reset" value="취소"/>
     </form>
        </main>
    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
    </div>

</body>
</html>