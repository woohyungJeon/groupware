<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<span id="main">메인페이지</span><br>
	
	<a href="${pageContext.request.contextPath }/insert">insert 테스트페이지</a><br>
	<a href="${pageContext.request.contextPath }/test">테스트페이지</a><br>
	<a href="${pageContext.request.contextPath }/utiltest?pg=1">유틸페이지</a><br>
	<a href="${pageContext.request.contextPath }/main/1">레스트풀테스트</a><br>
	
