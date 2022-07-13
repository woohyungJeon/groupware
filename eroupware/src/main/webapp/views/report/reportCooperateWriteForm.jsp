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
   

<form action="${pageContext.request.contextPath }/reportCooperateWrite" method="post" class="reportForm" name="reportCooperateWriteForm">
	<table class="table">
		<tr class="tr_main">
			<td colspan="6" rowspan="3" class="td_main">업무협조요청서</td>
			<td colspan="2" class="td_line">결재라인</td>
		</tr>
		<tr class="tr_rank">
			<td colspan="2">
				<input type="text" class="td_rank td_member_input" readonly="readonly" placeholder="(* 결재권자 선택)">
			</td>
		</tr>
		<tr class="tr_sign">
			<td class="tr_sign1" colspan="2"></td>
		</tr>
		<tr class="tr_inform">
			<td class="td_inform1">기안일자</td>
			<td class="td_inform2 td_reportDay"></td>
			<td class="td_inform1">기안자</td>
			<td class="td_inform2">
				<input type="text" class="informInput" name="r_drafter" value="${memberDTO.name}">
				<input type="hidden" name="r_id" value="${session_memberId}">
			</td>
			<td class="td_inform1">부서</td>
			<td class="td_inform2">
				<input type="text" class="informInput" name="r_department" value="${memberDTO.deptname}">
			</td>
			<td class="td_inform1">직급</td>
			<td class="td_inform2">
				<input type="text" class="informInput" name="r_position" value="${memberDTO.rankname}">
			</td>
		</tr>
		<tr class="tr_title">
			<td class="td_title1">제목</td>
			<td colspan="7">
				<input type="text" name="r_title" class="titleInput" placeholder=" ( * 필수입력 : [업무협조요청서] - 제목 ) " value="[업무협조요청서] - ">
			</td>
		</tr>
		<tr class="tr_content">
			<td class="td_content1">내용</td>
			<td colspan="7">
				<textarea name="r_content" class="contentTextarea" placeholder=" ( * 필수입력 : 내용을 입력하세요 )"></textarea>
			</td>
		<tr class="tr_aso">
			<td class="td_aso1">비고</td>
			<td colspan="7">
				<input type="text" name="r_aso" class="asoInput">
			</td>
		</tr>
		<tr class="tr_btn">
			<td colspan="8" class="td_btn">
				<input type="submit" value="기안하기">
				<input type="reset" value="다시작성">
				<input type="button" value="메인화면" id="btn" onclick="location.href='${pageContext.request.contextPath }/report'">
			</td>
		</tr>
	</table>
</form>

<!-- 결재권자 선택 모달 -->
<div class="reportModal modal-overlay">
	<div class="inputArea">
	<span class="modalCloseBtn">ｘ</span>
		<div class="inputMemberArea" >
			<p class="inputMemberTitle">결재권자 선택</p><br>
			<div class="selectMemberArea" id="memberComboTree">
				<tiles:insertDefinition name="department_selectbox"></tiles:insertDefinition>
			</div>
		</div>
	</div>
</div>