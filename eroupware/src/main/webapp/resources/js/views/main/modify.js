$(function() {


	emailSelectEvent();
	findAddressEvent();
	imageChangeEvent();
	
	modifyFormSubmitEvent();

});



function emailSelectEvent() {
	$(".emailSelect").change(function() {
		var value = $(".emailSelect option:selected").val();
		if (value != "self") {
			$(".inputText.emailb").val(value);
			$(".inputText.emailb").prop("readonly", true);
		} else {
			$(".inputText.emailb").val("");
			$(".inputText.emailb").prop("readonly", false);
		}
	});
}


/*다음 API 주소 검색*/
function findAddressEvent() {
	$(".addBtn").click(function() {
		new daum.Postcode({
			oncomplete: function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
				// 예제를 참고하여 다양한 활용법을 확인해 보세요.

				$(".addnumber").val(data.zonecode); //우편번호
				$(".addname").val(data.roadAddress); //도로명
				$(".addDetail").val("(" + data.buildingName + ") "); //도로명
				$(".addDetail").focus();
			}
		}).open();
	});


}

function imageChangeEvent() {
	$(".imageFile").on("change", function(event) {

		var file = event.target.files[0];

		var reader = new FileReader();
		reader.onload = function(e) {

			$(".imageArea").attr("src", e.target.result);
		}

		reader.readAsDataURL(file);
	});
}

function modifyFormSubmitEvent() {
	$(".modifyForm").submit(function() {
		
		var mobile1 = $(".mobile1").val().trim();
		var mobile2 = $(".mobile2").val().trim();
		var mobile3 = $(".mobile3").val().trim();
		
		var addnumber = $(".addnumber").val().trim();
		var addname = $(".addname").val().trim();
		var addDetail = $(".addDetail").val().trim();
		
		var emailf = $(".emailf").val().trim();
		var emailb = $(".emailb").val().trim();
		
		if(mobile1.length < 1) {
			alert("휴대폰 번호를 입력해주세요.");
			$(".mobile1").focus();
			return false;
		} else if(mobile2.length < 1) {
			alert("휴대폰 번호를 입력해주세요.");
			$(".mobile2").focus();
			return false;
		} else if(mobile3.length < 1) {
			alert("휴대폰 번호를 입력해주세요.");
			$(".mobile3").focus();
			return false;
		} else if(addnumber.length < 1) {
			alert("주소를 입력해주세요.");
			$(".addnumber").focus();
			return false;
		} else if(addname.length < 1) {
			alert("주소를 입력해주세요.");
			$(".addname").focus();
			return false;
		} else if(emailf.length < 1) {
			alert("이메일을 입력해주세요.");
			$(".emailf").focus();
			return false;
		} else if(emailb.length < 1) {
			alert("이메일을 입력해주세요.");
			$(".emailb").focus();
			return false;
		} else {
			$(".mobileHidden").val(mobile1+mobile2+mobile3);
			$(".emailHidden").val(emailf+"@"+emailb);
		}
		
	});
}
	