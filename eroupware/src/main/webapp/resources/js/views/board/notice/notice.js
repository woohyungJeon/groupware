
	$(function() {
		/*$.ajax({
			url: "noticeListJson.do", 
			type: "post",
			data: {"pg": "${pg}"},
			dataType: "json",
			success: function(json) {
				$.each(json.items, function(index, item) {	// items의 갯수만큼 함수 실행
					// 태그 생성
					var tr = $("<tr>", {align: "center"});
					var td1 = $("<td>").html(item.seq);
					var td2 = $("<td>").html(item.title);
					var td3 = $("<td>").html(item.name);
					var td4 = $("<td>").html(item.logtime);
					var td5 = $("<td>").html(item.hit);
					
					tr.append(td1).append(td2).append(td3).append(td4).append(td5);
					$("#noticeList").append(tr);
					
				});
			},
			error: function(xhr, textStatus, errorThrown) {
				alert("[Error] " + xhr.status);
			}
		});*/
	});