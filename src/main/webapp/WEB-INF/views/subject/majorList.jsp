<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>

<!-- productList.jsp 참고 -->
<article>
<br>
<h1>전공과목 리스트</h1>	
<form name="frm" id="subject_form" method="post">
<table id="search">
  <tr>
  <td class="search">
     <select name="dseq" id="serch_key">
	    <option value="1">화학과</option>
	    <option value="2">언론과</option>
	    <option value="3">영문학과</option>
	    <option value="4">국문학과</option>
	    <option value="5">컴퓨터공학과</option>
	    <option value="21">체육학과</option>
	</select>
     <input type="text" name="key" id="key">
     <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search_major()">
     <input class="btn" type="button" name="btn_total" value="전체보기 " onClick="go_total_major()">
  </td>
  </tr>
</table>
<br>
<table id="subjectList">
    <tr>
        <th>학과</th><th>과목명</th><th>교수명</th><th>수강시간</th>
    </tr>
    <c:choose>
    <c:when test="${majorListSize<=0}">
    <tr>
      <td>
        해당하는 결과가 없습니다.
      </td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${majorList}" var="subjectVO">
    <tr>
      <td>${subjectVO.dname}</td>
      <td>   
    	<!--<a href="subjectDetail${pageMaker.makeQuery(pageMaker.cri.pageNum)}&sseq=${subjectVO.sseq}"> -->
		 <a href="#" onclick="go_detail('${subjectVO.sseq}')">
    	 	${subjectVO.subname}     
   		 </a>
   	  </td>
      <td>${subjectVO.pname}</td>
      <td>${subjectVO.time}</td>
    </tr>
    </c:forEach>
     
	</c:otherwise>	
</c:choose>  
</table>
 </form>
 <br>
 <%@ include file="page_area.jsp" %>
 <br>
</article>
<%@ include file="../footer.jsp" %>
