var today = null;
var year = null;
var month = null;
var date = null;
var firstDay = null;
var lastDay = null;
var $tdDay = null;
var $tdSche = null;
var jsonData = null;


$(document).ready(function() {
    
});

$(function() {
	drawCalendar();
    initDate();
    drawDays();
    //drawSche();
    $("#movePrevMonth").on("click", function(){movePrevMonth();});
    $("#moveNextMonth").on("click", function(){moveNextMonth();});
    
    noticeEvent();
    projectEvent();
});
    
//Calendar 그리기
function drawCalendar(){
    var setTableHTML = "";
    setTableHTML+='<table class="calendar">';
    setTableHTML+='<tr><th>SUN</th><th>MON</th><th>TUE</th><th>WED</th><th>THU</th><th>FRI</th><th>SAT</th></tr>';
    for(var i=0;i<6;i++){
        setTableHTML+='<tr height="45">';
        for(var j=0;j<7;j++){
            setTableHTML+='<td style="text-overflow:ellipsis;overflow:hidden;white-space:nowrap">';
            setTableHTML+='    <div class="cal-day"></div>';
            /*setTableHTML+='    <div class="cal-schedule"></div>';*/
            setTableHTML+='</td>';
        }
        setTableHTML+='</tr>';
    }
    setTableHTML+='</table>';
    $("#cal_tab").html(setTableHTML);
}

//날짜 초기화
function initDate(){
    $tdDay = $("td div.cal-day")
    $tdSche = $("td div.cal-schedule")
    dayCount = 0;
    today = new Date();
    year = today.getFullYear();
    month = today.getMonth()+1;
    date = today.getDate();
    if(month < 10){month = "0"+month;}
    firstDay = new Date(year,month-1,1);
    lastDay = new Date(year,month,0);
    
    console.log("오늘 :: " + year + "-" + month + "-" + date);
}
    
//calendar 날짜표시
function drawDays(){
    $("#cal_top_year").text(year);
    $("#cal_top_month").text(month);
    for(var i=firstDay.getDay();i<firstDay.getDay()+lastDay.getDate();i++){
        $tdDay.eq(i).text(++dayCount);
    }
    for(var i=0;i<42;i+=7){
        $tdDay.eq(i).css("color","red");
    }
    for(var i=6;i<42;i+=7){
        $tdDay.eq(i).css("color","blue");
    }
    setToday();
}

//calendar 월 이동
function movePrevMonth(){
    month--;
    if(month<=0){
        month=12;
        year--;
    }
    if(month<10){
        month=String("0"+month);
    }
	getNewInfo();
}
    
function moveNextMonth(){
    month++;
    if(month>12){
        month=1;
        year++;
    }
    if(month<10){
        month=String("0"+month);
    }
    getNewInfo();
}

//정보갱신
function getNewInfo(){
	
    for(var i=0;i<42;i++){
        $tdDay.eq(i).text("");
        $tdSche.eq(i).text("");
    }
    dayCount=0;
    firstDay = new Date(year,month-1,1);
    lastDay = new Date(year,month,0);
    drawDays();
    //drawSche();
}
    
    //2019-08-27 추가본
    
//데이터 등록
/*function setData(){
    jsonData = 
    {
        "2022":{
            "04":{
                "20":"프로젝트"
            }
            ,"08":{
                "7":"칠석"
                ,"15":"광복절"
                ,"23":"처서"
            }
            ,"09":{
                "13":"추석"
                ,"23":"추분"
            }
        }
    }
}*/
    
//스케줄 그리기
function drawSche(){
    //setData();
    var dateMatch = null;
    for(var i=firstDay.getDay();i<firstDay.getDay()+lastDay.getDate();i++){
        var txt = "";
        txt =jsonData[year];
        if(txt){
            txt = jsonData[year][month];
            if(txt){
                txt = jsonData[year][month][i];
                dateMatch = firstDay.getDay() + i -1; 
                $tdSche.eq(dateMatch).text(txt);
            }
        }
    }
}
    
    
function setToday() {
	
	var currentDay = new Date();
	var currentYear = currentDay.getFullYear();
	var currentMonth = currentDay.getMonth() + 1;
	var currentDate = currentDay.getDate();
	
	var outputYear = $("#cal_top_year").text();
	var outputMonth = $("#cal_top_month").text();
	
	if((outputYear == currentYear) && (outputMonth == currentMonth)) {
		$(".cal-day").each(function() {
			if($(this).text() == currentDate) {
				$(this).closest("td").addClass("currentDay");
			}
		});
	} else {
		$("table.calendar tr td.currentDay").removeClass("currentDay");
	}
	
}


// 공지사항 이벤트
function noticeEvent() {
	
	$(".noticeList").click(function() {
		var seq = $(this).attr("data-seq");
		location.href=utils.getContextPath() + "/notice/"+seq;
	});
	
	$(".noticeArea .listButton").click(function() {
		location.href=utils.getContextPath() + "/notice";
	});
	
}

// 프로젝트 이벤트
function projectEvent() {
	$(".projectCardPercentSpan").each(function() {
		var $this = $(this);
		var percent = $(this).attr("data-percent");
  
		$({ val : 0 }).animate({ val : percent }, {
			duration: 1500,
		  	step: function() {
		    	$this.text(Math.floor(this.val)+"%");
		 	},
		  	complete: function() {
		    	$this.text(Math.floor(this.val)+"%");
		  	}
		});	
		
	});
}