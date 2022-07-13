$(function() {
	
	
	$(".searchForm").submit(function() {
		var option = $("#searchType option:selected").val();
		var keyword = $("#keywordInput").val();
		if(keyword.length < 1) {
			alert("검색어를 입력해주세요");
			$("#keywordInput").focus();
			return false;
		}
		location.href = utils.getContextPath() + "/contact?searchType="+option+"&keyword="+keyword;
	
	});
});  



$('.list_css').click(function(){
    var data = $(this).attr("id");    	
    console.log("data = " + data);
    var detailUrl = utils.getContextPath() + "/contact/" + data;
	var detailOption = "width = 650px, height=550px, scrollbars=no, location=no";
	
	console.log(detailUrl);
	window.open(detailUrl, "연락처", detailOption);
});
