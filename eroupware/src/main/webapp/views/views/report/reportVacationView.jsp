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
    padding-bottom: 10px;">전자결재</p>
   
	<table class="table">
		<tr class="tr_main">
			<td colspan="6" rowspan="3" class="td_main">휴가신청서</td>
			<td colspan="2" class="td_line">결재라인</td>
		</tr>
		<tr class="tr_rank">
			<td class="td_rank1">${vDTO.vapprover1}</td>
			<td class="td_rank2">${vDTO.vapprover2}</td>
		</tr>
		<tr class="tr_sign">
			<td class="td_sign1">${vDTO.vstatus1}</td>
			<td class="td_sign2">${vDTO.vstatus2}</td>
		</tr>
		<tr class="tr_inform">
			<td class="td_inform1">기안일자</td>
			<td class="td_inform2">${vDTO.vdraftDate}</td>
			<td class="td_inform1">기안자</td>
			<td class="td_inform2">${vDTO.vdrafter}</td>
			<td class="td_inform1">부서</td>
			<td class="td_inform2">${vDTO.vdepartment}</td>
			<td class="td_inform1">직급</td>
			<td class="td_inform2">${vDTO.vposition}</td>
		<tr class="tr_kinds">
			<td class="td_kinds1">휴가종류</td>
			<td colspan="7" class="kindsInput">${vDTO.vtype}</td>
		</tr>
		<tr class="tr_date">
			<td class="td_date1">휴가신청<br>날짜</td>
			<td colspan="7" class="dateInput">${vDTO.vStart}</td>
		</tr>
		<tr class="tr_title">
			<td class="td_title1">제목</td>
			<td colspan="7" class="titleInput">${vDTO.vtitle}</td>
		</tr>
		<tr class="tr_content">
			<td class="td_content1">내용</td>
			<td colspan="7" class="contentTextarea">${vDTO.vcontent}</td>
		<tr class="tr_aso">
			<td class="td_aso1">비고</td>
			<td colspan="7" class="asoInput"><!-- ${vDTO.aso} --></td>
		</tr>
		<tr class="tr_btn">
			<td colspan="8" class="td_btn">
				<input type="button" value="수정하기" onclick="location.href='${pageContext.request.contextPath }/reportVacationUpdateForm?seq=${vDTO.draft_seq}&pg=${pg}'">
				<input type="button" value="삭제하기" onclick="location.href='${pageContext.request.contextPath }/report/delete/${vDTO.draft_seq}?pg=${pg}'">
				<input type="button" value="메인화면" onclick="location.href='${pageContext.request.contextPath }/reportMain'">
			</td>
		</tr>
	</table>