<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
	
<script type="text/javascript">
window.onload = function() {
		if(${result > 0}) {
			alert("저장되었습니다");
			location.href="${pageContext.request.contextPath }/notice/${noticeDTO.seq}";
		} else {
			alert("저장하지 못했습니다");
			history.back();
		} 
	}
</script>