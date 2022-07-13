<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true" %>

<p style="font-size: 25px;
    font-weight: bold;
    width: 300px;
    border-bottom: 1px solid black;
    padding-bottom: 10px;">프로젝트</p>
    
<div class="projectDetailMainArea">
	
	<div class="infoArea">
		<input type="hidden" class="projectNo" value="${projectInfoDTO.projectNo }">
		<div class="projectInfoArea projectDetailArea">
			<span class="projectTitleSpan">${projectInfoDTO.title }</span>
			<span class="projectMembersSpan">${projectInfoDTO.pmembers }명&nbsp;참여중</span>
			<span class="projectRegdateSpan">프로젝트 생성일&nbsp;${projectInfoDTO.regdate }</span>
			<div class="projectContentDiv"><pre>${projectInfoDTO.content }</pre></div>
			<img class="settingIcon" src="${pageContext.request.contextPath }/resources/img/setting.png">
		</div>
		
		<div class="projectChartArea">
			<input type="hidden" class="totalCnt" value="${projectTaskCntDTO.totalCnt }">
			<input type="hidden" class="waitCnt" value="${projectTaskCntDTO.waitCnt }">
			<input type="hidden" class="processCnt" value="${projectTaskCntDTO.processCnt }">
			<input type="hidden" class="completeCnt" value="${projectTaskCntDTO.completeCnt }">
			<canvas class="projectTotalChart projectDetailArea" id="projectTotalChart">
			</canvas>
		</div>
		
		<div class="projectTaskChartArea projectDetailArea">
			<div class="projectTaskChart projectDetailArea">
				<div class="projectMemberListArea">
				<c:forEach var="projectMemberListDTO" items="${projectMemberList }">
				<div class="projectMember">
				<img src="${pageContext.request.contextPath }/resources/storage/${projectMemberListDTO.image}">
				
				<div class="nameGraphbarDiv">
				<span class="memberNameSpan">${projectMemberListDTO.rankname }&nbsp;${projectMemberListDTO.name }</span>
				<%-- <span>전체 : ${projectMemberListDTO.taskTotalCnt } / 완료 : ${projectMemberListDTO.taskCompleteCnt }</span> --%>
				
				<div class="progressBarOuter" data-id="${projectMemberListDTO.id }" 
					data-totalCnt="${projectMemberListDTO.taskTotalCnt }"
					data-completeCnt="${ projectMemberListDTO.taskCompleteCnt}"
					>
					<div class="progressBarInner" data-id="${projectMemberListDTO.id }" data-width="${projectMemberListDTO.taskPercent }">
					</div>
				</div>
				
				</div>
				
				<span class="percentTextSpan" data-id="${projectMemberListDTO.id }">${projectMemberListDTO.taskPercent }%</span>
			    
				</div>
				</c:forEach>
				</div>
			</div>
		</div>
		
		<div class="projectInputTaskArea projectDetailArea">
			<form action="${pageContext.request.contextPath }/project/${projectInfoDTO.projectNo }/task" method="post" class="taskAddForm" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${session_memberId }">
			<div class="inputTaskArea">
				<!-- <p class="inputTaskTitle">신규 태스크</p> -->
				
				<input type="text" name="title" class="inputText inputTitle" placeholder="태스크 제목을 입력하세요">
				
				<textarea name="content" class="inputText inputContent" placeholder="설명글을 입력할 수 있습니다"></textarea>
				
				
				<label class="filebtnLabel">파일첨부
					<input type="file" name="file" class="fileBtn">
			    </label>
			    <span class="fileSpan"></span>
				
				<input type="submit" value="태스크 생성" class="inputTaskSubmitBtn"> 
			</div>
		
			</form>
	
		</div>
		
	</div>
	
	
	
	<div class="projectTaskListArea projectDetailArea">
		<div class="projectMyTaskBtnArea">
			<!-- <a href="#">전체 태스크</a>
			<input type="button" class="newTaskBtn" value="NEW TASK">
			<input type="button" class="testBtn" value="다시그리기"> -->
		</div>
		
		<div class="projectTaskList">
			<table border="1">
			
				<tr>
					<td width="5%">상태</td>
					<td width="10%">담당자</td>
					<td width="15%">업무명</td>
					<td width="*">설명</td>
					<td width="15%">첨부파일</td>
					<td width="10%">변경</td>
				</tr>
				  
				<c:forEach var="taskDTO" items="${taskList }">
				<tr class="taskListTr">
					<td style="text-align: center">
						<span class="taskStatusSpan ${taskDTO.status }" data-taskNo="${taskDTO.taskNo }">
						</span>
					</td>
					<td  style="text-align: center"><%-- ${taskDTO.deptname }&nbsp; --%>${taskDTO.rankname }&nbsp;${taskDTO.name }</td>
					<td>${taskDTO.title }</td>
					<td>${taskDTO.content }</td>
					<td><a href="${pageContext.request.contextPath }/file/ew_task/${taskDTO.taskNo}">${taskDTO.filepath}</a></td>
					<td class="updateStatusBtnArea">
						<c:if test="${session_memberId == taskDTO.id }"> 
							<select class="updateStatusSelect" data-status="${taskDTO.status }" data-taskNo="${taskDTO.taskNo }" data-id="${taskDTO.id }">
								<option value="wait" <c:if test="${taskDTO.status == 'wait' }">selected</c:if> >대기</option>
								<option value="process" <c:if test="${taskDTO.status == 'process' }">selected</c:if> >진행</option>
								<option value="complete"<c:if test="${taskDTO.status == 'complete' }">selected</c:if> >완료</option>
								<option value="delete">삭제</option>
							</select>
						
						</c:if>
						
					</td>
				</tr>
				</c:forEach>
			</table>

		</div>
	</div>
	<input type="button" value="&lt; 목록보기" class="projectListBtn">
	
</div>


<div class="newProjectModal modal-overlay">

	<div class="inputArea">
		<form action="${pageContext.request.contextPath }/project/update" method="post" class="projectAddForm">
		<input type="hidden" name="projectNo" value="${projectInfoDTO.projectNo }">
		<div class="inputProjectArea">
			<span class="modalCloseBtn">ｘ</span>
			<p class="inputProjectTitle">프로젝트 수정</p>
			<input type="text" name="title" class="inputText inputTitle" placeholder="프로젝트 제목을 입력하세요" value="${projectInfoDTO.title }">
			<textarea name="content" class="inputText inputContent" placeholder="설명글을 입력할 수 있습니다">${projectInfoDTO.content }</textarea>
			
			<p class="detailTitle selectedMemberTitle">참여 멤버</p>

			<div class="selectedMemberArea"><!-- 
				--><c:forEach var="projectMemberListDTO" items="${projectMemberList }"><!-- 
					 --><span class="selectedMemberSpan old" data-id="${projectMemberListDTO.id }">${projectMemberListDTO.rankname }&nbsp;${projectMemberListDTO.name }</span><!--
  					--><input type="hidden" class="selectedMemberHidden" name="idArr" value="${projectMemberListDTO.id }"><!-- 
				 --></c:forEach><!--
			--></div>
			
			<input type="submit" value="프로젝트 수정" class="inputProjectSubmitBtn"> 
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