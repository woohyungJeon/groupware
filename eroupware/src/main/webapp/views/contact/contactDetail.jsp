<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>eroupware</title>
	<!-- 
	<link rel="stylesheet" type="text/css" href="/ezenit/resources/commons/css/common.css">
	<link rel="stylesheet" type="text/css" href="/ezenit/resources/commons/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/ezenit/resources/commons/css/header.css">
	<link rel="stylesheet" type="text/css" href="/ezenit/resources/commons/css/nav.css">	 
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/views/contact/contactDetail.css">
	
</head>

<body style="overflow-x: hidden; overflow-y: hidden">
<!-- 공통부분 -->
<p style="font-size: 25px;
   		  font-weight: bold;
   		  width: 300px;
   		  border-bottom: 1px solid black;
   		  padding-bottom: 10px;">상세정보</p>

<div class="div_wrap" style="text-align: center;">
	<div class="table_area">
		<table class="table_css">
			<tbody>
 				<tr class="tr_css">
 					<th rowspan="8" style="width: 50%"><img src="${pageContext.request.contextPath }/resources/storage/${contactDetail.image }"/></th>					
		        	<td style="width: 20%">이름: </td>
		        	<td>${contactDetail.name }</td>
		        </tr>                 
		        <tr class="tr_css">		        	
			        <td>전화번호: </td>
		    	    <td>${contactDetail.mobile }</td>
		        </tr>
		        <tr class="tr_css">
		        	<td>주소: </td>
		        	<td>${contactDetail.addname }</td>
		        </tr>
		        <tr class="tr_css">
		        	<td>부서: </td>
		        	<td>${contactDetail.deptname }</td>
		        </tr>
		        <tr class="tr_css">
		        	<td>직급: </td>
		        	<td>${contactDetail.rankname }</td>
		        </tr>
		        <tr class="tr_css">
		        	<td>이메일: </td>
		        	<td>${contactDetail.email }</td>
		        </tr>
		        <tr class="tr_css">
		        	<td>생일: </td>
		        	<td>${contactDetail.birth }</td>
		        </tr>
		        <tr class="tr_css">
		        	<td>입사일: </td>
		        	<td>${contactDetail.hiredate }</td>
		        </tr>
	        </tbody>        
		</table>		
	</div>
</div>
</body>