<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//쿠키 생성. 입력값 : (이름, 값);
	Cookie cookie1 = new Cookie("memberId", "water2018");
	
	//쿠키 유지 시간 설정. 단위 초(second). 1년: 365*24*60*60  //아무것도 안하고 30초가 지나가면 쿠키가 자동 소멸됨
	cookie1.setMaxAge(30);
	
	//응답에 쿠키 추가
	response.addCookie(cookie1);
%>
	<!-- 여러 쿠키 생성 가능 -->
<%  
	Cookie cookie2 = new Cookie("color", "red");
	cookie2.setMaxAge(30);
	response.addCookie(cookie2);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/datacss.css">
<title>Insert title here</title>
</head>
<body>
	Cookie 생성
	<hr>
	<a href="ep03_info.jsp">쿠키 정보 확인</a>
</body>
</html>