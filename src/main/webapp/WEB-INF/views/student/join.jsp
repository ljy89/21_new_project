<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>    
<%@ include file="sub_menu.html" %>   
  <article>
    <h2>Join Us</h2>
    <form id="join" action="join" method="post" name="formm">
      <fieldset>
        <legend>Basic Info</legend>
        <label>User ID</label>
        <input type="text"      name="sid"  id="id" value="${sid}"  size="12"  >
        <input type="hidden"    name="reid" id="reid" value="${reid}">
        <input type="button"    value="중복 체크"  class="dup" onclick="idcheck()"><br>
        <label>Password</label> 
        <input type="password"  name="pwd" id="pwd"><br> 
        <label>Retype Password</label> 
        <input type="password"  name="pwdCheck" id="pwdCheck"><br> 
        <label>Department</label>
        <select name="dseq" id="dseq">
		    <option value="">--Please choose an option--</option>
		    <option value="1">화학과</option>
		    <option value="2">언론과</option>
		    <option value="3">영문학과</option>
		    <option value="4">국문학과</option>
		    <option value="5">컴퓨터공학과</option>
		    <option value="21">체육학과</option>
		</select><br>
        <label>Name</label>
        <input type="text" name="sname" id="name"><br> 
        <label>E-Mail</label>
        <input type="text" name="email"><br>
		<label>Phone</label>
        <input type="text" name="phone"><br>
        
      </fieldset>
      
      <div class="clear"></div>
      <div id="buttons">
        <input type="button"    value="회원가입"   class="submit" onclick="go_save()"> 
        <input type="reset"      value="취소"     class="cancel">
      </div>
      <br>
    </form>
  </article>
<%@ include file="../footer.jsp" %>
  