<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>
<!-- admin-productWrite.jsp 참조 -->
<article>
<h1>강의등록</h1>  
<!-- [1] 파일을 업로드 하기 위해서는 폼태그를 post 방식으로 전송하고,
인코딩 타입을 multipart/form-data 로 지정해야 한다. -->
<form name="frm" id="write_form" method="post" enctype="multipart/form-data">
<table id="list">
<tr>
  <th>교양분류</th>
  <td colspan="5">
  <select name="kind" id="kind">
    <c:forEach items="${kindList}" var="kind" varStatus="status">
      <option value="${status.count}">${kind}</option>
   </c:forEach>
  </select>      
<tr>
  <th>과목명</th>
  <td width="343" colspan="5">
       <input type="text" name="name" id="name" size="47" maxlength="100" value="킬힐">
  </td>
</tr>
<tr>
  <th>교수명</th>
  <td width="70">
    <input type="text" name="price1" id="price1" size="11" onKeyUp='NumFormat(this)' value="10000">
  </td>
  <th>수업시간</th>
  <td width="70">
     <input type="text" name="price2" id="price2" size="11" onBlur="go_ab()" onKeyUp='NumFormat(this)' value="20000">
  </td>
  <th>수업장소</th>
    <td width="72">
      <input type="text" name="price3" id="price3" size="11" readonly onKeyUp='NumFormat(this)'>
    </td>
  </tr>
    
  <tr>
    <th>상세설명</th>
    <td colspan="5">
      <textarea name="content" id="content" rows="8" cols="70" >이뻐요</textarea>
    </td>
  </tr>
  <tr>
    <th>상품이미지</th>
    <td width="343" colspan="5">
<!--  [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다.  -->
      <input type="file" name="product_image" id="product_image">
    </td>
  </tr>    
</table>
<input class="btn" type="button" value="등록" onClick="go_save()">           
<input class="btn" type="button" value="취소" onClick="go_mov()">
</form> 
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>