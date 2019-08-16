
$(function(){
	$("#weaView").click(function(){
		var url = "weather.do";
		var code = $("#address option:selected").val(); // 1168064000 / 4141055000 / 4146125000
		
		$.ajax({
			type:"GET",
			url:url+"?code="+code,
			dataType:"text", // Info.jsp에서 JSON 형태의 문자(text)를 받았다.
			success:function(data){ // weatherInfo에서 응답 받은 data(JSON형태의 text)
				var tmp = $.trim(data);
				
				var obj = JSON.parse(tmp); // JSON 객체로 만듦 (key : value 형태로)
				
				$("#pubDate").val(obj.pubDate);
				$("#temp").val(obj.temp);
				$("#x").val(obj.x);
				$("#y").val(obj.y);
				$("#reh").val(obj.reh);
				$("#pop").val(obj.pop);
				$("#wfKor").val(obj.wfKor);
				
				var weather_condition = obj.wfKor;
				if(weather_condition == "맑음"){
					$("#weather_img").attr("src","/Jsp12_Weather/image/sun.png");
				} else if(weather_condition == "비") {
					$("#weather_img").attr("src","/Jsp12_Weather/image/rain.png");
				} else if(weather_condition == "눈") {
					$("#weather_img").attr("src","/Jsp12_Weather/image/snow.png");
				} else if(weather_condition == "흐림") {
					$("#weather_img").attr("src","/Jsp12_Weather/image/cloud.png");
				} else if(weather_condition == "구름 조금") {
					$("#weather_img").attr("src","/Jsp12_Weather/image/cloud_sun.png");
				} else {
					$("#weather_img").attr("src","/Jsp12_Weather/image/etc.png");
				}
			},
			error:function(){
				alert("날씨정보를 불러오는데 실패하였습니다.");
			}
		});
	});
});