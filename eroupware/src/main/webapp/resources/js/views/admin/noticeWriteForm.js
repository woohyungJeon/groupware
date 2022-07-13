/*window.onload = function() {
	CKEDITOR.replace('content', {
		allowedContent: true,
		config.resize_enabled = false,
	});
}
*/

$(function() {
	CKEDITOR.replace('content', ckeditor_config);
	checkForm();
	
});


var ckeditor_config = {
	resize_enabled: false,
	enterMode: CKEDITOR.ENTER_BR,
	shiftEnterMode: CKEDITOR.ENTER_P,
};

function checkForm() {
	$(".writeForm").submit(function() {
		var title = $(".input_titlesub").val().trim();
		
		if(title.length == 0) {
			alert("제목을 입력해주세요.");
			$(".input_titlesub").focus();
			return false;
		}else if(CKEDITOR.instances.content.getData().trim() =='' || CKEDITOR.instances.content.getData().trim().length ==0) {
			alert("내용을 입력해주세요.");
			CKEDITOR.instances.content.focus();
			return false;
		}	
			
	});
	
}



