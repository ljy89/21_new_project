<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>
<script type="text/javascript">

   function go_rep(qseq)
   {
	   var theForm = document.frm;
	   //theForm.qseq.value=qseq;
	   theForm.action="admin_qna_repsave";
	   theForm.submit();
   }   
</script>
<article>
<h2>회원정보</h2>   
<form name="frm" method="post">

<table>

   <tr>
         <th>이름</th>
         <td>${studentVO.sname}</td>  
    </tr>
    <tr>
        <th>학과명</th>
        <td> ${studentVO.dname}</td>  
    </tr>
    <tr>
        <th>이메일</th>
        <td> ${studentVO.email}</td>  
    </tr>
    <tr>
        <th>전화번호</th>
        <td> ${studentVO.phone}</td>  
    </tr>
</table>
 
</form>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>