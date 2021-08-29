<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>
<script type="text/javascript">
  function go_search(sname)
  {
     //document.frm.action="admin_member_list?key="+name;
     document.frm.action="admin_student_list";
     document.frm.submit();
  }
</script>

<article>
<h1>학생리스트</h1>  
<form name="frm" method="post">
<table style="float:right; ">
  <tr>
	  <td> 
		   이름
		  <input type="text" name="key" id="key">
		  <input class="btn" type="button" value="검색" onclick="go_search(this.key)">
	  </td>
  </tr>
</table>  

<br>

<table id="orderList">
  <tr>
    <th> 아이디 </th>    <th> 이름 </th>
    <th> 학과 </th><th> 이메일</th>  
    <th> 전화 </th>
  </tr>
  <c:forEach items="${studentList}" var="studentVO">  
  <tr>
    <td>${studentVO.sid} 
    </td>
    <td> ${studentVO.sname} </td>
    <td> ${studentVO.dname} </td>
    <td> ${studentVO.email} </td> 
    <td> ${studentVO.phone} </td>
  </tr>
  </c:forEach>
</table>
</form>
</article>
<%@ include file="../../footer.jsp"%>
</body>
</html>