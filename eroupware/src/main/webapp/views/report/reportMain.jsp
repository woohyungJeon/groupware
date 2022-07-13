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
	<p id="reportMain" class="report"> ∨ 상신하기 </p>
	<a href="${pageContext.request.contextPath }/reportExpenseWriteForm" class="list"> ＋ 지출품의서</a><br>
	<a href="${pageContext.request.contextPath }/reportCooperateWriteForm" class="list"> ＋ 업무협조요청서</a><br>
	<a href="${pageContext.request.contextPath }/reportVacationWriteForm" class="list"> ＋ 휴가신청서</a><br>
		
	<p class="report"> ∨ 상신함 </p>
	<a href="${pageContext.request.contextPath }/reportExpenseList" class="list"> ＋ 지출품의서 상신함</a><br>
	<a href="${pageContext.request.contextPath }/reportCooperateList" class="list"> ＋ 업무협조요청서 상신함</a><br>
	<a href="${pageContext.request.contextPath }/reportVacationList" class="list"> ＋ 휴가신청서 상신함</a><br>
	
	<p class="report"> ∨ 수신함 </p>
	<a href="${pageContext.request.contextPath }/reportExpenseReceptionList" class="list"> ＋ 지출품의서 수신함</a><br>
	<a href="${pageContext.request.contextPath }/reportCooperateReceptionList" class="list"> ＋ 업무협조요청서 수신함</a><br>
	<a href="${pageContext.request.contextPath }/reportVacationReceptionList" class="list"> ＋ 휴가신청서 수신함</a><br>
	</div>
	
	
	
	
	
	
	
	
	