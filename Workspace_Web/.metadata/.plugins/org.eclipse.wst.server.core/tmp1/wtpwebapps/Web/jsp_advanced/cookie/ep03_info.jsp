<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/datacss.css">
<title>Insert title here</title>
</head>
<body>
	쿠키 정보
	<hr>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				String name = cookies[i].getName();
				String value = cookies[i].getValue();
	%>	
				이름 : <%=name%> , 값 : <%=value%><br>
	<%
			}
		} else {
			out.println("쿠키가 없습니다.");
		}
	%>
	<br><br>
	<a href="ep01_home.jsp">[ 홈 ]</a>
</body>
</html>