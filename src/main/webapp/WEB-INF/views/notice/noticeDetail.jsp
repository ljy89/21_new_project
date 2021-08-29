<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>

<article>
<br>
<h1>글 상세 보기</h1> 
<form name="frm" id="detail_form" method="post">
<table id="list">
  <tr>
    <th>제목</th>
    <td>${noticeVO.subject}</td>
    </tr>    
    <tr>
        <th>작성자</th>
         <td>${noticeVO.sid}</td>
    </tr>
    
    <tr>
        <th >내용</th>
         <td>${noticeVO.content}</td>
    </tr>
    <input type="hidden" name="sid" value="${noticeVO.sid}">
</table>
<br>
<!--[8] 수정 버튼이 눌리면 상품 수정 페이지로 이동하되 현재 페이지와 상품 일련번호 값을 전달해 준다. --> 
<input class="submit"  type="button" value="수정" onClick="board_mod('${noticeVO.nseq}')">
<input class="submit"  type="button" value="삭제" onClick="board_del('${noticeVO.nseq}')">
<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다.
<input class="btn"  type="button" value="목록" onClick="go_list('${criteria.pageNum}', '${criteria.rowsPerPage}')">     -->        
</form>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>






