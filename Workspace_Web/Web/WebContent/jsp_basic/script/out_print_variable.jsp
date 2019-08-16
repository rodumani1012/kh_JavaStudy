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
	<%  out.print("html 이전에 변수 선언<br>"); %>
	<%
		out.print(message1 + "<br>");
		out.print(num1);
	%>
	<hr width="80%">
	
	<% 
		String message2 = "안녕하세요";
		int num2 = 500;
		
		out.print("body 에서 변수 선언<br>");
		out.print(message2 + "<br>");
		out.print(num2);
	%>
	<hr width="80%">
	
	<%  out.print("body 에서 직접 사용"); %>
	<br>
	<%  out.print("여기 Go" + "<br>");
		out.print(3000);
	%>
</body>
</html>