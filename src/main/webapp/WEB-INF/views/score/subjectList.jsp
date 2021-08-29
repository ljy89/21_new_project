<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ include file="sub_menu.jsp"%>
<!-- admin - productList.jsp 참조 -->
<article>
<h1>강의 리스트</h1>	
<form name="frm" id="score_form" method="post">
<table>
  <tr>
  <td width="642">
      상품명 
     <input type="text" name="key" id="key">
     <input class="btn" type="button" name="btn_search" value="검색" onClick="score_search()">
     <input class="btn" type="button" name="btn_total" value="전체보기 " onClick="score_total()">
  </td>
  </tr>
</table>
<table id="productList">
    <tr>
        <th>번호</th><th>과목명</th><th>학과명</th><th>수강일시</th>
    </tr>
    <c:choose>
    <c:when test="${scoreListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        해당 결과가 없습니다
      </td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${scoreList}" var="scoreVO">
    <tr>
      <td height="23" align="center" >${scoreVO.sseq}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
      	<%-- <a href="admin_product_detail${pageMaker.makeQuery(pageMaker.cri.pageNum)}&sseq=${professorVO.sseq}"> --%>
	  <a href="#" onclick="score_update('${scoreVO.sseq}')">
    	 ${scoreVO.subname}     
   		</a>
   	  </td>
      <td> ${scoreVO.dname}</td>
      <td> ${scoreVO.time}</td>
    </tr>
    </c:forEach>
    <!-- <tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr> -->
	</c:otherwise>	
</c:choose>  
</table>
</form> 
 <%@ include file="page_area.jsp" %>
</article>
<%@ include file="../footer.jsp" %>
