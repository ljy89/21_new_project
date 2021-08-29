<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>
<style>
body {
	width: 100%;
}

table {
	border: 1px solid #ccc; 
}
th {
	background: #DADAD5;
	width: 100px;
}

td {
	height : 46px;
	text-align: center;
}
</style>


<article>
<br>
<h1>시 간 표</h1> 
    
<form action="time_table" method="get">
	<input type="submit" value="시간표 확인">
</form>
<br>
  <div class="schedule" style="display:block;">
  	<table class="timeTable">
  		<thead class="timeTableHead">
  		  <tr>
  		  	<th>월</th><th>화</th><th>수</th><th>목</th><th>금</th>
  		  </tr>
  		</thead>
  		<tbody class="timeTableBody">
  		  <c:forEach items="${schedules}" var="row">
  		  	<tr>
	  		  	<c:forEach items="${row}" var="item">
	  		  	<td>${item}</td>
	  		  	</c:forEach>
  		  	</tr>
  		  </c:forEach>
  		</tbody>
  	</table> 
  </div>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>