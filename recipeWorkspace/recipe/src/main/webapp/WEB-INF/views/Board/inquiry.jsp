<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    // 세션에서 로그인된 사용자 정보 확인
    Object loginMember = session.getAttribute("loginMemberVo");

    // 로그인 정보가 없을 경우
    if (loginMember == null) {
%>
        <script type="text/javascript">
            alert("로그인을 해주세요.");
            window.location.href = "/member/login";
        </script>
<%
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문의 답변</title>
    <link rel="stylesheet" href="/css/board/inquiry.css">
    <jsp:include page="/WEB-INF/views/layout/util.jsp" />

</head>

<body>
    <div class="container">
        <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
        <main class="main">
               <h2>레시피 문의</h2>
              <div>
               <label>문의 제목</label>
               <input type="text" value="${recipe_inquiry.title}" id="title" name="title" readonly/>
               <br/><br/>
               <label>문의 내용</label>
               <textarea rows="5" placeholder="내용을 입력하세요" name="content" id="content" readonly>${recipe_inquiry.content}</textarea>
              </div>


           <div>
               <label>답변 내용</label>
               <c:choose>
                   <c:when test="${recipe_inquiry.answer == null}">
                       <input type="text" value="답변중입니다." readonly/>
                   </c:when>
                   <c:otherwise>
                        <textarea rows="5" placeholder="내용을 입력하세요" name="content" id="content" readonly>${recipe_inquiry.answer}</textarea>
                   </c:otherwise>
               </c:choose>
           </div>



             <c:if test="${recipe_inquiry.awnser_no == loginMemberVo.no}">
                <div>
                    <input type="button" value="답변하기" onclick="location.href='${contextPath}/recipe/answerForm?recipte_no=${recipe_inquiry.recipte_no}&write_no=${recipe_inquiry.write_no}&awnser_no=${recipe_inquiry.awnser_no}'">
                </div>
            </c:if>

        </main>


        <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
    </div>
</body>
</html>
