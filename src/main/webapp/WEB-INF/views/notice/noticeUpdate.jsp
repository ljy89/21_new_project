<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>

<article>
<h1>상품수정</h1>  
<form name="frm" id="update_form" method="post" enctype="multipart/form-data">
<input type="hidden" name="sseq" value="${noticeVO.sseq}">
<input type="hidden" name="code" >

<table id="list">
  <tr>
    <th>제목</th>
    <td width="343">
      <input type="text" name="title" id="tilte" size="47" maxlength="100" value="${noticeVO.name}">
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
<input class="btn" type="button" value="수정" onClick="go_mod_save('${productVO.pseq}')">           
<input class="btn" type="button" value="취소" onClick="go_mov()">
</form> 
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>