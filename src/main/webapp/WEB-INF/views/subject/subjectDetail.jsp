<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>

<!-- productDetail.jsp 참고 -->
<article>
<h1>과목 상세 보기</h1> 
<form name="frm" id="detail_form" method="post">
	<div>
		<table id="list">
		<input type="hidden" id="sseq" name="sseq" value="${subjectVO.sseq}"> <br>
			<tr>
				<th>학과명</th>
				<td>${subjectVO.dname}</td>
			</tr>
			
			<tr>
				<th>과목명</th>
				<td>${subjectVO.subname}</td>
			</tr>
			    
			<tr>
				<th align="center" >교수명</th>
				<td>${subjectVO.pname}</td>
			</tr>
					    
			<tr>
				<th >수업 시간</th>
				<td>${subjectVO.time}</td>
			</tr>
			
			<tr>
				<th>수업 소개</th>
				<td>${subjectVO.content}</td>
			</tr>
			
			<tr>
				<th>수업 장소</th>
				<td>${subjectVO.location}</td>
			</tr>
		    
		     <!--[7]<tr>
		     <th>상품이미지</th>
		     <td colspan="5" align="center">
		  상품 이미지를 출력하기 
		     <img src="product_images/${productVO.image}" width="200pt">    
		     </td>
		    </tr> -->    
		     
		</table>
	
	</div>
<input type="button" value="장바구니에 담기"   class="submit"    onclick="go_excart()"> 
<!-- <input type="button" value="수강신청"       class="submit"    onclick="go_register()">  -->
<input type="button" value="수강신청"       class="submit"    onclick="register_check()"> 
<input type="button" value="목록"       class="submit"    onclick="go_list()"> 
<!-- 
<input class="btn"  type="button" value="예비장바구니" onClick="go_list('${criteria.pageNum}', '${criteria.rowsPerPage}')">
<input class="btn"  type="button" value="수강등록" onClick="go_list('${criteria.pageNum}', '${criteria.rowsPerPage}')"> 
<input class="btn"  type="button" value="목록" onClick="go_list('${criteria.pageNum}', '${criteria.rowsPerPage}')">    -->         
</form>
</article>

<%@ include file="../footer.jsp"%>

</body>
</html>






