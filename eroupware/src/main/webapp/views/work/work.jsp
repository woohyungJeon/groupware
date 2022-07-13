<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<p style="font-size: 25px;
    font-weight: bold;
    width: 300px;
    border-bottom: 1px solid black;
    padding-bottom: 10px;">근태관리</p>
    
<div class="workMainArea">
	
	<div class="workListArea">
	
		<div class="monthSelectArea">
			<div class="datepickerArea"></div>
			<c:if test="${month == 1 }">
				<a href="${pageContext.request.contextPath }/work?year=${year-1}&month=12" class="monthSelectButton">&lt;</a>
			</c:if>
			
			<c:if test="${month != 1 }">
				<a href="${pageContext.request.contextPath }/work?year=${year}&month=${month-1}" class="monthSelectButton">&lt;</a>
			</c:if>
			
			<c:if test="${month < 10 }">
				<%-- <span class="monthSelectSpan">${year }.0${month }</span> --%>
				<input type="text" class="test" readonly="readonly" value="${year }.0${month }">
			</c:if>
			
			<input type="hidden" class="date_og" value="${year }.${month }">
			
			<c:if test="${month > 9 }">
				<%-- <span class="monthSelectSpan">${year }.${month}</span> --%>
				<input type="text" class="test" readonly="readonly" value="${year }.${month }">
			</c:if>
	
			<c:if test="${month == 12 }">
				<a href="${pageContext.request.contextPath }/work?year=${year+1}&month=1" class="monthSelectButton">&gt;</a>
			</c:if>
			
			<c:if test="${month != 12 }">
				<a href="${pageContext.request.contextPath }/work?year=${year}&month=${month+1}" class="monthSelectButton">&gt;</a>
			</c:if>
			
		</div>
		
		<div class="tableArea">
		<table>
			<tr class="title">
				<td width="24%">날짜</td>
				<td width="19%">출근시각</td>
				<td width="19%">출근IP</td>
				<td width="19%">퇴근시각</td>
				<td width="19%">퇴근IP</td>
			</tr>
			
			<c:forEach var="workListDTO" items="${workList }">
				<tr class="workList">
					<td>
						<span class="workDateSpan">${workListDTO.workDate }</span>
						<c:choose>
							<c:when test="${workListDTO.dayOfWeek ==  '일'}">
								<span class="dayOfWeekSpan sun">${workListDTO.dayOfWeek }</span>
							</c:when>
							<c:when test="${workListDTO.dayOfWeek ==  '토'}">
								<span class="dayOfWeekSpan sat">${workListDTO.dayOfWeek }</span>
							</c:when>
							<c:otherwise>
								<span class="dayOfWeekSpan">${workListDTO.dayOfWeek }</span>
							</c:otherwise>
						</c:choose>
					</td>
					<td>${workListDTO.startTime }</td>
					<td>${workListDTO.startIp }</td>
					<td>${workListDTO.endTime }</td>
					<td>${workListDTO.endIp }</td>
				</tr>
			</c:forEach>
				
		</table>
		</div>

	</div>

</div>
    