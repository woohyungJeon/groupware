<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%-- <tiles:getAsString name = "어트리뷰트이름" ignore = "true/false"/>
<tiles:insertAttribute name = "어트리뷰트이름" flush = "플러쉬여부" ignore = "에러무시여부"/> --%>

<tiles:importAttribute name="javascripts"/>
<tiles:importAttribute name="stylesheets"/>
<tiles:importAttribute name="favicon"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
	<!-- favicon 설정 -->
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/resources/img/<tiles:insertAttribute name="favicon" />">
	
	<!-- stylesheets -->
    <c:forEach var="css" items="${stylesheets}">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/<c:url value="${css}"/>.css">
    </c:forEach>
    <!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
    <!-- end stylesheets -->
    
    
    <!-- CDN 방식이 아닐 시 이미지가 깨져서 얘만 따로 가져옴 -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
	
</head>
<body>
	<div class="loader-moving">
		<span class="left"></span> <span class="right"></span>
	</div>

    <!-- header -->
	<tiles:insertAttribute name="header" />
	<!-- end header  -->
	
	<!-- body -->
	<div id="wrap">
		<tiles:insertAttribute name="body" />
	</div>
	<!-- end body -->
	
	<!-- scripts -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <c:forEach var="js" items="${javascripts}">
        <script src="${pageContext.request.contextPath }/resources/<c:url value="${js}"/>.js"></script>
    </c:forEach>
	<!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script> -->
    <!-- end scripts -->
</body>
</html>



