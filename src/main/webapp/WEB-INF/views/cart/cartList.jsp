<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>  
<%@ include file="sub_menu.jsp" %>       
  <article style="margin-bottom: 20px">
    <br>
    <h1> 예비장바구니 </h1>
    <form name="formm" id="theform" method="post">
    <c:choose>
    <c:when test= "${cartList.size() == 0}">
      <h3 style="color: red;text-align: center;"> 장바구니가 비었습니다. </h3> 
    </c:when>
    <c:otherwise>
      <table id="cartList">
        <tr>
          <th>선택</th><th>학과</th><th>과목명</th><th>교수명</th><th>수업일자</th>
        </tr>
        
        <c:forEach items="${cartList}"  var="cartVO">
        <tr>  
          <td> <span style="padding-left: 60px"><input id="cseq" type="checkbox" name="cseq" value= "${cartVO.cseq}"></span>     
          <td>
            <a href="subject_detail?sseq=${cartVO.sseq}">
               ${cartVO.dname}              
            </a>    
          </td>
          <td> ${cartVO.subname} </td>
          <td> ${cartVO.pname} </td>  
          <td> ${cartVO.time}</td>      
        </tr>
        </c:forEach>
        
      </table> 
    </c:otherwise>  
    </c:choose>  
     
    <div class="clear"></div>
     
    <div id="buttons" style="float: right">
      <!-- <input type="button" value="목록으로" class="cancel" onclick="location.href='index'">  -->   
      <c:if test= "${cartList.size() != 0}">
      <input type="button" value="삭제하기"  class="submit" onclick="go_cart_delete()">
      <input type="button" value="수강신청"  class="submit" onclick="cart_register_check_form()">
      </c:if>
     </div>
    </form>
  </article>
<%@ include file="../footer.jsp" %>