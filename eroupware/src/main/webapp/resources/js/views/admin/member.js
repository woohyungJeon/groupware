$(function() {
	approvalEvent();
});

// 회원 승인 이벤트
function approvalEvent() {
	$(".approvalBtn").click(function() {
		var id = $(this).attr("data-id");
		var name = $(this).attr("data-name");

		if (confirm(name + "님의 가입을 승인하시겠습니까?")) {
			$.ajax({
				url: utils.getContextPath() + "/admin/member/" + id,
				type: "post",
				dataType: "json",
				success: function(json) {
					if (json.result > 0) {
						$(".list_css[data-id="+id+"]").remove();
						alert("가입 승인 완료 되었습니다.");
					}
				},
				error: function(xhr, textStatus, errorThrown) {
					alert("[Error] " + xhr.status + " " + textStatus + " " + errorThrown);
				}
			});
		}

	});
}
