<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- <script type="text/javascript" src="../js/views/report/report.js?v=1"></script> -->

<p style="font-size: 25px;
    font-weight: bold;
    width: 300px;
    border-bottom: 1px solid #072a40;
    padding-bottom: 10px;">전자결재</p>
   

<form action="${pageContext.request.contextPath }/expenseInsertCheck" method="post" name="expenseInsertCheck">
	<table class="table">
		<tr class="tr_main">
			<td colspan="6" rowspan="3" class="td_main">지출품의서</td>
			<td colspan="2" class="td_line">결재라인</td>
		</tr>
		<tr class="tr_rank">
			<td class="td_rank1 td_member_input">
				
				<!-- <input type="text" name="eapprover1" class="rankInput" placeholder=" ( * 결재권자(1) ) "> -->
			</td>
			<td class="td_rank2 td_member_input">
				
				<!-- <input type="text" name="eapprover2" class="rankInput" placeholder=" ( * 결재권자(2) ) "> -->
			</td>
		</tr>
		
		
		<tr class="tr_sign">
			<td class="td_sign1">
				<input type="text" name="estatus1" class="signInput" placeholder=" ( * 상신완료 ) ">
			</td>
			<td class="td_sign2">
				<input type="text" name="estatus2" class="signInput" placeholder=" ( * 상신완료 ) ">
			</td>
		</tr>
		<tr class="tr_inform">
			<td class="td_inform1">기안일자</td>
			<td class="td_inform2 td_reportDay">
				<!-- <input type="date" name="edraftDate" class="informInput" > -->
			</td>
			<td class="td_inform1">기안자</td>
			<td class="td_inform2">
				${memberDTO.name }
				<!-- <input type="text" name="edrafter" class="informInput" placeholder=" ( * 필수입력 ) "> -->
			</td>
			<td class="td_inform1">부서</td>
			<td class="td_inform2">
				${memberDTO.deptname }
				<!-- <input type="text" name="edepartment" class="informInput" placeholder=" ( * 필수입력 ) "> -->
			</td>
			<td class="td_inform1">직급</td>
			<td class="td_inform2">
				${memberDTO.rankname }
				<!-- <input type="text" name="eposition" class="informInput" placeholder=" ( * 필수입력 ) "> -->
			</td>
		</tr>
		<tr class="tr_title">
			<td class="td_title1">제목</td>
			<td colspan="7">
				<input type="text" name="etitle" class="titleInput" placeholder=" ( * 필수입력 : [지출품의서] - 품의제목 ) ">
			</td>
		</tr>
		<tr class="tr_content">
			<td class="td_content1">내용</td>
			<td colspan="7">
				<textarea name="econtent" class="eontentTextarea" placeholder=" ( * 필수입력 : 내용을 입력하세요 )"></textarea>
			</td>
		</tr>
		<tr class="tr_receipt">
			<td class="td_receipt1">영수증<br>첨부</td>
			<td colspan="7" class="td_receipt2">
				<label> ( * 영수증 필수 첨부 ) </label>
				<input type="file" name="filepath" class="teceiptFile">
			</td>
		</tr>
		<tr class="tr_aso">
			<td class="td_aso1">비고</td>
			<td colspan="7">
				<input type="text" name="easo" class="asoInput">
			</td>
		</tr>
		<tr class="tr_btn">
			<td colspan="8" class="td_btn">
			<!-- 기안하기 누르면 ListDraft로 redirect -->
				<input type="submit" value="기안하기" onclick="expenseWriteCheck();">
				<input type="reset" value="다시작성">
				<input type="button" value="메인화면" id="btn" onclick="location.href='${pageContext.request.contextPath }/reportMain'">
			</td>
		</tr>
	</table>
</form>


<div class="reportModal modal-overlay">
	<div class="inputArea">
	<span class="modalCloseBtn">ｘ</span>
	<div class="inputMemberArea">
		<p class="inputMemberTitle">결재권자 선택</p><br>
		<div class="selectMemberArea" id="memberComboTree">
			<tiles:insertDefinition name="department_selectbox"></tiles:insertDefinition>
		</div>
	</div>
	</div>

</div>
