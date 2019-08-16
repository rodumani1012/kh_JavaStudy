<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
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
	{로그인}
	<br>
	<hr width="80%">
	로그인에 성공하셨습니다.
	<br><br>
	회원정보
	<br><br>
	아이디 : <%=id %>
	<br>
	비밀번호 : <%=password %>
</body>
</html>