<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ include file="sub_menu.jsp"%>
<!-- admin - productList.jsp 참조 -->
<article>
<h1>강의 리스트</h1>	

<form name="frm" id="sub_form" method="post">
<table>
  <tr>
  <td width="642">
      상품명 
     <input type="text" name="key" id="key">
     <input class="btn" type="button" name="btn_search" value="검색" onClick="pro_search()">
     <input class="btn" type="button" name="btn_total" value="전체보기 " onClick="pro_total()">
     <input class="btn" type="button" name="btn_write" value="강의등록" onClick="pro_wrt()">
  </td>
  </tr>
</table>
<br>
<table id="subjectList">
    <tr>
        <th>번호</th><th>과목명</th><th>학과명</th><th>수강일시</th>
    </tr>
    <c:choose>
    <c:when test="${subjectListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        해당 결과가 없습니다
      </td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${subjectList}" var="professorVO">
    <tr>
      <td height="23" align="center" >${professorVO.sseq}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
       <%--<a href="admin_product_detail${pageMaker.makeQuery(pageMaker.cri.pageNum)}&sseq=${professorVO.sseq}"> --%>
		  <a href="#" onclick="pro_detail('${professorVO.sseq}')">
    	 ${professorVO.subname}     
   		</a>
   	  </td>
      <td> ${professorVO.dname}</td>
      <td> ${professorVO.time}</td>
    </tr>
    </c:forEach>
    <!-- <tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr> -->
	</c:otherwise>	
</c:choose>  
</table>
</form> 
 <%--  <%@ include file="page_area.jsp"> --%>
</article>
<%@ include file="../footer.jsp" %>
