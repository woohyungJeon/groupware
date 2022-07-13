$(function() {
	
	// 모달창 이벤트
	modalEvent();
	
	// 투두 멤버 셀렉트 박스 이벤트
	todoMemberSelectBoxEvent();
	
	// 투두 멤버 셀렉트로 나를 추가
	addSelectedMemberToMe();
	
	// 투두 추가 유효성 검사
	validateAddTodoForm();
	
	// 개인 투두 카드 이벤트
	personalTodoCardEvent();
	
	// 카드 컬러 변경 팝업 이벤트
	todoCardColorPopupEvent();
});




// 모달창 이벤트
function modalEvent() {
	var modal = $(".newTodoModal");
	$(".newTodoBtn").click(function() {
		$('html').css({'overflow': 'hidden', 'height': '100%'});
		
		var cardLength = $(".todoCard").length;
		if(cardLength > 19) {
			alert("개인업무는 20개까지 생성가능합니다.");
			return false;
		}
		
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
	
	$(".inputTodoRadio").change(function() {
		var value = $(this).val();
		
		if(value=="personal") {
			$(".newTodoModal .inputTodoArea").removeClass("teamType");
			$(".selectedMemberTitle").hide();
			$(".selectedMemberArea").hide();
			$(".inputMemberArea").hide();
		} else if(value == "team") {
			$(".newTodoModal .inputTodoArea").addClass("teamType");
			$(".selectedMemberTitle").show();
			$(".inputMemberArea").show();
			$(".selectedMemberArea").show();
		}
	});

}

// 투두 멤버 셀렉트 박스 이벤트
function todoMemberSelectBoxEvent() {
	var selectedArea = $(".selectedMemberArea");
	
	$(".memberListAreaByDept li").click(function() {
		
		var memberId = $(this).attr("data-id");
		var memberName = $(this).text();
		
		if(!$(this).hasClass("me")) {
			if($(this).hasClass("on")) {
				$(".selectedMemberSpan[data-id="+memberId+"]").remove();
				$(this).removeClass("on");
			} else {
				var selectedMemberSpan = $("<span></span>", {
					class: "selectedMemberSpan",
					text: memberName,
					"data-id" : memberId
				});
				selectedArea.append(selectedMemberSpan);
				$(this).addClass("on");
			}
		}
		
	});
	
	$(document).on("click", ".selectedMemberSpan", function() {
		
		if(!$(this).hasClass("me")) {
			var memberId = $(this).attr("data-id");
			$(".memberListAreaByDept li[data-id="+memberId+"]").removeClass("on");
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
	$(".selectedMemberArea").append(selectedMemberSpan);
	
}

// 투두 추가 유효성 검사
function validateAddTodoForm() {
	var form = $(".todoAddForm");
	
	form.submit(function() {
		
		if(!$(".inputTitle").val().trim()) {
			alert("업무 제목을 입력해주세요.");
			$(".inputTitle").focus();
			return false;
		} else if(!$(".inputContent").val().trim()) {
			alert("업무 내용을 입력해주세요.");
			$(".inputContent").focus();
			return false;
		} else {
			form.submit();
		}
	});
}


// 개인 업무 카드 이벤트
function personalTodoCardEvent() {
	
	var cardLength = $(".todoCard").length;
	
	$(".todoCardInfo").text("생성된 카드 " + cardLength + "/20");
	
	// 수정 버튼
	$(".todoCardModifyBtn").click(function() {
		var content_og = $(this).closest(".todoCard").find("pre").text();
		
		var todoCardContent = $(this).closest(".todoCard").find(".todoCardContent");
		var todoCardTa = $(this).closest(".todoCard").find(".todoCardTa");
		var todoCardCompleteBtn = $(this).closest(".todoCard").find(".todoCardCompleteBtn");
		
		todoCardContent.hide();
		todoCardTa.text(content_og);
		todoCardTa.show();
		todoCardCompleteBtn.show();
		todoCardTa.focus();
		$(this).hide();
		
	});
	
	// 수정완료버튼
	$(".todoCardCompleteBtn").click(function() {
		var content_new = $(this).closest(".todoCard").find(".todoCardTa").val();
		var todoNo = $(this).attr("data-todoNo");
		
		
		$.ajax({
			url: utils.getContextPath() + "/todo/updateTodoContent",
			type: "post",
			data: {"content": content_new, "todoNo" : todoNo},
			dataType: "json",
			success: function(json) {
				if(json.result == 0) {
					alert("내용 수정 실패");
				}
			},
			error: function(xhr, textStatus, errorThrown) {
				alert("[Error] " + xhr.status + " " + textStatus + " " + errorThrown);
			}
		});
		
		var todoCardContent = $(this).closest(".todoCard").find(".todoCardContent");
		var todoCardTa = $(this).closest(".todoCard").find(".todoCardTa");
		var todoCardModifyBtn = $(this).closest(".todoCard").find(".todoCardModifyBtn");
		
		todoCardContent.show();
		todoCardContent.find("pre").text(content_new);
		todoCardTa.hide();
		todoCardModifyBtn.show();
		$(this).hide();
		
	});
	
	$(".todoCardDeleteBtn").click(function() {
		var todoNo = $(this).attr("data-todoNo");
		
		$.ajax({
			url: utils.getContextPath() + "/todo/deleteTodo",
			type: "post",
			data: {"todoNo" : todoNo},
			dataType: "json",
			success: function(json) {
				if(json.result == 0) {
					alert("투두 삭제 실패");
				}
			},
			error: function(xhr, textStatus, errorThrown) {
				alert("[Error] " + xhr.status + " " + textStatus + " " + errorThrown);
			}
		});
		
		$(this).closest(".todoCard").remove();
	});
	
}

// 투두 카드 라벨컬러변경 이벤트
function todoCardColorPopupEvent() {
	
	$(".todoCard").click(function(e) {
		if(!$(e.target).is(".todoCardBtn") && !$(e.target).is(".todoCardTa")) {
			//$(".todoCardColorPopup").hide();
			
			var test = $(this).find(".todoCardColorPopup").css("display");
			console.log("test :: " + test);
			
			if($(this).find(".todoCardColorPopup").css("display") == "block") {
				console.log("block");
				$(this).find(".todoCardColorPopup").hide();
			} else {
				$(".todoCardColorPopup").hide();
				$(this).find(".todoCardColorPopup").show();
			}
		}
	});
	
	$(".todoCardColorPopup span").click(function() {
		var color = $(this).attr("class");
		var todoNo = $(this).closest(".todoCardColorPopup").attr("data-todoNo");
		var todoCard = $(this).closest(".todoCard");
		
		$.ajax({
			url: utils.getContextPath() + "/todo/updateTodoColor",
			type: "post",
			data: {"todoNo": todoNo, "color" : color},
			dataType: "json",
			success: function(json) {
				if(json.result == 0) {
					alert("색상 변경 실패");
				}
			},
			error: function(xhr, textStatus, errorThrown) {
				alert("[Error] " + xhr.status + " " + textStatus + " " + errorThrown);
			}
		});
		
		todoCard.removeClass("red blue green orange purple gray");
		todoCard.addClass(color);
		
	});
	
	
	
}

// 카드위치 바꾸기 이벤트
$(function() {

	$("#todoCardSortable").sortable({
		items: ".todoCard",
		
		update: function(event, ui) {
			var length = $(".todoCard").length;

			$(this).children(".todoCard").each(function(index) {
				
				if($(this).attr("data-sort") != (length - index )) {
					$(this).attr("data-sort", (length - index ));	
				}
				
			});
			saveCardSort();
        }
	});

});


// 변경된 업무 카드 순서 ajax 통신
function saveCardSort() {
	var sortArray= [];
	$(".todoCard").each(function() {
		var obj = {"todoNo" :  $(this).attr("data-todoNo"), "sort" : $(this).attr("data-sort")};
		sortArray.push(obj);
		
	});
	
	$.ajax({
		url: utils.getContextPath() + "/todo/updateCardSort",
		type: "post",
		traditional: true,
		dataType: "json",
		data : {
			"list" : JSON.stringify(sortArray)
		},
		success: function(response) {
			console.log(response);
		},
		error: function(xhr, textStatus, errorThrown) {
			console.log("[Error] " + xhr.status + " " + textStatus + " " + errorThrown);
		}
	});
}

