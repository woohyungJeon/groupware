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
   

<form action="${pageContext.request.contextPath }/reportCooperateUpdate" method="get">
	<table class="table">
		<tr class="tr_main">
			<td colspan="6" rowspan="3" class="td_main">업무협조요청서</td>
			<td colspan="2" class="td_line">결재라인</td>
		</tr>
		<tr class="tr_rank">
			<td class="td_rank1">부서장</td>
			<td class="td_rank2">대표이사</td>
		</tr>
		<tr class="tr_sign">
			<td class="tr_sign1"></td>
			<td class="tr_sign2"></td>
		</tr>
		<tr class="tr_inform">
			<td class="td_inform1">기안일자</td>
			<td class="td_inform2">
				<input type="text" class="informInput">
			</td>
			<td class="td_inform1">기안자</td>
			<td class="td_inform2">
				<input type="text" class="informInput">
			</td>
			<td class="td_inform1">부서</td>
			<td class="td_inform2">
				<input type="text" class="informInput">
			</td>
			<td class="td_inform1">직급</td>
			<td class="td_inform2">
				<input type="text" class="informInput">
			</td>
		</tr>
		<tr class="tr_title">
			<td class="td_title1">제목</td>
			<td colspan="7">
				<input type="text" class="titleInput" placeholder="*[업무협조요청서] - 협조요청부서 ">
			</td>
		</tr>
		<tr class="tr_content">
			<td class="td_content1">내용</td>
			<td colspan="7">
				<textarea class="contentTextarea" placeholder="*내용을 입력하세요"></textarea>
			</td>
		<tr class="tr_aso">
			<td class="td_aso1">비고</td>
			<td colspan="7">
				<input type="text" class="asoInput">
			</td>
		</tr>
		<tr class="tr_btn">
			<td colspan="8" class="td_btn">
			<!-- 기안하기 누르면 ListDraft로 redirect -->
				<input type="submit" value="기안하기" onclick="cooperateWriteCheck();">
				<input type="reset" value="다시작성">
				<input type="button" value="메인화면" id="btn" onclick="location.href='${pageContext.request.contextPath }/reportMain'">
			</td>
		</tr>
	</table>
</form>