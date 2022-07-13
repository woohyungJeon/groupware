<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<p style="font-size: 25px;
    font-weight: bold;
    width: 300px;
    border-bottom: 1px solid black;
    padding-bottom: 10px;">전자결재 수신함</p>
   

	<table class="table">
		<tr class="tr_main">
			<td colspan="6" rowspan="3" class="td_main titleTd">수신 휴가신청서</td>
			<td colspan="2" class="td_line titleTd">결재라인</td>
		</tr>
		<tr class="tr_rank">
		<td colspan="2" class="td_rank td_member_input">${r_approver.rankname }&nbsp;${r_approver.name }</td>
	</tr>
		<tr class="tr_sign">
			<td colspan="2" class="td_sign">
				<c:if test="${vReportDTO.r_status == 'Y' }">
					승인
				</c:if>
				<c:if test="${vReportDTO.r_status == 'N' }">
					대기
				</c:if>
				<c:if test="${vReportDTO.r_status == 'F' }">
					반려
				</c:if>
			</td>
		</tr>
		<tr class="tr_inform">
			<td class="td_inform1 titleTd">기안일자</td>
			<td class="td_inform2 td_reportDay">
				<fmt:parseDate value="${vReportDTO.r_draftDate }" var="registered" pattern="yyyy-MM-dd" />
				<fmt:formatDate value="${registered}" pattern="yyyy-MM-dd" />
			</td>
			<td class="td_inform1 titleTd">기안자</td>
			<td class="td_inform2">${vReportDTO.r_drafter }</td>
			<td class="td_inform1 titleTd">부서</td>
			<td class="td_inform2">	${vReportDTO.r_department }</td>
			<td class="td_inform1 titleTd">직급</td>
			<td class="td_inform2">${vReportDTO.r_position }</td>
		</tr>
		<tr class="tr_kinds">
			<td class="td_kinds1 titleTd">휴가종류</td>
			<td class="td_kinds2 outputTd" colspan="7">${vReportDTO.r_type }</td>
		</tr>
		<tr class="tr_date">
			<td class="td_date1 titleTd">휴가신청<br>날짜</td>
			<td class="td_date2 outputTd" colspan="7">${vReportDTO.r_Start }</td>
		</tr>
		<tr class="tr_title">
			<td class="td_title1 titleTd">제목</td>
			<td class="td_title2 outputTd" colspan="7">${vReportDTO.r_title }</td>
		</tr>
		<tr class="tr_content">
			<td class="td_content1 titleTd">내용</td>
			<td class="td_content2 outputTd" colspan="7">${vReportDTO.r_content }</td>
		<tr class="tr_aso">
			<td class="td_aso1 titleTd">비고</td>
			<td class="td_aso2 outputTd" colspan="7">${vReportDTO.r_aso }</td>
		</tr>
		<tr class="tr_btn">
			<td colspan="8" class="td_btn">
				<input type="hidden" class="seq_ew_draft" value="${vReportDTO.seq_ew_draft}">
					<c:if test="${vReportDTO.r_status == 'N' }">
						<input type="button" value="승인" class="approveBtn reportBtn">
						&nbsp;&nbsp;
						<input type="button" value="반려" class="refuseBtn reportBtn">
					</c:if>
				&nbsp;&nbsp;
				<input type="button" value="뒤로가기" id="btn" onclick="location.href='${pageContext.request.contextPath }/reportVacationReceptionList'">
				&nbsp;&nbsp;
				<input type="button" value="메인화면" id="btn" onclick="location.href='${pageContext.request.contextPath }/report'">
			</td>
		</tr>
	</table>