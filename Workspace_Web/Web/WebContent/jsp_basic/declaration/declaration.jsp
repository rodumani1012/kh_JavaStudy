<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 느낌표의 유무 차이는 메인 안에 광역변수<%!%>(메인밖에선언)이냐 지역변수(메인안에 선언)이냐의 차이이다. -->
<%!
	String name = "홍길동";
%>
<%
	String message = "Hello";
%>			
<%!
	public String getName() {
		return name;
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
	hello
	<hr width="80%">

	<%
		out.print(message);
		out.print(name);
		out.print("<br>");
		out.print(getName());
	%>
	
</body>
</html>