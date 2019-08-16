
$(function(){
	getJson();
});

function getJson() {
	
	$.getJSON("json/bike.json", function(data){  
		//uri와 통신을하여 성공했을 때 function(data)를 실행함
		
		$("table").attr("border","1");
		
		$.each(data,function(key,val){
			// $.each(array/object, callback) {}
				// 이터레이블된 배열 또는 오브젝트 형태를 하나하나 꺼내서 함수 실행.
			if(key == "DESCRIPTION") {
				
				$("thead").append(
						"<tr>"+
							"<th>"+val.ADDR_GU+"</th>"+
							"<th>"+val.CONTENT_ID+"</th>"+
							"<th>"+val.CONTENT_NM+"</th>"+
							"<th>"+val.NEW_ADDR+"</th>"+
							"<th>"+val.CRADLE_COUNT+"</th>"+
							"<th>"+val.LONGITUDE+"</th>"+
							"<th>"+val.LATITUDE+"</th>"+
						"</tr>"
				);
				
			} else if (key == "DATA") {
				
				var list = val;
				
				for(var i = 0; i < list.length; i++) {
					
					var str = list[i];
					
					$("tbody").append(
							"<tr>"+
								"<td>"+str.addr_gu+"</td>"+
								"<td>"+str.content_id+"</td>"+
								"<td>"+str.content_nm+"</td>"+
								"<td>"+str.new_addr+"</td>"+
								"<td>"+str.cradle_count+"</td>"+
								"<td>"+str.longitude+"</td>"+
								"<td>"+str.latitude+"</td>"+
								"<input type='hidden' name='bike' value='"+
									str.addr_gu+"/"+str.content_id+"/"+
									str.content_nm+"/"+str.new_addr+"/"+
									str.cradle_count+"/"+str.longitude+"/"+
									str.latitude+"'>"+
							"</tr>"
					);
				}
				
			}
		});
	});
}
