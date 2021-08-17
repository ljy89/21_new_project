<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>

<!-- productList.jsp 참고 -->
<article>
<h1>교양과목 리스트</h1>	
<form name="frm" id="prod_form" method="post">
<table>
  <tr>
  <td width="642">
      상품명 
     <input type="text" name="key" id="key">
     <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search()">
     <input class="btn" type="button" name="btn_total" value="전체보기 " onClick="go_total()">
  </td>
  </tr>
</table>
<table id="liberalArtsList">
    <tr>
        <th>번호</th><th>과목명</th><th>교수명</th><th>수업일자</th>
    </tr>
    <c:choose>
    <c:when test="${liberalArtsListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        해당하는 결과가 없습니다.
      </td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${liberalArtsList}" var="subjectVO">
    <tr>
      <td height="23" align="center" >${subjectVO.dname}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
       <a href="admin_product_detail${pageMaker.makeQuery(pageMaker.cri.pageNum)}&sseq=${subjectVO.sseq}"> 
		<%--  <a href="#" onclick="go_detail('${productVO.pseq}')">--%>
    	 ${subjectVO.dname}     
   		</a>
   	  </td>
      <td>${subjectVO.pname}</td>
      <td>${subjectVO.time}</td>
    </tr>
    </c:forEach>
    <tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
	</c:otherwise>	
</c:choose>  
</table>
</form> 
 <%@ include file="page_area.jsp" %>
</article>
<%@ include file="../footer.jsp" %>
