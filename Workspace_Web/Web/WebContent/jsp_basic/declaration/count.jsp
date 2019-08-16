<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
int visitCount = 0;
%>    
<%
	visitCount = visitCount + 1;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/datacss.css">
<title>Insert title here</title>
</head>
<body>
	방문 횟수
	<hr width="80%">
	<%
		out.print(visitCount);
	%>
</body>
</html>