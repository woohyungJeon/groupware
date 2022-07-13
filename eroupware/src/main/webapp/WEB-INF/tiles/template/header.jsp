<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div id="header">

	<span class="headerLogo">EROUPWARE</span>
	
	<div id="headerMenu">

	<ul>
		<li><a href="${pageContext.request.contextPath }/contact">주소록</a>
		<!-- <ul class="sub sub1">
              <li><a href="#">개인 주소록</a></li>
              <li><a href="#">공유 주소록</a></li>
              <li><a href="#">중요 주소록</a></li>
        </ul> -->
		</li>
		
		<!-- <li><a href="#">캘린더</a>
		<ul class="sub sub2">
              <li><a href="#">내 캘린더</a></li>
              <li><a href="#">공유 캘린더</a></li>
              <li><a href="#">일정 추가</a></li>
        </ul>
		</li> -->
		
		<li><a href="${pageContext.request.contextPath }/report">전자결재</a>
		<!-- <ul class="sub sub3">
              <li><a href="#">진행중인 문서</a></li>
              <li><a href="#">문서함</a></li>
        </ul> -->
		</li>
		
		<li><a href="${pageContext.request.contextPath }/todo">업무관리</a>
		<ul class="sub sub4">
              <li><a href="${pageContext.request.contextPath }/todo">개인업무</a></li>
              <li><a href="${pageContext.request.contextPath }/project">프로젝트</a></li>
        </ul>
		</li>
		
		<li><a href="${pageContext.request.contextPath }/notice">게시판</a>
		<ul class="sub sub5">
              <li><a href="${pageContext.request.contextPath }/notice">공지사항</a></li>
              <li><a href="${pageContext.request.contextPath }/anony">익명 게시판</a></li>
        </ul>
		</li>
		
		<li><a href="${pageContext.request.contextPath }/work">근태관리</a></li>
	</ul>

	</div>
	
	<span class="headerTime"></span>
</div>

