<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	text-align: center;
}
</style>
</head>
<body>
	hello<br>world
	<hr width="80%">
	
	<%
	out.print("hello<br>world");
	out.print("<hr width=\"80%\">");
	%>
	
	안녕하세요
	<%
	out.print("<br><br>");
	%>
	!!!
</body>
</html>