<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 클래식에디터 적용 -->
<script
	src="https://cdn.ckeditor.com/ckeditor5/33.0.0/classic/ckeditor.js"></script> 

<p style="font-size: 25px;
   		 font-weight: bold;
   		 width: 300px;
   		 border-bottom: 1px solid black;
   		 padding-bottom: 10px;">공지사항</p>

<form action="${pageContext.request.contextPath }/notice/update" method="post" name="frm">
	<input type="hidden" name="seq" value="${noticeUpdate.seq }"> 
	<div class="div_wrap">
			<div class="table_area">
			<table class="table_css">
				<tbody class="tbody_css">
				<tr class="tr_main">
					<td class="td_title">제목</td>
					<td class="td_titlesub"><input class="input_titlesub"type="text" id="title" name="title" value="${noticeUpdate.title }"/></td>
				</tr>
				<tr class="tr_second">
				<!--<td class="td_content">내용</td> -->
					<td colspan="2"><textarea class= "td_contentsub" name="content" id="content" >${noticeUpdate.content }</textarea></td>	
					<script>
       					ClassicEditor
           				.create( document.querySelector( '#content' ))
           				.catch( error => {
               			console.error( error );
            			} );
   					</script>
				</tr>
				<tr class="tr_third">
					<td class="td_filepath">첨부파일</td>
					<td class="td_filepathsub">${noticeUpdate.filepath }</td>
				</tr>
				</tbody>
			</table>
			</div>
			<div class="btn_area">
				<input type="submit" id="noticeUpdate" name="noticeUpdate" value="작성">
				<input type="button" value="취소" onclick="history.back()">
			</div>
	</div>
</form>
	
