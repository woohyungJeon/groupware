<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 
<div id="loginFormWrap">

	<div class="loginFormArea">
	
		<form action="${pageContext.request.contextPath }/login" method="post" class="loginForm" onsubmit="return false;">	
			<h3>EROUPWARE</h3>
			<label class="inputLabel idLabel">ID</label>
			<input type="text" name="id" class="inputText inputId">
			<label class="inputLabel pwdLabel">PASSWORD</label>
			<input type="password" name="pwd" class="inputText inputPwd">
			<input type="submit" class="loginButton" value="LOGIN">
			<a href="${pageContext.request.contextPath }/join">Join</a>
		</form>
		
	</div>

</div>