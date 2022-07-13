<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="mainWrap">

	<!-- 공지사항 영역 -->
	<div class="area noticeArea">
		<span class="mainTitleSpan">공지사항</span>
		<input type="button" value="바로가기 >" class="listButton">
		<table>
			<tr>
				<td width="10%">번호</td>
				<td width="*">제목</td>
				<td width="25%">작성일</td>
				<td width="15%">조회수</td>
			</tr>
			
			<c:forEach var="noticeDTO" items="${noticeList }">
				<tr class="noticeList" data-seq="${noticeDTO.seq }">
					<td>${noticeDTO.seq }</td>
					<td class="titleTd">${noticeDTO.title }</td>
					<td>${noticeDTO.logtime }</td>
					<td>${noticeDTO.hit }</td>
				</tr>
			</c:forEach>
			
			
		</table>
	
	</div>
	
	<!-- 달력 영역 -->
	<div class="area calendarArea">
		<div class="cal_top">
	        <a href="#" id="movePrevMonth">
	        	<span id="prevMonth" class="cal_tit">&lt;&nbsp;</span>
        	</a>
	        
	        <span id="cal_top_year"></span>
	        <span id="cal_top_month"></span>
	        
	        <a href="#" id="moveNextMonth">
	        	<span id="nextMonth" class="cal_tit">&nbsp;&gt;</span>
        	</a>
        	
	    </div>
	    
	    <div id="cal_tab" class="cal">
	    </div>
	</div>
	
	<!-- 전자결재 영역 -->
	<div class="area reportArea">
		<span class="mainTitleSpan">전자결재</span>
		<input type="button" value="바로가기 >" class="listButton" onclick="location.href='${pageContext.request.contextPath}/report'">
		<div class="reportCardArea">
		<div class="reportCntDiv">
			<span class="reportCntTitle">대기</span>
			<span class="reportCntVal">${reportCountDTO.cnt_n}</span>
		</div>
		
		<div class="reportCntDiv">
			<span class="reportCntTitle">승인</span>
			<span class="reportCntVal">${reportCountDTO.cnt_y}</span>
		</div>
		 
		<div class="reportCntDiv">
			<span class="reportCntTitle">반려</span>
			<span class="reportCntVal">${reportCountDTO.cnt_f}</span>
		</div>
		
		<div class="reportCntDiv receiveArea">
			<span class="reportCntTitle">
				<img src="${pageContext.request.contextPath }/resources/img/report.png">
			</span>
			<span class="reportCntVal">${reportCountDTO.cnt_r}</span>
		</div>
			
		<table>
			<c:forEach var="reportListDTO" items="${reportList }">
			<tr onclick="location.href='${pageContext.request.contextPath}/report${reportListDTO.type}ReceptionView/${reportListDTO.seq_ew_draft }'">
				<td class="reportTitleTd">${reportListDTO.r_title }
					<%-- <c:if test="${reportListDTO.type == 'expense' }">
					[지출품의서]-${reportListDTO.r_title }
					</c:if>
					
					<c:if test="${reportListDTO.type == 'vacation' }">
					[휴가신청서]-${reportListDTO.r_title }
					</c:if>
					
					<c:if test="${reportListDTO.type == 'cooperate' }">
					[업무협조요청서]-${reportListDTO.r_title }
					</c:if> --%>
				</td>
				<td width="25%">${reportListDTO.r_position }&nbsp;${reportListDTO.r_drafter }</td>
				<td width="25%">${reportListDTO.r_draftDate }</td>
			</tr>
			</c:forEach>
		</table>
		
		</div>
	</div>
	
	<!-- 프로젝트 영역 -->
	<div class="area">
		<span class="mainTitleSpan">프로젝트</span>
		<input type="button" value="바로가기 >" class="listButton" onclick="location.href='${pageContext.request.contextPath}/project'">
		<div class="projectCardArea">
			<c:forEach var="projectListDTO" items="${projectList }">
				<div class="projectCard" onclick="location.href='${pageContext.request.contextPath}/project/${projectListDTO.projectNo }'" style="background: ${projectListDTO.color }">
					<span class="projectCardTitleSpan">${projectListDTO.title }</span>
					<span class="projectCardMemberSpan">${projectListDTO.pmembers }명 참여중</span>
					<span class="projectCardPercentSpan" data-percent="${projectListDTO.percent }"></span>
				</div>
			</c:forEach>
		
		</div>
	
	</div>


</div>
	
