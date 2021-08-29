<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>	 
<%@ include file="sub_menu.jsp" %>   
	<article>
	    <h1> 1:1 문의하기 </h1>
	    <table>
	    	<tr>
				<td><span style="font-size: 14px;">문의를 남겨주시면 1:1 답변을 드립니다.</span></td>
	    	</tr>
    	</table>   
		<form name="formm" method="post" action="qna_write">
			<fieldset>	
				<legend>Board Info</legend>		
			    <label>Title</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    <input type="text" name="subject"  size="63" ><br>
				<label>Content</label>
			    <textarea rows="8" cols="65" name="content"></textarea><br>
			</fieldset>   
		<div class="clear"></div>
		 <div id="buttons" style="float:right">
			<input type="submit"  value="글쓰기"     class="submit"> 
			<input type="reset"   value="취소"     class="cancel">
			<input type="button"  value="목록"  class="submit"  onclick="location.href='index'">	
		  </div>
		</form>
	</article>
<%@ include file="../footer.jsp" %>