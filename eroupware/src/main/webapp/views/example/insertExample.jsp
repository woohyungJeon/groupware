<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<form action="${pageContext.request.contextPath }/insert" method="post">
	이름<input type="text" name="name"><br>
	나이<input type="text" name="age"><br>
	메모<input type="text" name="memo"><br>
	<input type="submit" value="등록">
	</form>
	