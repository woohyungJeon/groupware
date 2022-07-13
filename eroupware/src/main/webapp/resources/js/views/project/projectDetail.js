$(function() {
	
	// 모달창 이벤트
	modalEvent();
	
	// 태스크 추가 유효성 검사
	validateAddTaskForm();
	
	// 프로젝트 전체 차트 그리기
	drawProjectTotalChart();
	
	// 프로젝트 멤버별 바 그래프 그리기
	drawBargraph();
	
	// 파일 업로드 이벤트
	fileInputEvent();
	
	// 태스크 상태 변경 이벤트
	updateTaskStatus();
	
	// 프로젝트 리스트 가기 버튼 이벤트
	projectListBtnEvent();
	
	// 프로젝트 수정 모달창 이벤트
	projectUpdateModalEvent();
	
});


// 모달창 이벤트
function modalEvent() {
	
	var modal = $(".newTaskModal");
	
	$(".newTaskBtn").click(function() {
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


// 투두 추가 유효성 검사
function validateAddTaskForm() {
	var form = $(".taskAddForm");
	
	form.submit(function() {
		
		if(!$(".inputTitle").val().trim()) {
			alert("태스크 제목을 입력해주세요.");
			$(".inputTitle").focus();
			return false;
		} else if(!$(".inputContent").val().trim()) {
			alert("태스크 내용을 입력해주세요.");
			$(".inputContent").focus();
			return false;
		} else {
			form.submit();
		}
	});
}

function drawProjectTotalChart() {
	
	var processCnt = $(".processCnt").val();
	var waitCnt = $(".waitCnt").val();
	var completeCnt = $(".completeCnt").val();
	
	var context = document.getElementById('projectTotalChart').getContext('2d');
	new Chart(context, {
		type: 'doughnut',
		options : {
			animation: {
            	duration: 5000,
        	}
		},
		data : {
			labels : ["대기", "진행", "완료"],
			datasets : [ {
				backgroundColor: ["#dbdbdb", "orange", "#38BE5E"],
				data : [waitCnt, processCnt, completeCnt]
			}]
		},
		
	});
}




// 멤버 테스크 바 그래프 그리기
function drawBargraph() {
    $(".progressBarOuter > .progressBarInner").each(function (i) {
        var $this  = $(this);
        var skills = $this.attr('data-width');
    
    	$this.css({'width' : skills + '%'});
	});
}


// 파일 입력 이벤트
function fileInputEvent() {
	$(".fileBtn").change(function() {
		var filename = $(this).val().replace(/^.*\\/, "");
		
		$(".fileSpan").text(filename);
	});
}

// 태스크 상태 변경
function updateTaskStatus() {
	$(".updateStatusSelect").change(function() {
		var projectNo = $(".projectNo").val();
		var taskNo = $(this).attr("data-taskNo");
		var status = $(this).val();
		
		// 삭제 클릭
		if(status == "delete") {
			if(confirm("정말 삭제하시겠습니까?")) {
				location.href=utils.getContextPath() + "/project/deleteTask?taskNo="+taskNo+"&projectNo="+projectNo;
				return;
			}
		}
		
		var id = $(this).attr("data-id");
		var status_old = $(this).attr("data-status");
		
		
		// 상태변경용 ajax
		$.ajax({
			url: utils.getContextPath() + "/project/updateTaskStatus",
			type: "post",
			data: {"status": status, "taskNo" : taskNo},
			dataType: "json",
			success: function(json) {
				if(json.result == 0) {
					alert("상태 변경 실패");
				}
			},
			error: function(xhr, textStatus, errorThrown) {
				alert("[Error] " + xhr.status + " " + textStatus + " " + errorThrown);
			}
		});
		
		// 리스트 맨앞 상태표시 동그라미 클래스값 바꾸기
		$(".taskStatusSpan[data-taskNo=" + taskNo + "]").removeClass("wait process complete");
		$(".taskStatusSpan[data-taskNo=" + taskNo + "]").addClass(status);
		
		// 이전상태에 따라서 전체 카운트 개수 재설정하기
		if(status_old == "wait") {
			var waitCnt = parseInt($(".waitCnt").val())-1;
			$(".waitCnt").val(waitCnt);
		} else if(status_old == "process") {
			var processCnt = parseInt($(".processCnt").val())-1;
			$(".processCnt").val(processCnt);
		} else if(status_old == "complete") {
			var completeCnt = parseInt($(".completeCnt").val())-1;
			$(".completeCnt").val(completeCnt);
		}
		
		$(this).attr("data-status", status);
		
		var newStatusValue = parseInt($("."+status+"Cnt").val())+1;
		
		$("."+status+"Cnt").val(newStatusValue);
		
		
		// 멤버 그래프 그려주기
		var memberTotalCnt = $(".progressBarOuter[data-id=" + id + "]").attr("data-totalcnt");
		var memberCompleteCnt = $(".progressBarOuter[data-id=" + id + "]").attr("data-completecnt");
		var completeCnt_new;
		
		
		if(status == "complete") {
			completeCnt_new = parseInt(memberCompleteCnt)+1;
		} else if(status == "wait" || status == "process") {
			
			if(parseInt(memberCompleteCnt) < 1) {
				completeCnt_new = 0;
			}
			
			if(status_old == "complete") {
				completeCnt_new = parseInt(memberCompleteCnt)-1;
			} else {
				completeCnt_new = memberCompleteCnt;
			}
		}
		
		var percent_new = (parseInt(completeCnt_new) * 100) / memberTotalCnt;

		percent_new = Math.floor(percent_new);

		$(".progressBarOuter[data-id=" + id + "]").attr("data-completecnt", completeCnt_new);
		$(".progressBarInner[data-id=" + id + "]").attr("data-width", percent_new);
		
		$(".percentTextSpan[data-id=" + id + "]").text(percent_new+"%");
		
		
		drawBargraph();
		
		drawProjectTotalChart();
		
	});
	
}

// 프로젝트 리스트 가기 버튼 이벤트
function projectListBtnEvent() {
	$(".projectListBtn").click(function() {
		location.href = utils.getContextPath() + "/project"
	});
}

// 프로젝트 수정 모달창 이벤트
function projectUpdateModalEvent() {
	
	var modal = $(".newProjectModal");
	
	$(".settingIcon").click(function() {
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
	
	
	$(".selectedMemberHidden").each(function() {
		var id = $(this).val();
		$(".memberListAreaByDept li[data-id="+id+"]").addClass("on old");
	});
	
	
	$(".memberListAreaByDept li").click(function() {
		var memberId = $(this).attr("data-id");
		var memberName = $(this).text();
		
		
		if(!$(this).hasClass("me")) {
			if(!$(this).hasClass("old")) {
				if($(this).hasClass("on")) {
					$(".selectedMemberSpan[data-id="+memberId+"]").remove();
					$(".selectedMemberHidden[value="+memberId+"]").remove();
					$(this).removeClass("on");
				} else {
					var selectedArea = $(".selectedMemberArea");
					var selectedMemberSpan = $("<span></span>", {
						class: "selectedMemberSpan",
						text: memberName,
						"data-id" : memberId
					});
					var selectedMemberHidden = $("<input></input>", {
						type: "hidden",
						class : "selectedMemberHidden",
						name: "idArrNew",
						value: memberId
					});
					
					selectedArea.append(selectedMemberSpan);
					selectedArea.append(selectedMemberHidden);
					
					$(this).addClass("on");
				}
			} else {
				alert("기존 프로젝트 멤버는 제외 불가능합니다.");
			}
		} else {
			alert("기존 프로젝트 멤버는 제외 불가능합니다.");
		}
	});
	
	// 참여 멤버에 선택된 멤버 해제
	$(document).on("click", ".selectedMemberSpan", function() {
		
		if($(this).hasClass("old")) {
			alert("기존 프로젝트 멤버는 제외 불가능합니다.");
		} else {
			var memberId = $(this).attr("data-id");
			$(".memberListAreaByDept li[data-id="+memberId+"]").removeClass("on");
			$(".selectedMemberHidden[value="+memberId+"]").remove();
			$(this).remove();
		}
	});
	
}
