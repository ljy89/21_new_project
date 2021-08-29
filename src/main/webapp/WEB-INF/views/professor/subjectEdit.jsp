<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ include file="sub_menu.jsp"%>
<!-- admin- productDetail.jsp -->
<article>
<h1>강의 상세페이지</h1> 
<form name="frm" id="detail_form" method="post">
<table id="list">
  <tr>
    <th>과목분류</th> 
    <td>
    <select name="majoryn">
    	<option value="y">전공과목</option>
    	<option value="n">교양과목</option> 
    </select>
     </td>    
    </tr>    
    <tr>
        <th align="center" >학과명</th>
        <td>${professorVO.dname}</td>
    </tr>
    
    <tr>
        <th>과목명</th>
        <td><input type="text" name="subname" value="${professorVO.subname}"></td>
    </tr>
     
    <tr>
        <th>교수명</th>
        <td>${professorVO.pname}</td>
    </tr>
    
    <tr>
        <th>상세내용</th>
        <td><textarea rows="5" cols="20" name="content">${professorVO.content}</textarea></td>
    </tr>
    
    <tr>
        <th>수업일자</th>
         <td><input type="text" name="time" value="${professorVO.time}"></td>
    </tr>
    
    <tr>
        <th>수업장소</th>
        <td><input type="text" name="location" value="${professorVO.location}"></td>
    </tr>
     
</table>
<!--[8] 수정 버튼이 눌리면 상품 수정 페이지로 이동하되 현재 페이지와 상품 일련번호 값을 전달해 준다. --> 
<input class="btn"  type="button" value="수정" onClick="pro_mod_action('${professorVO.sseq}')">
<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. --> 
<!-- <input class="btn"  type="button" value="목록" onClick="go_list('${criteria.pageNum}', '${criteria.rowsPerPage}')">  -->          
</form>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>






