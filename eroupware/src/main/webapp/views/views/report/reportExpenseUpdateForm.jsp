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
   

<form action="${pageContext.request.contextPath }/reportExpenseUpdate" method="get" name="reportExpenseUpdate">
	<table class="table">
		<tr class="tr_main">
			<td colspan="6" rowspan="3" class="td_main">지출품의서</td>
			<td colspan="2" class="td_line">결재라인</td>
		</tr>
		<tr class="tr_rank">
			<td class="td_rank1">
				<input type="text" class="rankInput" name="eapprover1" placeholder="${eDTO.eapprover1}">
			</td>
			<td class="td_rank2">
				<input type="text" class="rankInput" name="eapprover2" placeholder="${eDTO.eapprover2}">
			</td>
		</tr>
		<tr class="tr_sign">
			<td class="td_sign1">
				<input type="text" class="signInput" name="estatus1" placeholder="${eDTO.estatus1}">
			</td>
			<td class="td_sign2">
				<input type="text" class="signInput" name="estatus2" placeholder="${eDTO.estatus2}">
			</td>
		</tr>
		<tr class="tr_inform">
			<td class="td_inform1">기안일자</td>
			<td class="td_inform2">
				<input type="date" class="informInput" name="edraftDate" placeholder="${eDTO.edraftDate}">
			</td>
			<td class="td_inform1">기안자</td>
			<td class="td_inform2">
				<input type="text" class="informInput" name="edrafter" placeholder="${eDTO.edrafter}">
			</td>
			<td class="td_inform1">부서</td>
			<td class="td_inform2">
				<input type="text" class="informInput" name="edepartment" placeholder="${eDTO.edepartment}">
			</td>
			<td class="td_inform1">직급</td>
			<td class="td_inform2">
				<input type="text" class="informInput" name="eposition" placeholder="${eDTO.eposition}">
			</td>
		</tr>
		<tr class="tr_title">
			<td class="td_title1">제목</td>
			<td colspan="7">
				<input type="text" class="titleInput" name="etitle" placeholder="${eDTO.etitle}">
			</td>
		</tr>
		<tr class="tr_content">
			<td class="td_content1">내용</td>
			<td colspan="7">
				<textarea class="contentTextarea" name="econtent" placeholder="${eDTO.econtent}"></textarea>
			</td>
		</tr>
		<tr class="tr_receipt">
			<td class="td_receipt1">영수증<br>첨부</td>
			<td colspan="7" class="td_receipt2">
				<label> ( * 영수증 필수 첨부 ) </label>
				<input type="file" name="filepath" class="teceiptFile"> <!--  placeholder="${eDTO.efilepath}" -->
			</td>
		</tr>
		<tr class="tr_aso">
			<td class="td_aso1">비고</td>
			<td colspan="7">
				<input type="text" name="aso" class="asoInput"> <!-- placeholder="${eDTO.easo}" -->
			</td>
		</tr>
		<tr class="tr_btn">
			<td colspan="8" class="td_btn">
				<input type="submit" value="수정하기">
				<input type="reset" value="다시작성">
				<input type="button" value="메인화면" onclick="location.href='${pageContext.request.contextPath }/reportMain'">
			</td>
		</tr>
	</table>
</form>