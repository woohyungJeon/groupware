<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<p style="font-size: 25px;
    font-weight: bold;
    width: 300px;
    border-bottom: 1px solid black;
    padding-bottom: 10px;">Project</p>
    
<div class="projectMainArea">
	<button class="newProjectBtn"><img src="${pageContext.request.contextPath }/resources/img/plus_new.png">&nbsp;&nbsp;&nbsp;프로젝트 생성</button>
	<div class="projectListArea">
	
		<!-- <div class="todoBtnArea">
			<div class="switch-field">
				<input type="radio" name="type" id="type-personal" class="listTypeRadio" value="personal" checked />
				<label for="type-personal">개인</label>
				<input type="radio" name="type" id="type-team" class="listTypeRadio" value="team" />
				<label for="type-team">팀</label>
			</div> 
		</div> -->
		
		<div class="projectCardArea">

			<c:forEach var="projectListDTO" items="${projectList }">
				<div class="projectCard" onclick="location.href='${pageContext.request.contextPath}/project/${projectListDTO.projectNo }'">
					<span>${projectListDTO.title }</span>
					<span>${projectListDTO.pmembers }명 참여중</span>
				</div>
				
				
			</c:forEach>
		
		</div>
	
	</div>

</div>




<div class="newProjectModal modal-overlay">

	<div class="inputArea">
		<form action="${pageContext.request.contextPath }/project" method="post" class="projectAddForm">
		<input type="hidden" name="id" value="${session_memberId }">
		<div class="inputProjectArea">
			<span class="modalCloseBtn">ｘ</span>
			<p class="inputProjectTitle">새로운 프로젝트 생성</p>
			<input type="text" name="title" class="inputText inputTitle" placeholder="프로젝트 제목을 입력하세요">
			<textarea name="content" class="inputText inputContent" placeholder="설명글을 입력할 수 있습니다"></textarea>
			
			
			<p class="detailTitle selectedMemberTitle">참여 멤버</p>
			<div class="selectedMemberArea">
			
			</div>
			
			<input type="submit" value="프로젝트 생성" class="inputProjectSubmitBtn"> 
		</div>
		
		<div class="inputMemberArea">
			<p class="inputMemberTitle">멤버 선택</p><br>
			<div class="selectMemberArea" id="memberComboTree">
				<tiles:insertDefinition name="department_selectbox"></tiles:insertDefinition>
			</div>
		</div>
		</form>
	</div>

</div>
