<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>

<article>
<br>
<h1>자유 게시판</h1>	
<form name="frm" id="prod_form" method="post">
<table>
  <tr>
  <td width="642">
      상품명 
     <input type="text" name="key" id="key">
     <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search()">
     <input class="btn" type="button" name="btn_total" value="전체보기 " onClick="go_total()">
     <input class="btn" type="button" name="btn_write" value="새글등록" onClick="board_wrt()">
   </td>
  </tr>
</table>
<br>
<table id="productList">
    <tr>
        <th>번호</th><th>제목</th><th>날짜</th><th>작성자</th>
    </tr>
    <c:choose>
    <c:when test="${noticeListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        등록된 상품이 없습니다.
      </td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${noticeList}" var="noticeVO">
    <tr>
      <td height="23" align="center" >${noticeVO.nseq}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
     <%--  <a href="admin_product_detail${pageMaker.makeQuery(pageMaker.cri.pageNum)}&sseq=${noticeVO.sseq}"> --%>
		  <a href="#" onclick="board_detail('${noticeVO.nseq}')">
    	 ${noticeVO.subject}     
   		</a>
   	  </td>
      <td> ${noticeVO.indate}</td>
      <td> ${noticeVO.sid}</td>
    </tr>
    </c:forEach>
    <!-- <tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr> -->
	</c:otherwise>	
</c:choose>  
</table>
</form> 
<br>
 <%@ include file="page_area.jsp" %>
</article>
<%@ include file="../footer.jsp" %>
