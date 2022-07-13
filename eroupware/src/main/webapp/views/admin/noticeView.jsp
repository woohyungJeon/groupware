<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!--리스트 부분 -->
<div class="div_wrap">

	<p style="font-size: 25px;
	   		 font-weight: bold;
	   		 width: 200px;
	   		 border-bottom: 1px solid black;
	   		 padding-bottom: 10px;
	   		 margin-bottom: 50px">공지사항</p>
   		 
	<div class="table_area">
		<table class="table_css">
			<tr class="tr_main">				
				<td class="td_title">제목</td>
				<td class="td_titlesub">${noticeView.title}</td>
				<td class="td_hit">조회수
				<td class="td_hitsub">${noticeView.hit}</td>
			</tr>
			<tr class= "tr_second">				
				<td class="td_name">작성자</td>
				<td class="td_namesub">관리자</td>
				<td class="td_logtime">작성일</td>
				<td class="td_logtimesub">${noticeView.logtime}</td>
			</tr>
			<tr class="tr_third">
				<td class="td_content">내용</td>
				<td colspan="3" class="td_contentsub">
					<%-- <div>${noticeView.content}</div> --%>
					<div class="showContent"><c:out value='${noticeView.content}' escapeXml='false' /></div>
				</td>
			</tr>
			<tr class="tr_fouth">
				<td class="td_filepath">첨부파일</td>
				<td class="td_filepathsub">
					<a href="${pageContext.request.contextPath }/file/ew_notice/${noticeView.seq}">${noticeView.filepath}</a>
				</td>
			</tr>
		</table>
		</div>
		<div class="btn_area">
			<input type="hidden" class="hiddenSeq" value="${noticeView.seq }">
			<input type="button" value="수정" class="btn_modify"
				onclick="location.href='${pageContext.request.contextPath }/admin/notice/noticeUpdateForm/${noticeView.seq }'">
			<input type="button" value="삭제" class="btn_delete">
			<button id="noticeList" name="noticeList" class="btn_list"
				onclick="location.href='${pageContext.request.contextPath }/admin/notice'">목록</button>
		</div>
		
</div>
