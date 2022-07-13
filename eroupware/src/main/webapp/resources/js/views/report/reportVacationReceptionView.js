// 레디 펑션
$(function() {
	approveEvent();
});

function approveEvent() {
	
	$(".reportBtn").click(function() {
	
		var flag;
		
		if($(this).hasClass("approveBtn")) {
			flag = 'Y';	//승인
		} else {
			flag = 'F';	//반려
		}

		var seq_ew_draft = $(".seq_ew_draft").val();
		
		if(confirm("결재하시겠습니까?")) {
			
			$.ajax({
				url: utils.getContextPath() + "/report/vacationApprove/"+seq_ew_draft,
				type: "post",
				data: {"flag": flag},
				dataType: "json",
				
				success: function(json) {
					if(json.result > 0) {
						if(flag == 'Y') {
							alert("결재가 승인되었습니다.");
							$(".td_sign").text("승인");
						} else {
							alert("결재가 반려되었습니다.");
							$(".td_sign").text("반려");
						}
					}
				},
				error: function(xhr, textStatus, errorThrown) {
					alert("[Error] " + xhr.status + " " + textStatus + " " + errorThrown);
				}
			});	
		}
	});
}