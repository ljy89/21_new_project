<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>  
<%@ include file="sub_menu.jsp" %>       
  <article>
    <h2> ${title} </h2>
    <form name="formm" method="post" id="theform">    
             
     <h3> 결제 정보 </h3> 
     <table id="cartList">
     <tr>
        <th>결제일자</th><th>결제번호</th><th>과목명</th><th>가격</th>
     </tr>
     
     <c:forEach items="${orderList}"  var="orderVO">
     <tr>
     	<td> <fmt:formatDate value="${orderDetail.indate}" type="date"/></td>
     	<td> ${orderVO.season_order_seq} </td> 
        <td> ${orderVO.seasonname} </td>
        <td> <fmt:formatNumber type="currency" value="${orderVO.price}" /> </td>
		  
     </tr>
     </c:forEach>
     <tr>
     	<th> 결제 총액</th>
     	<td colspan="3"> <fmt:formatNumber type="currency" value="${totalPrice}" /> </td>     
     </tr>    
     </table>   
          
     <div class="clear"></div>
     <div id="buttons" style="float: right">
       <input type="button"    value="목록"  class="cancel"  onClick="season_order_list()">
     </div>
    </form>  
  </article>
<%@ include file="../footer.jsp" %>