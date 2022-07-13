$(function() {
	
	// 모달창 이벤트
	modalEvent();
	
	// 프로젝트 멤버 셀렉트 박스 이벤트
	todoMemberSelectBoxEvent();
	
	// 프로젝트 멤버 셀렉트로 나를 추가
	addSelectedMemberToMe();
	
	// 프로젝트 추가 유효성 검사
	validateAddTodoForm();
	
	// 프로젝트 진행률 증가시키기 애니메이션
	numberIncreaseAnimation();
	
});


// 모달창 이벤트
function modalEvent() {
	
	var modal = $(".newProjectModal");
	
	$(".newProjectBtn").click(function() {
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

// 투두 멤버 셀렉트 박스 이벤트
function todoMemberSelectBoxEvent() {
	var selectedArea = $(".selectedMemberArea");
	
	// 멤버 선택박스에서 선택하기
	$(".memberListAreaByDept li").click(function() {
		
		var memberId = $(this).attr("data-id");
		var memberName = $(this).text();
		
		// 나 자신 선택아닐경우
		if(!$(this).hasClass("me")) {
			// 선택된 멤버일 경우
			if($(this).hasClass("on")) {
				// 선택된 멤버박스에서 지워주기
				$(".selectedMemberSpan[data-id="+memberId+"]").remove();
				$(".selectedMemberHidden[value="+memberId+"]").remove();
				$(this).removeClass("on");
			// 선택되지 않은 멤버일경우
			} else {
				var selectedMemberSpan = $("<span></span>", {
					class: "selectedMemberSpan",
					text: memberName,
					"data-id" : memberId
				});
				var selectedMemberHidden = $("<input></input>", {
					type: "hidden",
					class : "selectedMemberHidden",
					name: "idArr",
					value: memberId
				});
				selectedArea.append(selectedMemberSpan);
				selectedArea.append(selectedMemberHidden);
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

// 투두 멤버 셀렉트로 나를 추가
function addSelectedMemberToMe() {
	var $me = $(".memberListAreaByDept li.me");
	var memberName = $me.text();
	var memberId = $me.attr("data-id");
	
	var selectedMemberSpan = $("<span></span>", {
			class: "selectedMemberSpan me",
			text: memberName,
			"data-id" : memberId
	});
	var selectedMemberHidden = $("<input></input>", {
			type: "hidden",
			class : "selectedMemberHidden",
			name: "idArr",
			value: memberId
	});
	$(".selectedMemberArea").append(selectedMemberSpan);
	$(".selectedMemberArea").append(selectedMemberHidden);
}

// 투두 추가 유효성 검사
function validateAddTodoForm() {
	var form = $(".projectAddForm");
	
	form.submit(function() {
		var selectedMemberLength = $(".selectedMemberSpan").length;
		
		if(!$(".inputTitle").val().trim()) {
			alert("프로젝트 제목을 입력해주세요.");
			$(".inputTitle").focus();
			return false;
		} else if(!$(".inputContent").val().trim()) {
			alert("프로젝트 내용을 입력해주세요.");
			$(".inputContent").focus();
			return false;
		} else if(selectedMemberLength < 2) {
			alert("최소 2명이상의 참여멤버가 필요합니다.")
			return false;
		} else {
			form.submit();
		}
	});
}

// 진행률 증가시키기 애니메이션
function numberIncreaseAnimation() {
	
	$(".percentSpan").each(function() {
		var $this = $(this);
		var percent = $(this).attr("data-percent");
  
		$({ val : 0 }).animate({ val : percent }, {
			duration: 1500,
		  	step: function() {
				console.log("value :: " + this.val);
		    	$this.text(Math.floor(this.val)+"%");
		 	},
		  	complete: function() {
		    	$this.text(Math.floor(this.val)+"%");
		  	}
		});	
		
	});
	
}

