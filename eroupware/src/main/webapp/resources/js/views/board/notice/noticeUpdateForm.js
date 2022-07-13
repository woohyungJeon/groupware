window.onload = function() {
	CKEDITOR.replace('content', ckeditor_config);
}

var ckeditor_config = {
	resize_enabled: false,
	enterMode: CKEDITOR.ENTER_BR,
	shiftEnterMode: CKEDITOR.ENTER_P,
};
