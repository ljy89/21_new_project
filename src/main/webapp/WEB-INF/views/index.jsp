<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>  

 <script>
  $(document).ready(function(){
	  var slideIndex = 1;
	  showSlides(slideIndex);
	  
  });
 </script>
  <div class="clear"></div>   

  <div id="front"> 
  		<!-- 슬라이드 시작 -->  
	     <!-- Slideshow container -->
	<div class="slideshow-container">
	
	    <!-- Full-width images with number and caption text -->
	    <div class="mySlides fade">
	      <div class="numbertext">1 / 3</div>
	      <img src="images/photo-2.jpg" style="width:100%">
	     
	    </div>
	  
	    <div class="mySlides fade">
	      <div class="numbertext">2 / 3</div>
	      <img src="images/photo-1.jpg" style="width:100%">
	     
	    </div>
	  
	    <div class="mySlides fade">
	      <div class="numbertext">3 / 3</div>
	      <img src="images/photo-3.jpg" style="width:100%">
	      
	    </div>
	  
	    <!-- Next and previous buttons -->
	    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
	    <a class="next" onclick="plusSlides(1)">&#10095;</a>
	  </div>
	  <br>
	  
	  <!-- The dots/circles -->
	  <div style="text-align:center">
	    <span class="dot" onclick="currentSlide(1)"></span>
	    <span class="dot" onclick="currentSlide(2)"></span>
	    <span class="dot" onclick="currentSlide(3)"></span>
	  </div>
        
        <!-- 슬라이드 끝 -->
        <!-- 공지 목록 시작 -->
         <div id="contents">
          <div id="tabMenu">
            <input type="radio" id="tab1" name="tabs" checked>
            <label for="tab1">공지사항</label>
            <input type="radio" id="tab2" name="tabs">
            <label for="tab2">자유게시판</label>      
            <div id="notice" class="tabContent">
              <h2>공지사항</h2>
              <form name="fmm" id="index_ann_form" method="post">
              <c:forEach items="${annList}" var="announcementVO">
              <ul>
                <li>
                	<input type="hidden" name="aseq" value="${announcementVO.aseq}">
                	<a href="#" onclick="index_ann_detail('${announcementVO.aseq}')">
    	 				${announcementVO.subject}     
   					</a>
   				</li>
              </ul>
              </c:forEach> 
              </form>
            </div>
            <!-- 공지 끝 -->
            <!-- 게시판 목록 시작 -->
             <div id="gallery" class="tabContent">
              <h2>자유 게시판</h2>
              <form name="fmm" id="index_board_form" method="post">
              <c:forEach items="${noticeList}" var="noticeVO">
	              <ul>
	               <li>
                	<input type="hidden" name="nseq" value="${noticeVO.nseq}">
                	<a href="#" onclick="index_board_detail('${noticeVO.nseq}')">
    	 				${noticeVO.subject}     
   					</a>
   				</li>          
	              </ul>
	           </c:forEach> 
              </form>
            </div>        
          </div>
          <!-- 게시판 목록 끝 -->
          <div id="links">
            <ul>
              <li>
                <a href="major_list">
                  <span id="quick-icon1"></span>
                  <p>과목조회</p>
                </a>
              </li>
              <li>
                <a href="my_register_list">
                  <span id="quick-icon2"></span>
                  <p>내수강내역</p>
                </a>            
              </li>
              <li>
                <a href="qna_list">
                  <span id="quick-icon3"></span>
                  <p>문의하기</p>
                </a>            
              </li>
            </ul>
          </div>
        </div>  
	  <div class="clear"></div>
  </div>
    
<%@ include file="footer.jsp" %>    