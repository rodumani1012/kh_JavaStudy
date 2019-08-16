<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String message1 = "Welcome"; //문자열
	int num1 = 1000; //정수
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%="html 이전에 변수 선언" %><br>
	<%=message1 %><br>
	<%=num1 %>
	<hr width="80%">
	
	<%
		String message2 = "안녕하세요";
		int num2 = 500;
	%>
	<%= "body 에서 변수 선언" %> <br>
	<%= message2 + " 안녕"%><br>
	<%= num2 + "<br>" %>
	<hr width="80%">
	
	<%="body 에서 직접 사용" %><br>
	<%="여기 Go" + "<br>" %>
	<%=3000 %>
</body>
</html>