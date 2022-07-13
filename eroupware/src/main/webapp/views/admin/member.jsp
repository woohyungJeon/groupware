<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!-- 게시글리스트 & 검색부분 -->
<div class="div_wrap" style="text-align: center;">
	
	<p style="font-size: 25px;
	   		 font-weight: bold;
	   		 width: 200px;
	   		 border-bottom: 1px solid black;
	   		 padding-bottom: 10px;
	   		 margin-bottom: 50px">회원관리</p>
		
	<div class="table_area">
		<table class="table_css">
			<thead>
				<tr class="tr_css">
					<th width="15%">아이디</th>
					<th width="10%">부서</th>
					<th width="15%">직급</th>
					<th width="15%">성함</th>
					<th width="15%">연락처</th>
					<th width="*">가입일</th> 
					<th width="10%">승인</th> 
				</tr>
			</thead>
			<tbody>
				<c:forEach var="memberDTO" items="${list }">
					<tr style="height: 40px;" class="list_css" data-id="${memberDTO.id }">
						<td class="td_title">${memberDTO.id }</td>
						<td>${memberDTO.deptname }</td>
						<td>${memberDTO.rankname }</td>
						<td>${memberDTO.name }</td>
						<td>${memberDTO.mobile }</td>
						<td>${memberDTO.hiredate }</td>
						<td><input type="button" value="승인" data-id="${memberDTO.id }" data-name="${memberDTO.name }" class="approvalBtn"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</div>