// 레디 펑션
$(function() {
	// 멤버 선택하기 이벤트
	modalEvent();
	reportMemberSelectBoxEvent();
	getMemberInfo();
	// 기안일자에 오늘날짜 넣어주기
	getToday();
	vacationWriteCheck();
	datepickerEvent();
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

$.datepicker.setDefaults({
        dateFormat: 'yy-mm-dd',
        prevText: '이전 달',
        nextText: '다음 달',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        yearSuffix: '년'
    });
    
function datepickerEvent() {
	$(".startDate").datepicker();
	$(".endDate").datepicker();
	
}

// 휴가신청서 입력검사
function vacationWriteCheck() {	
	
	$(".reportForm").submit(function() {
		var approver = $(".selectedMemberHidden").length;
		var title = $(".titleInput").val();
		var content = $(".contentTextarea").val().trim();
		var start_date = $(".startDate").val();
		var end_date = $(".endDate").val();
		var radio = $(':radio[name="r_type"]:checked').length;
		
		
		
		if(approver < 1) {
			alert("결재권자를 선택해주세요");
			return false;	
		} else if(radio < 1) {
			alert("휴가종류를 선택해주세요.");
			return false;
		} else if (start_date.length < 1){
			alert("시작날짜를 선택해주세요.");
			$(".startDate").focus();
			return false;
		} else if(end_date.length < 1) {
			alert("종료날짜를 선택해주세요.");
			$(".endDate").focus();
			return false;
		} else if(new Date(start_date) > new Date(end_date)) {
			alert("종료날짜는 시작날짜보다 빠를 수 없습니다.");
			$(".endDate").focus();
			return false;
		} else if(title.length < 1) {
			alert("제목을 입력하세요.");
			$(".titleInput").focus();
			return false;
		} else if(title == "[휴가신청서] - ") {
			alert("제목을 입력하세요.");
			$(".titleInput").focus();
			return false;
		} else if(content.length < 1) {
			alert("내용을 입력하세요.");
			$(".contentTextarea").focus();
			return false;
		} else {
			$(".r_Start").val(start_date + "~" + end_date);
		}
		
	});

}

