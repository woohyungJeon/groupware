$(function() {
	joinSubmitEvent();
	memberIdCheck();
	checkPw();
	emailSelectEvent();
 });
 
 /*다음 API 주소 검색*/
 function findAddressEvent(){
	
	 new daum.Postcode({
	 oncomplete: function(data) {
		 // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		 // 예제를 참고하여 다양한 활용법을 확인해 보세요.
 
		 $('[name=addnumber]').val(data.zonecode); //우편번호
		 $('[name=addname]').val(data.roadAddress); //도로명
		 }
	 }).open();
 }
 
 
 function memberIdCheck() {
	 
	 $(".inputId").keyup(function() {
		 var inputId = $(this).val();
		 var reqUrl = utils.getContextPath() + "/idCheck";
		 
		 if(inputId.length < 4) {
			 $(".idCheck").text("사용 불가능한 ID 입니다.");
			 $(".idCheck").css("color", "red");
			 $("#idDoubleCheck").val("false");
		} else {
			 $.ajax({
				 url: reqUrl,
				 type: "post",
				 data: {"id" : inputId },
				 dataType: "json",
				 success: function(json) {
					 if(json.result == 0){
						 console.log("json.result : " + json.result );
						 $(".idCheck").text("사용가능한 ID 입니다.");
						 $(".idCheck").css("color", "green");
						 $("#idDoubleCheck").val("true");
					 }else{
						 console.log("json.result : " + json.result );
						 $(".idCheck").text("사용 불가능한 ID 입니다.");
						 $(".idCheck").css("color", "red");
						 $("#idDoubleCheck").val("false");
					 }				
				 },			error: function(xhr, textStatus, errorThrown) {
					 alert("[Error] " + xhr.status + " " + textStatus + " " + errorThrown);
					 
				 }
			 });
		}
		 
		
	 
	 });
	 
 }
 
 function checkPw() {   
 	
	//$('.inputPwd').on("propertychange change keyup paste input", function(){
	$('.inputPwd').on("input",function(){
	
	 	var id = $(".inputId").val();
		var pw = $(".inputPwd").val();
		var pw2 = $(".inputPwdcheck").val();
		var reg = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;	
		var reg2 = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$/
		var blank_pattern = /[\s]/g;	
		
		console.log("정규식 전 :: " + pw);
		console.log("reg2.test(pw) :: " + reg2.test(pw));
		
		 if(!reg2.test(pw)) {
        	console.log("test :: " + !reg2.test(pw));
			$(".pwd").text("비밀번호는 8자 이상이어야 하며, 최소 하나 이상의 문자와 숫자를 포함해야 합니다.");
	    	$(".pwd").css("color", "red");	
			console.log(pw);	 
			//console.log("8자");
			return false;
		} 
		
		if(blank_pattern.test(pw) == true){
			$(".pwd").text("비밀번호는 공백 없이 입력해주세요.");
	    	$(".pwd").css("color", "red");
			$(".pwd").focus();	
			console.log("공백");
			return false;		
		} 
		
		if(id != "" && pw.search(id) > -1){
			$(".pwd").text("비밀번호에 아이디가 포함되었습니다.");
	    	$(".pwd").css("color", "red");
			$(".pwd").focus();
			console.log("아이디");
			return false;
		}
		
		if((pw2.length > 0) && (pw != pw2))	{
			$(".pwdCheck").text("비밀번호가 일치하지 않습니다.");
			$(".pwdCheck").css("color", "red");
			$(".pwdCheck").focus();
			$(".pwdCheck2").val("false");
			return false;
		} else if((pw2.length > 0) && (pw == pw2)) {
			$(".pwdCheck").text("비밀번호가 일치합니다..");
			$(".pwdCheck").css("color", "green");	
			$(".pwdCheck2").val("true");
		} 		
		
		$(".pwd").text("입력 완료");
    	$(".pwd").css("color", "green");   
    	$(".pwdCheck1").val("true");

	}); 
	
	$('.inputPwdcheck').on("propertychange change keyup paste input", function(){
		var id = $(".inputId").val();
		var pw = $(".inputPwd").val();
		var pw2 = $(".inputPwdcheck").val();
		var reg = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;		 
	
		if(pw == pw2){
			$(".pwdCheck").text("비밀번호가 일치합니다..");
			$(".pwdCheck").css("color", "green");						
		}else if(pw != pw2)	{
			$(".pwdCheck").text("비밀번호가 일치하지 않습니다.");
			$(".pwdCheck").css("color", "red");
			$(".pwdCheck").focus();
			$(".pwdCheck2").val("false");
			return false;
		} 
		$(".pwdCheck2").val("true");  
	});
	
}

function emailSelectEvent() {
	$(".emailSelect").change(function() {
		var value = $(".emailSelect option:selected").val();
		if(value != "self") {
			$(".inputEmailb").val(value);
			$(".inputEmailb").prop("readonly",true);
		} else {
			$(".inputEmailb").val("");
			$(".inputEmailb").prop("readonly",false);
		}
	});
}

 
 /*제출 유효성 검사 (빈칸)*/
 
 function joinSubmitEvent() {
 
 	
	$(".joinForm").submit(function(){
		var id = $(".inputId").val();
		var name = $(".inputName").val();
		var pwd = $(".inputPwd").val();
		var pwdCheck = $(".inputPwdcheck").val();
		var mobile1 = $(".inputMobile1").val();
		var mobile2 = $(".inputMobile2").val();
		var mobile3 = $(".inputMobile3").val();
		var mobile = "";
		var add = $(".inputAddnumber").val();
		var dep = $("select[name=department]").val();
		var pos = $("select[name=position]").val();
		var emailf = $(".inputEmailf").val();
		var emailb = $(".inputEmailb").val();
		var email = "";
		var birth = $(".inputBirth").val();
		var gender = $(".checkGender:checked").val();
		
		var idCheck = $("#idDoubleCheck").val();
		var pwdCheck1 = $(".pwdCheck1").val();
		var pwdCheck2 = $(".pwdCheck2").val();
		
	
		if(id.length == 0){
			alert("아이디를 입력하세요");
			$(".inputId").focus();
			return false;
		} else if(idCheck == "false") {
			alert("중복된 아이디입니다.");
			$(".inputId").focus();
			return false;
		} else if(name.length == 0){
			alert("이름을 입력하세요");
			$(".inputName").focus();
			return false;
		}else if(pwd.length == 0){
			alert("비밀번호를 입력하세요");
			$(".inputPwd").focus();
			return false;
		} else if(pwdCheck1 == "false") {
			alert("올바른 비밀번호를 입력하세요.");
			$(".inputPwd").focus();
			return false;
		} else if(pwdCheck.length == 0) {
			alert("비밀번호 확인을 입력하세요");
			$(".inputPwdCheck").focus();
			return false;
		} else if(pwdCheck2 == "false") {
			alert("올바른 비밀번호를 입력하세요.");
			$(".inputPwd").focus();
			return false;
		} else if(mobile1.length == 0 || mobile2.length == 0 || mobile3.length == 0){
			alert("휴대폰번호를 입력하세요");
			$(".inputMobile1").focus();
			return false;
		}else if(add.length == 0){			
			alert("주소를 입력하세요");
			$(".inputAddnumber").focus();
			return false;			
		}else if(dep == null){
			alert("부서를 선택하세요.");
			$("#department").focus();
			return false;
		}else if(pos == null){			
			alert("직급을 선택하세요");
			$("#position").focus();
			return false;
		}else if(emailf.length == 0 || emailb.length == 0){
			console.log(dep);
			console.log(pos);
			alert("이메일을 입력하세요");
			$(".inputEmailf").focus();
			return false;
		}else if(birth.length == 0){
			alert("생년월일을 입력하세요");
			$(".inputBirth").focus();
			return false;
		}else if(gender.length == 0){
			alert("성별을 선택하세요");
			$(".inputName").focus();
			return false;
		}

		mobile = mobile1 + mobile2 + mobile3;
		$("input[name=mobile]").val(mobile);
		
		email = emailf + "@" + emailb;
		$("input[name=email]").val(email);
				
		alert("회원가입이 완료되었습니다.");
	
	 });
	 
 }
 
 
 