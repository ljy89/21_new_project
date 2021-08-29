<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>    
<%@ include file="sub_menu.jsp" %>   
  <article>
  <br>
    <h1> 1:1 문의하기 </h1>
    <table>
    	<tr>
			<td><span style="font-size: 14px;">문의를 남겨주시면 1:1 답변을 드립니다.</span></td>
    	</tr>
    </table>
    <form name="formm" method="post">
      <table id="cartList">
      <tr>
        <th>번호</th> <th>제목</th> <th>등록일</th> <th>답변 여부</th>    
      </tr>
      <c:forEach items="${qnaList}"  var="qnaVO">
      <tr>  
        <td> ${qnaVO.qseq} </td>    
        <td> <a href="qna_view?qseq=${qnaVO.qseq}"> ${qnaVO.subject} </td>      
        <td> <fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
        <td> 
          <c:choose>
            <c:when test="${qnaVO.rep==1}"> no </c:when>
            <c:when test="${qnaVO.rep==2}"> yes </c:when>
          </c:choose>
        </td>    
      </tr>
      </c:forEach>    
      </table>
      <div class="clear"></div>
      <div id="buttons" style="float:right">
      <input type="button"  value="1:1 질문하기"  class="submit"    onclick="location.href='qna_write_form'"> 
      <input type="button"    value="목록"  class="cancel"  onclick="location.href='index'">  
      </div>
    </form>
  </article>
<%@ include file="../footer.jsp" %>