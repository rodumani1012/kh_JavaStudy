
$(function(){
	parseJson();
});

// JSON.stringify() : JSON 객체/javascript값 를(을) -> String(문자열)로 변환
// JSON.parse() : JSON 형태의 문자열 -> JSON 객체/값으로 변환

function parseJson() {
	
	$.getJSON("json/bike.json", function(data){
		
		$.ajax({
			url:"bike.do?command=second_db",
			method:"post",
			// data : url로 데이터 보내는 것
			// dataType : url과 통신되었을때 응답되는 
				//데이터의 타입을 명시.(받아주는 애들의 타입이 ?? 다. 라고 명시)
			data:{"obj":JSON.stringify(data)}, // JSON.stringify()으로 JavaScript 객체를 스트링으로 변환한다.
			success:function(msg){
				alert(msg + "개 성공");
				
				$("table").attr("border", "1");
				// bike02.jsp의 table에 값을 추가하자.
				$.each(data, function(key, val){
					if(key == "DESCRIPTION") {
						$("thead").append(
								"<tr>"
								+	"<th>"+val.ADDR_GU+"</th>"
								+	"<th>"+val.CONTENT_ID+"</th>"
								+	"<th>"+val.CONTENT_NM+"</th>"
								+	"<th>"+val.NEW_ADDR+"</th>"
								+	"<th>"+val.CRADLE_COUNT+"</th>"
								+	"<th>"+val.LONGITUDE+"</th>"
								+	"<th>"+val.LATITUDE+"</th>"
								+"</tr>"
						);
					} else if (key == "DATA") {
						
						var list = val;
						
						for (var i = 0; i < list.length; i++) {
							
							var str = list[i];

							$("tbody").append(
									"<tr>"
									+	"<th>"+str.list_gu+"</th>"
									+	"<th>"+str.content_id+"</th>"
									+	"<th>"+str.content_nm+"</th>"
									+	"<th>"+str.new_addr+"</th>"
									+	"<th>"+str.cradle_count+"</th>"
									+	"<th>"+str.longitude+"</th>"
									+	"<th>"+str.latitude+"</th>"
									+"</tr>"
							);
						}
					}
				});
			},
			error:function(){
				alert("통신 실패");
			}
		});
	});
}

