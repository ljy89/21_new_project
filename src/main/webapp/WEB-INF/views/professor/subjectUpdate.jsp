<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>
<!-- admin- productDetail.jsp -->

<article>
<h1>강의 수정</h1>  
<form name="frm" id="update_form" method="post" >

<table id="list">
  <tr>
    <th>학과명</th>
    <td colspan="5">
    <select name="kind" id="kind">
      <c:forEach items="${kindList}" var="kind" varStatus="status">
        <c:choose>
          <c:when test="${productVO.kind==status.count}">
            <option value="${status.count}" selected="selected">${kind}</option>
          </c:when>
          <c:otherwise>
            <option value="${status.count}">${kind}</option>
          </c:otherwise>
        </c:choose>
      </c:forEach>
    </select> 
    </td>
  </tr>
  <tr>
    <th>과목명</th>
    <td width="343" colspan="5">
      <input type="text" name="name" id="name" size="47" maxlength="100" value="${productVO.name}">
    </td>
  </tr>
  <tr>
    <th>교수명</th>
    <td width="70">        
      <input type="text" name="price1" id="price1" size="11" onKeyUp='NumFormat(this)' value="${productVO.price1}">
    </td>
    <th>수업일자</th>
    <td width="70">
      <input type="text" name="price2" id="price2" size="11" onBlur="go_ab()" onKeyUp='NumFormat(this)' value="${productVO.price2}">
    </td>
  </tr>
  
  <tr>
    <th>상세설명</th>
    <td colspan="5">
      <textarea name="content" id="content" rows="8" cols="70" >${productVO.content}</textarea>
    </td>
  </tr>
  <tr>
    <th>수업장소</th>
    <input type="text" name="price2" id="price2" size="11" value="${productVO.price2}">
  </tr>    
</table>
<br>
<input class="btn" type="button" value="수정" onClick="go_mod_save('${productVO.pseq}')">           
<input class="btn" type="button" value="취소" onClick="go_mov()">
</form> 
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>