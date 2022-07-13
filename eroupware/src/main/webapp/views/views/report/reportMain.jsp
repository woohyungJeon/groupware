<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 
	전자결재안의 메인페이지
	
	전자결재
	------
	
	> 상신하기
		--지출품의서
		--업무협조요청서
		--휴가신청서
	> 문서함
		--상신함
		--수신함
 -->
 <p style="font-size: 25px;
    font-weight: bold;
    width: 300px;
    border-bottom: 1px solid black;
    padding-bottom: 10px;">전자결재</p>
    
    <div class="reportMainArea">
	<p id="reportMain" class="draft"> [ ▼ 상신하기	 ] </p>
	<a href="${pageContext.request.contextPath }/expense" class="expense">☞지출품의서</a><br><br>
	<a href="${pageContext.request.contextPath }/cooperate" class="cooperate">☞업무협조요청서</a><br><br>
	<a href="${pageContext.request.contextPath }/vacation" class="vacation">☞휴가신청서</a><br><br><br>
		
	<p class="reception"> [ ▼ 문서함	 ] </p>
	<a href="${pageContext.request.contextPath }/listDraft" class="listDraft">☞상신함</a><br><br>
	<a href="${pageContext.request.contextPath }/listReception" class="listReception">☞수신함</a><br>
	</div>