<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Case 1. 전체 쿠키 삭제 -->
<%
	Cookie[] cookies1 = request.getCookies();
	if (cookies1 != null) {
		for (int i = 0; i < cookies1.length; i++) {
			//쿠키 삭제
			//쿠키의 유효기간을 만료시킨다.
			cookies1[i].setMaxAge(0);
			
			//쿠키를 응답에 추가한다.
			//추가하지 않으면 정상적으로 삭제되지 않는다.
			response.addCookie(cookies1[i]);
		}
	}
%>
<!-- Case 2. 특정 쿠키 삭제 -->
<%
	Cookie[] cookies2 = request.getCookies();
	if (cookies2 != null) {
		for (int i = 0; i < cookies2.length; i++) {
			
			Cookie cookie = cookies2[i];
			String cookieName = cookie.getName();
			if (cookieName.equals("memberId")) {
				cookies2[i].setMaxAge(0);
				response.addCookie(cookies2[i]);
			}			
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/datacss.css">
<title>Insert title here</title>
</head>
<body>
	쿠키가 삭제되었습니다.
	<hr>
	<br>
	<a href="ep01_home.jsp">[ 홈 ]</a> |
	<a href="ep03_info.jsp">쿠키 정보 확인</a>

</body>
</html>