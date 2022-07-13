$(function() {
	loginSubmitEvent();
	
});


function loginSubmitEvent() {
	
	$(".loginForm").submit(function() {
		var $id = $(".inputId");	
		var $pwd = $(".inputPwd");
		
		if(!$id.val().trim()) {
			alert("아이디를 입력해주세요.");
			$id.focus();
			return false;
		} else if(!$pwd.val().trim()) {
			alert("비밀번호를 입력해주세요.");
			$pwd.focus();
			return false;
		} else {
			
			$.ajax({
			url: utils.getContextPath() + "/login",
			type: "post",
			data: {"id": $id.val(), "pwd" : $pwd.val()},
			dataType: "json",
			success: function(json) {
				
				if(json.enabled == "Y") { // 승인된 계정
					if(json.authority == "Y") {	// 관리자 계정
						location.href=utils.getContextPath() + "/admin/member";
					} else {	// 일반 계정
						location.href=utils.getContextPath() + "/main";
					}
				} else if(json.enabled == 'N') { // 미승인 계정
					alert("승인되지 않은 계정입니다. 관리자에게 문의해주시기 바랍니다.")
				} else {	// 아이디 비밀번호 틀림
					alert("아이디 또는 비밀번호가 틀렸습니다.");
				}
			},
			error: function(xhr, textStatus, errorThrown) {
				alert("[Error] " + xhr.status + " " + textStatus + " " + errorThrown);
			}
		});
			
		}
		
		
	});
	
	
	
}