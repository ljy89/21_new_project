<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>  
<%@ include file="sub_menu.jsp" %> 

  <article>
    <h2>결제 내역(${title}) </h2>
    <form name="formm" id="theform" method="post">
      <table id="cartList">
      <tr>
        <th>주문일자</th> <th>주문번호</th> <th>상품명</th> <th>결제 금액</th> <th>주문 상세</th>    
      </tr>
      <c:forEach items="${orderList}"  var="orderVO">
      <tr>  
        <td>
        	<fmt:formatDate value="${orderVO.indate}" type="date"/>
        </td>
        <td> ${orderVO.season_order_seq} </td>    
        <td> ${orderVO.seasonname} </td>
        <td> <fmt:formatNumber value="${orderVO.price}" type="currency"/> </td>
        <td> <a href="order_detail?season_order_seq=${orderVO.season_order_seq}">상세 조회 </a></td>
      </tr>
      </c:forEach>    
      </table>   
          
      <div class="clear"></div>
      <div id="buttons" style="float: right">
       <input type="button"    value="목록"  class="cancel"  onClick="season_order_list()"> 
      </div>
    </form>  
  </article>
<%@ include file="../footer.jsp" %>   

<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
