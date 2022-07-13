$(function(){
	printClock();
	headerEvent();
   
}); /*** 레디펑션 끝 ***/
	
$(window).scroll(function() {
	$("#header").css("left", 0-$(this).scrollLeft());
	/*$("#headerMenu").css("left", 0-$(this).scrollLeft());*/
});

function headerEvent() {
	$("#header .headerLogo").click(function() {
		location.href = utils.getContextPath() + "/main";
	});
	
	
	/*$("#headerMenu > ul > li").off("hover").on("hover", function() {
		$(this).children("ul").stop().slideToggle(100);
	});*/
	
	$("#headerMenu > ul > li").hover(function() {
		
        $(this).children("ul").stop().slideToggle(100);
    });
}

function printClock() {
	
		var clock = $(".headerTime");
	    
	    var currentDate = new Date();  
	    var currentDay = currentDate.getDay();
	    var week = ['일', '월', '화', '수', '목', '금', '토']; 
	    var dayOfWeek = week[currentDay]; 

	    var calendar = currentDate.getFullYear() + "-" + (currentDate.getMonth()+1) + "-" + currentDate.getDate() // 현재 날짜
	    var amPm = 'AM'; // 초기값 AM
	    var currentHours = addZeros(currentDate.getHours(),2); 
	    var currentMinute = addZeros(currentDate.getMinutes() ,2);
	    var currentSeconds =  addZeros(currentDate.getSeconds(),2);
	    
	    if(currentHours >= 12){ // 시간이 12보다 클 때 PM으로 세팅, 12를 빼줌
	    	amPm = 'PM';
	    	currentHours = addZeros(currentHours - 12,2);
	    }
	    
	    clock.text(calendar+"("+dayOfWeek+") "+currentHours+":"+currentMinute+":"+currentSeconds + " " + amPm);
	    
	    setTimeout("printClock()",1000);         // 1초마다 printClock() 함수 호출
	}

	function addZeros(num, digit) { // 자릿수 맞춰주기
		  var zero = '';
		  num = num.toString();
		  if (num.length < digit) {
		    for (i = 0; i < digit - num.length; i++) {
		      zero += '0';
		    }
		  }
		  return zero + num;
	}



