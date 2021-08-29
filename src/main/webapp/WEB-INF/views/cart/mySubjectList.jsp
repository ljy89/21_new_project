<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>

<!-- admin-orderList.jsp -->
<article>
<br>
<h1>수강리스트</h1>
	<form id="theform" name="frm" method="post">
  
  	<table id="registerList">
  	<tr>
    	<th>삭제</th><th>학과</th><th>과목명</th><th>교수명</th><th>수업시간</th>
  	</tr>
  	<c:forEach items="${registerList}" var="registerVO">
  	<tr>
    	<td>
      	<input type="checkbox" name="rdseq" value= "${registerVO.rdseq}">
    </td>
     <td>${registerVO.dname}</td>
    <td>
    	<a href="subject_detail?sseq=${registerVO.sseq} ">
    		${registerVO.subname}
    	</a>
    </td>
   <td>${registerVO.pname}</td>
    <td>${registerVO.time}</td>
  </tr>
  </c:forEach>
  </table>
  <br>
   <input type="button" value="목록으로" class="cancel" onclick="location.href='index'">    
   <input type="button" value="삭제"  class="submit" onclick="go_register_delete()">
   <br>
</form>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>