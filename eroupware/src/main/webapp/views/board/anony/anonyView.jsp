<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!--  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->

<!-- 공통부분!! -->
<p style="font-size: 25px;
   		 font-weight: bold;
   		 width: 300px;
   		 border-bottom: 1px solid black;
   		 padding-bottom: 10px;">익명게시판</p>
   		 
<!--리스트 부분 -->
<div class="div_wrap">
	<div class="table_area">
		<!--  <form name="readForm" role="form" method="post">
		<input type="hidden" id="anonyNo" name="anonyNo" value="${anonyView.anonyNo}" />
		</form>--> 
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
		<c:if test="${anonyView.likeFlag > 0 }">
			<div class="likeImg like"></div>
		</c:if>
		
		<c:if test="${anonyView.likeFlag < 1 }">
			<div class="likeImg dislike"></div>
		</c:if>
	</div>
<!-- 좋아요 기능 시작-->
		<%-- <div class="like_area">
		<c:choose>
			<c:when test = "${anonyView.id } == null }">
				<a href = 'javascript: like_func();'><img src = "${pageContext.request.contextPath }/resources/img/heart.png" class="heart_img"></a>
			</c:when>
			<c:otherwise>
				<a href = 'javascript: login_func();'><img src = "${pageContext.request.contextPath }/resources/img/heart.png" class="heart_img"></a>
			</c:otherwise>
		</c:choose>	
		</div>  --%>
<!-- 좋아요 기능 끝 -->		
		<div class="btn_area">
			<%-- <input type="button" value="수정" class="btn_modify" onclick="location.href='${pageContext.request.contextPath }/anony/anonyUpdate/${anonyDTO.anonyNo }'">
			<input type="button" value="삭제" class="btn_delete" onclick="location.href='${pageContext.request.contextPath }/anony/anonyDelete/${anonyView.anonyNo }'"> --%>
			<button id="anonyList" name="anonyList" class="btn_list" onclick="location.href='${pageContext.request.contextPath }/anony'">목록</button>
		</div>
</div>


<!-- <form action="${pageContext.request.contextPath }/anony/reply/${anonyView.anonyNo}" name="replyForm" method="post">
  <input type="hidden" id="anonyNo" name="anonyNo" value="${anonyView.anonyNo}" /> --%>

  <input type="hidden" id="page" name="page" value="${scri.page}">  
  <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
  <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
  <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 

  <div>
    <label for="id">댓글 작성자</label><input type="text" id="id" name="id" />
    <br/>
    <label for="content">댓글 내용</label><input type="text" id="content" name="content" />
  </div>
  <div>
  	<input type="submit" value="작성">
  </div>
</form>
		
		
<div id="reply">
  <ol class="anonyReplyList">
    <c:forEach items="${anonyReplyList}" var="anonyReplyList">
      <li>
        <p>
        작성자 : ${anonyReplyList.id}<br />
        작성 날짜 :  <fmt:formatDate value="${anonyReplyList.regdate}" pattern="yyyy-MM-dd" />
        </p>

        <p>${anonyReplyList.content}</p>
      </li>
    </c:forEach>   
  </ol>
</div>
	</div>
</div> --> 
