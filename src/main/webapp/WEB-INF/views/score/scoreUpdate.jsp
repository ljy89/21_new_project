<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ include file="sub_menu.jsp"%>

<!-- productList.jsp 참고 -->
<article>
<h1>성적 등록</h1>	
<form name="frm" id="prod_form" method="post">



<table id="scoreList">
    <tr>
        <th>학생명</th><th>점수</th>
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
	  
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">
      	${scoreVO.sname}
      	<input type="checkbox" id="rdseq" name="rdseq" value= "${scoreVO.rdseq}" checked="checked" style="display: none;">
      </td>
   	  <td>
   	  		<input type="text" id="score" name="score" size="6" value="${scoreVO.score}">
   	  		<input type="hidden" name="sseq" value="${scoreVO.sseq}">
   	  </td>
    </tr>
    
    </c:forEach>
    <!--  <tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>-->
	</c:otherwise>	
</c:choose>  
</table>
<!-- <input class="btn" type="button" value="등록" onClick="score_mod_save('${scoreVO.rdseq}')"> -->
<br>
<input class="btn" type="button" value="등록" onClick="score_mod_save()">           
<input class="btn" type="reset" value="취소" >
</form> 
<br>
<%-- <%@ include file="page_area.jsp" %> --%>
</article>
<%@ include file="../footer.jsp" %>
