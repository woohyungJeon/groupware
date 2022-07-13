<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div id="header">

	<span class="headerLogo">EROUPWARE</span>
	
	<div id="headerMenu">

	<ul>
		<li><a href="${pageContext.request.contextPath }/admin/member">회원관리</a>
		</li>
		
		<li><a href="${pageContext.request.contextPath }/admin/notice">게시판</a>
		<ul class="sub sub2">
              <li><a href="${pageContext.request.contextPath }/admin/notice">공지사항</a></li>
              <li><a href="${pageContext.request.contextPath }/admin/anony">익명 게시판</a></li>
        </ul>
		</li>
		
	</ul>

	</div>
	<a href="${pageContext.request.contextPath }/logout" class="adminLogoutBtn">로그아웃</a>
	<span class="headerTime"></span>
</div>

