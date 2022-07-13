$(function() {

	// 년, 월 선택 이벤트
	//datepickerEvent();

});

/*function datepickerEvent() {
	$(".test").datepicker({
		dateFormat: 'yy.mm',
		showOn: 'focus',
		beforeShow: function(input) {

			var i_offset= $(input).offset(); //클릭된 input의 위치값 체크

			setTimeout(function(){

			   $('#ui-datepicker-div').css({'top':i_offset.top+50, 'bottom':'', 'left':i_offset.left-45});      //datepicker의 div의 포지션을 강제로 input 위치에 그리고 좌측은 모바일이여서 작기때문에 무조건 10px에 놓았다.

			})

		},
		onSelect: function(dateText, inst) {
			date = $(".test").val();
			var arr=date.split(".");
			var year=arr[0];
			var month=arr[1];
			
			monthSelectedEvent(year, month);
		  } 
	});
	
}*/

function monthSelectedEvent(year, month) {
	location.href = utils.getContextPath() + "/work?year=" + year + "&month=" + month;
}


$(document).ready(function () {
    $.datepicker.regional['ko'] = {
        closeText: '닫기',
        prevText: '이전달',
        nextText: '다음달',
        currentText: '오늘',
        monthNames: ['1월(JAN)','2월(FEB)','3월(MAR)','4월(APR)','5월(MAY)','6월(JUN)',
        '7월(JUL)','8월(AUG)','9월(SEP)','10월(OCT)','11월(NOV)','12월(DEC)'],
        monthNamesShort: ['1월','2월','3월','4월','5월','6월',
        '7월','8월','9월','10월','11월','12월'],
        dayNames: ['일','월','화','수','목','금','토'],
        dayNamesShort: ['일','월','화','수','목','금','토'],
        dayNamesMin: ['일','월','화','수','목','금','토'],
        weekHeader: 'Wk',
        dateFormat: 'yy.mm.dd',
        firstDay: 0,
        isRTL: false,
        showMonthAfterYear: true,
        yearSuffix: '',
        /*showOn: 'focus',*/
        /*buttonText: "달력",*/
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        yearRange: 'c-99:c+99',
        setDate: '01.01.01'
    };
    $.datepicker.setDefaults($.datepicker.regional['ko']);

    var datepicker_default = {
        /*showOn: 'focus',*/
        /*buttonText: "달력",*/
        currentText: "이번달",
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        yearRange: 'c-99:c+99',
        showOtherMonths: true,
        selectOtherMonths: true,
        setDate: '01.01.01'
    }

    datepicker_default.closeText = "선택";
    datepicker_default.dateFormat = "yy.mm";
    datepicker_default.onClose = function (dateText, inst) {
        var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
        var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
        $(this).datepicker( "option", "defaultDate", new Date(year, month, 1) );
        $(this).datepicker('setDate', new Date(year, month, 1));
        
        monthSelectedEvent(year, Number(month)+1);
    }

    /*datepicker_default.beforeShow = function () {
        var selectDate = $(".date_og").val().split(".");
        var year = Number(selectDate[0]);
        var month = Number(selectDate[1]) - 1;
        $(this).datepicker( "option", "defaultDate", new Date(year, month, 1) );
    }*/
    
    datepicker_default.beforeShow = function (input) {
		var i_offset= $(input).offset(); //클릭된 input의 위치값 체크
		setTimeout(function(){
			$('#ui-datepicker-div').css(
				{'top':i_offset.top+50, 'bottom':'', 'left':i_offset.left-45}
			);      //datepicker의 div의 포지션을 강제로 input 위치에 그리고 좌측은 모바일이여서 작기때문에 무조건 10px에 놓았다.

		});
    }
    
    datepicker_default.afterShow = function () {
        var selectDate = $(".date_og").val().split(".");
        alert("gdgd");
        var year = Number(selectDate[0]);
        var month = Number(selectDate[1]) - 1;
        $(this).datepicker( "option", "defaultDate", new Date(year, month, 1) );
    }
    
   
    
    /*datepicker_default.onSelect = function () {
		date = $(".test").val();
		var arr=date.split(".");
		var year=arr[0];
		var month=arr[1];

		monthSelectedEvent(year, month);
    }*/

    $(".test").datepicker(datepicker_default);
    /*$(".test").datepicker("option", "defaultDate", new Date(2008,9,3));*/
});
