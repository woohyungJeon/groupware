$(function(){
	
   // 로드시 화면전환 효과 제거
   $(".loader-moving").addClass("end");
   
   memberSelectBoxEvent();
   
}); /*** 레디펑션 끝 ***/


// 멤버 선택 박스 이벤트
function memberSelectBoxEvent() {
	
	$(".department_li > span").click(function() {
		$(this).next("ul").slideToggle("200");
		changePlusMinusImg($(this));
	});
	
	
}

// 멤버 선택 박스 부서 클릭시 아이콘 변경
function changePlusMinusImg(that){
	
	var plusminusValue = that.find(".plusminusIcon").text();
	
	if(plusminusValue == "＋") {
		that.find(".plusminusIcon").text("－");
	} else {
		that.find(".plusminusIcon").text("＋");
	}
	
}





