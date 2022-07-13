<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 공통부분 -->
<p style="font-size: 25px;
   		  font-weight: bold; 
    	  width: 300px;; 
    	  border-bottom: 1px solid black;
   		  padding-bottom: 10px;">주소록</p>
	
<!-- 게시글리스트 & 검색부분 -->
<div class="search_area">
	<form method="get" role="form" class="searchForm">
		<div class="search">
			<select name="searchType" id="searchType" class="searchType">
				<option value="n"
					<c:out value="${scri.searchType eq 'n' ? 'selected' : ''}"/>>이름</option>
				<option value="e"
					<c:out value="${scri.searchType eq 'e' ? 'selected' : ''}"/>>이메일</option>
				<option value="m"
					<c:out value="${scri.searchType eq 'm' ? 'selected' : ''}"/>>전화번호</option>
			</select> <input type="text" name="keyword" id="keywordInput" class="search_keyword"
				value="${scri.keyword}" />
			<button id="searchBtn" type="submit" class="search_btn"><img src="${pageContext.request.contextPath }/resources/img/noticeSearch.png" class="search_img"></button>
		</div>
	</form>
	
<div class="div_wrap" style="text-align: center;">
	<div class="table_area">
		<table class="table_css">
			<thead>
				<tr class="tr_css">
					<th>이름</th>
					<th>전화번호</th>
					<th>메일</th>
					<th>부서</th>
					<th>직급</th>
				</tr>
			</thead>			  
			<tbody>
				<c:forEach var="contactList" items="${contactlist }">
					<!-- <tr style="height: 40px;" class="list_css"
						onclick="location.href='${pageContext.request.contextPath }/contact/${contactList.id }'">--> 
					 <tr style="height: 40px;" class="list_css" id="${contactList.id }">
						<td>${contactList.name }</td>
						<td>${contactList.mobile }</td>
						<td>${contactList.email }</td>
						<td>${contactList.deptname }</td>
						<td>${contactList.rankname }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
	</div>
	<!-- 페이지 부분 -->
	<div class="paging_area">	
		<ul class = "paging_css">
			<c:if test="${pageMaker.prev}">
				<li><a class="paging_a"
					href="contact${pageMaker.makeSearch(pageMaker.startPage - 1)}"> < prev </a></li>
			</c:if>
			
			<c:forEach begin="${pageMaker.startPage}"
				end="${pageMaker.endPage}" var="idx">
				<li><a class="paging_a"
					href="contact${pageMaker.makeSearch(idx)}">${idx}</a></li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a class="paging_a"
					href="contact${pageMaker.makeSearch(pageMaker.endPage + 1)}">next ></a></li>
			</c:if>
		</ul>
	</div>
				
	
	
	</div>

</div>