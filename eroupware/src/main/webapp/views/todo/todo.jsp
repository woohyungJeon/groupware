<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<p style="font-size: 25px;
    font-weight: bold;
    width: 300px;
    border-bottom: 1px solid black;
    padding-bottom: 10px;">업무관리</p>
    
<div class="todoMainArea">
	<%-- <button class="newTodoBtn"><img src="${pageContext.request.contextPath }/resources/img/plus_new.png">&nbsp;&nbsp;&nbsp;새로운 업무</button> --%>
	<span class="todoCardInfo"></span>
	<div class="todoListArea">
	
		<div class="todoCardArea">
				<div class="newTodoCard newTodoBtn"><span>+</span></div>
			<div  id="todoCardSortable">
			<c:forEach var="todoDTO" items="${todoList }">
				<div class="todoCard ${todoDTO.color }" data-todoNo="${todoDTO.todoNo }" data-sort="${todoDTO.sort }">
					<span class="todoCardTitle">${todoDTO.title }</span>
					<span class="todoCardDate">${todoDTO.regdate }</span>
					<div class="todoCardContent"><pre>${todoDTO.content }</pre></div>
					<textarea class="todoCardTa"></textarea>
					<!-- <input type="button" class="todoCardBtn todoCardColorBtn" value="라벨 변경"> -->
					<span class="todoCardBtnArea">
						<input type="button" class="todoCardBtn todoCardModifyBtn" value="수정">
						<input type="button" data-todoNo="${todoDTO.todoNo }" class="todoCardBtn todoCardCompleteBtn" value="완료">
						<input type="button" data-todoNo="${todoDTO.todoNo }" class="todoCardBtn todoCardDeleteBtn" value="삭제">
					</span>
					
					<div class="todoCardColorPopup" data-todoNo="${todoDTO.todoNo }">
						<span class="red"></span>
						<span class="blue"></span>
						<span class="green"></span>
						<span class="orange"></span>
						<span class="purple"></span>
						<span class="gray"></span>
					</div>
				</div>
				
			</c:forEach>
			</div>
		</div>
	
	</div>

</div>


<div class="newTodoModal modal-overlay">

	<div class="inputArea">
		<form action="${pageContext.request.contextPath }/todo" method="post" class="todoAddForm">
		<input type="hidden" name="id" value="${session_memberId }">
		<div class="inputTodoArea">
			<span class="modalCloseBtn">ｘ</span>
			<p class="inputTodoTitle">새로운 업무 생성</p>
			
			<input type="text" name="title" class="inputText inputTitle" placeholder="업무 제목을 입력하세요">
			
			<textarea name="content" class="inputText inputContent" placeholder="설명글을 입력할 수 있습니다"></textarea>
			
			<input type="submit" value="업무 생성" class="inputTodoSubmitBtn"> 
		</div>
		
		</form>
	</div>

</div>
