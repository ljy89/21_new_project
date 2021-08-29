<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>

<article>
<br>
<h1>상품수정</h1>  
<form name="frm" id="update_form" method="post" enctype="multipart/form-data">
<input type="hidden" name="nseq" value="${noticeVO.nseq}">

<table id="list">
  <tr>
    <th>제목</th>
    <td width="343">
      <input type="text" name="subject" id="tilte" size="47" maxlength="100" value="${noticeVO.subject}">
    </td>
  </tr>
  <tr>
  
  <tr>
    <th>상세설명</th>
    <td>
      <textarea name="content" id="content" rows="8" cols="70" >${noticeVO.content}</textarea>
    </td>
  </tr>
  
</table>
<br>
<input class="submit" type="button" value="수정" onClick="notice_mod_save('${notceVO.nseq}')">           
<input class="submit" type="reset" value="취소">
</form> 
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>