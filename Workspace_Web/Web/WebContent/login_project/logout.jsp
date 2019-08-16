<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/datacss.css">
</head>
<body>
	<a href="home.jsp">Home</a> |
	{로그아웃} |
	<a href="update_pw.jsp">비밀번호 변경</a>
	<hr width="80%">
	
	<form action="logout_result.jsp">
		<input type="submit" value="로그아웃">
	</form>
</body>
</html>