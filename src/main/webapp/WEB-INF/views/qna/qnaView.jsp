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
    <br>
    <form name="formm" method="post">
    <table id="notice">
      <tr>
              <th>제목</th>
              <td>${qnaVO.subject}</td> 
      </tr>
      <tr>
        <th>등록일</th>
        <td> <fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
      </tr>
      <tr>
        <th>질문내용</th>
        <td>${qnaVO.content} 
      </tr>
      <tr>
        <th>답변 내용</th>
        <td>${qnaVO.reply}  
      </tr>
    </table>
    <div class="clear"></div>
     <div id="buttons" style="float:right">
      <input type="button"  value="목록보기"     class="submit"  onclick="location.href='qna_list'">  
      </div>
    </form>
  </article>
<%@ include file="../footer.jsp" %>