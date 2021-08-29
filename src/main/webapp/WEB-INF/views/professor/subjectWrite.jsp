<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ include file="sub_menu.jsp"%>
<!-- admin-productWrite.jsp 참조 -->
<article>
<h1>강의 등록</h1>  
<!-- [1] 파일을 업로드 하기 위해서는 폼태그를 post 방식으로 전송하고,
인코딩 타입을 multipart/form-data 로 지정해야 한다. -->
<form name="frm" id="write_form" method="post" >
<!-- <form name="frm" id="write_form" method="post" enctype="multipart/form-data"> -->
<table id="list">
<tr>
  <th>과목분류</th>
  <td>
  	<select name="majoryn" id="majoryn">
      <option value="y">전공과목</option>
	  <option value="n">교양과목</option>
  	</select>      
	</td>
</tr>

<tr>
  <th>과목명</th>
  <td>
       <input type="text" name="subname" id="subname">
  </td>
</tr>
<tr>
  <th>교수 아이디</th>
  <td width="70">
    <input type="text" name="pid" id="pid" value="${professorUser.pid}" readonly="readonly">
  </td>
 </tr>
 <tr>
  <th>수업시간</th>
  <td width="70">
     <input type="text" name="time" id="time">
  </td>
</tr>
<tr>
  <th>수업장소</th>
    <td width="72">
      <input type="text" name="location" id="location" size="11" >
    </td>
  </tr>
    
  <tr>
    <th>상세설명</th>
 	<td>
      <textarea name="content" id="content" rows="8" cols="70" ></textarea>
    </td>
  </tr>
  
  <tr>
  <th>학과명</th>
  <td>
  	<select name="dseq" id="dseq">
      <option value="1">화학과</option>
	  <option value="2">언론과</option>
	  <option value="3">영문확과</option>
	  <option value="4">국문학과</option>
	  <option value="5">컴퓨터공학과</option>
	  <option value="6">일반교양</option>
	  <option value="21">체육학과</option>
  	</select>      
	</td>
</tr>


 <!--   <tr>
  <th>상품이미지</th>
    <td width="343" colspan="5">
  [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다.  
      <input type="file" name="product_image" id="product_image">
    </td>
  </tr>   --> 
</table>
<br>
<input class="btn" type="button" value="등록" onClick="pro_save()">           
<input class="btn" type="reset" value="취소" >
</form> 
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>