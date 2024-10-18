    <%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
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
    <html>
    <head>
        <meta charset="UTF-8">
        <title>목록 페이지 입니다.</title>

    </head>
    <body>
            <div class="container">
                <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
                <main class="main">

                <div class="container">
                    <table border="1">
                     <tr>
                        <td>레시피 번호 </td>
                        <td>제목</td>
                        <td>문의 상태</td>
                      </tr>
                    <c:forEach var="recipe_inquiry" items="${recipe_inquiry}">
                          <tr>
                            <td>${recipe_inquiry.recipte_no}</td>
                            <td>
                             <a href="${contextPath}/recipe/inquiry?recipte_no=${recipe_inquiry.recipte_no}&write_no=${recipe_inquiry.write_no}&awnser_no=${recipe_inquiry.awnser_no}">
                                 ${recipe_inquiry.title}
                             </a>
                            </td>
                            <td>${recipe_inquiry.state}</td>
                          </tr>

                    </c:forEach>
                    </table>

                </div>

                    <jsp:include page="/WEB-INF/views/Board/pagination.jsp" />

                   </div>
                </main>
                <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
            </div>




    </body>
    </html>
