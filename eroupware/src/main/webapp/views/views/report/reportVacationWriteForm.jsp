<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="../js/views/report/report.js?v=1"></script>

<p style="font-size: 25px;
    font-weight: bold;
    width: 300px;
    border-bottom: 1px solid black;
    padding-bottom: 10px;">전자결재</p>
   

<form action="${pageContext.request.contextPath }/vacationInsertCheck" method="get" name="vacationInsertCheck">
	<table class="table">
		<tr class="tr_main">
			<td colspan="6" rowspan="3" class="td_main">휴가신청서</td>
			<td colspan="2" class="td_line">결재라인</td>
		</tr>
		<tr class="tr_rank">
			<td class="td_rank1" name="vapprover1">부서장</td>
			<td class="td_rank2" name="vapprover2">대표이사</td>
		</tr>
		<tr class="tr_sign">
			<td class="td_sign1" name="vstatus1"></td>
			<td class="td_sign2" name="vstatus2"></td>
		</tr>
		<tr class="tr_inform">
			<td class="td_inform1">기안일자</td>
			<td class="td_inform2">
				<input type="text" name="vdraftDate" class="informInput">
			</td>
			<td class="td_inform1">기안자</td>
			<td class="td_inform2">
				<input type="text" name="vdrafter" class="informInput">
			</td>
			<td class="td_inform1">부서</td>
			<td class="td_inform2">
				<input type="text" name="vdepartment" class="informInput">
			</td>
			<td class="td_inform1">직급</td>
			<td class="td_inform2">
				<input type="text" name="vposition" class="informInput">
			</td>
		<tr class="tr_kinds">
			<td class="td_kinds1">휴가종류</td>
			<td colspan="7">
				<input type="radio" name="vacationKinds" value="정기">정기
				<input type="radio" name="vacationKinds" value="연차">연차
				<input type="radio" name="vacationKinds" value="반차">반차
				<input type="radio" name="vacationKinds" value="병가">병가
				<input type="radio" name="vacationKinds" value="기타">기타
			</td>
		</tr>
		<tr class="tr_date">
			<td class="td_date1">휴가신청<br>날짜</td>
			<td colspan="7">
				<input type="text" name="vstart" class="dateInput"  placeholder="*날짜를 입력하세요">
			</td>
		</tr>
		<tr class="tr_title">
			<td class="td_title1">제목</td>
			<td colspan="7">
				<input type="text" name="vtitle" class="titleInput"  placeholder="*[휴가신청서] - 휴가종류 ">
			</td>
		</tr>
		<tr class="tr_content">
			<td class="td_content1">내용</td>
			<td colspan="7">
				<textarea name="vcontent" class="contentTextarea"  placeholder="*내용을 입력하세요"></textarea>
			</td>
		<tr class="tr_aso">
			<td class="td_aso1">비고</td>
			<td colspan="7">
				<input type="text" name="vaso" class="asoInput">
			</td>
		</tr>
		<tr class="tr_btn">
			<td colspan="8" class="td_btn">
			<!-- 기안하기 누르면 ListDraft로 redirect -->
				<input type="submit" value="기안하기" onclick="vacationWriteCheck();">
				<input type="reset" value="다시작성">
				<input type="button" value="메인화면" id="btn" onclick="location.href='${pageContext.request.contextPath }/reportMain'">
			</td>
		</tr>
	</table>
</form>