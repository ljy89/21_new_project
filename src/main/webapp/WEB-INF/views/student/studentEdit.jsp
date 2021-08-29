<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>
<script type="text/javascript">
<!-- admin css 추가-->
   function go_list()
   {
	   var theForm = document.frm;
	   theForm.action="studentDetail";
	   theForm.submit();
   }

   function go_rep(qseq)
   {
	   var theForm = document.frm;
	   //theForm.qseq.value=qseq;
	   theForm.action="studentEditAction";
	   theForm.submit();
   }   
</script>
<article>
<br>
<h1>회원정보</h1>   
<form name="frm" method="post">
<table>
   <tr>
         <th><label>이름</label> </th>
         <td>${studentVO.sname}</td>  
    </tr>
    <tr>
        <th><label>학과명</label></th>
        <td>${studentVO.dname}</td>  
    </tr>
    <tr>
        <th><label>이메일</label> </th>
        <td> <input name="email" type="email" value="${studentVO.email}"><br> </td>  
    </tr>
    <tr>
        <th><label>전화번호</label> </th>
        <td><input name="phone" type="text" value="${studentVO.phone}"><br> </td>  
    </tr>
</table>
<br>
 <input type="button" class="submit" value="수정" onClick="go_rep('${qnaVO.qseq}')">    
<input type="button" class="submit" value="목록" onClick="go_list()">
<br>
</form>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>