$(function() {
	passwordCheckEvent();
});

function passwordCheckEvent() {
	
	$(".passwordCheckForm").submit(function() {
		var pwd = $(".password").val();
		if(pwd.trim().length == 0) {
			alert("비밀번호를 입력해주세요");
			$(".password").focus();
			return false;
		} else {
			
			var id = $("#memberId").val();
			
			console.log("id : " + id);
			
			$.ajax({
				url: utils.getContextPath() + "/memberPwdCheck",
				type: "post",
				data: {"id": id, "pwd" : pwd},
				dataType: "json",
				success: function(json) {
					if(json.result > 0) {
						location.href=utils.getContextPath() + "/member/"+id;
					} else {
						alert("비밀번호가 틀렸습니다.");
					}
				},
				error: function(xhr, textStatus, errorThrown) {
					alert("[Error] " + xhr.status + " " + textStatus + " " + errorThrown);
				}
			});
			
		}
		
	});
	
}