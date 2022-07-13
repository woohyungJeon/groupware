<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<p style="font-size: 25px;
   		 font-weight: bold;
   		 width: 300px;
   		 border-bottom: 1px solid black;
   		 padding-bottom: 10px;">내 정보관리</p>	

<div class="pwdCheckWrap">
<form class="passwordCheckForm" onsubmit="return false">
	<input type="hidden" id="memberId" value="${session_memberId }">
	<p class="title">비밀번호 확인</p>
	<p class="info">내 정보수정을 위해 비밀번호를 입력해주세요</p>
	<input type="password" name="password" class="password">
	<input type="submit" value="확인" class="confirmBtn">
	<a href="javascript:history.back()">취소</a>
</form>

</div>
	
