<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>

<!-- productDetail.jsp 참고 -->
<article>
<h1>과목 상세 보기</h1> 
<form name="frm" id="detail_form" method="post">
	<div>
		<input type="hidden" id="sseq" name="sseq" value="${subjectVO.sseq}"> <br>
		<table id="list">
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
				<td>
					${subjectVO.location}
 					<c:if test="${subjectVO.dseq ==1}">
				        <script type="text/javascript">
					        $(function(){
					        	$('#lat').val( '37.45873723246293' );
						        $('#lng').val( '126.948101522509' );
					        });
					        
				        </script>
			        </c:if>
			        
			        <c:if test="${subjectVO.dseq ==2}">
				        <script type="text/javascript">
				        	$(function(){
				        		 $('#lat').val( '37.46058072061213' );
							     $('#lng').val( '126.95381329738014' );
				        	});
				        </script>
			        </c:if>
			        
			        <c:if test="${subjectVO.dseq ==3}">
				        <script type="text/javascript">
				        $(function(){
				        	 $('#lat').val( '37.46058072061213' );
						     $('#lng').val( '126.95381329738014' );
			        	});
					       
				        </script>
			        </c:if>
			        
			        <c:if test="${subjectVO.dseq ==4}">
				        <script type="text/javascript">
				        $(function(){
				        	$('#lat').val( '37.46058072061213' );
					        $('#lng').val( '126.95381329738014' );
			        	});
					        
				        </script>
			        </c:if>
			        
			        <c:if test="${subjectVO.dseq ==5}">
				        <script type="text/javascript">
				        $(function(){
				        	$('#lat').val( '37.45625477115274' );
					        $('#lng').val( '126.95068162732704' );
			        	});
					        
				        </script>
			        </c:if>
			        
			        <c:if test="${subjectVO.dseq ==6}">
				        <script type="text/javascript">
				        $(function(){
				        	 $('#lat').val( '37.46158990403721' );
						     $('#lng').val( '126.95094634186978' );
			        	});
					       
				        </script>
			        </c:if>
			        
			        <c:if test="${subjectVO.dseq ==21}">
				        <script type="text/javascript">
				        $(function(){
				        	 $('#lat').val( '37.46746822713338' );
						     $('#lng').val( '126.95225408726452' );
			        	});
					       
				        </script>
			        </c:if>
					<input type="hidden" name="lat" id="lat">
					<input type="hidden" name="lng" id="lng">
				</td>
			</tr>
		    
		    
		    <tr>
		    <!-- 지도[s] -->    
		    	<td colspan="2">
		    		<div id="map" style="width:680px;height:260px; margin:auto; margin-top:10px;"></div>
		    	</td>
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
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b689048b4155877ce6273042dc0db7f9"></script>
    <script>
    $(document).ready(function() {
    		var lat = $('#lat').val();
    		var lng = $('#lng').val();
    		
    		//alert(lat);
    		//alert(lng);
    		
		    var container = document.getElementById('map'); //지도 표시 div
		    
		    var options = {
		          center: new kakao.maps.LatLng(lat, lng), //지도의 중심좌표
		          level: 3 //지도의 확대 레벨
		       };
		 
		    var map = new kakao.maps.Map(container, options);
		        
		        // 마커가 표시될 위치
		    var markerPosition  = new kakao.maps.LatLng(lat, lng); 
		 
		        // 마커 생성
		    var marker = new kakao.maps.Marker({
		            position: markerPosition
		        });
		 
		        // 마커가 지도 위에 표시되도록 설정
		    marker.setMap(map);
		 
		        // 아래 코드는 지도 위의 마커를 제거하는 코드
		        // marker.setMap(null);  
    });	        
	</script>
	<!-- 지도[e] -->	
</body>
</html>






