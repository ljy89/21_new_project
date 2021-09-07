<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 신청</title>
<link href="CSS/subpage.css" rel="stylesheet">
<style type="text/css">
body{   
  background-color: #987C4D;
  color : white;
  font-family: Verdana;
}
#wrap{     
  margin: 0 20px;
}

div .pop_button{
	
margin-left: 110px;
}

</style>
<script type="text/javascript">
function cart_pop_close(){
  
  self.close();
}
</script>
</head>
<body>
<div id="wrap">
 
  <form method=post name=formm id="theform" style="margin-right:0 "
  		action="register_check_form" >
 
    <div style="margin-top: 20px">   
      <c:if test="${message == 1}">
        <script type="text/javascript">
          opener.document.formm.sseq.value="";
        </script>
        ${register.subname} 이미 수강 신청한 과목입니다<br><br>
        <div class="pop_button">
        	 <input type="button" class="submit" value="확인" class="cancel" onclick="cart_pop_close()">
        </div>
      </c:if>
      
      <c:if test="${message==-1}">
        ${register.subname} 시간에 수강 신청한 과목이 있습니다<br><br>
        <div class="pop_button">
        	<input type="button" class="submit" value="확인" class="cancel" onclick="cart_pop_close()">
        </div>
        
      </c:if>
      
      <c:if test="${message==0}">
        ${register.subname} 수강 신청이 완료되었습니다.<br><br>
        <div class="pop_button">
        	<input type="button" class="submit" value="확인" class="cancel" onclick="cart_pop_close()">
        </div>
        
      </c:if>
    </div>
  </form>
</div>  
</body>
</html>