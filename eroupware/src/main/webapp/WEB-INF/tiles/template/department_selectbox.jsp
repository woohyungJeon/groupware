<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tiles:importAttribute name="deptSelectDTOList"/>
<tiles:importAttribute name="memberSelectDTOList"/>

<div class="member_select_area">
	<ul>
		<c:forEach var="deptSelectDTO" items="${deptSelectDTOList}">
			<li data-department-no="${deptSelectDTO.deptno}" class="department_li">
			<span class="deptname">
				<span class="plusminusIcon">＋</span>
				<!-- <span class="plusminusIcon">－</span> -->
				<%-- <img src="${pageContext.request.contextPath }/resources/img/plus.png"> --%>
				<span>${deptSelectDTO.deptname}</span>
			</span>
				<ul class="memberListAreaByDept">
					<c:forEach var="memberSelectDTO" items="${memberSelectDTOList }">
						<c:if test="${deptSelectDTO.deptno ==  memberSelectDTO.deptno}">

							<c:if test="${session_memberId == memberSelectDTO.id }">
								<li data-id="${memberSelectDTO.id }" class="on me">${memberSelectDTO.rankname} ${memberSelectDTO.name }</li>
							</c:if>
							
							<c:if test="${session_memberId != memberSelectDTO.id }">
								<li data-id="${memberSelectDTO.id }">${memberSelectDTO.rankname} ${memberSelectDTO.name }</li>
							</c:if>
							
						</c:if>
					</c:forEach>
					
				</ul>
			</li>
		</c:forEach>
	</ul>
</div>


