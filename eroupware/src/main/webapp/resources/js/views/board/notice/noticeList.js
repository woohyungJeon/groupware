$(function() {
	
	$(".searchForm").submit(function() {
		var option = $("#searchType option:selected").val();
		var keyword = $("#keywordInput").val();
		if(keyword.length < 1) {
			alert("검색어를 입력해주세요");
			$("#keywordInput").focus();
			return false;
		}
		location.href = utils.getContextPath() + "/notice?searchType="+option+"&keyword="+keyword;
	
	});
	
});  