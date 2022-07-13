<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<p style="font-size: 25px;
    font-weight: bold;
    width: 300px;
    border-bottom: 1px solid #072a40;
    padding-bottom: 10px;">전자결재</p>
   
	<table class="table">
		<tr class="tr_main">
			<td colspan="6" rowspan="3" class="td_main">지출품의서</td>
			<td colspan="2" class="td_line">결재라인</td>
		</tr>
		<tr class="tr_rank">
			<td class="td_rank1">${eDTO.eapprover1}</td>
			<td class="td_rank2">${eDTO.eapprover2}</td>
		</tr>
		<tr class="tr_sign">
			<td class="td_sign1">${eDTO.estatus1}</td>
			<td class="td_sign2">${eDTO.estatus2}</td>
		</tr>
		<tr class="tr_inform">
			<td class="td_inform1">기안일자</td>
			<td class="td_inform2">${eDTO.edraftDate}</td>
			<td class="td_inform1">기안자</td>
			<td class="td_inform2">${eDTO.edrafter}</td>
			<td class="td_inform1">부서</td>
			<td class="td_inform2">${eDTO.edepartment}</td>
			<td class="td_inform1">직급</td>
			<td class="td_inform2">${eDTO.eposition}</td>
		</tr>
		<tr class="tr_title">
			<td class="td_title1">제목</td>
			<td colspan="7">${eDTO.etitle}</td>
		</tr>
		<tr class="tr_content">
			<td class="td_content1">내용</td>
			<td colspan="7" class="contentTextarea">${eDTO.econtent}</td>
		</tr>
		<tr class="tr_receipt">
			<td class="td_receipt1">영수증<br>첨부</td>
			<td colspan="7" class="td_receipt2"><!-- ${eDTO.filepath}  --></td>
		</tr>
		<tr class="tr_aso">
			<td class="td_aso1">비고</td>
			<td colspan="7"><!-- ${eDTO.etitle}  --></td>
		</tr>
		<tr class="tr_btn">
			<td colspan="8" class="td_btn">
				<input type="button" value="수정하기" onclick="location.href='${pageContext.request.contextPath }/reportExpenseUpdateForm?seq=${eDTO.draft_seq}&pg=${pg}'">
				<input type="button" value="삭제하기" onclick="location.href='${pageContext.request.contextPath }/report/delete/${eDTO.draft_seq}?pg=${pg}'">
				<input type="button" value="메인화면" onclick="location.href='${pageContext.request.contextPath }/reportMain'">
			</td>
		</tr>
	</table>