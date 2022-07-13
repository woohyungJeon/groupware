<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div id="nav">


	<div class="myCard myInfo">
	
		<span class="myTitle">My</span>
		
		<img class="memberImage">
		
		<div class="myName">
			<span class="memberName"></span>&nbsp;(<span class="memberId"></span>)<br>
			<span class="memberDept"></span><br>
			<span class="memberEmail"></span><br>
			<!-- <span class="loginHistory">최근로그인:2022-04-07 12:17</span> -->
		</div>
		
		<div class="myButtonArea">
			<a href="${pageContext.request.contextPath }/modify">내 정보관리</a>
			<a href="${pageContext.request.contextPath }/logout">로그아웃</a>
		</div>
		
	</div>
	
	<div class="myCard myQuickMemo">
		<span class="myTitle">Quick Memo</span>
		<%-- <img class="editIcon" src="${pageContext.request.contextPath }/resources/img/editIconWhite.png"> --%>
		<span class="editCompleteBtn">완료</span>
		<div class="quickMemoArea">
		<pre></pre>
		
		</div>
		
		<textarea class="quickMemoTa" wrap="hard" rows="7"></textarea>
		
	</div>
	
	<div class="myCard myTnAMenu">
		<span class="myTitle">T&A</span>
		
		<div class="tnaButtonArea">
			<input type="hidden" class="session_memberId" value="${session_memberId }">
			<input type="button" value="출근" class="workStartBtn workBtn">
			<input type="button" value="퇴근" class="workEndBtn workBtn">
		</div>
		
	</div>
	
	<div class="copyrightArea">
	Copyright 2022. team-eroupware<br>All rights reserved.
	</div>
</div>

<input type="hidden" class="toastrMsg" data-type="${magType }" data-msg="${msg}">