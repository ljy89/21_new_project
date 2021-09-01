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
        <div id="contents">
          <div id="tabMenu">
            <input type="radio" id="tab1" name="tabs" checked>
            <label for="tab1">공지사항</label>
            <input type="radio" id="tab2" name="tabs">
            <label for="tab2">Q&A</label>      
            <div id="notice" class="tabContent">
              <h2>공지사항 내용입니다.</h2>
              <ul>            
                <li>사무실을 이전했습니다</li>
                <li>[참가 모집] 카약 체험에 초대합니다.</li>
                <li>[참가 모집] 여름 방학 기간, 오름 체험단을 모집합니다.</li>
                <li>겨울, 추천 여행지</li>
                <li>가을, 추천 여행지</li>            
              </ul>
            </div>
            <div id="gallery" class="tabContent">
              <h2>갤러리 내용입니다.</h2>
              <ul>
                <li><img src="images/img-1.jpg"></li>
                <li><img src="images/img-2.jpg"></li>
                <li><img src="images/img-3.jpg"></li>
                <li><img src="images/img-1.jpg"></li>
                <li><img src="images/img-2.jpg"></li>
                <li><img src="images/img-3.jpg"></li>                     
              </ul>
            </div>        
          </div>
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