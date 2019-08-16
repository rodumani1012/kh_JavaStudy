// 참고 :  http://tcpschool.com/ajax/ajax_server_response

function getParameterValues(){
	var name = "name="+encodeURIComponent($("#name").val());
	var kor = "kor="+$("#kor").val();
	var eng = "eng="+$("#eng").val();
	var math = "math="+$("#math").val();
	
	return name + "&" + kor + "&" + eng + "&" + math;
}

$(function(){
	$("#process").click(function(){
		alert("query:" + getParameterValues());
		load();
	});
});

function load(){
	var url = "calscore.do?"+getParameterValues();
	/*
	 Ajax에서 서버로부터의 응답을 확인하기 위해 사용하는 XMLHttpRequest 객체의 프로퍼티는 다음과 같습니다.
 	- readyState 프로퍼티
 	- status 프로퍼티
 	- onreadystatechange 프로퍼티
 	*/
	httpRequest = new XMLHttpRequest();		 // 서버와 통신하는 객체
	httpRequest.onreadystatechange=callback; // 처리할 함수. readystate가 change할 때마다 사용될 함수(calback)
	httpRequest.open("GET",url,true); // open() 메소드는 서버로 보낼 Ajax 요청의 형식을 설정합니다. true : 비동기 / false : 동기
	httpRequest.send();					// get : send() / post:send(내용)
}

function callback(){
	
	alert("readyState : " + httpRequest.readyState);
	
	if(httpRequest.readyState == 4) { // .readyState : XMLHttpRequest 객체의 현재 상태를 나타냅니다.
		alert("status : " + httpRequest.status); /*
		 1. UNSENT (숫자 0) : XMLHttpRequest 객체가 생성됨.
		
		 2. OPENED (숫자 1) : open() 메소드가 성공적으로 실행됨.
		
		 3. HEADERS_RECEIVED (숫자 2) : 모든 요청에 대한 응답이 도착함.
		
		 4. LOADING (숫자 3) : 요청한 데이터를 처리 중임.
		
		 5. DONE (숫자 4) : 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨.*/
		
		if(httpRequest.status == 200) { // status 프로퍼티는 서버의 문서 상태를 나타냅니다.
										// 200 : 서버에 문서가 존재함.  404: 서버에 문서가 존재하지않음
			var obj = JSON.parse(httpRequest.responseText);
			
			$("#result").html(decodeURIComponent(obj.name)+"님의 총점은 " + obj.sum + "이고, 평균은"
					+ obj.avg + "이고, 등급은 " + obj.grade + "입니다.");
		} else {
			alert("데이터 계산 실패");
		}
	}
}

/*
	javascript variable hoisting : https://steady-snail.tistory.com/40
	
	XMLHttpRequest : javascript object로써 http를 통한 데이터 송수신 지원

	<onreadystatechange>
		-readyState
		0: uninitialized - 실행(load)되지 않음
		1: loading - 실행중
		2: loaded - 실행됨
		3: interactive - 통신 됨
		4: complete - 통신 완료
		
		-status
		200: 성공
		403: forbidden (권한이 없을 때. ex)db... )
		404: not found (요청이 없을 때)
		500: internal server error (서버 안에서 에러가 났을 때)
		...
		
	<한글 사용 인코딩>
		-encodeURI() : 주소줄에 사용되는 특수문자를 제외하고 인코딩
		-encodeURIComponent() : 모든 문자를 인코딩
		-decodeURI() : encodeURI()를 사용한 것을 decode 해주는 것
		-decodeURIComponent() : encodeURIComponent()를 사용한 것을 decode 해주는 것
 */



