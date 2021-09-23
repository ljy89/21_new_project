<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>

<!-- productList.jsp 참고 -->
<article>
<br>
<h1>계절학기 리스트</h1>	

<form name="frm" id="subject_form" method="post">
<table>
  <tr>
  <td class="search">
     <select name="serch_key" id="serch_key">
	    <option value="d">과목명</option>
	    <option value="p">교수명</option>
	</select>
     <input type="text" name="key" id="key">
     <input class="btn" type="button" name="btn_search" value="검색" onClick="season_search()">
     <input class="btn" type="button" name="btn_total" value="전체보기 " onClick="season_subject_total()">
  </td>
  </tr>
</table>
<br>
<table id="subjectList">
    <tr>
        <th>번호</th><th>과목명</th><th>교수명</th><th>수업일자</th>
    </tr>
    <c:choose>
    <c:when test="${seasonListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        해당하는 결과가 없습니다.
      </td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${seasonList}" var="seasonVO">
    <tr>
      <td height="23" align="center" >${seasonVO.dname}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
		 <a href="#" onclick="go_seasnon_detail('${seasonVO.seseq}')">
    	 ${seasonVO.seasonname}     
   		</a>
   	  </td>
      <td>${seasonVO.pname}</td>
      <td>${seasonVO.time}</td>
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
