<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
 
<div id="joinFormWrap">
<div class="joinFormArea">

   <form action="${pageContext.request.contextPath }/join" method="post" class="joinForm">   
      <h3>EROUPWARE</h3>
      
      <table class="joinTable">
      <tr>
      	<th>
      		<label for="userid"></label>* ID
      	</th>
       	<td>
       		<input type="text" name="id" class="inputText inputId">
       		<div class="status idCheck"></div>        		
      		<div class="status">아이디를 입력하세요(영문 소문자, 숫자만 입력 가능)</div>
      		<input type="hidden" id="idDoubleCheck">      		
	    </td>
      </tr>  	 
      <tr>
      	<th>
      		<label for="username">* NAME</label>
      	</th>
	    <td>
	    	<input type="text" name="name" class="inputText inputName">
	    </td>	    	
      </tr>
      <tr>
      	<th>
      		<label for="userpwd">* PASSWORD</label>
    	</th>
        <td>
        	<input type="password" name="pwd" class="inputText inputPwd">
        	<div class="status pwd">비밀번호를 입력하세요.(영문 대/소문자, 숫자 모두 포함 가능)</div>
        	<input type="hidden" class="pwdCheck1" value="false">
        </td>
      </tr>
      <tr>
      	<th>
      		<label for="userpwd">* PASSWORD</label>
    	</th>
        <td>
        	<input type="password" name="pwd2" class="inputText inputPwdcheck" maxlength="16">
        	<div class="status pwdCheck">비밀번호를 확인하세요.</div>
        	<input type="hidden" class="pwdCheck2" value="false">
        </td>
      </tr>
      <tr>
      	<th>
      		<label for="usermobile">* MOBILE</label>
      	</th>
      	<td>
      		<input type="text" name="mobile1" class="inputText inputMobile1" maxlength="3">-
      		<input type="text" name="mobile2" class="inputText inputMobile2" maxlength="4">-
      		<input type="text" name="mobile3" class="inputText inputMobile3" maxlength="4">
      		<input type="hidden" name="mobile">
      	</td>
      </tr>
      <tr>
      	<th>
      		<label for="useraddress">* ADDRESS</label>
      	</th>
      	<td>
      		<input type="text" name="addnumber" class="inputText inputAddnumber" readonly>
      		<input type="button" class="postBtn" onclick="findAddressEvent()" value="우편번호"><br>
      		<input type="text" name="addname" class="inputText inputAddname" readonly><br>
      		<input type="text" name="adddetail" class="inputText inputAdddeatil">
      		<div class="status">상세주소를 입력하세요.(필수x)</div>
      	</td>      
      </tr>
      <tr>
      	<th>
      		<label for="userdepartment">* DEPARTMENT</label>
      	</th>	    
	    <td>
	    	<select name="department" class="selectDepartment">
	    	<option value="" selected disabled hidden>==선택==</option>
	        <option value="1">총무팀</option>
	        <option value="2">인사팀</option>
	        <option value="3">회계팀</option>
	        <option value="4">영업 1팀</option>
	        <option value="5">영업 2팀</option>
	        <option value="6">해외영업팀</option>
	        <option value="7">개발 1팀</option>
	        <option value="8">개발 2팀</option>
	        <option value="9">개발 3팀</option>
	        <option value="10">품질보증팀</option>         
	      	</select>
	  	</td>
      </tr>
      <tr>  
      	<th>
      		<label for="userposition">* POSITION</label>
      	</th>
      	<td>
      		<select name="position" class="selectPosition">
      		<option value="" selected disabled hidden>==선택==</option>
	        <option value="1">사원</option>
	        <option value="2">주임</option>
	        <option value="3">대리</option>
	        <option value="4">과장</option>
	        <option value="5">차장</option>
	        <option value="6">팀장</option>
	        <option value="7">부장</option>         
	    	</select>
	    </td>
      </tr>
      <tr>
      	<th>
      		<label for="useremail">* EMAIL</label>
      	</th>
      	<td>
      		<input type="text" name="emailf" class="inputText inputEmailf">
      		<span class="a">@</span>
      		<input type="text" name="emailb" class="inputText inputEmailb">
      		<input type="hidden" name="email">
            <select name="mailslc" class="emailSelect">
                <option value="self" selected>직접입력</option>
                <option value="naver.com">naver.com</option>
                <option value="gmail.com">gmail.com</option>
                <option value="daum.com">daum.com</option>
                <option value="yahoo.com">yahoo.com</option>
            </select>      		
      	</td>
      </tr>    
      <tr>
      	<th>
      		<label for="userbirth">*BIRTH</label>
      	</th>	
      	<td><input type="text" name="birth" class="inputText inputBirth" minlength="6" placeholder="ex) 950101"></td>
      </tr> 
      <tr>
      	<th>
      		<label for="usergender">*GENDER</label>
      	</th>
		<td>
			<label for="male"><input id="male" type="radio"  value="Male" name="gender" class="checkGender" checked>남성</label>
			<label for="female"><input id="female" type="radio" value="Female" name="gender" class="checkGender">여성</label>
		</td>
      </tr>
      </table>
      
      	<input type="submit" class="joinButton" value="JOIN">
      
      <a class="cancelBtn" href="${pageContext.request.contextPath }/login">Login</a>
   </form> 
</div>
</div>  

