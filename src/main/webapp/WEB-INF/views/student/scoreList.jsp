<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>

<!-- productList.jsp 참고 -->
<article>
<h1>성적 확인</h1>	
<form name="frm" id="prod_form" method="post">



<table id="scoreList">
    <tr>
        <th>과목명</th><th>교수명</th><th>점수</th>
    </tr>
    <c:choose>
    <c:when test="${scoreListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        조회할 과목이 없습니다.
      </td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${scoreList}" var="scoreVO">
    <tr>
      <td>${scoreVO.subname}</td>
      <td>${scoreVO.pname}</td>
   	  <td>${scoreVO.score}</td>
    </tr>
    </c:forEach>
	</c:otherwise>	
</c:choose>  
</table>
</form> 

</article>
<%@ include file="../footer.jsp" %>
