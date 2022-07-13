<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 공통부분!! -->
<p style="font-size: 25px;
   		 font-weight: bold;
   		 width: 300px;
   		 border-bottom: 1px solid black;
   		 padding-bottom: 10px;">전자결재</p>
   		 
<div class="div_wrap" style="text-align: center;">
		<p class="main_title">휴가요청서 상신</p>
		<div class="table_area">
			<form method="post">
				<table class="table_css">
					<thead>
						<tr class="tr_css">
							<th width="10%">NO</th>
							<th width="*%">제목</th>
							<th width="15%">작성자</th>
							<th width="20%">작성일</th>
							<th width="10%">결재상태</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vReportDTO" items="${list }">
							<tr class="list_css"
								onclick="location.href='${pageContext.request.contextPath }/reportVacationView/${vReportDTO.seq_ew_draft }?pg=${pg }'">
								<td width="15%">${vReportDTO.seq_ew_draft}</td>
								<td width="*%">${vReportDTO.r_title}</td>
								<td width="15%">${vReportDTO.r_drafter}</td>
								<td width="15%">
									<fmt:parseDate value="${vReportDTO.r_draftDate }" var="registered" pattern="yyyy-MM-dd" />
									<fmt:formatDate value="${registered}" pattern="yyyy-MM-dd" />
								</td>
								<td width="10%">
									<c:if test="${vReportDTO.r_status == 'Y' }">
										승인
									</c:if>
									
									<c:if test="${vReportDTO.r_status == 'N' }">
										대기
									</c:if>
									
									<c:if test="${vReportDTO.r_status == 'F' }">
										반려
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
		<!-- 페이징 번호 보기 -->
		<div class="paging_area">
<ul class= "paging_css">
			<c:if test="${startPage > 3}">
				<li><a class="paging_a" href="reportVacationList?pg=${startPage-1}">이전</a></li>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${pg == i}">
					<li><a class="paging_a" href="reportVacationList?pg=${i}">${i}</a></li>
				</c:if>

				<c:if test="${pg != i}">
					<li><a class="paging_a" href="reportVacationList?pg=${i}">${i}</a></li>
				</c:if>
			</c:forEach>

			<c:if test="${endPage < totalP}">
				<li><a class="paging_a" href="reportVacationList?pg=${endPage+1}">다음</a></li>
			</c:if>
		</div>
		<div class="writebtn_area">
			<input class="writebtn_css" type="button" value="새 기안하기" id="btn" onclick="location.href='${pageContext.request.contextPath }/reportVacationWriteForm'">
			&nbsp;
			<input class="writebtn_css" type="button"  value="메인화면" id="btn" onclick="location.href='${pageContext.request.contextPath }/report'">
		</div>
	</div>