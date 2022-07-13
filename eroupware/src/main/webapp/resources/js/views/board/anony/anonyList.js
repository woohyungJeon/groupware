$(function() {
	$('#searchBtn').click(function() {
		//alert("gdgd");
		var option = $("#searchType option:selected").val();
		var keyword = $("#keywordInput").val();
		location.href = utils.getContextPath() + "/anony?searchType="+option+"&keyword="+keyword;
	});
});  