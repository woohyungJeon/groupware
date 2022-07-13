$(function(){
	// nav 퀵메모 이벤트
	quickMemoEvent();
	
	// nav 로그인 유저 정보 가져오기
	getMemberInfo();
	
	// 네비사이드바 길이 조정
	setNavHeight();
	
	// 출퇴근 버튼 이벤트
	workButtonEvent();
	
	showToastrMsgAlert();
});

// nav 퀵메모 이벤트
function quickMemoEvent() {
	
	var quickMemoArea = $("#nav .myQuickMemo .quickMemoArea");
	var quickMemoAreaPre = $("#nav .myQuickMemo .quickMemoArea pre");
	var quickMemoTa = $("#nav .myQuickMemo .quickMemoTa");
	var editIcon = $("#nav .myQuickMemo .editIcon");
	var editCompleteBtn = $("#nav .myQuickMemo .editCompleteBtn");
	
	$("#nav .quickMemoArea").click(function() {
		
		quickMemoArea.hide();
		quickMemoTa.show();
		/*editIcon.hide();*/
		editCompleteBtn.show();
		
		var outputMemo = quickMemoAreaPre.text();
		console.log(outputMemo);
		quickMemoTa.val(outputMemo);
		quickMemoTa.focus();
	});
	
	$("#nav .editCompleteBtn").click(function() {
		
		quickMemoArea.show();
		quickMemoTa.hide();
		/*editIcon.show();*/
		editCompleteBtn.hide();
		
		
		var inputMemo = quickMemoTa.val();
		
		$.ajax({
			url: utils.getContextPath() + "/main/updateMemberMemo",
			type: "post",
			data: {"qmemo": inputMemo},
			dataType: "json",
			success: function(json) {
				if(json.result == 0) {
					alert("메모 수정 실패");
				}
			},
			error: function(xhr, textStatus, errorThrown) {
				alert("[Error] " + xhr.status + " " + textStatus + " " + errorThrown);
			}
		});
		
		quickMemoAreaPre.text(inputMemo);
	});
	
	quickMemoTa.keyup(function() {
		var str = $(this).val();
		var str_arr = str.split("\n");  // 줄바꿈 기준으로 나눔 
		var row = str_arr.length;  // row = 줄 수 
		if(row > 7){
			//마지막 입력문자 삭제
			alert("7줄 이상 입력할 수 없습니다.")
			var lastChar = str.slice(0,-1); //열 
			$(this).val(lastChar);
		}
	});
	
}

// nav 유저 정보 가져오기
function getMemberInfo() {
	
	$.ajax({
			url: utils.getContextPath() + "/main/memberInfo",
			type: "post",
			/*data: {"loginId": "0000002"},*/
			dataType: "json",
			success: function(json) {
				  
				$(".myInfo .memberName").text(json.name);
				$(".myInfo .memberId").text(json.id);
				$(".myInfo .memberDept").text(json.deptname + " " + json.rankname);
				$(".myInfo .memberEmail").text(json.email);
				
				$('.myInfo .memberImage').attr('src', utils.getContextPath() + "/resources/storage/" + json.image);
				
				$("#nav .myQuickMemo .quickMemoArea pre").text(json.qmemo);

			},
			error: function(xhr, textStatus, errorThrown) {
				alert("[Error] " + xhr.status + " " + textStatus + " " + errorThrown);
			}
		});
}

// 네비 사이드바 세로길이 조정
function setNavHeight() {
	var wrapHeight = $("#wrap").height();
	
	$("#nav").height(wrapHeight+80);
}


// 출근퇴근 버튼 이벤트
function workButtonEvent() {
	$(".workBtn").click(function() {
		
		var session_memberId = $(".session_memberId").val();
		var timeFlag;
		var message;
		
		if($(this).hasClass("workStartBtn")) {
			timeFlag = "startTime";
			message = "출근"
		} else if($(this).hasClass("workEndBtn")) {
			timeFlag = "endTime";
			message = "퇴근"
		}
		
		$.ajax({
			url: utils.getContextPath() + "/work",
			type: "post",
			data: {
				"id": session_memberId,
				"timeFlag": timeFlag
				},
			dataType: "json",
			success: function(json) {
				if(json.result == 1) {
					//toastr.success(message + " 처리 완료되었습니다.");
					alert(message + " 처리 완료되었습니다.");
				} else if(json.result == 2) {
					alert("이미 완료된 처리입니다.");
				} 
			},
			error: function(xhr, textStatus, errorThrown) {
				alert("[Error] " + xhr.status + " " + textStatus + " " + errorThrown);
			}
		});
	});

}


function showToastrMsgAlert() {
	var msg = $(".toastrMsg").attr("data-msg");
	if(msg.length > 0) {
		toastr.success(msg);
	}
}



