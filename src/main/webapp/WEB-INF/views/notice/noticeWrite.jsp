<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>

<article>
<h1>새글등록</h1>  
<!-- [1] 파일을 업로드 하기 위해서는 폼태그를 post 방식으로 전송하고,
인코딩 타입을 multipart/form-data 로 지정해야 한다. -->
<form name="frm" id="write_form" method="post">
<table id="list">
  
  <tr>
  	<th>제목</th>
  	<td><input type="text" name="subject" id="subject" size="47" maxlength="100"></td>
  </tr>
<tr>

<tr>
    <th>상세설명</th>
    <td colspan="5">
      <textarea name="content" id="content" rows="8" cols="70" ></textarea>
    </td>
  </tr>

</table>
<input class="btn" type="button" value="등록" onClick="board_save()">           
<input class="btn" type="reset" value="취소">
</form> 
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>