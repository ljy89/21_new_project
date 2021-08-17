<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<%@ include file="sub_menu.jsp"%>
<script type="text/javascript">
  function go_search(name)
  {
     //document.frm.action="admin_member_list?key="+name;
     document.frm.action="admin_member_list";
     document.frm.submit();
  }
</script>

<article>
<h1>회원리스트</h1>  
<form name="frm" method="post">
<table style="float:right; ">
  <tr>
  <td> 
  회원 이름
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
  <c:forEach items="${memberList}" var="memberVO">  
  <tr>
    <td>${memberVO.id} 
    </td>
    <td> ${memberVO.name} </td>
    <td> ${memberVO.dname} </td>
    <td> ${memberVO.email} </td> 
    <td> ${memberVO.phone} </td>
  </tr>
  </c:forEach>
</table>
</form>
</article>
<%@ include file="../../footer.jsp"%>
</body>
</html>