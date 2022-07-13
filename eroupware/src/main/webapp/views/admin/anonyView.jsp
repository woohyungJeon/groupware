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
	   		 margin-bottom: 50px">익명게시판</p>
	   		 
	<div class="table_area">
		<table class="table_css">
			<tr class="tr_main">
				<td class="td_title">제목</td>
				<td class="td_titlesub">${anonyView.title}</td>
				<td class="td_hit">조회수
				<td class="td_hitsub">${anonyView.hit}</td>
			</tr>
			<tr class="tr_second">
				<td class="td_regdate">작성일</td>
				<td class="td_regdatesub">${anonyView.regdate}</td>
				<td class="td_like">좋아요</td>
				<td class="td_likesub">${anonyView.likeCount }</td>
			</tr>
			<tr class="tr_third">
				<td class="td_content">내용</td>
				<td colspan="3" class="td_contentsub">
					<div class="showContent">${anonyView.content}</div>
				</td>
			</tr>
		</table>
		<input type="hidden" class="anonyNo" value="${anonyView.anonyNo }">
	</div>
	
		<div class="btn_area">
			<input type="button" value="삭제" class="btn_delete" onclick="location.href='${pageContext.request.contextPath }/admin/anony/delete/${anonyView.anonyNo }'">
			<button id="anonyList" name="anonyList" class="btn_list" onclick="location.href='${pageContext.request.contextPath }/admin/anony'">목록</button>
		</div>
</div>


