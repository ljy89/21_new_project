<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %> 
<%@ include file="sub_menu.html" %>       
  <article>
    <h1>Login</h1>
    <form method="post" action="login">
        <fieldset>
        <legend></legend>
          <label>User ID </label>&nbsp
          <input name="sid" type="text"><br> 
          <label>Password</label> 
           <input name="pwd" type="password"><br> 
        </fieldset>
        
        <div class="clear"></div>
        <div id="buttons">
            <input type="submit" value="로그인" class="submit">
            <input type="button" value="회원가입" class="cancel" onclick="location='join'">   
        </div>
    </form>  
  </article>
<%@ include file="../footer.jsp" %>      
