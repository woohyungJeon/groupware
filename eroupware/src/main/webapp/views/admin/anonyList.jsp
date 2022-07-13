<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!--리스트 부분 -->
<div class="div_wrap" style=text-align:center;>
	<p style="font-size: 25px;
	   		 font-weight: bold;
	   		 width: 200px;
	   		 border-bottom: 1px solid black;
	   		 padding-bottom: 10px;
	   		 margin-bottom: 50px">익명게시판</p>
	   		 
	<div class="table_area">
		<table class="table_css">
			<thead>
				<tr class="tr_css">
					<th width="10%">NO</th>
					<th width="*%">제목</th>
					<th width="15%">작성일</th>
					<th width="10%">좋아요</th>
					<th width="10%">조회수</th>
				</tr>
			</thead>  
			<tbody>
				<c:forEach var="anonyList" items="${list}">
					<tr style="height: 40px;" class="list_css"
						onclick="location.href='${pageContext.request.contextPath }/admin/anony/${anonyList.anonyNo}'">
						<td width="10%">${anonyList.anonyNo }</td>
						<!-- 하루동안 새글표시 추가 -->
						<c:set var="time" value="${anonyList.regdate}" />
						<c:choose>
							<c:when test="${time >= nowday }">
								<td width="*%" class="td_title"><img class="new"
									src="${pageContext.request.contextPath }/resources/img/new.png">${anonyList.title }</td>
							</c:when>
							<c:otherwise>
								<td width="*%" class="td_title">${anonyList.title }</td>
							</c:otherwise>
						</c:choose>

						<td width="15%">${anonyList.regdate }</td>
						<td width="10%">${anonyList.likeCount }</td>
						<td width="10%">${anonyList.hit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- 페이지부분 -->
	<div class="paging_area">
		<ul class="paging_css">
			<c:if test="${pageMaker.prev}">
				<li><a class="paging_a"
					href="anony${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
				var="idx">
				<li><a class="paging_a"
					href="anony${pageMaker.makeSearch(idx)}">${idx}</a></li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a class="paging_a"
					href="anony${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
			</c:if>
		</ul>
	</div>

	<div class="search_area">
		<form method="get" role="form" class="searchForm">
			<div class="search">
				<select name="searchType" id="searchType" class="searchType">
					<option value="t"
						<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
					<option value="c"
						<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
					<option value="tc"
						<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
				</select> <input type="text" name="keyword" id="keywordInput"
					class="search_keyword" value="${scri.keyword}" />
				<button id="searchBtn" type="submit" class="search_btn">
					<img
						src="${pageContext.request.contextPath }/resources/img/noticeSearch.png"
						class="search_img">
				</button>
				</div>
		</form>
		
	</div>
	
</div>