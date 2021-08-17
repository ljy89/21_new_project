<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>

<!-- admin-orderList.jsp -->
<article>
<h1>주문리스트</h1>
<form name="frm" method="post">
  <table style="float: right;">
    <tr>
      <td>주문자 이름 <input type="text" name="key"> 
      <input class="btn" type="button" value="검색" onclick="go_search()">
      </td>
    </tr>
  </table>
  <br>
  <table id="orderList">
  <tr>
    <th>삭제</th><th>학과</th><th>과목명</th><th>교수명</th>
    <th>수업시간</th>
  </tr>
  <c:forEach items="${orderList}" var="orderVO">
  <tr>
    <td>
      <input type="checkbox" name="cseq" value= "${orderVO.cseq}">
    </td>
     <td>${orderVO.dname}</td>
    <td>${orderVO.sname}</td>
   <td>${orderVO.pname}</td>
    
  </tr>
  </c:forEach>
  </table>
   <input type="button" value="목록으로" class="cancel" onclick="location.href='index'">    
   <input type="button" value="삭제"  class="submit" onclick="go_cart_delete()">
</form>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>