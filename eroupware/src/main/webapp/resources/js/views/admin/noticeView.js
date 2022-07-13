$(function() {
	
	$(".btn_delete").click(function() {
		var seq = $(".hiddenSeq").val();
		if(confirm("정말 삭제하시겠습니까?")) {
			location.href=utils.getContextPath() + "/admin/notice/delete/"+seq;
		}
		
	});
	
	
	
});


