<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>학사관리 시스템</title>
  <link rel="stylesheet" href="css/system.css" >  
  <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script> 
   <script type="text/javascript" src="student/member.js"></script>
  <script type="text/javascript" src="slide.js"></script>
</head>

<body>
<div id="wrap">
<!--헤더파일 들어가는 곳 시작 -->
  <header>
          <div id="logo">
            <a href="index.html">
              <h1>학사시스템</h1>
            </a>
          </div>
          <nav id="catagory_menu">
            <ul>
              <c:choose>
              <c:when test="${empty sessionScope.loginUser}">
              <li>         
                <a href="login_form" style="width:110px;">LOGIN(student)</a>
                <a href="professor_login_form" style="width:110px;">professor</a>
                <a href="admin_login_form" style="width:110px;">admin</a>
              </li>		       
              
              <li><a href="join">JOIN</a></li>
              </c:when>
              <c:otherwise>
              <li style="color:orange">
                ${sessionScope.loginUser.sname}(${sessionScope.loginUser.sid})
              </li>
              <li><a href="logout">LOGOUT</a></li>
              </c:otherwise>       
              </c:choose>
              
            </ul>
           </nav>
          <nav>
            <ul id="topMenu">
              <li><a href="#">과목조회 <span>▼</span></a>
                <ul>
                  <li><a href="major">전공과목</a></li>
                  <li><a href="liberalArts">교양과목</a></li>
                </ul>
              </li>
              <li><a href="#">수강신청내역 <span>▼</span></a>
                <ul>
                  <li><a href="#">예비장바구니</a></li>
                  <li><a href="#">내 수업내역</a></li>
                </ul>
              </li>
              <li><a href="studentDetail">마이페이지</a></li>
              <li><a href="#">게시판 <span>▼</span></a>
                <ul>
                  <li><a href="#">공지사항</a></li>
                  <li><a href="#">문의게시판</a></li>
                </ul>
              </li>
            </ul>
          </nav>
          <div class="clear"></div>
        </header>
  <!--헤더파일 들어가는 곳 끝 -->