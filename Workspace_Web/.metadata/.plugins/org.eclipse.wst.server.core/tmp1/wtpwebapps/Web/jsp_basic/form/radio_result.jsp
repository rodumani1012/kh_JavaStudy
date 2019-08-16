<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8"); //한글 처리
%>
<%
	String city = request.getParameter("city");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/datacss.css"> 
<title>Insert title here</title>
</head>
<body>
	전송결과
	<hr width="80%">
	<%=city%><br><br>
	<a href="radio_form.jsp">[입력 화면]</a>
</body>	
</html>