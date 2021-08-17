<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>  
<%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.jsp" %> 

<!-- cartList.jsp참조 -->      
  <article style="margin-bottom: 20px">
    <h2> Cart List </h2>
    <form name="formm" id="theform" method="post">
    <c:choose>
    <c:when test= "${cartList.size() == 0}">
      <h3 style="color: red;text-align: center;"> 장바구니가 비었습니다. </h3> 
    </c:when>
    <c:otherwise>
      <table id="cartList">
        <tr>
          <th>과목명</th><th>학과명</th><th>교수명</th><th>수업일자</th><th>삭 제</th>    
        </tr>
        
        <c:forEach items="${cartList}"  var="cartVO">
        <tr>      
          <td>
            <a href="subject_detail?sseq=${cartVO.sseq}">
              <h3> ${cartVO.sname} </h3>              
            </a>    
          </td>
          <td> ${cartVO.dname} </td>
         <td> ${cartVO.pname} </td>     
          <td> ${cartVO.time} </td>   
          <td> <input type="checkbox" name="cseq" value= "${cartVO.cseq}"> 
          </td>
        </tr>
        </c:forEach>
      </table> 
    </c:otherwise>  
    </c:choose>  
     
    <div class="clear"></div>
     
    <div id="buttons" style="float: right">
      <input type="button" value="목록으로" class="cancel" onclick="location.href='index'">    
      <c:if test= "${cartList.size() != 0}">
      <input type="button" value="수강등록"  class="submit" onclick="go_order_insert()">
      </c:if>
      <input type="button" value="삭제"  class="submit" onclick="go_cart_delete()">
     </div>
    </form>
  </article>
<%@ include file="../footer.jsp" %>