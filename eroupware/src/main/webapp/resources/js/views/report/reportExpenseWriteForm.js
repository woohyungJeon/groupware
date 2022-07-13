// 레디 펑션
$(function() {
	// 멤버 선택하기 이벤트
	modalEvent();
	reportMemberSelectBoxEvent();
	getMemberInfo();
	// 기안일자에 오늘날짜 넣어주기
	getToday();
	expenseWriteCheck();
});

// 멤버 선택하기 이벤트
// 모달창 이벤트

// 모달창 이벤트
function modalEvent() {
	
	var modal = $(".reportModal");
	
	$(".td_member_input").click(function() {
		$('html').css({'overflow': 'hidden', 'height': '100%'});
		modal.show();
	});
	
	
	modal.click(function(e) {
		if(e.target.classList.contains("modal-overlay")) {
			$('html').css({'overflow': 'auto', 'height': '100%'});
			modal.hide();
		}
	});
	
	$(".modalCloseBtn").click(function() {
		$('html').css({'overflow': 'auto', 'height': '100%'});
		modal.hide();
	});

}

// 멤버 셀렉트 박스 이벤트
function reportMemberSelectBoxEvent() {
	
	// 멤버 선택박스에서 선택하기
	$(".memberListAreaByDept li").click(function() {

		var memberId = $(this).attr("data-id");
		var memberName = $(this).text();
		
		// 나 자신 선택아닐경우
		if(!$(this).hasClass("me")) {
			// 선택된 멤버일 경우
			if($(this).hasClass("on")) {
				// 선택된 멤버박스에서 지워주기
				$(".td_rank").val("");
				$(".selectedMemberHidden[value="+memberId+"]").remove();
				$(this).removeClass("on");
			// 선택되지 않은 멤버일경우
			} else {
				$(".td_rank").val("");
				$(".selectedMemberHidden").remove();
				$(".memberListAreaByDept li.on").not("me").removeClass("on");
				
				var selectedMemberHidden = $("<input></input>", {
					type: "hidden",
					class : "selectedMemberHidden",
					name: "r_approver",
					value: memberId
				});
				
				$(".td_rank").val(memberName);
				$(".td_rank").append(selectedMemberHidden);

				$(".reportModal").hide();
				/*selectedArea.append(selectedMemberSpan);
				selectedArea.append(selectedMemberHidden);*/
				$(this).addClass("on");
			}
		}
		
	});
	
	// 참여 멤버에 선택된 멤버 해제
	$(document).on("click", ".selectedMemberSpan", function() {
		
		if(!$(this).hasClass("me")) {
			var memberId = $(this).attr("data-id");
			$(".memberListAreaByDept li[data-id="+memberId+"]").removeClass("on");
			$(".selectedMemberHidden[value="+memberId+"]").remove();
			$(this).remove();
		}
	});
}
// 기안일자에 오늘날짜 넣어주기
function getToday() {
    var currentDate = new Date();  

    var calendar = currentDate.getFullYear() + "-" + (currentDate.getMonth()+1) + "-" + currentDate.getDate() // 현재 날짜
    
    $(".td_reportDay").text(calendar);
}

// 지출품의서 입력검사
// 업무협조요청서 입력검사
function expenseWriteCheck() {	
	
	$(".reportForm").submit(function() {
		
		var approver = $(".selectedMemberHidden").length;
		var title = $(".titleInput").val();
		var content = $(".contentTextarea").val().trim();
		
		if(approver < 1) {
			alert("결재권자를 선택해주세요");
			return false;	
		} else if(title.length < 1) {
			alert("제목을 입력하세요.");
			$(".titleInput").focus();
			return false;
		} else if(title == "[지출품의서] - ") {
			alert("제목을 입력하세요.");
			$(".titleInput").focus();
			return false;
		} else if(content.length < 1) {
			alert("내용을 입력하세요.");
			$(".contentTextarea").focus();
			return false;
		}
		
	});

}
