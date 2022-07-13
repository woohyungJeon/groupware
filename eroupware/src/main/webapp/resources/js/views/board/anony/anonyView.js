$(function() {
	likeEvent();	
});

function likeEvent() {
	$(".likeImg").click(function() {
		var anonyNo = $(".anonyNo").val();
		var likeFlag;
		var likeCount = Number($(".td_likesub").text());
		
		if($(this).hasClass("like")) {
			likeFlag = 1;
			$(this).removeClass("like");
			$(this).addClass("dislike");
			likeCount--;	
		} else if($(this).hasClass("dislike")) {
			likeFlag = 0;
			$(this).removeClass("dislike");
			$(this).addClass("like");
			likeCount++;
		}
		
		$.ajax({
			url: utils.getContextPath() + "/anony/updateLike",
			type: "post",
			data: {"anonyNo": anonyNo, "likeFlag" : likeFlag},
			dataType: "json",
			success: function(json) {
				if(json.result == 0) {
					alert("좋아요 실패");
				}
			},
			error: function(xhr, textStatus, errorThrown) {
				alert("[Error] " + xhr.status + " " + textStatus + " " + errorThrown);
			}
		});
		$(".td_likesub").text(likeCount);
		
		
	});
}