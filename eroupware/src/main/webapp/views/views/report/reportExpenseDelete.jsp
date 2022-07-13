<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<script type="text/javascript">
	if(${result > 0}) {
		alert("삭제 성공");
	    location.href = "${pageContext.request.contextPath }/expenseList?pg=${pg}";
	} else {
	    alert("삭제 실패");
	    location.href = "${pageContext.request.contextPath }/expenseList/${eDTO.draft_seq}?&pg=${pg}";
	}   
</script>