<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<p style="font-size: 25px;
   		 font-weight: bold;
   		 width: 300px;
   		 border-bottom: 1px solid black;
   		 padding-bottom: 10px;">내 정보관리</p>	

<div class="modifyWrap">
	<form action="${pageContext.request.contextPath }/member/${session_memberId}" method="post" class="modifyForm" enctype="multipart/form-data">
	<table>
		<tr class="imageTd">
			<td colspan="2">
				<img src="${pageContext.request.contextPath }/resources/storage/${memberModifyDTO.image}" class="imageArea">

				<label class="filebtnLabel" for="imageFile">
					<img src="${pageContext.request.contextPath }/resources/img/camera.png" class="cameraImg">
			    </label>
				<input type="file" name="file" id="imageFile" class="imageFile" accept="image/png, image/gif, image/jpeg">

			</td>
		</tr> 
		
		<tr>
			<td class="titleTd">ID</td>
			<td class="fixedTd">${memberModifyDTO.id }</td>
		</tr>
		
		<tr>
			<td class="titleTd">NAME</td>
			<td class="fixedTd">${memberModifyDTO.name }</td>
		</tr>
		
		<tr>
			<td class="titleTd">MOBILE</td>
			<td>
				<input type="text" name="mobile1" maxLength="3" onKeyup="this.value=this.value.replace(/[^-0-9]/g,'');" class="mobile mobile1 inputText" value="${memberModifyDTO.mobile1 }">-
				<input type="text" name="mobile2" maxLength="4" onKeyup="this.value=this.value.replace(/[^-0-9]/g,'');" class="mobile mobile2 inputText" value="${memberModifyDTO.mobile2 }">-
				<input type="text" name="mobile3" maxLength="4" onKeyup="this.value=this.value.replace(/[^-0-9]/g,'');" class="mobile mobile3 inputText" value="${memberModifyDTO.mobile3 }">
				<input type="hidden" name="mobile" class="mobileHidden">
			</td>
		</tr>
		
		<tr>
			<td class="titleTd">ADDRESS</td>
			<td>
				<input type="text" name="addnumber" readonly="readonly" class="addnumber inputText" value="${memberModifyDTO.addNumber }">
				<input type="button" value="주소검색" class="addBtn"><br>
				<input type="text" name="addname" readonly="readonly" class="addname inputText" value="${memberModifyDTO.addName }"><br>
				<input type="text" name="adddetail" class="addDetail inputText" value="${memberModifyDTO.addDetail }">
			</td>
		</tr>
		
		<tr>
			<td class="titleTd">DEPARTMENT</td>
			<td>
				<select name="deptno" class="selectDepartment select">
			        <option value="1" <c:if test="${memberModifyDTO.deptno == 1}">selected</c:if> >총무팀</option>
			        <option value="2" <c:if test="${memberModifyDTO.deptno == 2}">selected</c:if>>인사팀</option>
			        <option value="3" <c:if test="${memberModifyDTO.deptno == 3}">selected</c:if>>회계팀</option>
			        <option value="4" <c:if test="${memberModifyDTO.deptno == 4}">selected</c:if>>영업 1팀</option>
			        <option value="5" <c:if test="${memberModifyDTO.deptno == 5}">selected</c:if>>영업 2팀</option>
			        <option value="6" <c:if test="${memberModifyDTO.deptno == 6}">selected</c:if>>해외영업팀</option>
			        <option value="7" <c:if test="${memberModifyDTO.deptno == 7}">selected</c:if>>개발 1팀</option>
			        <option value="8" <c:if test="${memberModifyDTO.deptno == 8}">selected</c:if>>개발 2팀</option>
			        <option value="9" <c:if test="${memberModifyDTO.deptno == 9}">selected</c:if>>개발 3팀</option>
			        <option value="10" <c:if test="${memberModifyDTO.deptno == 10}">selected</c:if>>품질보증팀</option>         
	      		</select>
			</td>
		</tr>
		
		<tr>
			<td class="titleTd">POSITION</td>
			<td>
				<select name="rankno" class="selectPosition select">
		        <option value="1" <c:if test="${memberModifyDTO.rankno == 1}">selected</c:if>>사원</option>
		        <option value="2" <c:if test="${memberModifyDTO.rankno == 2}">selected</c:if>>주임</option>
		        <option value="3" <c:if test="${memberModifyDTO.rankno == 3}">selected</c:if>>대리</option>
		        <option value="4" <c:if test="${memberModifyDTO.rankno == 4}">selected</c:if>>과장</option>
		        <option value="5" <c:if test="${memberModifyDTO.rankno == 5}">selected</c:if>>차장</option>
		        <option value="6" <c:if test="${memberModifyDTO.rankno == 6}">selected</c:if>>팀장</option>
		        <option value="7" <c:if test="${memberModifyDTO.rankno == 7}">selected</c:if>>부장</option>         
	    	</select>
			</td>
		</tr>
		
		<tr>
			<td class="titleTd">EMAIL</td>
			<td>
				<input type="text" name="emailf" class="emailf inputText" value="${memberModifyDTO.emailf}">@<input type="text" name="emailb" class="emailb inputText" value="${memberModifyDTO.emailb}">
				
				<select name="mailslc" class="emailSelect select">
	                <option value="self" selected>직접입력</option>
	                <option value="naver.com" <c:if test="${memberModifyDTO.emailb == 'naver.com'}">selected</c:if>>naver.com</option>
	                <option value="gmail.com" <c:if test="${memberModifyDTO.emailb == 'gmail.com'}">selected</c:if>>gmail.com</option>
	                <option value="daum.com" <c:if test="${memberModifyDTO.emailb == 'daum.com'}">selected</c:if>>daum.com</option>
	                <option value="yahoo.com" <c:if test="${memberModifyDTO.emailb == 'yahoo.com'}">selected</c:if>>yahoo.com</option>
            	</select>
            	<input type="hidden" name="email" class="emailHidden">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" class="buttonTd">
				<input type="submit" value="정보수정" class="modifySubmitBtn">
				<input type="button" value="CANCEL" class="cancelBtn" onclick="javascript:history.back();">
			</td> 
		</tr>
	
	</table>
	</form>

</div>
	
